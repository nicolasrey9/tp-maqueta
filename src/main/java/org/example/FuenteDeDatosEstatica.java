package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.excepciones.CSVSinTitulo;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TODO: hacer que obtenga el separador del CSV, para que tolere CSVs separados por ";"
public class FuenteDeDatosEstatica {

  private static final List<String> titulos = Arrays.asList("titulo", "title");
  private static final List<String> descripciones = Arrays.asList("desc", "descripcion", "description");
  private static final List<String> categorias = Arrays.asList("tipo", "grupo", "categoria", "causa", "category");
  private static final List<String> latitudes = Arrays.asList("lat", "latitude", "latitud");
  private static final List<String> longitudes = Arrays.asList("long", "lng", "lon", "logitude", "longitud");
  private static final List<String> fechas = Arrays.asList("fecha", "date");

  public static List<Hecho> hechosExtraidos = new ArrayList<>();


  public static void extraerHechos(Path rutaDataset) {
    if(!esArchivoCSV(rutaDataset)) { throw new RuntimeException("Solo hay soporte para .csv actualmente"); }

    try (Reader reader = Files.newBufferedReader(rutaDataset)) {
      try (CSVReader csvReader = new CSVReader(reader)) {
        String[] linea;
        linea = csvReader.readNext();

        // son -1 en caso de NOT FOUND
        short posicionTitulo = buscarColumna(linea, true, titulos.toArray(new String[0]));
        if(posicionTitulo == -1) throw new CSVSinTitulo("No se ha detectado columna de titulo en el archivo CSV" + rutaDataset.toString());
        short posicionDescripcion = buscarColumna(linea, true, descripciones.toArray(new String[0]));
        short posicionCategoria = buscarColumna(linea, true, categorias.toArray(new String[0]));
        short posicionLatitud = buscarColumna(linea, false,latitudes.toArray(new String[0]));
        short posicionLongitud = buscarColumna(linea, false,longitudes.toArray(new String[0]));
        short posicionFecha = buscarColumna(linea, true, fechas.toArray(new String[0]));


        while ((linea = csvReader.readNext()) != null) {
          String titulo = campoDeLinea(linea, posicionTitulo);
          String descripcion = campoDeLinea(linea, posicionDescripcion);
          String categoria = campoDeLinea(linea, posicionCategoria);
          String latitud = campoDeLinea(linea, posicionLatitud);
          String longitud = campoDeLinea(linea, posicionLongitud);
          String fechaString = campoDeLinea(linea, posicionFecha);

          Ubicacion ubicacion = null;
          try {
            if (latitud != null && longitud != null)
              ubicacion = new Ubicacion(Double.parseDouble(latitud), Double.parseDouble(longitud));
          } catch (NumberFormatException e) {
            throw new RuntimeException("Error al convertir lat/lon en línea: " + Arrays.toString(linea), e);
          }

          LocalDate fecha = null;
          try {
            if (fechaString != null)
              fecha = LocalDate.parse(fechaString);
          } catch (DateTimeParseException e) {
            throw new RuntimeException("Formato de fecha inválido: " + fechaString, e);
          }

          // TODO validar que no se repita Titulo de hecho, en caso de hacerlo pisarlo.

          Hecho hecho = new Hecho(titulo, descripcion, categoria, ubicacion, fecha, Origen.CSV);

          hechosExtraidos.add(hecho);

        }
      } catch (CsvValidationException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  private static boolean esArchivoCSV(Path rutaArchivo) {
    return rutaArchivo.getFileName().toString().endsWith(".csv");
  }

  private static String campoDeLinea(String[] linea, short posicion) {
    if(posicion == -1 || linea[posicion].isBlank()) return null;
    return linea[posicion];
  }


  private static short buscarColumna(String[] encabezado, boolean modoFlexible, String... posiblesNombres) {
    for (short i = 0; i < encabezado.length; i++) {
      String nombreColumna = encabezado[i].toLowerCase().trim();
      for (String posible : posiblesNombres) {
        posible = posible.toLowerCase();
        if (
            nombreColumna.equals(posible) ||
                (modoFlexible && nombreColumna.startsWith(posible))
        ) {
          return i;
        }
      }
    }
    return -1;  // manejo de errores
  }

  //FALTARÍA COMENZAR LA LÓGICA DE A DONDE VA CADA HECHO
  //DEBEMOS PENSAR SI ES TRABAJO DEL HECHO, DE LA FUENTE O DE LA COLECCIÓN
  // A DONDE VA A PARAR CADA UNO DE LOS HECHOS






}

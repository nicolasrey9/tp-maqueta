package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


//TODO: hacer que obtenga el separador del CSV, para que tolere CSVs separados por ";"
public class FuenteDeDatosEstatica {

  private static final List<String> titulos = Arrays.asList("event", "name", "titulo", "title");
  private static final List<String> descripciones = Arrays.asList("desc", "descripcion", "description");
  private static final List<String> categorias = Arrays.asList("tipo", "grupo", "categoria", "causa");
  private static final List<String> latitudes = Arrays.asList("lat", "latitude", "latitud");
  private static final List<String> longitudes = Arrays.asList("long", "lng", "lon", "logitude", "longitud");
  private static final List<String> fechas = Arrays.asList("fecha", "date", "start");




  public static void extraerHechos(Path rutaDataset) {
    if(!esArchivoCSV(rutaDataset)) { throw new RuntimeException("Solo hay soporte para .csv actualmente"); }

    //TODO
    try (Reader reader = Files.newBufferedReader(rutaDataset)) {
      try (CSVReader csvReader = new CSVReader(reader)) {
        String[] line;
        line = csvReader.readNext();

        // son -1 en caso de NOT FOUND
        short posicionTitulo = buscarColumna(line, true, titulos.toArray(new String[0]));
        short descripcion = buscarColumna(line, true, descripciones.toArray(new String[0]));
        short categoria = buscarColumna(line, true, categorias.toArray(new String[0]));
        short latitud = buscarColumna(line, false,latitudes.toArray(new String[0]));
        short longitud = buscarColumna(line, false,longitudes.toArray(new String[0]));
        short fecha = buscarColumna(line, true, fechas.toArray(new String[0]));


        // iteraciones se usa solo para el test, BORRAR
        int iteraciones = 0;
        while ((line = csvReader.readNext()) != null && iteraciones < 2) {
          System.out.println(Arrays.toString(line));
          iteraciones ++;
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





}

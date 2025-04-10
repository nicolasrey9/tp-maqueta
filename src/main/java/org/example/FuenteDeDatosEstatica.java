package org.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuenteDeDatosEstatica {
  public static void extraerHechos(Path rutaDataset) {
    if(!esArchivoCSV(rutaDataset)) { throw new RuntimeException("Solo hay soporte para .csv actualmente"); }

    //TODO
    try (Reader reader = Files.newBufferedReader(rutaDataset)) {
      try (CSVReader csvReader = new CSVReader(reader)) {
        String[] line;
        line = csvReader.readNext();

        short posicionTitulo = obtenerPosicionTitulo(line);
        short descripcion = obtenerPosiciondescripcion(line);
        short categoria = obtenerPosicioncategoria(line);
        short latitud = obtenerPosicionlatitud(line);
        short longitud = obtenerPosicionlongitud(line);
        short fecha = obtenerPosicionfecha(line);

        // iteraciones se usa solo para el test, BORRAR
        int iteraciones = 0;
        while ((line = csvReader.readNext()) != null && iteraciones < 100) {
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

  private static short obtenerPosicionTitulo(String[] line) {
  }

  private static short obtenerPosicionfecha(String[] line) {
  }

  private static short obtenerPosicionlongitud(String[] line) {
  }

  private static short obtenerPosicionlatitud(String[] line) {
  }

  private static short obtenerPosicioncategoria(String[] line) {
  }

  private static short obtenerPosiciondescripcion(String[] line) {
  }


  private static short obtenerPosicionDe(String[] line, ) {
  }





}

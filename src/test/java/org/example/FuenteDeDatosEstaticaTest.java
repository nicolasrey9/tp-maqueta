package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Path;

public class FuenteDeDatosEstaticaTest {
  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    String path1 = "C:\\Users\\nicol\\OneDrive\\Desktop\\CSVs\\2_public_emdat_2025-04-08.csv";
    String path2 = "C:\\Users\\nicol\\OneDrive\\Desktop\\CSVs\\SAT-MV-BU_2017-2023.csv";
    String path3 = "C:\\Users\\nicol\\OneDrive\\Desktop\\CSVs\\csv_formateados\\ARCHIVO 2023.csv";

    Assertions.assertDoesNotThrow(() -> FuenteDeDatosEstatica.extraerHechos(Path.of(path3)));

    Hecho primerHecho = FuenteDeDatosEstatica.hechosExtraidos.get(0);

    System.out.println(primerHecho.getTitulo());
    System.out.println(primerHecho.getCategoria());
    System.out.println(primerHecho.getDescripcion());
    System.out.println(primerHecho.getContenidoMultimedia());
    System.out.println(primerHecho.getOrigen());
    System.out.println(primerHecho.getFechaDeAcontecimiento());
    System.out.println(primerHecho.getFechaDeCarga());

  }

}
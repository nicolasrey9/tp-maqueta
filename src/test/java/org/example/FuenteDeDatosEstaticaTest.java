package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Path;

public class FuenteDeDatosEstaticaTest {
  @Test
  public void elTipoDeUnaCamisaNuevaEsCAMISA() {
    String path = "C:\\Users\\nicol\\OneDrive\\Desktop\\CSVs\\2_public_emdat_2025-04-08.csv";
    Assertions.assertDoesNotThrow(() -> FuenteDeDatosEstatica.extraerHechos(Path.of(path)));
  }

}
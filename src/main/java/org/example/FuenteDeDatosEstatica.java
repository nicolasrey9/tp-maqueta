package org.example;

public class FuenteDeDatosEstatica {
  public static void extraerHechos(String rutaDataset) {
    if(!esArchivoCSV(rutaDataset)) { throw new RuntimeException("Solo hay soporte para .csv actualmente"); }

    //TODO


  }

  private static boolean esArchivoCSV(String rutaArchivo) {
    return true;  //TODO validacion
  }
}

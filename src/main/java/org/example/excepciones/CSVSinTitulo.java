package org.example.excepciones;

public class CSVSinTitulo extends RuntimeException {

  public CSVSinTitulo(String s) {
    super(s);
  }
}

package org.example;

import java.util.ArrayList;
import java.util.List;

public class Coleccion {
  private List<Hecho> hechos = new ArrayList<>();

  public void removerHecho(Hecho hecho) {
    hechos.removeIf(h -> h.equals(hecho) && !hecho.esVeridico());
  }

  public void agregarHecho(Hecho hecho) {
    if (hecho.esVeridico()) {
      hechos.add(hecho);
    }
  }
}

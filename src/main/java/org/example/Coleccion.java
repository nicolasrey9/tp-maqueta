package org.example;

import java.util.ArrayList;
import java.util.List;

public class Coleccion {
  private List<Hecho> hechos = new ArrayList<>();
  private String categoria;

  public void removerHecho(Hecho hecho) {
    hechos.removeIf(h -> h.equals(hecho) && !hecho.esVeridico()); //primero debo haber asegurarme que NO es veridico
  }

  public void agregarHecho(Hecho hecho) {
    if (hecho.esVeridico()) {
      hechos.add(hecho);
    }
  }

  public String getCategoria() {
    return categoria;
  }
}

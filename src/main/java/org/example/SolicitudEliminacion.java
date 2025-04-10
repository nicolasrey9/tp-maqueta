package org.example;

public class SolicitudEliminacion {
  private final Hecho hecho;
  private final String motivo;

  public SolicitudEliminacion(Hecho hecho, String motivo) {
    this.hecho = hecho;
    this.motivo = motivo;
  }

  public Hecho getHecho() {
    return hecho;
  }

  public String getMotivo() {
    return motivo;
  }
}
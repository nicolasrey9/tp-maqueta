package org.example;

import java.time.LocalDateTime;

public class SolicitudEliminacion {
  private final Hecho hecho;
  private final String justificacion;
  private final LocalDateTime fecha;
  private EstadoSolicitud estado;

  public SolicitudEliminacion(Hecho hecho, String justificacion) {
//    if (justificacion.length() < 500) {
//      throw new IllegalArgumentException("La justificación debe tener al menos 500 caracteres");
//    } LÓGICA REPETIDA EN HECHO
    this.hecho = hecho;
    this.justificacion = justificacion;
    this.fecha = LocalDateTime.now();
    this.estado = EstadoSolicitud.PENDIENTE;

    this.enviarSoliAlHecho(this.hecho);
  }

  // Getters
  public Hecho getHecho() { return hecho; }
  public String getJustificacion() { return justificacion; }
  public EstadoSolicitud getEstado() { return estado; }

  // Métodos para el administrador??

  // Falta ver como vamos a manejar las solicitudes,
  // se me ocurre crear una lista con todas las
  // solicitudes que accedan los admins.
  //tambien hay que preguntar como es el manejo de spam en
  //las solicitudes.

  public void aceptar() {
    this.estado = EstadoSolicitud.ACEPTADA;
    hecho.eliminarHecho(); // Marca el hecho como oculto
  }

  public void rechazar() {
    this.estado = EstadoSolicitud.RECHAZADA;
  }

  private void enviarSoliAlHecho(Hecho hecho) {
    hecho.agregarSolicitud(this);
  }

  public void eliminarSolicitud() {
    this.estado = EstadoSolicitud.RECHAZADA;
  }
}

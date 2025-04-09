package org.example;

public class Visitante {
  private DatosPersonales datosPersonales = null;
  private TipoUsuario tipo = TipoUsuario.VISUALIZADOR;

  public Visitante() {}

  public void visualizar() {
    //TODO logica para visualizar
  }

  public void subirHechos() {
    //TODO logica para subir
    if(this.tipo != TipoUsuario.CONTRIBUYENTE) this.tipo = TipoUsuario.CONTRIBUYENTE;
  }

  public void darseAConocer(DatosPersonales datosPersonales) {
    this.datosPersonales = datosPersonales;
    this.tipo = TipoUsuario.CONTRIBUYENTE;
  }

  public TipoUsuario getTipo() {
    return tipo;
  }


}


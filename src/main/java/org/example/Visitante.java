package org.example;

public class Visitante {
  private DatosPersonales datosPersonales = null;
  private TipoUsuario tipo = TipoUsuario.VISUALIZADOR;

  public Visitante() {}


  public void subirHecho() {
    if(this.tipo != TipoUsuario.CONTRIBUYENTE) this.tipo = TipoUsuario.CONTRIBUYENTE;
    //TODO logica para subir
  }

  public void darseAConocer(DatosPersonales datosPersonales) {
    this.datosPersonales = datosPersonales;
    this.tipo = TipoUsuario.CONTRIBUYENTE;
  }

  public TipoUsuario getTipo() {
    return tipo;
  }


}


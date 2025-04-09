package org.example;

public class Usuario {
  private DatosPersonales datosPersonales = null;
  private TipoUsuario tipo = TipoUsuario.VISUALIZADOR;

  public Usuario() {}

  public void visualizar() {
    //TODO logica para visualizar
  }

  public void subirHechos() {
    //TODO logica para subir
  }

  public void darseAConocer(DatosPersonales datosPersonales) {
    if(tipo == TipoUsuario.CONTRIBUYENTE) throw new RuntimeException("Este usuario ya se dio a conocer");
    this.datosPersonales = datosPersonales;
    this.tipo = TipoUsuario.CONTRIBUYENTE;
  }

  public TipoUsuario getTipo() {
    return tipo;
  }


}


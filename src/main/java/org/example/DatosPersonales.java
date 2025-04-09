package org.example;

public class DatosPersonales {
  final String nombre;
  String apellido = null;
  Integer edad = null;

  public DatosPersonales(String nombre) {
    this(nombre, null, null);
  }

  public DatosPersonales(String nombre, String apellido) {
    this(nombre, apellido, null);
  }

  public DatosPersonales(String nombre, int edad) {
    this(nombre, null, edad);
  }

  public DatosPersonales(String nombre, String apellido, Integer edad) {
    this.validarNombre(nombre);
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
  }

  private void validarNombre(String nombre) {
    if (nombre == null || nombre.isBlank())
      throw new IllegalArgumentException("El nombre es obligatorio");
  }

}

package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hecho {
  private final String titulo;
  private String descripcion;
  private String categoria;
  private ContenidoMultimedia contenidoMultimedia;
  private Ubicacion ubicacion;
  private LocalDate fechaDeAcontecimiento;
  private LocalDateTime fechaDeCarga;
  private Origen origen;


  public Hecho(String titulo, String descripcion, String categoria,
               ContenidoMultimedia contenidoMultimedia, Ubicacion ubicacion,
               LocalDate fechaDeAcontecimiento, Origen origen) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.categoria = categoria;
    this.ubicacion = ubicacion;
    this.fechaDeAcontecimiento = fechaDeAcontecimiento;
    this.origen = origen;
    this.contenidoMultimedia = contenidoMultimedia;
    this.fechaDeCarga = LocalDateTime.now();
  }

  public Hecho(String titulo, String descripcion, String categoria,
               Ubicacion ubicacion, LocalDate fechaDeAcontecimiento,
               Origen origen) {
    this(titulo, descripcion, categoria, null, ubicacion,
          fechaDeAcontecimiento, origen);
  }

  // getters

  public String getTitulo() { return titulo; }

  public String getDescripcion() { return descripcion; }

  public String getCategoria() { return categoria; }

  public ContenidoMultimedia getContenidoMultimedia() { return contenidoMultimedia; }

  public Ubicacion getUbicacion() { return ubicacion; }

  public LocalDate getFechaDeAcontecimiento() { return fechaDeAcontecimiento; }

  public LocalDateTime getFechaDeCarga() { return fechaDeCarga; }

  public Origen getOrigen() { return origen; }

  // setters

  protected void setDescripcion(String descripcion) { this.descripcion = descripcion; }

  protected void setCategoria(String categoria) { this.categoria = categoria; }

  protected void setContenidoMultimedia(ContenidoMultimedia contenidoMultimedia) {
    this.contenidoMultimedia = contenidoMultimedia;
  }

  protected void setUbicacion(Ubicacion ubicacion) { this.ubicacion = ubicacion; }

  protected void setFechaDeAcontecimiento(LocalDate fechaDeAcontecimiento) {
    this.fechaDeAcontecimiento = fechaDeAcontecimiento;
  }

  protected void setFechaDeCarga(LocalDateTime fechaDeCarga) {
    this.fechaDeCarga = fechaDeCarga;
  }

  protected void setOrigen(Origen origen) {
    this.origen = origen;
  }



}

package com.backend.parcial.entity;


public class Odontologo {

    private Long id;
    private String nombre;
    private String apellido;

    public Odontologo(Long id, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }
    public Odontologo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "\nId: " + id + " - Nombre: " + nombre + " Apellido: " + apellido;
    }
}

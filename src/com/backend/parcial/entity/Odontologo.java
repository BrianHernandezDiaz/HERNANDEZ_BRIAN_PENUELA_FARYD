package com.backend.parcial.entity;


public class Odontologo {

    private Long id;
    private int numero_matricula;
    private String nombre;
    private String apellido;

    public int getNumero_matricula() {
        return numero_matricula;
    }

    public void setNumero_matricula(int numero_matricula) {
        this.numero_matricula = numero_matricula;
    }

    public Odontologo(Long id, int numero_matricula, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.numero_matricula = numero_matricula;
    }
    public Odontologo(int numero_matricula, String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_matricula = numero_matricula;
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

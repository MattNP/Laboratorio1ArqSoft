package com.udea.controller;

/**
 *
 * @author jorgel.diaz
 */
public class BeanUsuario {
    
    private String nombres;
    private String apellidos;
    private int edad;
    private float estatura;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public BeanUsuario(String nombres, String apellidos, int edad, float estatura) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estatura = estatura;
    }
    
}

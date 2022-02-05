/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ya.tarea.dao;

/**
 *
 * @author Yobany Abrego
 */
public class Persona 
{

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Estatura
     */
    public double getEstatura() {
        return Estatura;
    }

    /**
     * @param Estatura the Estatura to set
     */
    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
    }

    /**
     * @return the Peso
     */
    public double getPeso() {
        return Peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }
    public String getRow() {
        return String.format("%s\t%s\t%s\t%s\t%s", Id, Nombre, Apellido, Estatura, Peso);
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    private String Nombre;
    private String Apellido;
    private double Estatura;
    private double Peso;
    private int Id;
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

public class Jornadas {

    private int codigo;
    private String nombre;

    public Jornadas() {}

    public Jornadas(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Jornadas(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS Y SETTERS

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}


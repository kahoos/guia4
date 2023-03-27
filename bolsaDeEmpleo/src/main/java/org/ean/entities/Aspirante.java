package org.ean.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "aspirante")
@Table(name = "aspirante")

public class Aspirante {

    @Id
    @Column(name = "cedula", nullable = false)
    private int cedula;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "aniosexp", nullable = false)
    private int aniosexp;
    @Column(name = "profesion", nullable = false, length = 45)
    private String profesion;
    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;

    public Aspirante(){}

    public Aspirante(int cedula, String nombre, int edad, int aniosexp, String profesion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.aniosexp = aniosexp;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAniosexp() {
        return aniosexp;
    }

    public void setAniosexp(int aniosexp) {
        this.aniosexp = aniosexp;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void mostrarInformacion() {
        System.out.println("\nCC: " + cedula +
                " \n Nombre: " + nombre +
                " \n Edad: " + edad + " años" +
                " \n Experiencia: " + aniosexp + " años" +
                " \n Profesión: " + profesion +
                " \n Teléfono: " + telefono
                );
    }
}

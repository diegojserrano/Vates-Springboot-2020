package com.example.abmhr;

import org.springframework.data.jpa.repository.query.Procedure;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES", schema = "HR")
public class Empleado {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private int id;

    @Column(name = "FIRST_NAME")
    private String nombre;

    @Column(name = "LAST_NAME")
    private String apellido;

    @Column(name = "PHONE_NUMBER")
    private String telefono;

    @Column
    private String email;



    public Empleado(int id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}

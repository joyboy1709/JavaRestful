package com.santiago.springboot.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
      //variables
    private int id;
    
    private String nombre;
    
    private int edad;
    
    private double salario;

   
    public Persona() {}

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        
        this.salario = calcularSalario(edad);
    }

    // Método para calcular el salario
    private double calcularSalario(int edad) {
        double SALARIO_MINIMO = 1000;  
        return (edad * SALARIO_MINIMO) / 3;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        // Actualiza el salario si cambia la edad
        this.salario = calcularSalario(edad);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

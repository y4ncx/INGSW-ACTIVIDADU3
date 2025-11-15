package com.empresa.nomina.modelos;

public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected int tiempoEnEmpresa;
    protected double salarioBase;

    public Empleado(String nombre, String id, int tiempoEnEmpresa, double salarioBase) {
        if (tiempoEnEmpresa < 0) {
            throw new IllegalArgumentException("El tiempo en empresa no puede ser negativo");
        }

        if (salarioBase < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }

        this.nombre = nombre;
        this.id = id;
        this.tiempoEnEmpresa = tiempoEnEmpresa;
        this.salarioBase = salarioBase;


    }

    public abstract double calcularSalarioBruto();
    public abstract double calcularBeneficios();
    public abstract double calcularDeducciones();

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() + calcularBeneficios() + calcularDeducciones();
    }


    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getTiempoEnEmpresa() {
        return tiempoEnEmpresa;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

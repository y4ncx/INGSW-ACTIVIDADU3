package com.empresa.nomina.modelos;

public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected int tiempoEnEmpresa;
    protected double salarioBase;

    // Constructor generico con excepciones para numeros negativos (para no romper la logica)

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

    // metodos abstractos que cada tipo de empleado va a implementar

    public abstract double calcularSalarioBruto();
    public abstract double calcularBeneficios();
    public abstract double calcularDeducciones();


    //metodo comun

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() + calcularBeneficios() + calcularDeducciones();
    }

    // Getters

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


    //Sin Setters, ya que no se deberia modificar los datos de un empleado una vez haya sido creado.
}

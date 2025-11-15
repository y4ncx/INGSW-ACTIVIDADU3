package com.empresa.nomina.modelos;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String nombre, String id, int tiempoEnEmpresa, double salarioBase) {
        super(nombre, id, tiempoEnEmpresa, salarioBase);
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }

    @Override
    public double calcularBeneficios() {
        return 0; // no aplica
    }

    @Override
    public double calcularDeducciones() {
        return 0; // lo hara el servicio
    }
}

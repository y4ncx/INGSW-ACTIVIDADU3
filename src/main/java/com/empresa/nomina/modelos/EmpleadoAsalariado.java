package com.empresa.nomina.modelos;

public class EmpleadoAsalariado extends Empleado{

    public EmpleadoAsalariado(String nombre, String apellido, int edad, double salarioBase) {
        super(nombre, apellido, edad, salarioBase);
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase;
    }

    @Override
    public double calcularBeneficios() {
        if (tiempoEnEmpresa > 5 ) {
            return salarioBase * 0.10; // le damos un bono del 10% si tiene mas de 5 años
        }

        return 0;
    }

    @Override
    public double calcularDeducciones() {
        return 0; // esto lo hara el servicio mas adelante
    }


}

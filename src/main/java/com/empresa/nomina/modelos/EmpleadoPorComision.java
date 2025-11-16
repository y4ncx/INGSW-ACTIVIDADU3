package com.empresa.nomina.modelos;

public class EmpleadoPorComision extends Empleado {

    public double ventas;
    public double porcentajeComision;


    public EmpleadoPorComision(String nombre, String id, int tiempoEnEmpresa, double salarioBase, double ventas, double porcentajeComision) {
        super(nombre, id, tiempoEnEmpresa, salarioBase);

        if (ventas < 0 ) {
            throw new IllegalArgumentException("El venta no puede ser menor a 0");
        }

        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;

    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase + (ventas * porcentajeComision);
    }

    @Override
    public double calcularBeneficios() {
        if (ventas > 20_000_000){ // los _ solo mejoran la legibilidad, son separadores que java no lee
            return ventas * 0.03; // bono del 3%
        }

        return 0;
    }

    @Override
    public double calcularDeducciones() {
        return 0; // lo hace el servicio
    }

}

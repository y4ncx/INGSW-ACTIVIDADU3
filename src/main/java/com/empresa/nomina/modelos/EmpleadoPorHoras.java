package com.empresa.nomina.modelos;

public class EmpleadoPorHoras extends Empleado{

    private double horasTrabajadas;
    private double tarifaHora;
    private boolean accesoFondoAhorro;

    public EmpleadoPorHoras (String nombre, String id, int tiempoEnEmpresa, double salarioBase, double horasTrabajadas, double tarifaHora, boolean accesoFondoAhorro) {
        super(nombre, id, tiempoEnEmpresa, salarioBase);


        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("horasTrabajadas no puede ser negativo");
        }
        if (tarifaHora < 0) {
            throw new IllegalArgumentException("tarifaHora no puede ser negativo");
        }

        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
        this.accesoFondoAhorro = accesoFondoAhorro;

    }


    @Override
    public double calcularSalarioBruto() {
        double normales = Math.min(40, horasTrabajadas) * tarifaHora;
        double extras = Math.max(0, horasTrabajadas = 40) *(tarifaHora * 1.5);
        return normales + extras;
    }

    @Override
    public double calcularBeneficios() {
        return 0; // lo calcuila el servicio
    }

    @Override
    public double calcularDeducciones() {
        return 0; // lo calcula el servicio
    }


    public boolean tieneAccesoFondoAhorro() {
        return accesoFondoAhorro;
    }


}

package com.empresa.nomina.servicios;

import com.empresa.nomina.util.Constantes;
import com.empresa.nomina.util.Validaciones;

public class CalculadoraDeducciones {

    public double calcularDeducciones(double salarioBase) {
        Validaciones.validarSalario(salarioBase);

        double salud = calcularSalud(salarioBase);
        double pension = calcularPension(salarioBase);
        double fondoSolidaridad = calcularFondoSolidaridad(salarioBase);

        return salud + pension + fondoSolidaridad;
    }

    public double calcularSalud(double salarioBase) {
        return salarioBase * Constantes.PORCENTAJE_SALUD;
    }

    public double calcularPension(double salarioBase) {
        return salarioBase * Constantes.PORCENTAJE_PENSION;
    }

    public double calcularFondoSolidaridad(double salarioBase) {
        if (salarioBase >= Constantes.TOPE_FONDO_SOLIDARIDAD) {
            return salarioBase * Constantes.PORCENTAJE_FONDO_SOLIDARIDAD;
        }
        return 0;
    }
}

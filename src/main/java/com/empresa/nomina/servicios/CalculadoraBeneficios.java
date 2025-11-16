package com.empresa.nomina.servicios;

import com.empresa.nomina.util.Constantes;
import com.empresa.nomina.util.Validaciones;

public class CalculadoraBeneficios {

    public double calcularBeneficios(double salarioBase, double horasExtras) {
        Validaciones.validarSalario(salarioBase);
        Validaciones.validarHoras(horasExtras);

        double auxilioTransporte = calcularAuxilioTransporte(salarioBase);
        double primaServicios = calcularPrimaServicios(salarioBase);
        double vacaciones = calcularVacaciones(salarioBase);
        double pagoHorasExtras = calcularPagoHorasExtras(salarioBase, horasExtras);

        return auxilioTransporte + primaServicios + vacaciones + pagoHorasExtras;
    }

    public double calcularAuxilioTransporte(double salarioBase) {
        return salarioBase * Constantes.PORCENTAJE_AUXILIO_TRANSPORTE;
    }

    public double calcularPrimaServicios(double salarioBase) {
        return salarioBase * Constantes.PORCENTAJE_PRIMA;
    }

    public double calcularVacaciones(double salarioBase) {
        return salarioBase * Constantes.PORCENTAJE_VACACIONES;
    }

    public double calcularPagoHorasExtras(double salarioBase, double horasExtras) {
        if (horasExtras <= 0) return 0;

        double valorHora = salarioBase / Constantes.HORAS_LABORALES_MES;
        double valorHoraExtra = valorHora * Constantes.VALOR_HORA_EXTRA;

        return horasExtras * valorHoraExtra;
    }
}

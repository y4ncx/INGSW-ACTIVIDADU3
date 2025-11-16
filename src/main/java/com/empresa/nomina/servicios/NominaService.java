package com.empresa.nomina.servicios;

import com.empresa.nomina.util.Constantes;
import com.empresa.nomina.util.Validaciones;

public class NominaService {

    private final CalculadoraBeneficios calculadoraBeneficios;
    private final CalculadoraDeducciones calculadoraDeducciones;

    public NominaService() {
        this.calculadoraBeneficios = new CalculadoraBeneficios();
        this.calculadoraDeducciones = new CalculadoraDeducciones();
    }

    public NominaService(CalculadoraBeneficios calculadoraBeneficios,
                        CalculadoraDeducciones calculadoraDeducciones) {

        this.calculadoraBeneficios = calculadoraBeneficios;
        this.calculadoraDeducciones = calculadoraDeducciones;
    }

    public double calcularNominaTotal(Object modeloNominable,
                                    double salarioBase,
                                    double horasExtras) {

        Validaciones.validarNoNulo(modeloNominable);
        Validaciones.validarSalario(salarioBase);
        Validaciones.validarHoras(horasExtras);

        double totalBeneficios =
                calculadoraBeneficios.calcularBeneficios(salarioBase, horasExtras);

        double totalDeducciones =
                calculadoraDeducciones.calcularDeducciones(salarioBase);

        double salarioNeto = salarioBase + totalBeneficios - totalDeducciones;

        if (salarioNeto < Constantes.MINIMO_SALARIO_NETO) {
            salarioNeto = Constantes.MINIMO_SALARIO_NETO;
        }

        return salarioNeto;
    }
}

package com.empresa.nomina.util;

public final class Validaciones {

    private Validaciones() {

    }


    public static void validarNoNulo(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(Constantes.ERROR_MODELO_NULO);
        }
    }

    public static void validarSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException(Constantes.ERROR_SALARIO_INVALIDO);
        }
    }

    public static void validarHoras(double horas) {
        if (horas < 0) {
            throw new IllegalArgumentException(Constantes.ERROR_HORAS_INVALIDAS);
        }
    }
}

package com.empresa.nomina.util;

import com.empresa.nomina.modelos.Empleado;

public final class Validaciones {

    private Validaciones() {

    }
    public static void validarEmpleado(Empleado e) {
        if (e == null) {
            throw new IllegalArgumentException("El empleado no puede ser null");
        }

        validarString(e.getNombre(), "nombre");
        validarString(e.getId(), "id");
        validarNumeroNoNegativo(e.getTiempoEnEmpresa(), "tiempo en empresa");
        validarNumeroNoNegativo(e.getSalarioBase(), "salario base");
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

        public static void validarString(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("El campo " + campo + " no puede estar vacío");
        }
    }

    public static void validarNumeroNoNegativo(double valor, String campo) {
        if (valor < 0) {
            throw new IllegalArgumentException("El campo " + campo + " no puede ser negativo");
        }
    }
}
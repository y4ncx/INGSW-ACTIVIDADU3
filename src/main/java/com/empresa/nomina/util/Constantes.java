package com.empresa.nomina.util;

public final class Constantes {

    public static final double SALARIO_MINIMO = 1300000.00;
    public static final int HORAS_LABORALES_MES = 240;
    public static final double VALOR_HORA_EXTRA = 1.25;

    public static final double PORCENTAJE_AUXILIO_TRANSPORTE = 0.06;
    public static final double PORCENTAJE_PRIMA = 0.0833;
    public static final double PORCENTAJE_VACACIONES = 0.0417;

    public static final double PORCENTAJE_SALUD = 0.04;
    public static final double PORCENTAJE_PENSION = 0.04;
    public static final double PORCENTAJE_FONDO_SOLIDARIDAD = 0.01;
    public static final double TOPE_FONDO_SOLIDARIDAD = 4000000.00;


    public static final String ERROR_SALARIO_INVALIDO =
            "El salario base no puede ser negativo ni nulo.";

    public static final String ERROR_HORAS_INVALIDAS =
            "Las horas trabajadas deben ser mayores o iguales a cero.";

    public static final String ERROR_MODELO_NULO =
            "El modelo recibido es nulo.";


    public static final double MINIMO_SALARIO_NETO = 0.0;

    private Constantes() { }
}

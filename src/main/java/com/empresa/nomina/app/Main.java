package com.empresa.nomina.app;

import com.empresa.nomina.modelos.*;
import com.empresa.nomina.servicios.NominaService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Contenedor simple para emparejar un Empleado con sus horas extras conocidas.
    private static class EjemploEmpleado {
        public final Empleado empleado;
        public final double horasExtras;

        public EjemploEmpleado(Empleado empleado, double horasExtras) {
            this.empleado = empleado;
            this.horasExtras = horasExtras;
        }
    }

    public static void main(String[] args) {

        // Mostrar mensaje inicial.
        System.out.println("===== INICIO SISTEMA DE NÓMINA =====");

        // Instanciar el servicio de nómina que calcula beneficios y deducciones.
        NominaService nominaService = new NominaService();

        // Crear la lista de empleados de ejemplo junto con sus horas extras.
        List<EjemploEmpleado> ejemplos = cargarEmpleadosEjemplo();

        // Recorrer cada ejemplo y calcular la nómina usando NominaService.
        for (EjemploEmpleado ejemplo : ejemplos) {

            // Mostrar encabezado del empleado.
            System.out.println();
            System.out.println("Empleado: " + ejemplo.empleado.getNombre() + " (ID: " + ejemplo.empleado.getId() + ").");

            // Calcular salario bruto usando el método del propio modelo.
            double salarioBruto;

            try {
                salarioBruto = ejemplo.empleado.calcularSalarioBruto();

                // Mostrar el salario bruto calculado por el modelo.
                System.out.printf(" - Salario bruto calculado por el modelo: %.2f.%n", salarioBruto);

            } catch (Exception ex) {

                // Mostrar error si el cálculo directo del modelo falla.
                System.out.println(" - Error calculando salario bruto: " + ex.getMessage() + ".");
                salarioBruto = ejemplo.empleado.getSalarioBase();
                System.out.printf(" - Se usará salario base como aproximación: %.2f.%n", salarioBruto);
            }

            // Calcular beneficios y deducciones usando NominaService.
            try {
                double neto = nominaService.calcularNominaTotal(
                        ejemplo.empleado, ejemplo.empleado.getSalarioBase(), ejemplo.horasExtras
                );

                // Mostrar el resultado neto final obtenido por el servicio.
                System.out.printf(" - Salario neto final calculado por el servicio: %.2f.%n", neto);

            } catch (IllegalArgumentException iae) {
                // Mostrar mensaje claro si las validaciones internas fallan.
                System.out.println(" - No fue posible calcular la nómina con NominaService: " + iae.getMessage() + ".");

            } catch (Exception e) {

                // Captura general para evitar que un error detenga el resto de ejemplos.
                System.out.println(" - Error inesperado al calcular nómina: " + e.getMessage() + ".");
            }

            // Mostrar beneficios y deducciones invocando los métodos del modelo cuando existan.
            try {
                double beneficiosModelo = ejemplo.empleado.calcularBeneficios();

                // Mostrar beneficios reportados por el modelo.
                System.out.printf(" - Beneficios según modelo: %.2f.%n", beneficiosModelo);

            } catch (Exception ex) {
                System.out.println(" - Error calculando beneficios por el modelo: " + ex.getMessage() + ".");
            }

            try {
                double deduccionesModelo = ejemplo.empleado.calcularDeducciones();

                // Mostrar deducciones reportadas por el modelo.
                System.out.printf(" - Deducciones según modelo: %.2f.%n", deduccionesModelo);

            } catch (Exception ex) {
                System.out.println(" - Error calculando deducciones por el modelo: " + ex.getMessage() + ".");
            }
        }

        // Mostrar mensaje de cierre.
        System.out.println();
        System.out.println("===== FIN SISTEMA DE NÓMINA =====");
    }

    // Crear empleados de ejemplo y devolverlos con las horas extras conocidas.
    private static List<EjemploEmpleado> cargarEmpleadosEjemplo() {
        List<EjemploEmpleado> lista = new ArrayList<>();

        // Crear Empleado Asalariado con salario base positivo y tiempo en empresa mayor a 5 años.
        EmpleadoAsalariado asalariado = new EmpleadoAsalariado(
                "Ana Pérez", "E-001", 6, 3_000_000.00
        );

        lista.add(new EjemploEmpleado(asalariado, 0.0));

        // Crear Empleado Por Comision con ventas y porcentaje de comisión.
        EmpleadoPorComision comision = new EmpleadoPorComision(
                "Carlos Gómez", "E-002", 3, 1_200_000.00, 25_000_000.00, 0.05
        );

        lista.add(new EjemploEmpleado(comision, 0.0));

        // Crear Empleado Por Horas. Las horasExtras se especifican igual que las horas pasadas minus 40.
        // En este caso el empleado trabajó 48 horas, por lo que horasExtras = 8.
        double horasTrabajadas = 48.0;
        double horasExtras = Math.max(0, horasTrabajadas - 40.0);
        EmpleadoPorHoras porHoras = new EmpleadoPorHoras(
                "Luisa Torres", "E-003", 2, 1_200_000.00, horasTrabajadas, 18_000.00, true
        );

        lista.add(new EjemploEmpleado(porHoras, horasExtras));

        // Crear Empleado Temporal con salario base estándar.
        EmpleadoTemporal temporal = new EmpleadoTemporal(
                "Mario Díaz", "E-004", 1, 1_600_000.00
        );

        lista.add(new EjemploEmpleado(temporal, 0.0));

        return lista;
    }
}

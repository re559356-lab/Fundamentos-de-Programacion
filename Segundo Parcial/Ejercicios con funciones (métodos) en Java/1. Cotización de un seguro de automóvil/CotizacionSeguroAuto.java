import java.util.Scanner;

public class CotizacionSeguroAuto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valorVehiculo;
        int edad;
        int accidentes;
        boolean tieneSeguridad;

        System.out.println("=== SISTEMA DE COTIZACIÓN DE SEGUROS DE AUTOMÓVIL ===");

        // 1. Validación de restricciones de entrada
        do {
            System.out.print("Ingrese el valor del vehículo (mayor a 0): ");
            valorVehiculo = scanner.nextDouble();
            if (valorVehiculo <= 0) {
                System.out.println("Error: El valor del vehículo debe ser mayor que cero.");
            }
        } while (valorVehiculo <= 0);

        do {
            System.out.print("Ingrese la edad del conductor (entre 18 y 100): ");
            edad = scanner.nextInt();
            if (edad < 18 || edad > 100) {
                System.out.println("Error: La edad debe estar entre 18 y 100 años.");
            }
        } while (edad < 18 || edad > 100);

        do {
            System.out.print("Ingrese la cantidad de accidentes reportados (no negativo): ");
            accidentes = scanner.nextInt();
            if (accidentes < 0) {
                System.out.println("Error: El número de accidentes no puede ser negativo.");
            }
        } while (accidentes < 0);

        System.out.print("¿Cuenta con sistema de seguridad adicional? (true para sí, false para no): ");
        tieneSeguridad = scanner.nextBoolean();

        // 2. Ejecución modular de funciones
        double tarifaBase = calcularTarifaBase(valorVehiculo);
        double recargoEdad = calcularRecargoPorEdad(tarifaBase, edad);
        double recargoAccidentes = calcularRecargoPorAccidentes(tarifaBase, accidentes);
        
        // Subtotal acumulado necesario para calcular el descuento de seguridad
        double subtotalAcumulado = tarifaBase + recargoEdad + recargoAccidentes;
        double descuento = calcularDescuentoSeguridad(subtotalAcumulado, tieneSeguridad);
        
        double costoFinal = calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento);

        // 3. Despliegue de resultados detallados
        System.out.println("\n-----------------------------------------");
        System.out.println("           DESGLOSE DE COTIZACIÓN        ");
        System.out.println("-----------------------------------------");
        System.out.printf("Tarifa Base (4%%):           $%.2f\n", tarifaBase);
        System.out.printf("Recargo por Edad:            $%.2f\n", recargoEdad);
        System.out.printf("Recargo por Accidentes:      $%.2f\n", recargoAccidentes);
        System.out.printf("Descuento por Seguridad:     $%.2f\n", descuento);
        System.out.println("-----------------------------------------");
        System.out.printf("COSTO FINAL DE LA PÓLIZA:    $%.2f\n", costoFinal);
        System.out.println("-----------------------------------------");

        scanner.close();
    }

    // Métodos obligatorios solicitados
    public static double calcularTarifaBase(double valorVehiculo) {
        return valorVehiculo * 0.04;
    }

    public static double calcularRecargoPorEdad(double tarifaBase, int edad) {
        if (edad < 25) {
            return tarifaBase * 0.20; // Recargo del 20%
        } else if (edad <= 60) {
            return 0.0; // Sin recargo
        } else {
            return tarifaBase * 0.10; // Recargo del 10%
        }
    }

    public static double calcularRecargoPorAccidentes(double tarifaBase, int accidentes) {
        return tarifaBase * 0.08 * accidentes; // 8% por cada accidente
    }

    public static double calcularDescuentoSeguridad(double subtotal, boolean tieneSeguridad) {
        if (tieneSeguridad) {
            return subtotal * 0.05; // 5% de descuento sobre el acumulado
        }
        return 0.0;
    }

    public static double calcularCostoFinal(double tarifaBase, double recargoEdad, double recargoAccidentes, double descuento) {
        double subtotal = tarifaBase + recargoEdad + recargoAccidentes;
        return subtotal - descuento;
    }
}
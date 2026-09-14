import java.util.Scanner;

public class ControlConsumoElectrico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lecturaAnterior;
        double lecturaActual;
        double consumo = 0;
        boolean tieneApoyo;
        boolean entradaValida = false;

        System.out.println("=== SISTEMA DE CONTROL DE CONSUMO ELÉCTRICO ===");

        // 1. Validación de restricciones de entrada
        do {
            System.out.print("Ingrese la lectura anterior del medidor (no negativa): ");
            lecturaAnterior = scanner.nextDouble();
            System.out.print("Ingrese la lectura actual del medidor (mayor o igual a la anterior): ");
            lecturaActual = scanner.nextDouble();

            if (lecturaAnterior < 0 || lecturaActual < 0) {
                System.out.println("Error: Las lecturas no pueden ser negativas.");
            } else if (lecturaActual < lecturaAnterior) {
                System.out.println("Error: La lectura actual debe ser mayor o igual que la lectura anterior.");
            } else {
                consumo = calcularConsumo(lecturaAnterior, lecturaActual);
                if (consumo > 10000.0) {
                    System.out.println("Error: El consumo (" + consumo + " kWh) excede el límite máximo permitido de 10,000 kWh.");
                } else {
                    entradaValida = true;
                }
            }
        } while (!entradaValida);

        System.out.print("¿La vivienda pertenece al programa de apoyo gubernamental? (true para sí, false para no): ");
        tieneApoyo = scanner.nextBoolean();

        // 2. Ejecución modular de funciones
        double costoConsumo = calcularCostoConsumo(consumo);
        double cargoFijo = 95.0;
        
        // El costo antes de impuesto incluye el consumo más el cargo fijo
        double costoAntesImpuesto = costoConsumo + cargoFijo;
        
        double descuento = calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo);
        
        // Base sobre la cual se calcula el impuesto (costo antes de impuesto menos el descuento)
        double baseImpuesto = costoAntesImpuesto - descuento;
        double impuesto = calcularImpuesto(baseImpuesto);
        
        double total = calcularTotal(costoConsumo, cargoFijo, descuento, impuesto);

        // 3. Despliegue de resultados a través del método requerido
        mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total);

        scanner.close();
    }

    // Métodos obligatorios solicitados
    public static double calcularConsumo(double lecturaAnterior, double lecturaActual) {
        return lecturaActual - lecturaAnterior;
    }

    public static double calcularCostoConsumo(double consumo) {
        double costo = 0.0;
        if (consumo <= 150) {
            costo = consumo * 1.20;
        } else if (consumo <= 400) {
            // Primeros 150 kWh a 1.20 + el resto del bloque hasta 400 a 1.80
            costo = (150 * 1.20) + ((consumo - 150) * 1.80);
        } else {
            // Primeros 150 a 1.20 + siguientes 250 a 1.80 + excedente superior a 400 a 2.75
            costo = (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75);
        }
        return costo;
    }

    public static double calcularDescuentoApoyo(double consumo, double costoAntesImpuesto, boolean tieneApoyo) {
        if (tieneApoyo && consumo <= 250) {
            return costoAntesImpuesto * 0.30; // 30% de descuento sobre el costo antes del impuesto
        }
        return 0.0;
    }

    public static double calcularImpuesto(double baseImponible) {
        return baseImponible * 0.16; // 16% de impuesto
    }

    public static double calcularTotal(double costoConsumo, double cargoFijo, double descuento, double impuesto) {
        // El total es el costo antes del impuesto (costoConsumo + cargoFijo), menos el descuento, más el impuesto
        double costoAntesImpuesto = costoConsumo + cargoFijo;
        return costoAntesImpuesto - descuento + impuesto;
    }

    public static void mostrarRecibo(double consumo, double costoConsumo, double descuento, double impuesto, double total) {
        System.out.println("\n=========================================");
        System.out.println("           RECIBO DE LUZ - CFE           ");
        System.out.println("=========================================");
        System.out.printf("Consumo registrado:           %.2f kWh\n", consumo);
        System.out.printf("Costo por consumo escalonado: $%.2f\n", costoConsumo);
        System.out.printf("Cargo fijo:                   $95.00\n");
        System.out.printf("Descuento por programa apoyo: -$%.2f\n", descuento);
        System.out.printf("Impuesto (16%%):               +$%.2f\n", impuesto);
        System.out.println("-----------------------------------------");
        System.out.printf("TOTAL A PAGAR:                $%.2f\n", total);
        System.out.println("=========================================");
    }
}
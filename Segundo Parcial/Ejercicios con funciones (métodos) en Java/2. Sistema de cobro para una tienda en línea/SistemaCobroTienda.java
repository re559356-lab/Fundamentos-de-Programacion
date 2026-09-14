import java.util.Scanner;

public class SistemaCobroTienda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double precio1, precio2, precio3;
        int cantidad1, cantidad2, cantidad3;
        int tipoCliente;
        String codigoPostal;

        System.out.println("=== SISTEMA DE COBRO - TIENDA EN LÍNEA ===");

        // 1. Validaciones de entradas con restricciones
        // Producto 1
        do {
            System.out.print("Ingrese el precio del producto 1 (mayor a 0): ");
            precio1 = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto 1 (entero mayor a 0): ");
            cantidad1 = scanner.nextInt();
            if (precio1 <= 0 || cantidad1 <= 0) {
                System.out.println("Error: El precio y la cantidad deben ser mayores que cero.");
            }
        } while (precio1 <= 0 || cantidad1 <= 0);

        // Producto 2
        do {
            System.out.print("Ingrese el precio del producto 2 (mayor a 0): ");
            precio2 = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto 2 (entero mayor a 0): ");
            cantidad2 = scanner.nextInt();
            if (precio2 <= 0 || cantidad2 <= 0) {
                System.out.println("Error: El precio y la cantidad deben ser mayores que cero.");
            }
        } while (precio2 <= 0 || cantidad2 <= 0);

        // Producto 3
        do {
            System.out.print("Ingrese el precio del producto 3 (mayor a 0): ");
            precio3 = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto 3 (entero mayor a 0): ");
            cantidad3 = scanner.nextInt();
            if (precio3 <= 0 || cantidad3 <= 0) {
                System.out.println("Error: El precio y la cantidad deben ser mayores que cero.");
            }
        } while (precio3 <= 0 || cantidad3 <= 0);

        // Tipo de Cliente
        do {
            System.out.print("Ingrese el tipo de cliente (1: Regular, 2: Frecuente): ");
            tipoCliente = scanner.nextInt();
            if (tipoCliente != 1 && tipoCliente != 2) {
                System.out.println("Error: El tipo de cliente solo puede ser 1 o 2.");
            }
        } while (tipoCliente != 1 && tipoCliente != 2);

        // Código Postal
        scanner.nextLine(); // Limpiar búfer
        do {
            System.out.print("Ingrese el código postal (exactamente 5 dígitos): ");
            codigoPostal = scanner.nextLine();
            if (!validarCodigoPostal(codigoPostal)) {
                System.out.println("Error: El código postal debe contener exactamente cinco dígitos numéricos.");
            }
        } while (!validarCodigoPostal(codigoPostal));

        // 2. Ejecución modular de funciones requeridas
        double sub1 = calcularSubtotalProducto(precio1, cantidad1);
        double sub2 = calcularSubtotalProducto(precio2, cantidad2);
        double sub3 = calcularSubtotalProducto(precio3, cantidad3);

        double subtotalGeneral = calcularSubtotalGeneral(sub1, sub2, sub3);
        double descuento = calcularDescuento(subtotalGeneral, tipoCliente);
        
        double subtotalConDescuento = subtotalGeneral - descuento;
        double envio = calcularEnvio(subtotalGeneral, codigoPostal);
        double impuesto = calcularImpuesto(subtotalConDescuento);
        double total = calcularTotal(subtotalGeneral, descuento, impuesto, envio);

        // 3. Despliegue de resultados detallados
        System.out.println("\n-----------------------------------------");
        System.out.println("           RESUMEN DE COMPRA             ");
        System.out.println("-----------------------------------------");
        System.out.printf("Subtotal General:            $%.2f\n", subtotalGeneral);
        System.out.printf("Descuento aplicado:         -$%.2f\n", descuento);
        System.out.printf("Costo de Envío:             +$%.2f\n", envio);
        System.out.printf("Impuesto (16%%):             +$%.2f\n", impuesto);
        System.out.println("-----------------------------------------");
        System.out.printf("TOTAL A PAGAR:               $%.2f\n", total);
        System.out.println("-----------------------------------------");

        scanner.close();
    }

    // Método adicional de apoyo para validar el código postal (5 dígitos)
    public static boolean validarCodigoPostal(String cp) {
        if (cp == null || cp.length() != 5) {
            return false;
        }
        for (int i = 0; i < cp.length(); i++) {
            if (!Character.isDigit(cp.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Métodos obligatorios solicitados
    public static double calcularSubtotalProducto(double precio, int cantidad) {
        return precio * cantidad;
    }

    public static double calcularSubtotalGeneral(double subtotal1, double subtotal2, double subtotal3) {
        return subtotal1 + subtotal2 + subtotal3;
    }

    public static double calcularDescuento(double subtotal, int tipoCliente) {
        if (tipoCliente == 2) {
            return subtotal * 0.10; // Cliente frecuente: 10%
        }
        return 0.0; // Cliente regular: 0%
    }

    public static double calcularEnvio(double subtotal, String codigoPostal) {
        // Se utiliza el código postal como parámetro según la firma requerida
        if (subtotal < 1000.0) {
            return 150.0;
        } else if (subtotal < 3000.0) {
            return 80.0;
        } else {
            return 0.0; // Gratis si es igual o superior a $3,000
        }
    }

    public static double calcularImpuesto(double subtotalConDescuento) {
        return subtotalConDescuento * 0.16; // 16% de impuesto
    }

    public static double calcularTotal(double subtotal, double descuento, double impuesto, double envio) {
        return (subtotal - descuento) + impuesto + envio;
    }
}

import java.util.Scanner;

public class CinePrecioEntradasCiclo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constantes de precios
        final double PRECIO_BASE = 50.0;
        final double PRECIO_MIERCOLES = 30.0;
        final double PRECIO_PAREJA_JUEVES = 75.0;
        
        String respuesta;
        
        do {
            System.out.println("\n=== SISTEMA DE VENTA DE ENTRADAS DE CINE ===");
            
            System.out.print("Introduce el numero de personas: ");
            int personas = scanner.nextInt();
            
            // Validar que el número de personas sea positivo
            if (personas <= 0) {
                System.out.println("Error: El numero de personas debe ser mayor a 0.");
                System.out.print("\n¿Deseas realizar otra operacion? (si/no): ");
                respuesta = scanner.next().trim().toLowerCase();
                continue; // Vuelve al inicio del ciclo
            }
            
            System.out.print("Introduce el dia de la semana (Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo): ");
            // Limpiar y normalizar la entrada
            String dia = scanner.next().trim().toLowerCase();
            
            System.out.print("¿Cuentas con membresia? (si/no): ");
            String tieneMembresiaStr = scanner.next().trim().toLowerCase();
            boolean tieneMembresia = tieneMembresiaStr.equals("si") || tieneMembresiaStr.equals("s") || tieneMembresiaStr.equals("sí");
            
            double total = 0.0;
            
            // Estructura selectiva múltiple para calcular según el día
            switch (dia) {
                case "miercoles":
                case "miércoles":
                    total = personas * PRECIO_MIERCOLES;
                    break;
                    
                case "jueves":
                    int parejas = personas / 2;
                    int individuales = personas % 2;
                    total = (parejas * PRECIO_PAREJA_JUEVES) + (individuales * PRECIO_BASE);
                    break;
                    
                case "lunes":
                case "martes":
                case "viernes":
                case "sabado":
                case "sábado":
                case "domingo":
                    total = personas * PRECIO_BASE;
                    break;
                    
                default:
                    System.out.println("Error: Dia de la semana no valido.");
                    System.out.print("\n¿Deseas realizar otra operacion? (si/no): ");
                    respuesta = scanner.next().trim().toLowerCase();
                    continue; // Vuelve al inicio del ciclo si el día es incorrecto
            }
            
            // Aplicar el 10% de descuento si cuenta con membresía
            if (tieneMembresia) {
                double descuento = total * 0.10;
                total = total - descuento;
                System.out.println("¡Se ha aplicado un 10% de descuento por membresia!");
            }
            
            // Mostrar resultado final formateado
            System.out.println("\n----------------------------------------");
            System.out.println("Cantidad de personas: " + personas);
            System.out.println("Dia seleccionado: " + dia.substring(0, 1).toUpperCase() + dia.substring(1));
            System.out.println("Membresia aplicada: " + (tieneMembresia ? "Si" : "No"));
            System.out.printf("El precio total a pagar es: $%.2f pesos\n", total);
            System.out.println("----------------------------------------");
            
            // Preguntar si desea realizar otra compra
            System.out.print("\n¿Deseas calcular otra compra de entradas? (si/no): ");
            respuesta = scanner.next().trim().toLowerCase();
            
        } while (respuesta.equals("si") || respuesta.equals("s") || respuesta.equals("sí"));
        
        System.out.println("\n¡Sistema de cine finalizado. Hasta luego!");
        scanner.close();
    }
}
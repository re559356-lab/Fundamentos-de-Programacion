import java.util.Scanner;

public class CinePrecioEntradas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constantes de precios
        final double PRECIO_BASE = 50.0;
        final double PRECIO_MIERCOLES = 30.0;
        final double PRECIO_PAREJA_JUEVES = 75.0;
        
        System.out.println("=== SISTEMA DE VENTA DE ENTRADAS DE CINE ===");
        
        System.out.print("Introduce el numero de personas: ");
        int personas = scanner.nextInt();
        
        // Validar que el número de personas sea positivo
        if (personas <= 0) {
            System.out.println("Error: El numero de personas debe ser mayor a 0.");
            scanner.close();
            return;
        }
        
        System.out.print("Introduce el dia de la semana (Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo): ");
        // Limpiamos y normalizamos la entrada para evitar problemas de mayúsculas/minúsculas o acentos
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
                // Cada pareja (2 personas) paga $75, y si sobra 1 persona paga el precio base ($50)
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
                scanner.close();
                return;
        }
        
        // Aplicar el 10% de descuento si cuenta con membresía (aplica todos los días)
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
        
        scanner.close();
    }
}
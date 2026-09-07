import java.util.Scanner;

public class PresupuestoPasteleria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double total = 0.0;
        String desglose = "=== DESGLOSE DEL PRESUPUESTO ===\n";
        
        System.out.println("=== PASTELERIA: PRESUPUESTO DE TARTAS ===");
        System.out.println("Elige el sabor de la tarta:");
        System.out.println("1. Manzana ($200 pesos)");
        System.out.println("2. Fresa ($250 pesos)");
        System.out.println("3. Chocolate");
        System.out.print("Introduce tu opcion (1-3): ");
        int opcionSabor = scanner.nextInt();
        
        // Estructura selectiva múltiple para el sabor base
        switch (opcionSabor) {
            case 1:
                total += 200.0;
                desglose += "- Tarta de Manzana: $200.00\n";
                break;
                
            case 2:
                total += 250.0;
                desglose += "- Tarta de Fresa: $250.00\n";
                break;
                
            case 3:
                System.out.println("\nElige el tipo de chocolate:");
                System.out.println("1. Negro ($280 pesos)");
                System.out.println("2. Blanco ($300 pesos)");
                System.out.print("Introduce tu opcion (1-2): ");
                int opcionChocolate = scanner.nextInt();
                
                if (opcionChocolate == 1) {
                    total += 280.0;
                    desglose += "- Tarta de Chocolate Negro: $280.00\n";
                } else if (opcionChocolate == 2) {
                    total += 300.0;
                    desglose += "- Tarta de Chocolate Blanco: $300.00\n";
                } else {
                    System.out.println("Error: Opcion de chocolate no valida.");
                    scanner.close();
                    return;
                }
                break;
                
            default:
                System.out.println("Error: Sabor de tarta no valido.");
                scanner.close();
                return;
        }
        
        // Preguntar por los snacks
        System.out.print("\n¿Deseas añadir snacks (fresa, galleta, durazno, etc.)? (si/no): ");
        String respuestaSnack = scanner.next().trim().toLowerCase();
        
        if (respuestaSnack.equals("si") || respuestaSnack.equals("s") || respuestaSnack.equals("sí")) {
            System.out.print("¿Cuantos snacks deseas añadir?: ");
            int cantidadSnacks = scanner.nextInt();
            
            if (cantidadSnacks > 0) {
                double costoSnacks = cantidadSnacks * 25.0;
                total += costoSnacks;
                desglose += "- Snacks (" + cantidadSnacks + " unidades): $" + costoSnacks + ".00\n";
            }
        }
        
        // Preguntar por la personalización con nombre
        System.out.print("\n¿Deseas personalizar la tarta con un nombre ($30 pesos)? (si/no): ");
        String respuestaNombre = scanner.next().trim().toLowerCase();
        
        if (respuestaNombre.equals("si") || respuestaNombre.equals("s") || respuestaNombre.equals("sí")) {
            System.out.print("Introduce el nombre que llevara la tarta: ");
            scanner.nextLine(); // Limpiar el buffer de entrada
            String nombreTarta = scanner.nextLine();
            
            total += 30.0;
            desglose += "- Personalizacion con nombre (" + nombreTarta + "): $30.00\n";
        }
        
        // Mostrar presupuesto final y detallado
        System.out.println("\n----------------------------------------");
        System.out.println(desglose);
        System.out.printf("TOTAL A PAGAR: $%.2f pesos\n", total);
        System.out.println("----------------------------------------");
        
        scanner.close();
    }
}
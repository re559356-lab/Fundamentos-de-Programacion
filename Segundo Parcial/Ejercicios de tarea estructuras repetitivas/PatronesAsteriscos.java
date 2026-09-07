import java.util.Scanner;

public class PatronesAsteriscos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Generador de Patrones con Asteriscos ===");
        System.out.print("Ingrese el número de líneas (n): ");
        int n = scanner.nextInt();
        
        if (n > 0) {
            // --- Figura 1: Cuadrado ---
            System.out.println("\n--- Figura 1: Cuadrado ---");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            
            // --- Figura 2: Pirámide Invertida ---
            System.out.println("\n--- Figura 2: Pirámide Invertida ---");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= (2 * (n - i) + 1); j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            
            // --- Figura 3: Pirámide Normal ---
            System.out.println("\n--- Figura 3: Pirámide Normal ---");
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            
        } else {
            System.out.println("Por favor, ingrese un número entero positivo mayor a 0.");
        }
        
        scanner.close();
    }
}
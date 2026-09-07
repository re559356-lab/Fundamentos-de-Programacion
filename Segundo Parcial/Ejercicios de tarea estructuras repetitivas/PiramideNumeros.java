import java.util.Scanner;

public class PiramideNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Generador de Pirámide de Números ===");
        System.out.print("Ingrese un número entero n: ");
        int n = scanner.nextInt();
        
        if (n > 0) {
            System.out.println("\nSalida:");
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j + "   ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Por favor, ingrese un número entero positivo mayor a 0.");
        }
        
        scanner.close();
    }
}
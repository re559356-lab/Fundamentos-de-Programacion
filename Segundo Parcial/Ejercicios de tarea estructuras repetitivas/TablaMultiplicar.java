import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        
        System.out.println("=== Generador de Tablas de Multiplicar ===");
        System.out.print("Ingrese un número (0 para salir): ");
        n = scanner.nextInt();
        
        while (n != 0) {
            System.out.println("\n--- Tabla de multiplicar del " + n + " ---");
            
            for (int i = 1; i <= 10; i++) {
                System.out.println(n + " x " + i + " = " + (n * i));
            }
            
            System.out.print("Ingrese otro número (0 para salir): ");
            n = scanner.nextInt();
        }
        
        System.out.println("\nPrograma finalizado con éxito.");
        scanner.close();
    }
}

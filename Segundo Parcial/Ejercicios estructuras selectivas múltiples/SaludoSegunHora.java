import java.util.Scanner;

public class SaludoSegunHora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce la hora (formato 0-23): ");
        int hora = scanner.nextInt();
        
        // Validación de que la hora esté en un formato de reloj válido (0 a 23)
        if (hora >= 0 && hora <= 23) {
            
            // Estructura selectiva para determinar el saludo
            if (hora >= 6 && hora <= 12) {
                System.out.println("Buenos dias");
            } else if (hora >= 13 && hora <= 20) {
                System.out.println("Buenas tardes");
            } else {
                // Cubre el rango de 21 a 5 (21, 22, 23, 0, 1, 2, 3, 4, 5)
                System.out.println("Buenas noches");
            }
            
        } else {
            System.out.println("Error: La hora introducida no es valida. Debe estar entre 0 y 23.");
        }
        
        scanner.close();
    }
}
import java.util.Scanner;

public class DiasDelMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el numero del mes (1-12): ");
        int mes = scanner.nextInt();
        
        // Estructura selectiva múltiple (Switch moderno)
        switch (mes) {
            case 1 -> System.out.println("Enero: 31 dias");
            case 2 -> System.out.println("Febrero: 28 dias");
            case 3 -> System.out.println("Marzo: 31 dias");
            case 4 -> System.out.println("Abril: 30 dias");
            case 5 -> System.out.println("Mayo: 31 dias");
            case 6 -> System.out.println("Junio: 30 dias");
            case 7 -> System.out.println("Julio: 31 dias");
            case 8 -> System.out.println("Agosto: 31 dias");
            case 9 -> System.out.println("Septiembre: 30 dias");
            case 10 -> System.out.println("Octubre: 31 dias");
            case 11 -> System.out.println("Noviembre: 30 dias");
            case 12 -> System.out.println("Diciembre: 31 dias");
            default -> System.out.println("Error: El valor introducido no esta comprendido entre 1 y 12.");
        }
        
        scanner.close();
    }
}
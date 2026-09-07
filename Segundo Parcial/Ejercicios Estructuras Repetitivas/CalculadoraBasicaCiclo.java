import java.util.Scanner;

public class CalculadoraBasicaCiclo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        
        do {
            System.out.println("\n--- NUEVA OPERACION ---");
            System.out.print("Introduce el primer numero entero: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Introduce el segundo numero entero: ");
            int num2 = scanner.nextInt();
            
            System.out.print("Introduce un operador (+, -, *, /): ");
            char operador = scanner.next().charAt(0);
            
            // Estructura selectiva múltiple para la operación
            switch (operador) {
                case '+':
                    int suma = num1 + num2;
                    System.out.println("Resultado: " + num1 + " + " + num2 + " = " + suma);
                    break;
                case '-':
                    int resta = num1 - num2;
                    System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resta);
                    break;
                case '*':
                    int multiplicacion = num1 * num2;
                    System.out.println("Resultado: " + num1 + " * " + num2 + " = " + multiplicacion);
                    break;
                case '/':
                    // Validación para evitar la división por cero
                    if (num2 != 0) {
                        double division = (double) num1 / num2;
                        System.out.println("Resultado: " + num1 + " / " + num2 + " = " + division);
                    } else {
                        System.out.println("Error: Division por cero no permitida.");
                    }
                    break;
                default:
                    System.out.println("Error: Operador no valido. Utiliza +, -, * o /.");
                    break;
            }
            
            // Preguntar si desea realizar otra operación
            System.out.print("\n¿Deseas realizar otra operacion? (si/no): ");
            respuesta = scanner.next().trim().toLowerCase();
            
        } while (respuesta.equals("si") || respuesta.equals("s") || respuesta.equals("sí"));
        
        System.out.println("\n¡Calculadora finalizada. Hasta luego!");
        scanner.close();
    }
}
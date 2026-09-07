import java.util.Scanner;

public class CalculoAreasCiclo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;
        
        do {
            System.out.println("\n=== MENU DE CALCULO DE AREAS ===");
            System.out.println("1. Cuadrado");
            System.out.println("2. Rectangulo");
            System.out.println("3. Triangulo");
            System.out.println("4. Circulo");
            System.out.print("Elige una opcion (1-4): ");
            int opcion = scanner.nextInt();
            
            // Estructura selectiva múltiple para el menú
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el valor del lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    double areaCuadrado = lado * lado;
                    System.out.println("El area del cuadrado es: " + areaCuadrado);
                    break;
                    
                case 2:
                    System.out.print("Introduce la base del rectangulo: ");
                    double baseRec = scanner.nextDouble();
                    System.out.print("Introduce la altura del rectangulo: ");
                    double alturaRec = scanner.nextDouble();
                    double areaRectangulo = baseRec * alturaRec;
                    System.out.println("El area del rectangulo es: " + areaRectangulo);
                    break;
                    
                case 3:
                    System.out.print("Introduce la base del triangulo: ");
                    double baseTri = scanner.nextDouble();
                    System.out.print("Introduce la altura del triangulo: ");
                    double alturaTri = scanner.nextDouble();
                    double areaTriangulo = (baseTri * alturaTri) / 2;
                    System.out.println("El area del triangulo es: " + areaTriangulo);
                    break;
                    
                case 4:
                    System.out.print("Introduce el radio del circulo: ");
                    double radio = scanner.nextDouble();
                    double areaCirculo = Math.PI * Math.pow(radio, 2);
                    System.out.println("El area del circulo es: " + areaCirculo);
                    break;
                    
                default:
                    System.out.println("Error: La opcion elegida no es valida. Debe ser entre 1 y 4.");
                    break;
            }
            
            // Preguntar si desea realizar otro cálculo
            System.out.print("\n¿Deseas calcular otra area? (si/no): ");
            respuesta = scanner.next().trim().toLowerCase();
            
        } while (respuesta.equals("si") || respuesta.equals("s") || respuesta.equals("sí"));
        
        System.out.println("\n¡Programa de áreas finalizado. Hasta luego!");
        scanner.close();
    }
}
import java.util.Scanner;

public class PaqueteriaInternacional {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double peso;
        double gramos;
        double costo = 0;
        double total;
        int zona;

        System.out.print("Ingrese el peso del paquete en kilogramos: ");
        peso = sc.nextDouble();

        // Verificar si el paquete puede ser transportado
        if (peso > 5) {

            System.out.println("El paquete no puede ser transportado.");
            System.out.println("Motivo: el peso supera los 5 kg.");

        } else {

            System.out.println("\nSeleccione la zona de destino:");
            System.out.println("1. América del Norte - $11 por gramo");
            System.out.println("2. América Central - $10 por gramo");
            System.out.println("3. América del Sur - $12 por gramo");
            System.out.println("4. Europa - $25 por gramo");
            System.out.println("5. Asia - $30 por gramo");

            System.out.print("Ingrese la zona: ");
            zona = sc.nextInt();

            // Convertir kilogramos a gramos
            gramos = peso * 1000;

            // Determinar el costo según la zona
            switch (zona) {

                case 1:
                    costo = 11;
                    break;

                case 2:
                    costo = 10;
                    break;

                case 3:
                    costo = 12;
                    break;

                case 4:
                    costo = 25;
                    break;

                case 5:
                    costo = 30;
                    break;

                default:
                    System.out.println("Zona no válida.");
                    sc.close();
                    return;
            }

            // Calcular el costo total
            total = gramos * costo;

            System.out.println("\n--- Datos del envío ---");
            System.out.println("Peso: " + gramos + " gramos");
            System.out.println("Costo por gramo: $" + costo);
            System.out.println("Costo total del envío: $" + total);
        }

        sc.close();
    }
}
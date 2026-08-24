import java.util.Scanner;

public class GananciaUva {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double precioInicial, precioFinal, kilos, ganancia;
        char tipo;
        int tamano;

        System.out.print("Ingrese el precio inicial por kilo: ");
        precioInicial = sc.nextDouble();

        System.out.print("Ingrese la cantidad de kilos: ");
        kilos = sc.nextDouble();

        System.out.print("Ingrese el tipo de uva (A o B): ");
        tipo = sc.next().toUpperCase().charAt(0);

        System.out.print("Ingrese el tamaño de la uva (1 o 2): ");
        tamano = sc.nextInt();

        if (tipo == 'A') {

            if (tamano == 1) {
                precioFinal = precioInicial + 0.20;
            } else {
                precioFinal = precioInicial + 0.30;
            }

        } else {

            if (tamano == 1) {
                precioFinal = precioInicial - 0.30;
            } else {
                precioFinal = precioInicial - 0.50;
            }
        }

        ganancia = kilos * precioFinal;

        System.out.println("\nPrecio final por kilo: $" + precioFinal);
        System.out.println("Ganancia obtenida: $" + ganancia);

        sc.close();
    }
}

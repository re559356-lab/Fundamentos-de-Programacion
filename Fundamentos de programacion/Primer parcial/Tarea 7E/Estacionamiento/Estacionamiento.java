import java.util.Scanner;

public class Estacionamiento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int horas;
        double total;

        System.out.print("Ingrese el número de horas: ");
        horas = sc.nextInt();

        if (horas <= 2) {

            total = horas * 30;

        } else if (horas <= 5) {

            total = (2 * 30) + ((horas - 2) * 25);

        } else if (horas <= 10) {

            total = (2 * 30) + (3 * 25) + ((horas - 5) * 20);

        } else {

            total = 380;
        }

        System.out.println("El total a pagar es: $" + total);

        sc.close();
    }
}
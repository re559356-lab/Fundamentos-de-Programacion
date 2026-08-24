import java.util.Scanner;

public class ConsultorioDrLorenzo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el número de cita: ");
        int cita = sc.nextInt();

        int costo;
        if (cita <= 3) {
            costo = 900;
        } else if (cita <= 5) {
            costo = 800;
        } else if (cita <= 8) {
            costo = 600;
        } else {
            costo = 500;
        }

        // Calcular total acumulado
        int total = 0;
        for (int i = 1; i <= cita; i++) {
            if (i <= 3) {
                total += 900;
            } else if (i <= 5) {
                total += 800;
            } else if (i <= 8) {
                total += 600;
            } else {
                total += 500;
            }
        }

        System.out.println("Costo de la cita: $" + costo);
        System.out.println("Total acumulado del tratamiento: $" + total);

        sc.close();
    }
}

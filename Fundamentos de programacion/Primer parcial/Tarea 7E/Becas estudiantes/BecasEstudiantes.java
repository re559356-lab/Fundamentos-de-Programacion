import java.util.Scanner;

public class BecasEstudiantes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int edad;
        double promedio;
        double beca;

        System.out.print("Ingrese la edad del alumno: ");
        edad = sc.nextInt();

        System.out.print("Ingrese el promedio del alumno: ");
        promedio = sc.nextDouble();

        if (edad > 18) {

            if (promedio >= 9) {
                beca = 10000;
                System.out.println("La beca mensual es de: $" + beca);

            } else if (promedio >= 7.5) {
                beca = 8000;
                System.out.println("La beca mensual es de: $" + beca);

            } else if (promedio >= 6) {
                beca = 5000;
                System.out.println("La beca mensual es de: $" + beca);

            } else {
                System.out.println("Se enviará una carta de invitación para que estudie más.");
            }

        } else {

            if (promedio >= 9) {
                beca = 8000;
                System.out.println("La beca mensual es de: $" + beca);

            } else if (promedio >= 8) {
                beca = 6000;
                System.out.println("La beca mensual es de: $" + beca);

            } else if (promedio >= 6) {
                beca = 4000;
                System.out.println("La beca mensual es de: $" + beca);

            } else {
                System.out.println("Se enviará una carta de invitación para que estudie más.");
            }
        }

        sc.close();
    }
}
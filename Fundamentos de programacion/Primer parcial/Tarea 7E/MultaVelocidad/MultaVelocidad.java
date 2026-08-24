import java.util.Scanner;

public class MultaVelocidad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vel, resultado;
        boolean cumpleanios;

        System.out.print("Ingrese la velocidad: ");
        vel = sc.nextInt();

        System.out.print("¿Es tu cumpleaños? (true/false): ");
        cumpleanios = sc.nextBoolean();

        // Ajuste de velocidad si es cumpleaños
        if (cumpleanios) {
            vel = vel - 5;
        }

        // Evaluación de la multa
        if (vel <= 60) {
            resultado = 0; // sin multa
        } else if (vel <= 80) {
            resultado = 1; // multa pequeña
        } else {
            resultado = 2; // multa grande
        }

        System.out.println("Resultado: " + resultado);

        sc.close();
    }
}

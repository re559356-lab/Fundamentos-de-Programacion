import java.util.Scanner;

public class ParImparNeutro {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero;

        System.out.print("Ingrese un número: ");
        numero = sc.nextInt();

        if (numero == 0) {
            System.out.println("El número es neutro");
        } else if (numero % 2 == 0) {
            System.out.println("El número es par");
        } else {
            System.out.println("El número es impar");
        }

        sc.close();
    }
}


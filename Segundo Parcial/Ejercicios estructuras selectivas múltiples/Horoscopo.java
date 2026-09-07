import java.util.Scanner;

public class Horoscopo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el numero de tu mes de nacimiento (1-12): ");
        int mes = scanner.nextInt();
        
        System.out.print("Introduce el dia de tu nacimiento: ");
        int dia = scanner.nextInt();
        
        String signoSodiacal = "";
        boolean fechaValida = true;
        
        // Estructura selectiva múltiple para evaluar el mes
        switch (mes) {
            case 1: // Enero
                if (dia >= 1 && dia <= 19) signoSodiacal = "Capricornio";
                else if (dia >= 20 && dia <= 31) signoSodiacal = "Acuario";
                else fechaValida = false;
                break;
                
            case 2: // Febrero (suponiendo max 28 o 29 dias)
                if (dia >= 1 && dia <= 18) signoSodiacal = "Acuario";
                else if (dia >= 19 && dia <= 29) signoSodiacal = "Piscis";
                else fechaValida = false;
                break;
                
            case 3: // Marzo
                if (dia >= 1 && dia <= 20) signoSodiacal = "Piscis";
                else if (dia >= 21 && dia <= 31) signoSodiacal = "Aries";
                else fechaValida = false;
                break;
                
            case 4: // Abril
                if (dia >= 1 && dia <= 19) signoSodiacal = "Aries";
                else if (dia >= 20 && dia <= 30) signoSodiacal = "Tauro";
                else fechaValida = false;
                break;
                
            case 5: // Mayo
                if (dia >= 1 && dia <= 20) signoSodiacal = "Tauro";
                else if (dia >= 21 && dia <= 31) signoSodiacal = "Geminis";
                else fechaValida = false;
                break;
                
            case 6: // Junio
                if (dia >= 1 && dia <= 20) signoSodiacal = "Geminis";
                else if (dia >= 21 && dia <= 30) signoSodiacal = "Cancer";
                else fechaValida = false;
                break;
                
            case 7: // Julio
                if (dia >= 1 && dia <= 22) signoSodiacal = "Cancer";
                else if (dia >= 23 && dia <= 31) signoSodiacal = "Leo";
                else fechaValida = false;
                break;
                
            case 8: // Agosto
                if (dia >= 1 && dia <= 22) signoSodiacal = "Leo";
                else if (dia >= 23 && dia <= 31) signoSodiacal = "Virgo";
                else fechaValida = false;
                break;
                
            case 9: // Septiembre
                if (dia >= 1 && dia <= 22) signoSodiacal = "Virgo";
                else if (dia >= 23 && dia <= 30) signoSodiacal = "Libra";
                else fechaValida = false;
                break;
                
            case 10: // Octubre
                if (dia >= 1 && dia <= 22) signoSodiacal = "Libra";
                else if (dia >= 23 && dia <= 31) signoSodiacal = "Escorpio";
                else fechaValida = false;
                break;
                
            case 11: // Noviembre
                if (dia >= 1 && dia <= 21) signoSodiacal = "Escorpio";
                else if (dia >= 22 && dia <= 30) signoSodiacal = "Sagitario";
                else fechaValida = false;
                break;
                
            case 12: // Diciembre
                if (dia >= 1 && dia <= 21) signoSodiacal = "Sagitario";
                else if (dia >= 22 && dia <= 31) signoSodiacal = "Capricornio";
                else fechaValida = false;
                break;
                
            default:
                fechaValida = false;
                break;
        }
        
        // Mostrar el resultado de forma adecuada
        if (fechaValida) {
            System.out.println("Tu signo del zodiaco es: " + signoSodiacal);
        } else {
            System.out.println("Error: La fecha introducida (mes o dia) no es valida.");
        }
        
        scanner.close();
    }
}
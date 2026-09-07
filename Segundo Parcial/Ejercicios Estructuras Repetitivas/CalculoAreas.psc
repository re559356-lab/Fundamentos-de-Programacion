Proceso CalculoAreas
    Definir opcion Como Entero;
    Definir lado, base, altura, radio Como Real;
    Definir respuesta Como Caracter;
    
    Repetir
        Escribir "=== MENU AREAS ===";
        Escribir "1. Cuadrado";
        Escribir "2. Rectangulo";
        Escribir "3. Triangulo";
        Escribir "4. Circulo";
        Escribir "Elige una opcion (1-4): ";
        Leer opcion;
        
        Segun opcion Hacer
            1:
                Escribir "Introduce el lado: ";
                Leer lado;
                Escribir "Area: ", lado * lado;
            2:
                Escribir "Introduce base y altura: ";
                Leer base, altura;
                Escribir "Area: ", base * altura;
            3:
                Escribir "Introduce base y altura: ";
                Leer base, altura;
                Escribir "Area: ", (base * altura) / 2;
            4:
                Escribir "Introduce el radio: ";
                Leer radio;
                Escribir "Area: ", PI * (radio ^ 2);
            De Otro Modo:
                Escribir "Opcion no valida.";
        FinSegun
        
        Escribir "¿Deseas calcular otra area? (si/no): ";
        Leer respuesta;
    Hasta Que respuesta = "no" o respuesta = "n";
FinProceso
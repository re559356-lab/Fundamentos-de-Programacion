Proceso CalculadoraBasica
    Definir num1, num2 Como Entero;
    Definir operador Como Caracter;
    
    Escribir "Introduce el primer numero: ";
    Leer num1;
    Escribir "Introduce el segundo numero: ";
    Leer num2;
    Escribir "Introduce un operador (+, -, *, /): ";
    Leer operador;
    
    Segun operador Hacer
        "+": Escribir "Resultado: ", num1 + num2;
        "-": Escribir "Resultado: ", num1 - num2;
        "*": Escribir "Resultado: ", num1 * num2;
        "/": 
            Si num2 <> 0 Entonces
                Escribir "Resultado: ", num1 / num2;
            Sino
                Escribir "Error: Division por cero.";
            FinSi
        De Otro Modo:
            Escribir "Operador no valido.";
    FinSegun
FinProceso
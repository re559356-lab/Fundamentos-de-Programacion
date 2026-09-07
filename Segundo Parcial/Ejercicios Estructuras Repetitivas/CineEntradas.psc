Proceso CineEntradas
    Definir personas Como Entero;
    Definir dia, membresia, respuesta Como Caracter;
    Definir total, parejas, individuales Como Real;
    
    Repetir
        Escribir "Introduce el numero de personas: ";
        Leer personas;
        Escribir "Introduce el dia de la semana: ";
        Leer dia;
        Escribir "¿Cuentas con membresia? (si/no): ";
        Leer membresia;
        
        total <- 0;
        
        Si dia = "miercoles" o dia = "miércoles" Entonces
            total <- personas * 30;
        Sino
            Si dia = "jueves" Entonces
                parejas <- trunc(personas / 2);
                individuales <- personas MOD 2;
                total <- (parejas * 75) + (individuales * 50);
            Sino
                total <- personas * 50;
            FinSi
        FinSi
        
        Si membresia = "si" o membresia = "s" Entonces
            total <- total - (total * 0.10);
        FinSi
        
        Escribir "Total a pagar: $", total;
        
        Escribir "¿Deseas realizar otra compra? (si/no): ";
        Leer respuesta;
    Hasta Que respuesta = "no" o respuesta = "n";
FinProceso
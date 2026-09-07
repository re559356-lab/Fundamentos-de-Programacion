Proceso SaludoHora
    Definir hora Como Entero;
    
    Escribir "Introduce la hora (0-23): ";
    Leer hora;
    
    Si hora >= 0 y hora <= 23 Entonces
        Si hora >= 6 y hora <= 12 Entonces
            Escribir "Buenos dias";
        Sino
            Si hora >= 13 y hora <= 20 Entonces
                Escribir "Buenas tardes";
            Sino
                Escribir "Buenas noches";
            FinSi
        FinSi
    Sino
        Escribir "Hora no valida.";
    FinSi
FinProceso
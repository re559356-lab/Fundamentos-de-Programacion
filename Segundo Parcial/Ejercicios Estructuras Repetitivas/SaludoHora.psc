Proceso SaludoHora
    Definir hora Como Entero;
    Definir respuesta Como Caracter;
    
    Repetir
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
        
        Escribir "¿Deseas consultar otra hora? (si/no): ";
        Leer respuesta;
    Hasta Que respuesta = "no" o respuesta = "n";
FinProceso
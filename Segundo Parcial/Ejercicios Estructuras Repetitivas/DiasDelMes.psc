Proceso DiasDelMes
    Definir mes Como Entero;
    Definir respuesta Como Caracter;
    
    Repetir
        Escribir "Introduce el numero del mes (1-12): ";
        Leer mes;
        
        Segun mes Hacer
            1: Escribir "Enero: 31 dias";
            2: Escribir "Febrero: 28 dias";
            3: Escribir "Marzo: 31 dias";
            4: Escribir "Abril: 30 dias";
            5: Escribir "Mayo: 31 dias";
            6: Escribir "Junio: 30 dias";
            7: Escribir "Julio: 31 dias";
            8: Escribir "Agosto: 31 dias";
            9: Escribir "Septiembre: 30 dias";
            10: Escribir "Octubre: 31 dias";
            11: Escribir "Noviembre: 30 dias";
            12: Escribir "Diciembre: 31 dias";
            De Otro Modo:
                Escribir "Error: El valor debe estar entre 1 y 12.";
        FinSegun
        
        Escribir "¿Deseas consultar otro mes? (si/no): ";
        Leer respuesta;
    Hasta Que respuesta = "no" o respuesta = "n";
FinProceso
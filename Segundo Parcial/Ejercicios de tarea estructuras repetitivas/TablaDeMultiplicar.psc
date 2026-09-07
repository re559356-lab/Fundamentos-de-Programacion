Algoritmo TablaDeMultiplicar
    Definir n, i Como Entero
    
    Escribir "=== Generador de Tablas de Multiplicar ==="
    Escribir "Ingrese un número (ingrese 0 para salir): "
    Leer n
    
    Mientras n <> 0 Hacer
        Escribir ""
        Escribir "--- Tabla del ", n, " ---"
        
        Para i <- 1 Hasta 10 Con Paso 1 Hacer
            Escribir n, " x ", i, " = ", (n * i)
        FinPara
        
        Escribir ""
        Escribir "Ingrese otro número (0 para salir): "
        Leer n
    FinMientras
    
    Escribir "Programa finalizado con éxito."
FinAlgoritmo

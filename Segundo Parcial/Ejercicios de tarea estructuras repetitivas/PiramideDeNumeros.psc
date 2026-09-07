Algoritmo PiramideDeNumeros
    Definir n, i, j Como Entero
    
    Escribir "=== Generador de Pirámide de Números ==="
    Escribir "Ingrese un número entero n: "
    Leer n
    
    Si n > 0 Entonces
        Escribir ""
        Escribir "Salida:"
        
        Para i <- 1 Hasta n Con Paso 1 Hacer
            Para j <- 1 Hasta i Con Paso 1 Hacer
                Escribir j, "   " Sin Saltar
            FinPara
            Escribir "" // Salto de línea para la siguiente fila
        FinPara
    Sino
        Escribir "Por favor, ingrese un número mayor a 0."
    FinSi
    
    Escribir "Programa finalizado."
FinAlgoritmo
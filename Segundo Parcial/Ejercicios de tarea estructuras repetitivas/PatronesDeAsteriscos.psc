Algoritmo PatronesDeAsteriscos
    Definir n, i, j Como Entero
    
    Escribir "=== Generador de Patrones con Asteriscos ==="
    Escribir "Ingrese el número de líneas (n): "
    Leer n
    
    Si n > 0 Entonces
        // --- Figura 1: Cuadrado ---
        Escribir ""
        Escribir "Figura 1: Cuadrado"
        Para i <- 1 Hasta n Con Paso 1 Hacer
            Para j <- 1 Hasta n Con Paso 1 Hacer
                Escribir "* " Sin Saltar
            FinPara
            Escribir ""
        FinPara
        
        // --- Figura 2: Pirámide Invertida ---
        Escribir ""
        Escribir "Figura 2: Pirámide Invertida"
        Para i <- 1 Hasta n Con Paso 1 Hacer
            // Espacios en blanco
            Para j <- 1 Hasta i - 1 Con Paso 1 Hacer
                Escribir "  " Sin Saltar
            FinPara
            // Asteriscos
            Para j <- 1 Hasta (2 * (n - i) + 1) Con Paso 1 Hacer
                Escribir "* " Sin Saltar
            FinPara
            Escribir ""
        FinPara
        
        // --- Figura 3: Pirámide Normal ---
        Escribir ""
        Escribir "Figura 3: Pirámide Normal"
        Para i <- 1 Hasta n Con Paso 1 Hacer
            // Espacios en blanco
            Para j <- 1 Hasta n - i Con Paso 1 Hacer
                Escribir "  " Sin Saltar
            FinPara
            // Asteriscos
            Para j <- 1 Hasta (2 * i - 1) Con Paso 1 Hacer
                Escribir "* " Sin Saltar
            FinPara
            Escribir ""
        FinPara
        
    Sino
        Escribir "Por favor, ingrese un número mayor a 0."
    FinSi
    
    Escribir ""
    Escribir "Programa finalizado."
FinAlgoritmo
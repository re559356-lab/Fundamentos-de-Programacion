Algoritmo Ganancia_Uva
	
    Definir precioInicial, precioFinal, kilos, ganancia Como Real
    Definir tipo Como Caracter
    Definir tamano Como Entero
	
    Escribir "Ingrese el precio inicial por kilo:"
    Leer precioInicial
	
    Escribir "Ingrese la cantidad de kilos:"
    Leer kilos
	
    Escribir "Ingrese el tipo de uva (A o B):"
    Leer tipo
	
    Escribir "Ingrese el tamaño de la uva (1 o 2):"
    Leer tamano
	
    Si tipo = "A" Entonces
        Si tamano = 1 Entonces
            precioFinal <- precioInicial + 0.20
        Sino
            precioFinal <- precioInicial + 0.30
        FinSi
    Sino
        Si tamano = 1 Entonces
            precioFinal <- precioInicial - 0.30
        Sino
            precioFinal <- precioInicial - 0.50
        FinSi
    FinSi
	
    ganancia <- kilos * precioFinal
	
    Escribir "El precio final por kilo es: $", precioFinal
    Escribir "La ganancia obtenida es: $", ganancia
	
FinAlgoritmo

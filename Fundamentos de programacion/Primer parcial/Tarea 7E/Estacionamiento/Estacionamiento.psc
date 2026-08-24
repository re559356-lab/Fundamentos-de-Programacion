Algoritmo Estacionamiento
	
    Definir horas Como Entero
    Definir total Como Real
	
    Escribir "Ingrese el número de horas que utilizó el estacionamiento:"
    Leer horas
	
    Si horas <= 2 Entonces
        total <- horas * 30
		
    Sino
        Si horas <= 5 Entonces
            total <- (2 * 30) + ((horas - 2) * 25)
			
        Sino
            Si horas <= 10 Entonces
                total <- (2 * 30) + (3 * 25) + ((horas - 5) * 20)
				
            Sino
                total <- 380
            FinSi
        FinSi
    FinSi
	
    Escribir "El total a pagar es: $", total
	
FinAlgoritmo

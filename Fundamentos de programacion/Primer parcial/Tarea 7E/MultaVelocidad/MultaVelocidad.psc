Algoritmo MultaVelocidad

		Definir vel, resultado Como Entero
		Definir cumpleaños Como Logico
		
		Escribir "Ingrese la velocidad:"
		Leer vel
		
		Escribir "¿Es tu cumpleaños? (Verdadero/Falso):"
		Leer cumpleaños
		
		Si cumpleaños Entonces
			vel <- vel - 5
		FinSi
		
		Si vel <= 60 Entonces
			resultado <- 0
		Sino
			Si vel <= 80 Entonces
				resultado <- 1
			Sino
				resultado <- 2
			FinSi
		FinSi
		
		Escribir "Resultado: ", resultado
		
FinAlgoritmo

Algoritmo ConsultorioDrLorenzo
		
		Definir numeroCita, pagoCita, totalPagado Como Real
		
		Escribir "Ingrese el número de cita:"
		Leer numeroCita
		
		Si numeroCita <= 3 Entonces
			pagoCita <- 900
		Sino
			Si numeroCita <= 5 Entonces
				pagoCita <- 800
			Sino
				Si numeroCita <= 8 Entonces
					pagoCita <- 600
				Sino
					pagoCita <- 500
				FinSi
			FinSi
		FinSi
		
		Si numeroCita <= 3 Entonces
			totalPagado <- numeroCita * 900
		Sino
			Si numeroCita <= 5 Entonces
				totalPagado <- (3 * 900) + ((numeroCita - 3) * 800)
			Sino
				Si numeroCita <= 8 Entonces
					totalPagado <- (3 * 900) + (2 * 800) + ((numeroCita - 5) * 600)
				Sino
					totalPagado <- (3 * 900) + (2 * 800) + (3 * 600) + ((numeroCita - 8) * 500)
				FinSi
			FinSi
		FinSi
		
		Escribir "Pago de la cita: $", pagoCita
		Escribir "Total pagado por el tratamiento: $", totalPagado
		
FinAlgoritmo

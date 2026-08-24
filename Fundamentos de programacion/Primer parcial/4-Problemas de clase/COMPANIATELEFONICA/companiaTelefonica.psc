Algoritmo CompaniaTelefonica
	Definir minutos Como Entero
	Definir dia, turno Como Cadena
	Definir costo, impuesto, total Como Real
	Escribir 'Ingrese los minutos de la llamada:'
	Leer minutos
	Escribir 'Ingrese el dia (domingo/habil):'
	Leer dia
	Si dia='habil' Entonces
		Escribir 'Ingrese el turno (matutino/vespertino):'
		Leer turno
	FinSi
	Si minutos<=5 Entonces
		costo <- minutos*1.00
	SiNo
		Si minutos<=8 Entonces
			costo <- (5*1.00)+((minutos-5)*0.80)
		SiNo
			Si minutos<=10 Entonces
				costo <- (5*1.00)+(3*0.80)+((minutos-8)*0.70)
			SiNo
				costo <- (5*1.00)+(3*0.80)+(2*0.70)+((minutos-10)*0.50)
			FinSi
		FinSi
	FinSi
	Si dia='domingo' Entonces
		impuesto <- costo*0.03
	SiNo
		Si turno='matutino' Entonces
			impuesto <- costo*0.15
		SiNo
			impuesto <- costo*0.10
		FinSi
	FinSi
	total <- costo+impuesto
	Escribir 'Costo de la llamada: $', costo
	Escribir 'Impuesto: $', impuesto
	Escribir 'Total a pagar: $', total
FinAlgoritmo

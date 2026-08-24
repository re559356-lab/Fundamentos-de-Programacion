Algoritmo AhorroAnual
	Definir mes Como Entero
	Definir deposito, ahorroTotal Como Real
	ahorroTotal <- 0
	Escribir '=== CÁLCULO DE AHORRO ANUAL (12 MESES) ==='
	Para mes<-1 Hasta 12 Hacer
		Escribir 'Ingrese la cantidad a depositar al final del mes ', mes, ': $'
		Leer deposito
		ahorroTotal <- ahorroTotal+deposito
		Escribir '-> Ahorro acumulado hasta el mes ', mes, ': $', ahorroTotal
		Escribir '----------------------------------------'
	FinPara
	Escribir 'RESULTADO FINAL:'
	Escribir 'El ahorro total acumulado en el año es: $', ahorroTotal
FinAlgoritmo

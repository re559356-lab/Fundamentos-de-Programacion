Algoritmo RegistroVentas
	Definir N, i Como Entero
	Definir venta, monto1, monto2, monto3, montoTotal Como Real
	Definir cont1, cont2, cont3 Como Entero
	cont1 <- 0
	cont2 <- 0 // Mayores a $1000
	cont3 <- 0 // Mayores a $500 pero menores o iguales a $1000
	monto1 <- 0 // Menores o iguales a $500
	monto2 <- 0
	monto3 <- 0
	montoTotal <- 0
	Escribir 'Ingrese el número total de ventas (N): '
	Leer N
	Para i<-1 Hasta N Hacer
		Escribir 'Ingrese el valor de la venta ', i, ': $'
		Leer venta
		montoTotal <- montoTotal+venta
		Si venta>1000 Entonces
			cont1 <- cont1+1
			monto1 <- monto1+venta
		SiNo
			Si venta>500 Entonces
				cont2 <- cont2+1
				monto2 <- monto2+venta
			SiNo
				cont3 <- cont3+1
				monto3 <- monto3+venta
			FinSi
		FinSi
	FinPara
	Escribir '----------------------------------------'
	Escribir 'RESULTADOS FINALES:'
	Escribir '1. Ventas mayores a $1000: ', cont1, ' | Monto vendido: $', monto1
	Escribir '2. Ventas entre $500.01 y $1000: ', cont2, ' | Monto vendido: $', monto2
	Escribir '3. Ventas menores o iguales a $500: ', cont3, ' | Monto vendido: $', monto3
	Escribir '----------------------------------------'
	Escribir 'Monto total global de todas las ventas: $', montoTotal
FinAlgoritmo

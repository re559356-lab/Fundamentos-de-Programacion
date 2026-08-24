Algoritmo PresupuestoBanquetes
	Definir personas Como Entero
	Definir costoPlatillo, presupuestoTotal Como Real
	Escribir '=== CÁLCULO DE PRESUPUESTO PARA BANQUETES ==='
	Escribir 'Ingrese el número de personas para el evento: '
	Leer personas
	Si personas>300 Entonces
		costoPlatillo <- 75.00
	SiNo
		Si personas>200 Entonces
			costoPlatillo <- 85.00
		SiNo
			costoPlatillo <- 95.00
		FinSi
	FinSi
	presupuestoTotal <- personas*costoPlatillo
	Escribir '----------------------------------------'
	Escribir 'RESULTADOS:'
	Escribir 'Costo por platillo: $', costoPlatillo
	Escribir 'Presupuesto total a presentar: $', presupuestoTotal
FinAlgoritmo

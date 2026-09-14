Proceso ControlConsumoElectrico
    Definir lecturaAnterior, lecturaActual, consumo, costoConsumo, cargoFijo, baseDescuento, descuento, baseImpuesto, impuesto, total Como Real
    Definir tieneApoyo Como Lógico
    Definir entradaValida Como Lógico
	
    cargoFijo <- 95.0
	
    // Validación de restricciones de lectura
    Repetir
        Escribir "Ingrese la lectura anterior del medidor (>= 0): "
        Leer lecturaAnterior
        Escribir "Ingrese la lectura actual del medidor (>= lectura anterior): "
        Leer lecturaActual
        
        Si lecturaAnterior < 0 O lecturaActual < 0 Entonces
            Escribir "Error: Las lecturas no pueden ser negativas."
            entradaValida <- Falso
        Sino
            Si lecturaActual < lecturaAnterior Entonces
                Escribir "Error: La lectura actual debe ser mayor o igual que la anterior."
                entradaValida <- Falso
            Sino
                // Validar consumo máximo permitido (10,000 kWh)
                consumo <- lecturaActual - lecturaAnterior
                Si consumo > 10000 Entonces
                    Escribir "Error: El consumo excede el límite máximo permitido de 10,000 kWh."
                    entradaValida <- Falso
                Sino
                    entradaValida <- Verdadero
                Fin Si
            Fin Si
        Fin Si
    Hasta Que entradaValida
	
    Escribir "¿Pertenece al programa de apoyo? (Verdadero/Falso): "
    Leer tieneApoyo
	
    // Ejecución de métodos obligatorios
    consumo <- calcularConsumo(lecturaAnterior, lecturaActual)
    costoConsumo <- calcularCostoConsumo(consumo)
    
    // Base para descuento (Costo de consumo + Cargo fijo, según la lógica del enunciado)
    baseDescuento <- costoConsumo + cargoFijo
    descuento <- calcularDescuentoApoyo(consumo, baseDescuento, tieneApoyo)
    
    baseImpuesto <- (costoConsumo + cargoFijo) - descuento
    impuesto <- calcularImpuesto(baseImpuesto)
    total <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
	
    // Mostrar recibo utilizando método de visualización
    mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
Fin Proceso

Funcion con <- calcularConsumo(lecturaAnterior, lecturaActual)
    con <- lecturaActual - lecturaAnterior
Fin Funcion

Funcion costo <- calcularCostoConsumo(consumo)
    Definir acumulado Como Real
    acumulado <- 0.0
    
    Si consumo <= 150 Entonces
        acumulado <- consumo * 1.20
    Sino
        Si consumo <= 400 Entonces
            acumulado <- (150 * 1.20) + ((consumo - 150) * 1.80)
        Sino
            acumulado <- (150 * 1.20) + (250 * 1.80) + ((consumo - 400) * 2.75)
        Fin Si
    Fin Si
    costo <- acumulado
Fin Funcion

Funcion desc <- calcularDescuentoApoyo(consumo, costoAntesImpuesto, tieneApoyo)
    Si tieneApoyo Y consumo <= 250 Entonces
        desc <- costoAntesImpuesto * 0.30
    Sino
        desc <- 0.0
    Fin Si
Fin Funcion

Funcion imp <- calcularImpuesto(baseImponible)
    imp <- baseImponible * 0.16
Fin Funcion

Funcion tot <- calcularTotal(costoConsumo, cargoFijo, descuento, impuesto)
    tot <- (costoConsumo + cargoFijo) - descuento + impuesto
Fin Funcion

SubProceso mostrarRecibo(consumo, costoConsumo, descuento, impuesto, total)
    Escribir "=== RECIBO DE LUZ ==="
    Escribir "Consumo Total: ", consumo, " kWh"
    Escribir "Costo por Consumo: $", costoConsumo
    Escribir "Cargo Fijo: $95.00"
    Escribir "Descuento aplicado: $", descuento
    Escribir "Impuesto (16%): $", impuesto
    Escribir "TOTAL A PAGAR: $", total
Fin SubProceso
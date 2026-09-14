Proceso CotizacionSeguro
    Definir valorVehiculo, tarifaBase, recargoEdad, recargoAccidentes, subtotal, descuento, costoFinal Como Real
    Definir edad, accidentes Como Entero
    Definir tieneSeguridad Como Lógico
	
    // Validación de restricciones
    Repetir
        Escribir "Ingrese el valor del vehículo (> 0): "
        Leer valorVehiculo
        Si valorVehiculo <= 0 Entonces
            Escribir "Error: El valor debe ser mayor que cero."
        Fin Si
    Hasta Que valorVehiculo > 0
	
    Repetir
        Escribir "Ingrese la edad del conductor (18 - 100): "
        Leer edad
        Si edad < 18 O edad > 100 Entonces
            Escribir "Error: La edad debe estar entre 18 y 100 años."
        Fin Si
    Hasta Que edad >= 18 Y edad <= 100
	
    Repetir
        Escribir "Ingrese la cantidad de accidentes (>= 0): "
        Leer accidentes
        Si accidentes < 0 Entonces
            Escribir "Error: Los accidentes no pueden ser negativos."
        Fin Si
    Hasta Que accidentes >= 0
	
    Escribir "¿Cuenta con sistema de seguridad adicional? (Verdadero/Falso): "
    Leer tieneSeguridad
	
    // Ejecución de métodos
    tarifaBase <- calcularTarifaBase(valorVehiculo)
    recargoEdad <- calcularRecargoPorEdad(tarifaBase, edad)
    recargoAccidentes <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
    
    subtotal <- tarifaBase + recargoEdad + recargoAccidentes
    descuento <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
    costoFinal <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
	
    // Resultados
    Escribir "Tarifa Base: $", tarifaBase
    Escribir "Recargo por Edad: $", recargoEdad
    Escribir "Recargo por Accidentes: $", recargoAccidentes
    Escribir "Descuento por Seguridad: $", descuento
    Escribir "Costo Final de la Póliza: $", costoFinal
Fin Proceso

Funcion tarifa <- calcularTarifaBase(valor)
    tarifa <- valor * 0.04
Fin Funcion

Funcion recargo <- calcularRecargoPorEdad(tarifaBase, edad)
    Si edad < 25 Entonces
        recargo <- tarifaBase * 0.20
    Sino
        Si edad <= 60 Entonces
            recargo <- 0.0
        Sino
            recargo <- tarifaBase * 0.10
        Fin Si
    Fin Si
Fin Funcion

Funcion recargo <- calcularRecargoPorAccidentes(tarifaBase, accidentes)
    recargo <- tarifaBase * 0.08 * accidentes
Fin Funcion

Funcion desc <- calcularDescuentoSeguridad(subtotal, tieneSeguridad)
    Si tieneSeguridad Entonces
        desc <- subtotal * 0.05
    Sino
        desc <- 0.0
    Fin Si
Fin Funcion

Funcion final <- calcularCostoFinal(tarifaBase, recargoEdad, recargoAccidentes, descuento)
    final <- (tarifaBase + recargoEdad + recargoAccidentes) - descuento
Fin Funcion
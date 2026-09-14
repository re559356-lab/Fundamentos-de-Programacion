Proceso SistemaCobroTienda
    Definir p1, p2, p3, sub1, sub2, sub3, subtotalGeneral, descuento, envio, impuesto, total Como Real
    Definir c1, c2, c3, tipoCliente Como Entero
    Definir codigoPostal Como Cadena
    Definir entradaValida Como Lógico
	
    Escribir "=== REGISTRO DE PRODUCTOS (3 Artículos) ==="
    
    // Validación para Producto 1
    Repetir
        Escribir "Producto 1 - Ingrese precio (> 0): "
        Leer p1
        Escribir "Producto 1 - Ingrese cantidad (> 0): "
        Leer c1
        Si p1 <= 0 O c1 <= 0 Entonces
            Escribir "Error: El precio y la cantidad deben ser mayores que cero."
        Fin Si
    Hasta Que p1 > 0 Y c1 > 0
	
    // Validación para Producto 2
    Repetir
        Escribir "Producto 2 - Ingrese precio (> 0): "
        Leer p2
        Escribir "Producto 2 - Ingrese cantidad (> 0): "
        Leer c2
        Si p2 <= 0 O c2 <= 0 Entonces
            Escribir "Error: El precio y la cantidad deben ser mayores que cero."
        Fin Si
    Hasta Que p2 > 0 Y c2 > 0
	
    // Validación para Producto 3
    Repetir
        Escribir "Producto 3 - Ingrese precio (> 0): "
        Leer p3
        Escribir "Producto 3 - Ingrese cantidad (> 0): "
        Leer c3
        Si p3 <= 0 O c3 <= 0 Entonces
            Escribir "Error: El precio y la cantidad deben ser mayores que cero."
        Fin Si
    Hasta Que p3 > 0 Y c3 > 0
	
    // Validación de Tipo de Cliente (1 o 2)
    Repetir
        Escribir "Tipo de cliente (1: Regular, 2: Frecuente): "
        Leer tipoCliente
        Si tipoCliente <> 1 Y tipoCliente <> 2 Entonces
            Escribir "Error: El tipo de cliente debe ser 1 o 2."
        Fin Si
    Hasta Que tipoCliente = 1 O tipoCliente = 2
	
    // Validación de Código Postal (Exactamente 5 dígitos)
    Repetir
        Escribir "Ingrese el código postal (exactamente 5 dígitos): "
        Leer codigoPostal
        // Validar longitud y que contenga solo números (simplificado con lógica de longitud aquí)
        Si Longitud(codigoPostal) = 5 Entonces
            entradaValida <- Verdadero
            Para i <- 1 Hasta 5 Hacer
                Si Subcadena(codigoPostal, i, i) < "0" O Subcadena(codigoPostal, i, i) > "9" Entonces
                    entradaValida <- Falso
                Fin Si
            Fin Para
        Sino
            entradaValida <- Falso
        Fin Si
        
        Si No entradaValida Entonces
            Escribir "Error: El código postal debe constar de exactamente 5 dígitos numéricos."
        Fin Si
    Hasta Que entradaValida
	
    // Ejecución de métodos obligatorios
    sub1 <- calcularSubtotalProducto(p1, c1)
    sub2 <- calcularSubtotalProducto(p2, c2)
    sub3 <- calcularSubtotalProducto(p3, c3)
    
    subtotalGeneral <- calcularSubtotalGeneral(sub1, sub2, sub3)
    descuento <- calcularDescuento(subtotalGeneral, tipoCliente)
    
    // Subtotal después de descuento necesario para el impuesto
    Definir subConDesc Como Real
    subConDesc <- subtotalGeneral - descuento
    
    envio <- calcularEnvio(subtotalGeneral, codigoPostal)
    impuesto <- calcularImpuesto(subConDesc)
    total <- calcularTotal(subtotalGeneral, descuento, impuesto, envio)
	
    // Resultados
    Escribir "Subtotal General: $", subtotalGeneral
    Escribir "Descuento aplicado: $", descuento
    Escribir "Costo de Envío: $", envio
    Escribir "Impuesto (16%): $", impuesto
    Escribir "TOTAL A PAGAR: $", total
Fin Proceso

Funcion sub <- calcularSubtotalProducto(precio, cantidad)
    sub <- precio * cantidad
Fin Funcion

Funcion general <- calcularSubtotalGeneral(s1, s2, s3)
    general <- s1 + s2 + s3
Fin Funcion

Funcion desc <- calcularDescuento(subtotal, tipoCliente)
    Si tipoCliente = 2 Entonces
        desc <- subtotal * 0.10 // Frecuente 10%
    Sino
        desc <- 0.0             // Regular 0%
    Fin Si
Fin Funcion

Funcion costoEnvio <- calcularEnvio(subtotal, codigoPostal)
    Si subtotal < 1000 Entonces
        costoEnvio <- 150.0
    Sino
        Si subtotal < 3000 Entonces
            costoEnvio <- 80.0
        Sino
            costoEnvio <- 0.0
        Fin Si
    Fin Si
Fin Funcion

Funcion imp <- calcularImpuesto(subtotalConDescuento)
    imp <- subtotalConDescuento * 0.16
Fin Funcion

Funcion tot <- calcularTotal(subtotal, descuento, impuesto, envio)
    tot <- (subtotal - descuento) + impuesto + envio
Fin Funcion
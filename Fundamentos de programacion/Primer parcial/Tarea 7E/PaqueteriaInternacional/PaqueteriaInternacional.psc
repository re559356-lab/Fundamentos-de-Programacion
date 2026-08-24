Algoritmo PaqueteriaInternacional
	
    Definir peso, gramos, costo, total Como Real
    Definir zona Como Entero
	
    Escribir "Ingrese el peso del paquete en kilogramos:"
    Leer peso
	
    Si peso > 5 Entonces
		
        Escribir "El paquete no puede ser transportado."
        Escribir "Motivo: el peso supera los 5 kg."
		
    Sino
		
        Escribir "Ingrese la zona de destino:"
        Escribir "1. América del Norte"
        Escribir "2. América Central"
        Escribir "3. América del Sur"
        Escribir "4. Europa"
        Escribir "5. Asia"
        Leer zona
		
        gramos <- peso * 1000
		
        Segun zona Hacer
			
            1:
                costo <- 11
            2:
                costo <- 10
            3:
                costo <- 12
            4:
                costo <- 25
            5:
                costo <- 30
            De Otro Modo:
                costo <- 0
                Escribir "Zona no válida."
				
        FinSegun
		
        Si costo > 0 Entonces
            total <- gramos * costo
			
            Escribir "Peso del paquete: ", gramos, " gramos"
            Escribir "Costo por gramo: $", costo
            Escribir "Costo total del envío: $", total
        FinSi
		
    FinSi
	
FinAlgoritmo

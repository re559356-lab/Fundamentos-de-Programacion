Algoritmo BecasEstudiantes
	
    Definir edad Como Entero
    Definir promedio Como Real
    Definir beca Como Real
	
    Escribir "Ingrese la edad del alumno:"
    Leer edad
	
    Escribir "Ingrese el promedio del alumno:"
    Leer promedio
	
    Si edad > 18 Entonces
		
        Si promedio >= 9 Entonces
            beca <- 10000
            Escribir "La beca mensual es de: $", beca
			
        Sino
            Si promedio >= 7.5 Entonces
                beca <- 8000
                Escribir "La beca mensual es de: $", beca
				
            Sino
                Si promedio >= 6 Entonces
                    beca <- 5000
                    Escribir "La beca mensual es de: $", beca
					
                Sino
                    Escribir "Se enviará una carta de invitación para que estudie más."
                FinSi
            FinSi
        FinSi
		
    Sino
		
        Si promedio >= 9 Entonces
            beca <- 8000
            Escribir "La beca mensual es de: $", beca
			
        Sino
            Si promedio >= 8 Entonces
                beca <- 6000
                Escribir "La beca mensual es de: $", beca
				
            Sino
                Si promedio >= 6 Entonces
                    beca <- 4000
                    Escribir "La beca mensual es de: $", beca
					
                Sino
                    Escribir "Se enviará una carta de invitación para que estudie más."
                FinSi
            FinSi
        FinSi
		
    FinSi
	
FinAlgoritmo
Proceso Pasteleria
    Definir opcionSabor, opcionChoco, cantidadSnacks Como Entero;
    Definir total Como Real;
    Definir respuestaSnack, respuestaNombre, nombreTarta, respuesta Como Caracter;
    
    Repetir
        total <- 0;
        Escribir "Elige el sabor (1. Manzana, 2. Fresa, 3. Chocolate): ";
        Leer opcionSabor;
        
        Segun opcionSabor Hacer
            1: total <- total + 200;
            2: total <- total + 250;
            3: 
                Escribir "Tipo de chocolate (1. Negro $280, 2. Blanco $300): ";
                Leer opcionChoco;
                Si opcionChoco = 1 Entonces total <- total + 280; Sino total <- total + 300; FinSi
			FinSegun
			
			Escribir "¿Deseas añadir snacks? (si/no): ";
			Leer respuestaSnack;
			Si respuestaSnack = "si" o respuestaSnack = "s" Entonces
				Escribir "Cuantos snacks: ";
				Leer cantidadSnacks;
				total <- total + (cantidadSnacks * 25);
			FinSi
			
			Escribir "¿Deseas personalizar con nombre ($30)? (si/no): ";
			Leer respuestaNombre;
			SI respuestaNombre = "si" o respuestaNombre = "s" Entonces
            Escribir "Introduce el nombre: ";
            Leer nombreTarta;
            total <- total + 30;
			Fin SI
			
			Escribir "Total del presupuesto: $", total;
			
			Escribir "¿Deseas hacer otro presupuesto? (si/no): ";
			Leer respuesta;
		Hasta Que respuesta = "no" o respuesta = "n";
FinProceso
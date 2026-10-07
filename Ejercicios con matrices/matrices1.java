import java.util.Scanner;

public class matrices1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("EJEMPLO DE MATRICES");
        System.out.print("¿Cuantas filas tendra la matriz? ");
        int filas = sc.nextInt();

        System.out.print("¿Cuantas columnas tendra la matriz? ");
        int columnas = sc.nextInt();

        if (filas <= 0 || columnas <= 0) {
            System.out.println("Las filas y columnas deben ser mayores que cero.");
            sc.close();
            return;
        }

        int[][] matriz = new int[filas][columnas];

        // Indica si cada posicion esta ocupada
        boolean[][] ocupado = new boolean[filas][columnas];

        int cantidad = 0;
        int totalPosiciones = filas * columnas;

        boolean llenadoInicial = false;

        int opcion;

        do {

            System.out.println("\n========== MENU DE MATRIZ ==========");
            System.out.println("1. Llenado inicial");
            System.out.println("2. Visualizacion");
            System.out.println("3. Modificacion");
            System.out.println("4. Eliminacion");
            System.out.println("5. Busqueda");
            System.out.println("6. Actualizacion");
            System.out.println("7. Ordenacion ascendente");
            System.out.println("8. Ordenacion descendente");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                // =====================================
                // 1. LLENADO
                // =====================================

                case 1:

                    System.out.println("\nLLENADO INICIAL");

                    if (llenadoInicial) {

                        System.out.println("El llenado inicial ya fue realizado.");
                        System.out.println("No puedes volver a llenar la matriz.");
                        System.out.println("Utiliza Actualizacion para agregar valores.");

                    } else {

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                System.out.print(
                                    "Introduce el valor para [" + i + "][" + j + "]: "
                                );

                                matriz[i][j] = sc.nextInt();

                                ocupado[i][j] = true;

                                cantidad++;
                            }
                        }

                        llenadoInicial = true;

                        System.out.println("Matriz llenada correctamente.");
                    }

                    break;


                // =====================================
                // 2. VISUALIZACION
                // =====================================

                case 2:

                    System.out.println("\nVISUALIZACION DE LA MATRIZ");

                    if (!llenadoInicial) {

                        System.out.println("Primero realiza el llenado inicial.");

                    } else {

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                if (ocupado[i][j]) {
                                    System.out.print(matriz[i][j] + "\t");
                                } else {
                                    System.out.print("\t");
                                }
                            }

                            System.out.println();
                        }

                        System.out.println("\nPosiciones de la matriz:");

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                if (ocupado[i][j]) {

                                    System.out.println(
                                        "[" + i + "][" + j + "] = "
                                        + matriz[i][j]
                                    );

                                } else {

                                    System.out.println(
                                        "[" + i + "][" + j + "] = Vacia"
                                    );
                                }
                            }
                        }

                        System.out.println("\nElementos ocupados: " + cantidad);
                        System.out.println(
                            "Espacios disponibles: "
                            + (totalPosiciones - cantidad)
                        );
                    }

                    break;


                // =====================================
                // 3. MODIFICACION
                // =====================================

                case 3:

                    System.out.println("\nMODIFICACION");

                    if (!llenadoInicial) {

                        System.out.println("Primero realiza el llenado inicial.");

                    } else {

                        System.out.print("Introduce la fila: ");
                        int fila = sc.nextInt();

                        System.out.print("Introduce la columna: ");
                        int columna = sc.nextInt();

                        if (
                            fila >= 0 &&
                            fila < filas &&
                            columna >= 0 &&
                            columna < columnas &&
                            ocupado[fila][columna]
                        ) {

                            System.out.println(
                                "Valor actual: "
                                + matriz[fila][columna]
                            );

                            System.out.print("Introduce el nuevo valor: ");

                            matriz[fila][columna] = sc.nextInt();

                            System.out.println(
                                "Modificacion realizada correctamente."
                            );

                        } else {

                            System.out.println(
                                "Posicion no valida o esta vacia."
                            );
                        }
                    }

                    break;


                // =====================================
                // 4. ELIMINACION
                // =====================================

                case 4:

                    System.out.println("\nELIMINACION");

                    if (!llenadoInicial) {

                        System.out.println("Primero realiza el llenado inicial.");

                    } else if (cantidad == 0) {

                        System.out.println("La matriz esta vacia.");

                    } else {

                        System.out.print("Introduce la fila: ");
                        int fila = sc.nextInt();

                        System.out.print("Introduce la columna: ");
                        int columna = sc.nextInt();

                        if (
                            fila >= 0 &&
                            fila < filas &&
                            columna >= 0 &&
                            columna < columnas &&
                            ocupado[fila][columna]
                        ) {

                            // Se elimina el valor
                            matriz[fila][columna] = 0;

                            // La posicion queda disponible
                            ocupado[fila][columna] = false;

                            cantidad--;

                            System.out.println(
                                "Elemento eliminado correctamente."
                            );

                            System.out.println(
                                "La posicion [" + fila + "][" +
                                columna + "] esta vacia."
                            );

                        } else {

                            System.out.println(
                                "Posicion no valida o ya esta vacia."
                            );
                        }
                    }

                    break;


                // =====================================
                // 5. BUSQUEDA
                // =====================================

                case 5:

                    System.out.println("\nBUSQUEDA");

                    if (!llenadoInicial) {

                        System.out.println("Primero realiza el llenado inicial.");

                    } else {

                        System.out.print("Introduce el valor que deseas buscar: ");
                        int buscar = sc.nextInt();

                        boolean encontrado = false;

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                if (
                                    ocupado[i][j] &&
                                    matriz[i][j] == buscar
                                ) {

                                    System.out.println(
                                        "Elemento encontrado en ["
                                        + i + "][" + j + "]"
                                    );

                                    encontrado = true;
                                }
                            }
                        }

                        if (!encontrado) {

                            System.out.println(
                                "El elemento no se encuentra en la matriz."
                            );
                        }
                    }

                    break;


                // =====================================
                // 6. ACTUALIZACION
                // =====================================

                case 6:

                    System.out.println("\nACTUALIZACION");

                    if (!llenadoInicial) {

                        System.out.println(
                            "Primero realiza el llenado inicial."
                        );

                    } else {

                        int disponibles =
                            totalPosiciones - cantidad;

                        if (disponibles == 0) {

                            System.out.println(
                                "No existen posiciones disponibles."
                            );

                            System.out.println(
                                "La matriz esta llena."
                            );

                        } else {

                            System.out.println(
                                "Posiciones disponibles:"
                            );

                            for (int i = 0; i < filas; i++) {

                                for (int j = 0; j < columnas; j++) {

                                    if (!ocupado[i][j]) {

                                        System.out.println(
                                            "[" + i + "][" + j + "]"
                                        );
                                    }
                                }
                            }

                            System.out.println(
                                "Espacios disponibles: "
                                + disponibles
                            );

                            System.out.print(
                                "¿Cuantos valores deseas agregar? "
                            );

                            int agregar = sc.nextInt();

                            if (
                                agregar <= 0 ||
                                agregar > disponibles
                            ) {

                                System.out.println(
                                    "Cantidad no valida."
                                );

                            } else {

                                for (int k = 0; k < agregar; k++) {

                                    boolean agregado = false;

                                    for (int i = 0;
                                         i < filas && !agregado;
                                         i++) {

                                        for (int j = 0;
                                             j < columnas;
                                             j++) {

                                            if (!ocupado[i][j]) {

                                                System.out.print(
                                                    "Introduce el nuevo "
                                                    + "valor para ["
                                                    + i + "][" + j + "]: "
                                                );

                                                matriz[i][j] =
                                                    sc.nextInt();

                                                ocupado[i][j] = true;

                                                cantidad++;

                                                agregado = true;

                                                break;
                                            }
                                        }
                                    }
                                }

                                System.out.println(
                                    "Actualizacion realizada correctamente."
                                );
                            }
                        }
                    }

                    break;


                // =====================================
                // 7. ORDEN ASCENDENTE
                // =====================================

                case 7:

                    System.out.println("\nORDENACION ASCENDENTE");

                    if (!llenadoInicial) {

                        System.out.println(
                            "Primero realiza el llenado inicial."
                        );

                    } else {

                        // Ordenar todos los elementos ocupados
                        // de menor a mayor

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                for (int k = i; k < filas; k++) {

                                    int inicio;

                                    if (k == i) {
                                        inicio = j + 1;
                                    } else {
                                        inicio = 0;
                                    }

                                    for (int l = inicio;
                                         l < columnas;
                                         l++) {

                                        if (
                                            ocupado[i][j] &&
                                            ocupado[k][l] &&
                                            matriz[i][j] > matriz[k][l]
                                        ) {

                                            int auxiliar =
                                                matriz[i][j];

                                            matriz[i][j] =
                                                matriz[k][l];

                                            matriz[k][l] =
                                                auxiliar;
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println(
                            "Matriz ordenada de menor a mayor:"
                        );

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                if (ocupado[i][j]) {
                                    System.out.print(
                                        matriz[i][j] + "\t"
                                    );
                                } else {
                                    System.out.print("\t");
                                }
                            }

                            System.out.println();
                        }
                    }

                    break;


                // =====================================
                // 8. ORDEN DESCENDENTE
                // =====================================

                case 8:

                    System.out.println("\nORDENACION DESCENDENTE");

                    if (!llenadoInicial) {

                        System.out.println(
                            "Primero realiza el llenado inicial."
                        );

                    } else {

                        // Ordenar de mayor a menor

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                for (int k = i; k < filas; k++) {

                                    int inicio;

                                    if (k == i) {
                                        inicio = j + 1;
                                    } else {
                                        inicio = 0;
                                    }

                                    for (int l = inicio;
                                         l < columnas;
                                         l++) {

                                        if (
                                            ocupado[i][j] &&
                                            ocupado[k][l] &&
                                            matriz[i][j] < matriz[k][l]
                                        ) {

                                            int auxiliar =
                                                matriz[i][j];

                                            matriz[i][j] =
                                                matriz[k][l];

                                            matriz[k][l] =
                                                auxiliar;
                                        }
                                    }
                                }
                            }
                        }

                        System.out.println(
                            "Matriz ordenada de mayor a menor:"
                        );

                        for (int i = 0; i < filas; i++) {

                            for (int j = 0; j < columnas; j++) {

                                if (ocupado[i][j]) {
                                    System.out.print(
                                        matriz[i][j] + "\t"
                                    );
                                } else {
                                    System.out.print("\t");
                                }
                            }

                            System.out.println();
                        }
                    }

                    break;


                // =====================================
                // 9. SALIR
                // =====================================

                case 9:

                    System.out.println(
                        "Saliendo del programa..."
                    );

                    break;


                default:

                    System.out.println(
                        "Opcion no valida."
                    );
            }

        } while (opcion != 9);

        sc.close();
    }
}

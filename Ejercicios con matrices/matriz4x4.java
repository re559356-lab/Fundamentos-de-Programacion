import java.util.Scanner;

public class matriz4x4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Matriz original
        int[][] matriz = new int[4][4];

        // Matriz para los cuadrados
        int[][] matrizCuadrados = new int[4][4];

        // Indica si la matriz ya fue rellenada
        boolean matrizLlena = false;

        int opcion;

        do {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Rellenar toda la matriz");
            System.out.println("2. Suma de cada fila y columna");
            System.out.println("3. Suma de una fila");
            System.out.println("4. Suma de una columna");
            System.out.println("5. Mayor y menor con su posicion");
            System.out.println("6. Contar numeros pares");
            System.out.println("7. Contar numeros impares");
            System.out.println("8. Generar matriz con cuadrados");
            System.out.println("9. Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Media de todos los valores");
            System.out.println("12. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();

            // =====================================================
            // OPCION 1 - RELLENAR MATRIZ
            // =====================================================

            if (opcion == 1) {

                System.out.println("\n--- RELLENAR MATRIZ ---");

                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 4; j++) {

                        boolean repetido;

                        do {

                            repetido = false;

                            System.out.print("Ingrese un numero para ["
                                    + i + "][" + j + "]: ");

                            int numero = entrada.nextInt();

                            // Revisar si el numero ya existe
                            for (int x = 0; x < 4; x++) {

                                for (int y = 0; y < 4; y++) {

                                    if (matriz[x][y] == numero) {
                                        repetido = true;
                                    }
                                }
                            }

                            if (repetido) {

                                System.out.println(
                                    "Ese numero ya se encuentra en la matriz."
                                );

                                System.out.println(
                                    "Ingrese otro numero."
                                );

                            } else {

                                matriz[i][j] = numero;
                            }

                        } while (repetido);
                    }
                }

                matrizLlena = true;

                System.out.println("\nLa matriz se ha rellenado correctamente.");

                // Mostrar matriz
                System.out.println("\n--- MATRIZ ORIGINAL ---");

                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 4; j++) {

                        System.out.print(matriz[i][j] + "\t");
                    }

                    System.out.println();
                }
            }

            // =====================================================
            // OPCIONES 2 A 11
            // =====================================================

            else if (opcion >= 2 && opcion <= 11) {

                // Comprobar que la matriz ya fue rellenada
                if (!matrizLlena) {

                    System.out.println(
                        "\nPrimero debes rellenar la matriz."
                    );

                } else {

                    // Mostrar siempre la matriz original
                    System.out.println("\n--- MATRIZ ORIGINAL ---");

                    for (int i = 0; i < 4; i++) {

                        for (int j = 0; j < 4; j++) {

                            System.out.print(matriz[i][j] + "\t");
                        }

                        System.out.println();
                    }

                    // =================================================
                    // OPCION 2 - SUMA DE FILAS Y COLUMNAS
                    // =================================================

                    if (opcion == 2) {

                        System.out.println("\n--- SUMA DE FILAS ---");

                        for (int i = 0; i < 4; i++) {

                            int sumaFila = 0;

                            for (int j = 0; j < 4; j++) {

                                sumaFila += matriz[i][j];
                            }

                            System.out.println(
                                "Fila " + (i + 1) + ": " + sumaFila
                            );
                        }

                        System.out.println("\n--- SUMA DE COLUMNAS ---");

                        for (int j = 0; j < 4; j++) {

                            int sumaColumna = 0;

                            for (int i = 0; i < 4; i++) {

                                sumaColumna += matriz[i][j];
                            }

                            System.out.println(
                                "Columna " + (j + 1) + ": " + sumaColumna
                            );
                        }
                    }

                    // =================================================
                    // OPCION 3 - SUMA DE UNA FILA
                    // =================================================

                    else if (opcion == 3) {

                        int fila;

                        do {

                            System.out.print(
                                "\nIngrese el numero de fila (1-4): "
                            );

                            fila = entrada.nextInt();

                            if (fila < 1 || fila > 4) {

                                System.out.println(
                                    "Fila incorrecta. Debe ser entre 1 y 4."
                                );
                            }

                        } while (fila < 1 || fila > 4);

                        int suma = 0;

                        for (int j = 0; j < 4; j++) {

                            suma += matriz[fila - 1][j];
                        }

                        System.out.println(
                            "La suma de la fila " + fila + " es: " + suma
                        );
                    }

                    // =================================================
                    // OPCION 4 - SUMA DE UNA COLUMNA
                    // =================================================

                    else if (opcion == 4) {

                        int columna;

                        do {

                            System.out.print(
                                "\nIngrese el numero de columna (1-4): "
                            );

                            columna = entrada.nextInt();

                            if (columna < 1 || columna > 4) {

                                System.out.println(
                                    "Columna incorrecta. Debe ser entre 1 y 4."
                                );
                            }

                        } while (columna < 1 || columna > 4);

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            suma += matriz[i][columna - 1];
                        }

                        System.out.println(
                            "La suma de la columna "
                            + columna + " es: " + suma
                        );
                    }

                    // =================================================
                    // OPCION 5 - MAYOR Y MENOR
                    // =================================================

                    else if (opcion == 5) {

                        int mayor = matriz[0][0];
                        int menor = matriz[0][0];

                        int filaMayor = 0;
                        int columnaMayor = 0;

                        int filaMenor = 0;
                        int columnaMenor = 0;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                if (matriz[i][j] > mayor) {

                                    mayor = matriz[i][j];

                                    filaMayor = i;
                                    columnaMayor = j;
                                }

                                if (matriz[i][j] < menor) {

                                    menor = matriz[i][j];

                                    filaMenor = i;
                                    columnaMenor = j;
                                }
                            }
                        }

                        System.out.println(
                            "Mayor: " + mayor
                        );

                        System.out.println(
                            "Posicion: fila " + (filaMayor + 1)
                            + ", columna " + (columnaMayor + 1)
                        );

                        System.out.println(
                            "Menor: " + menor
                        );

                        System.out.println(
                            "Posicion: fila " + (filaMenor + 1)
                            + ", columna " + (columnaMenor + 1)
                        );
                    }

                    // =================================================
                    // OPCION 6 - CONTAR PARES
                    // =================================================

                    else if (opcion == 6) {

                        int pares = 0;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                if (matriz[i][j] % 2 == 0) {

                                    pares++;
                                }
                            }
                        }

                        System.out.println(
                            "Cantidad de numeros pares: " + pares
                        );
                    }

                    // =================================================
                    // OPCION 7 - CONTAR IMPARES
                    // =================================================

                    else if (opcion == 7) {

                        int impares = 0;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                if (matriz[i][j] % 2 != 0) {

                                    impares++;
                                }
                            }
                        }

                        System.out.println(
                            "Cantidad de numeros impares: " + impares
                        );
                    }

                    // =================================================
                    // OPCION 8 - MATRIZ DE CUADRADOS
                    // =================================================

                    else if (opcion == 8) {

                        System.out.println(
                            "\n--- MATRIZ DE CUADRADOS ---"
                        );

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                matrizCuadrados[i][j] =
                                    matriz[i][j] * matriz[i][j];

                                System.out.print(
                                    matrizCuadrados[i][j] + "\t"
                                );
                            }

                            System.out.println();
                        }
                    }

                    // =================================================
                    // OPCION 9 - DIAGONAL PRINCIPAL
                    // =================================================

                    else if (opcion == 9) {

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            suma += matriz[i][i];
                        }

                        System.out.println(
                            "La suma de la diagonal principal es: "
                            + suma
                        );
                    }

                    // =================================================
                    // OPCION 10 - DIAGONAL INVERSA
                    // =================================================

                    else if (opcion == 10) {

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            suma += matriz[i][3 - i];
                        }

                        System.out.println(
                            "La suma de la diagonal inversa es: "
                            + suma
                        );
                    }

                    // =================================================
                    // OPCION 11 - MEDIA
                    // =================================================

                    else if (opcion == 11) {

                        int suma = 0;

                        for (int i = 0; i < 4; i++) {

                            for (int j = 0; j < 4; j++) {

                                suma += matriz[i][j];
                            }
                        }

                        double media = (double) suma / 16;

                        System.out.println(
                            "La media de todos los valores es: "
                            + media
                        );
                    }
                }
            }

            // =====================================================
            // OPCION 12 - SALIR
            // =====================================================

            else if (opcion == 12) {

                System.out.println("\nPrograma finalizado.");
            }

            else {

                System.out.println(
                    "\nOpcion no valida."
                );
            }

        } while (opcion != 12);

        entrada.close();
    }
}
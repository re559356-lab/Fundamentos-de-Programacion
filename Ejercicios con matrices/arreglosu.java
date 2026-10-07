
import java.util.Scanner;

public class arreglosu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("EJEMPLO DE ARREGLOS UNIDIMENSIONALES");
        System.out.print("¿Cuantos elementos tendra el arreglo? ");

        int N = sc.nextInt();

        if (N <= 0) {
            System.out.println("El tamaño debe ser mayor que cero.");
            sc.close();
            return;
        }

        int[] A = new int[N];
        boolean[] ocupado = new boolean[N];

        int cantidad = 0;
        int opcion;
        boolean llenadoInicial = false;

        do {
            System.out.println("\n========== MENU DE ARREGLOS ==========");
            System.out.println("1. Llenado inicial del arreglo");
            System.out.println("2. Visualizacion del arreglo");
            System.out.println("3. Modificacion por posicion");
            System.out.println("4. Eliminacion de elementos");
            System.out.println("5. Busqueda de un elemento");
            System.out.println("6. Actualizacion de posiciones eliminadas");
            System.out.println("7. Ordenacion ascendente");
            System.out.println("8. Ordenacion descendente");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                // 1. LLENADO INICIAL
                case 1:
                    System.out.println("\nLLENADO INICIAL");

                    if (llenadoInicial) {
                        System.out.println("El llenado inicial ya fue realizado.");
                        System.out.println("Utiliza Actualizacion para agregar nuevos valores.");
                    } else {

                        for (int i = 0; i < N; i++) {
                            System.out.print("Introduce el valor para la posicion " + i + ": ");
                            A[i] = sc.nextInt();
                            ocupado[i] = true;
                            cantidad++;
                        }

                        llenadoInicial = true;

                        System.out.println("Arreglo llenado correctamente.");
                    }
                    break;

                // 2. VISUALIZACION
                
case 2:
    System.out.println("\nVISUALIZACION DEL ARREGLO");

    if (!llenadoInicial) {
        System.out.println("Primero realiza el llenado inicial.");
    } else {

        System.out.println("Elementos del arreglo:");

        for (int i = 0; i < A.length; i++) {

            if (ocupado[i]) {
                System.out.println("Posicion " + i + ": " + A[i]);
            } else {
                System.out.println("Posicion " + i + ":");
            }
        }

        System.out.println("\nValores del arreglo:");

        for (int i = 0; i < A.length; i++) {
            if (ocupado[i]) {
                System.out.print(A[i] + " ");
            } else {
                System.out.print("  ");
            }
        }

        System.out.println();
        System.out.println("Elementos ocupados: " + cantidad);
        System.out.println("Espacios disponibles: " + (N - cantidad));
    }
    break;
               

                // 3. MODIFICACION POR POSICION
                case 3:
                    System.out.println("\nMODIFICACION DEL ARREGLO");

                    if (!llenadoInicial) {
                        System.out.println("Primero realiza el llenado inicial.");
                    } else {

                        System.out.print("Introduce la posicion que deseas modificar: ");
                        int posicion = sc.nextInt();

                        if (posicion >= 0 && posicion < N && ocupado[posicion]) {

                            System.out.println("Valor actual: " + A[posicion]);

                            System.out.print("Introduce el nuevo valor: ");
                            A[posicion] = sc.nextInt();

                            System.out.println("Modificacion realizada correctamente.");

                        } else {
                            System.out.println("Posicion no valida o eliminada.");
                        }
                    }
                    break;

                // 4. ELIMINACION
                
case 4:
    System.out.println("\nELIMINACION DE ELEMENTOS");

    if (!llenadoInicial) {
        System.out.println("Primero realiza el llenado inicial.");
    } else if (cantidad == 0) {
        System.out.println("No hay elementos para eliminar.");
    } else {

        System.out.println("Elementos actuales:");

        for (int i = 0; i < N; i++) {
            if (ocupado[i]) {
                System.out.println("Posicion " + i + ": " + A[i]);
            }
        }

        System.out.print("Introduce la posicion que deseas eliminar: ");
        int posicion = sc.nextInt();

        if (posicion >= 0 && posicion < N && ocupado[posicion]) {

            A[posicion] = 0;
            ocupado[posicion] = false;
            cantidad--;

            System.out.println("Elemento eliminado correctamente.");
            System.out.println("La posicion " + posicion + " esta vacia.");

        } else {
            System.out.println("Posicion no valida o ya eliminada.");
        }
    }
    break;

                // 5. BUSQUEDA
                case 5:
                    System.out.println("\nBUSQUEDA DE UN ELEMENTO");

                    if (!llenadoInicial) {
                        System.out.println("Primero realiza el llenado inicial.");
                    } else {

                        System.out.print("Introduce el valor que deseas buscar: ");
                        int buscar = sc.nextInt();

                        boolean encontrado = false;

                        for (int i = 0; i < N; i++) {

                            if (ocupado[i] && A[i] == buscar) {
                                System.out.println("Elemento encontrado en la posicion " + i);
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("El elemento no se encuentra en el arreglo.");
                        }
                    }
                    break;

                // 6. ACTUALIZACION DE POSICIONES ELIMINADAS
                case 6:
                    System.out.println("\nACTUALIZACION DEL ARREGLO");

                    if (!llenadoInicial) {
                        System.out.println("Primero realiza el llenado inicial.");
                    } else {

                        int disponibles = N - cantidad;

                        if (disponibles == 0) {
                            System.out.println("No existen posiciones disponibles.");
                            System.out.println("El arreglo esta lleno.");
                        } else {

                            System.out.println("Posiciones disponibles:");

                            for (int i = 0; i < N; i++) {
                                if (!ocupado[i]) {
                                    System.out.println("Posicion " + i);
                                }
                            }

                            System.out.println("Espacios disponibles: " + disponibles);

                            System.out.print("¿Cuantos valores deseas agregar? ");
                            int agregar = sc.nextInt();

                            if (agregar <= 0 || agregar > disponibles) {
                                System.out.println("Cantidad no valida.");
                            } else {

                                for (int i = 0; i < agregar; i++) {

                                    // Buscar la primera posicion disponible
                                    int posicion = 0;

                                    while (ocupado[posicion]) {
                                        posicion++;
                                    }

                                    System.out.print("Introduce el nuevo valor para la posicion "
                                            + posicion + ": ");

                                    A[posicion] = sc.nextInt();
                                    ocupado[posicion] = true;
                                    cantidad++;

                                    System.out.println("Valor agregado correctamente.");
                                }

                                System.out.println("Actualizacion finalizada.");
                            }
                        }
                    }
                    break;

                // 7. ORDENACION ASCENDENTE
                case 7:
                    System.out.println("\nORDENACION ASCENDENTE");

                    if (!llenadoInicial) {
                        System.out.println("Primero realiza el llenado inicial.");
                    } else {

                        // Ordenar solamente los elementos ocupados
                        for (int i = 0; i < N - 1; i++) {
                            for (int j = 0; j < N - 1; j++) {

                                if (ocupado[j] && ocupado[j + 1]
                                        && A[j] > A[j + 1]) {

                                    int auxiliar = A[j];
                                    A[j] = A[j + 1];
                                    A[j + 1] = auxiliar;
                                }
                            }
                        }

                        // Colocar los elementos ocupados antes de los espacios vacios
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N - 1; j++) {

                                if (!ocupado[j] && ocupado[j + 1]) {

                                    A[j] = A[j + 1];
                                    ocupado[j] = true;
                                    ocupado[j + 1] = false;
                                }
                            }
                        }

                        System.out.println("Arreglo ordenado de menor a mayor:");

                        for (int i = 0; i < N; i++) {
                            if (ocupado[i]) {
                                System.out.print(A[i] + " ");
                            }
                        }

                        System.out.println();
                    }
                    break;

                // 8. ORDENACION DESCENDENTE
                case 8:
                    System.out.println("\nORDENACION DESCENDENTE");

                    if (!llenadoInicial) {
                        System.out.println("Primero realiza el llenado inicial.");
                    } else {

                        // Ordenar los elementos ocupados
                        for (int i = 0; i < N - 1; i++) {
                            for (int j = 0; j < N - 1; j++) {

                                if (ocupado[j] && ocupado[j + 1]
                                        && A[j] < A[j + 1]) {

                                    int auxiliar = A[j];
                                    A[j] = A[j + 1];
                                    A[j + 1] = auxiliar;
                                }
                            }
                        }

                        // Colocar los elementos ocupados antes de los espacios vacios
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N - 1; j++) {

                                if (!ocupado[j] && ocupado[j + 1]) {

                                    A[j] = A[j + 1];
                                    ocupado[j] = true;
                                    ocupado[j + 1] = false;
                                }
                            }
                        }

                        System.out.println("Arreglo ordenado de mayor a menor:");

                        for (int i = 0; i < N; i++) {
                            if (ocupado[i]) {
                                System.out.print(A[i] + " ");
                            }
                        }

                        System.out.println();
                    }
                    break;

                // 9. SALIR
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 9);

        sc.close();
    }
}
import java.util.Scanner;

public class Calificaciones {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // ==========================================
        // PEDIR CANTIDAD DE ESTUDIANTES Y EXAMENES
        // ==========================================

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int n = entrada.nextInt();

        System.out.print("Ingrese la cantidad de examenes: ");
        int m = entrada.nextInt();

        // ==========================================
        // MATRIZ PRINCIPAL
        // ==========================================

        double[][] calificaciones = new double[n][m];

        // ==========================================
        // LLENAR MATRIZ
        // ==========================================

        System.out.println("\n--- CAPTURA DE CALIFICACIONES ---");

        for (int i = 0; i < n; i++) {

            System.out.println("\nEstudiante " + (i + 1));

            for (int j = 0; j < m; j++) {

                do {

                    System.out.print(
                        "Calificacion del examen " + (j + 1) + ": "
                    );

                    calificaciones[i][j] = entrada.nextDouble();

                    if (calificaciones[i][j] < 0 ||
                        calificaciones[i][j] > 10) {

                        System.out.println(
                            "La calificacion debe estar entre 0 y 10."
                        );
                    }

                } while (calificaciones[i][j] < 0 ||
                         calificaciones[i][j] > 10);
            }
        }

        // ==========================================
        // MOSTRAR MATRIZ ORIGINAL
        // ==========================================

        System.out.println("\n========== MATRIZ DE CALIFICACIONES ==========");

        for (int i = 0; i < n; i++) {

            System.out.print("Estudiante " + (i + 1) + ": ");

            for (int j = 0; j < m; j++) {

                System.out.print(calificaciones[i][j] + "\t");
            }

            System.out.println();
        }

        // ==========================================
        // 1. PROMEDIO DE CADA ESTUDIANTE
        // ==========================================

        double[] promedios = new double[n];

        System.out.println("\n========== PROMEDIO DE CADA ESTUDIANTE ==========");

        for (int i = 0; i < n; i++) {

            double suma = 0;

            for (int j = 0; j < m; j++) {

                suma += calificaciones[i][j];
            }

            promedios[i] = suma / m;

            System.out.println(
                "Estudiante " + (i + 1) +
                ": " + promedios[i]
            );
        }

        // ==========================================
        // 2. BUSCAR EL MEJOR PROMEDIO
        // ==========================================

        double mejorPromedio = promedios[0];

        for (int i = 1; i < n; i++) {

            if (promedios[i] > mejorPromedio) {

                mejorPromedio = promedios[i];
            }
        }

        System.out.println("\n========== MEJOR PROMEDIO ==========");

        System.out.println(
            "Mejor promedio: " + mejorPromedio
        );

        // ==========================================
        // CONTAR ESTUDIANTES ENTRE 9 Y 10
        // ==========================================

        int cantidadMejores = 0;

        for (int i = 0; i < n; i++) {

            if (promedios[i] >= 9 &&
                promedios[i] <= 10) {

                cantidadMejores++;
            }
        }

        // ==========================================
        // CREAR MATRIZ DE ESTUDIANTES ENTRE 9 Y 10
        // ==========================================

        double[][] mejores = new double[cantidadMejores][m + 1];

        int filaMejor = 0;

        for (int i = 0; i < n; i++) {

            if (promedios[i] >= 9 &&
                promedios[i] <= 10) {

                // Guardar numero de estudiante
                mejores[filaMejor][0] = i + 1;

                // Guardar calificaciones
                for (int j = 0; j < m; j++) {

                    mejores[filaMejor][j + 1] =
                        calificaciones[i][j];
                }

                filaMejor++;
            }
        }

        // ==========================================
        // MOSTRAR LISTADO DE ESTUDIANTES 9-10
        // ==========================================

        System.out.println(
            "\n========== ESTUDIANTES CON PROMEDIO ENTRE 9 Y 10 =========="
        );

        if (cantidadMejores == 0) {

            System.out.println(
                "No hay estudiantes con promedio entre 9 y 10."
            );

        } else {

            for (int i = 0; i < cantidadMejores; i++) {

                System.out.print(
                    "Estudiante " +
                    (int) mejores[i][0] +
                    ": "
                );

                for (int j = 1; j <= m; j++) {

                    System.out.print(
                        mejores[i][j] + "\t"
                    );
                }

                System.out.println(
                    "Promedio: " +
                    promedios[(int) mejores[i][0] - 1]
                );
            }
        }

        // ==========================================
        // 3. ESTUDIANTES CON PROMEDIO MENOR A 7
        // ==========================================

        int cantidadBajos = 0;

        for (int i = 0; i < n; i++) {

            if (promedios[i] < 7) {

                cantidadBajos++;
            }
        }

        // ==========================================
        // CREAR MATRIZ DE ESTUDIANTES CON PROMEDIO < 7
        // ==========================================

        double[][] bajos = new double[cantidadBajos][m + 1];

        int filaBajo = 0;

        for (int i = 0; i < n; i++) {

            if (promedios[i] < 7) {

                // Guardar numero de estudiante
                bajos[filaBajo][0] = i + 1;

                // Guardar calificaciones
                for (int j = 0; j < m; j++) {

                    bajos[filaBajo][j + 1] =
                        calificaciones[i][j];
                }

                filaBajo++;
            }
        }

        // ==========================================
        // MOSTRAR ESTUDIANTES CON PROMEDIO < 7
        // ==========================================

        System.out.println(
            "\n========== ESTUDIANTES CON PROMEDIO MENOR A 7 =========="
        );

        if (cantidadBajos == 0) {

            System.out.println(
                "No hay estudiantes con promedio menor a 7."
            );

        } else {

            for (int i = 0; i < cantidadBajos; i++) {

                System.out.print(
                    "Estudiante " +
                    (int) bajos[i][0] +
                    ": "
                );

                for (int j = 1; j <= m; j++) {

                    System.out.print(
                        bajos[i][j] + "\t"
                    );
                }

                System.out.println(
                    "Promedio: " +
                    promedios[(int) bajos[i][0] - 1]
                );
            }
        }

        // ==========================================
        // 4. EXAMEN CON MAYOR PROMEDIO
        // ==========================================

        double mayorPromedioExamen = 0;
        int examenMayor = 0;

        for (int j = 0; j < m; j++) {

            double suma = 0;

            for (int i = 0; i < n; i++) {

                suma += calificaciones[i][j];
            }

            double promedioExamen = suma / n;

            if (j == 0 || promedioExamen > mayorPromedioExamen) {

                mayorPromedioExamen = promedioExamen;
                examenMayor = j;
            }
        }

        System.out.println(
            "\n========== EXAMEN CON MAYOR PROMEDIO =========="
        );

        System.out.println(
            "El examen con mayor promedio fue el examen "
            + (examenMayor + 1)
            + " con promedio de "
            + mayorPromedioExamen
        );

        // ==========================================
        // 5. EXAMEN CON MENOR PROMEDIO
        // ==========================================

        double menorPromedioExamen = 0;
        int examenMenor = 0;

        for (int j = 0; j < m; j++) {

            double suma = 0;

            for (int i = 0; i < n; i++) {

                suma += calificaciones[i][j];
            }

            double promedioExamen = suma / n;

            if (j == 0 || promedioExamen < menorPromedioExamen) {

                menorPromedioExamen = promedioExamen;
                examenMenor = j;
            }
        }

        System.out.println(
            "\n========== EXAMEN CON MENOR PROMEDIO =========="
        );

        System.out.println(
            "El examen con menor promedio fue el examen "
            + (examenMenor + 1)
            + " con promedio de "
            + menorPromedioExamen
        );

        entrada.close();
    }
}
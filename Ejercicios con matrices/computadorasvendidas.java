import java.util.Scanner;

public class computadorasvendidas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // ==========================================
        // PEDIR CANTIDAD DE VENDEDORES Y ZONAS
        // ==========================================

        System.out.print("Ingrese la cantidad de vendedores: ");
        int n = entrada.nextInt();

        System.out.print("Ingrese la cantidad de zonas: ");
        int m = entrada.nextInt();

        // ==========================================
        // CREAR LAS MATRICES
        // ==========================================

        // Cantidad de computadoras vendidas
        int[][] cantidad = new int[n][m];

        // Precio de cada computadora
        double[][] precio = new double[n][m];

        // ==========================================
        // LLENAR LAS MATRICES
        // ==========================================

        System.out.println("\n========== CAPTURA DE VENTAS ==========");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.println(
                    "\nVendedor " + (i + 1)
                    + " - Zona " + (j + 1)
                );

                System.out.print(
                    "¿Cuantas computadoras vendio?: "
                );

                cantidad[i][j] = entrada.nextInt();

                System.out.print(
                    "¿Cual fue el precio de cada computadora?: $"
                );

                precio[i][j] = entrada.nextDouble();
            }
        }

        // ==========================================
        // MOSTRAR MATRIZ DE CANTIDADES
        // ==========================================

        System.out.println("\n========== CANTIDAD DE COMPUTADORAS ==========");

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(
                    cantidad[i][j] + "\t"
                );
            }

            System.out.println();
        }

        // ==========================================
        // 1. ZONA QUE MAS COMPUTADORAS VENDIO
        // ==========================================

        int zonaMayor = 0;
        int mayorComputadorasZona = 0;

        for (int j = 0; j < m; j++) {

            int totalZona = 0;

            for (int i = 0; i < n; i++) {

                totalZona += cantidad[i][j];
            }

            if (j == 0 || totalZona > mayorComputadorasZona) {

                mayorComputadorasZona = totalZona;
                zonaMayor = j;
            }
        }

        // ==========================================
        // 2. VENDEDOR QUE MENOS COMPUTADORAS VENDIO
        // ==========================================

        int vendedorMenor = 0;
        int menorComputadoras = 0;
        double ventaMenor = 0;

        for (int i = 0; i < n; i++) {

            int totalComputadoras = 0;
            double totalVenta = 0;

            for (int j = 0; j < m; j++) {

                totalComputadoras += cantidad[i][j];

                totalVenta += cantidad[i][j] * precio[i][j];
            }

            if (i == 0 || totalComputadoras < menorComputadoras) {

                menorComputadoras = totalComputadoras;
                vendedorMenor = i;
                ventaMenor = totalVenta;
            }
        }

        // ==========================================
        // 3. VENDEDOR QUE MAS COMPUTADORAS VENDIO
        // ==========================================

        int vendedorMayor = 0;
        int mayorComputadoras = 0;
        double ventaMayor = 0;

        for (int i = 0; i < n; i++) {

            int totalComputadoras = 0;
            double totalVenta = 0;

            for (int j = 0; j < m; j++) {

                totalComputadoras += cantidad[i][j];

                totalVenta += cantidad[i][j] * precio[i][j];
            }

            if (i == 0 || totalComputadoras > mayorComputadoras) {

                mayorComputadoras = totalComputadoras;
                vendedorMayor = i;
                ventaMayor = totalVenta;
            }
        }

        // ==========================================
        // 4. TOTAL DE COMPUTADORAS Y DINERO
        // ==========================================

        int totalComputadoras = 0;
        double totalDinero = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                totalComputadoras += cantidad[i][j];

                totalDinero += cantidad[i][j] * precio[i][j];
            }
        }

        // ==========================================
        // MOSTRAR RESULTADOS
        // ==========================================

        System.out.println("\n==========================================");
        System.out.println("              RESULTADOS");
        System.out.println("==========================================");

        // 1. Zona que más vendió
        System.out.println(
            "\n1. ZONA QUE MAS COMPUTADORAS VENDIO"
        );

        System.out.println(
            "Zona: " + (zonaMayor + 1)
        );

        System.out.println(
            "Computadoras vendidas: "
            + mayorComputadorasZona
        );

        // 2. Vendedor que menos vendió
        System.out.println(
            "\n2. VENDEDOR QUE MENOS COMPUTADORAS VENDIO"
        );

        System.out.println(
            "Vendedor: " + (vendedorMenor + 1)
        );

        System.out.println(
            "Computadoras vendidas: "
            + menorComputadoras
        );

        System.out.printf(
            "Venta total: $%.2f%n",
            ventaMenor
        );

        // 3. Vendedor que más vendió
        System.out.println(
            "\n3. VENDEDOR QUE MAS COMPUTADORAS VENDIO"
        );

        System.out.println(
            "Vendedor: " + (vendedorMayor + 1)
        );

        System.out.println(
            "Computadoras vendidas: "
            + mayorComputadoras
        );

        System.out.printf(
            "Venta total: $%.2f%n",
            ventaMayor
        );

        // 4. Total general
        System.out.println(
            "\n4. TOTAL DE COMPUTADORAS VENDIDAS"
        );

        System.out.println(
            "Computadoras vendidas por todos los vendedores: "
            + totalComputadoras
        );

        System.out.printf(
            "Dinero total de todas las ventas: $%.2f%n",
            totalDinero
        );

        entrada.close();
    }
}
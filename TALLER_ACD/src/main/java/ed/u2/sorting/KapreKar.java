package ed.u2.sorting;

import java.util.*;

public class KapreKar {


    static final int CONSTANTE_KAPREKAR = 6174;
    static final int MAXIMO_ITERACIONES = 50;
    static final int NUMERO_DIGITOS = 4;
    static final int TOTAL_NUMEROS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Estructuras de datos
        Queue<Integer> colaDeNumeros = new LinkedList<>();
        List<String> filasReporte = new ArrayList<>();


        System.out.println("=================================================");
        System.out.println("       SIMULACION DE KAPREKAR (Clase Unica)      ");
        System.out.println("=================================================");
        System.out.println("Presiona [ENTER] para iniciar:");
        scanner.nextLine();

        System.out.println("\n[ GLOSARIO DE COLUMNAS ]");
        System.out.println("  * S.Orig    : Semilla Original (Aleatorio 1000-9999).");
        System.out.println("  * S.Final   : Ultima semilla calculada antes del resultado.");
        System.out.println("  * Resultado : Valor final obtenido (Meta: 6174).");
        System.out.println("  * Iter      : Numero de iteraciones (restas) realizadas.");
        System.out.println("  * Estado    : LOGRADO (si llego a 6174) o NO LOGRADO.");
        System.out.println("-------------------------------------------------");

        // 2.- Llenar la Cola
        int contador = 0;
        while (contador < TOTAL_NUMEROS) {
            int semilla = 1000 + random.nextInt(9000);

            // Validamos que no sean digitos iguales
            if (!tieneDigitosIguales(semilla)) {
                colaDeNumeros.offer(semilla);
                contador++;
            }
        }

        // 3.- teorema
        System.out.println("Calculando resultados");
        int indiceNumero = 1;

        while (!colaDeNumeros.isEmpty()) {
            int semillaActual = colaDeNumeros.poll();
            int valorOriginal = semillaActual;

            int iteraciones = 0;
            int resultado = semillaActual;
            int semillaFinal = semillaActual; // guardamos valor previo :3

            // Bucle de Kaprekar
            while (resultado != CONSTANTE_KAPREKAR && iteraciones < MAXIMO_ITERACIONES) {
                iteraciones++;
                semillaFinal = resultado; // actualizamos antes de operar

                int[] digitos = separarEnDigitos(resultado);

                //  BUBBLESORT
                int[] arrMayor = BubbleSort.obtenerCopiaDescendente(digitos);
                int numMayor = convertirArregloAEntero(arrMayor);

                int[] arrMenor = BubbleSort.obtenerCopiaAscendente(digitos);
                int numMenor = convertirArregloAEntero(arrMenor);

                resultado = numMayor - numMenor;

                if (resultado == 0) break;
            }

            String estado = (resultado == CONSTANTE_KAPREKAR) ? "LOGRADO" : "NO LOGRADO";

            // Crear la fila para la tabla
            String fila = String.format("| %-3d | %-10d | %-10d | %-10d | %-4d | %-15s |",
                    indiceNumero, valorOriginal, semillaFinal, resultado, iteraciones, estado);

            filasReporte.add(fila);
            indiceNumero++;
        }

        // 4.- TABLA FINAL
        System.out.println("\n");
        System.out.println("=======================================================================");
        System.out.println("                         REPORTE FINAL DE RESULTADOS              ");
        System.out.println("=======================================================================");

        // Encabezados
        System.out.printf("| %-3s | %-10s | %-10s | %-10s | %-4s | %-15s |\n",
                "#", "S.Orig", "S.Final", "Resultado", "Iter", "Estado");

        System.out.println("|-----|------------|------------|------------|------|-----------------|");

        // Datos
        for (String fila : filasReporte) {
            System.out.println(fila);
        }
        System.out.println("=======================================================================");
    }



    private static boolean tieneDigitosIguales(int numero) {
        int[] d = separarEnDigitos(numero);
        return (d[0] == d[1] && d[1] == d[2] && d[2] == d[3]);
    }

    private static int[] separarEnDigitos(int numero) {
        int[] arr = new int[NUMERO_DIGITOS];
        for (int i = NUMERO_DIGITOS - 1; i >= 0; i--) {
            arr[i] = numero % 10;
            numero /= 10;
        }
        return arr;
    }

    private static int convertirArregloAEntero(int[] arr) {
        int num = 0;
        int mult = 1;
        for (int i = NUMERO_DIGITOS - 1; i >= 0; i--) {
            num += arr[i] * mult;
            mult *= 10;
        }
        return num;
    }
}
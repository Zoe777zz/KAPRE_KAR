package ed.u2.sorting;

public final class BubbleSort {


    public static void ordenarAscendente(int[] arreglo) {
        if (arreglo == null) return;
        int tamanio = arreglo.length;

        for (int pasada = 0; pasada < tamanio - 1; pasada++) {
            boolean huboIntercambio = false;
            for (int indice = 0; indice < tamanio - 1 - pasada; indice++) {
                if (arreglo[indice] > arreglo[indice + 1]) {
                    int temporal = arreglo[indice];
                    arreglo[indice] = arreglo[indice + 1];
                    arreglo[indice + 1] = temporal;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) break;
        }
    }

    public static void ordenarDescendente(int[] arreglo) {
        if (arreglo == null) return;
        int tamanio = arreglo.length;

        for (int pasada = 0; pasada < tamanio - 1; pasada++) {
            boolean huboIntercambio = false;
            for (int indice = 0; indice < tamanio - 1 - pasada; indice++) {
                if (arreglo[indice] < arreglo[indice + 1]) {
                    int temporal = arreglo[indice];
                    arreglo[indice] = arreglo[indice + 1];
                    arreglo[indice + 1] = temporal;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) break;
        }
    }

    public static int[] obtenerCopiaAscendente(int[] original) {
        if (original == null) return null;

        // creamos una copia
        int[] copia = original.clone();

        // ordenar copia
        ordenarAscendente(copia);

        // devolver la copia lista
        return copia;
    }

    public static int[] obtenerCopiaDescendente(int[] original) {
        if (original == null) return null;
        int[] copia = original.clone();
        ordenarDescendente(copia);
        return copia;
    }
}
# KAPRE_KAR
# Simulación de la Constante de Kaprekar (6174)

## Descripción 
Este programa en Java demuestra la convergencia de números aleatorios de 4 dígitos hacia la **Constante de Kaprekar (6174)**

El proceso consiste en:
1. Generar un número de 4 dígitos (que no tenga todos sus dígitos iguales)
2. Ordenar los dígitos de manera descendente (Mayor) y ascendente (Menor)
3. Restar: Mayor - Menor
4. Repetir el proceso con el resultado hasta llegar a `6174` o alcanzar un límite de iteraciones

## Detalles de Implementación

### 1. Estructuras de Datos
Se utilizó una Cola Dinámica para almacenar las 10 semillas generadas aleatoriamente antes de ser procesadas

### 2. Algoritmo de Ordenamiento (Bubble Sort)
Para ordenar los dígitos de cada número, se implementó el algoritmo de **Ordenamiento Burbuja (`BubbleSort`)** con las siguientes características:
* **Ordenamiento Ascendente y Descendente:** Métodos separados para obtener el número menor y mayor
* **Optimización "Corte Temprano":** Si en una pasada no se realizan intercambios, el algoritmo se detiene automáticamente, mejorando la eficiencia si los dígitos ya están ordenados
* **Inmutabilidad:** Se crearon métodos que devuelven una **copia nueva** del arreglo ordenado, manteniendo intacto el arreglo original de dígitos

### 3. Generación de Semillas
Para asegurar números válidos de 4 cifras, se utilizó la fórmula:
`1000 + random.nextInt(9000)`
Esto garantiza un rango exacto entre [1000, 9999]. Se incluye una validación para descartar números con dígitos idénticos (ej. 1111, 2222), ya que estos dan como resultado 0.

## Archivos del Proyecto

| Archivo | Descripción |
| :--- | :--- |
| `Kaprekar.java` | Clase principal. Contiene el `main`, la lógica de la Cola, el bucle matemático y la vista (impresión de la tabla). |
| `BubbleSort.java` | Clase de utilidad. Contiene la lógica de ordenamiento y los métodos para obtener copias ordenadas. |

## Cómo Ejecutar
1. Asegúrese de que ambos archivos estén en la misma carpeta/paquete `ed.u2.sorting`.
2. Compile y ejecute la clase `Kaprekar`.
3. El programa se ejecutará sin mostrar cálculos intermedios y presentará una tabla final.

## Ejemplo de Salida (Tabla Final)

Al finalizar la ejecución, el programa muestra un reporte como el siguiente:

=======================================================================
                         REPORTE FINAL DE RESULTADOS              
=======================================================================
| #   | S.Orig     | S.Final    | Resultado  | Iter | Estado          |
|-----|------------|------------|------------|------|-----------------|
| 1   | 8293       | 8532       | 6174       | 3    | LOGRADO         |
| 2   | 1234       | 4321       | 6174       | 3    | LOGRADO         |
| 3   | 8730       | 8730       | 6174       | 4    | LOGRADO         |
...
=======================================================================

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase;

/**
 *
 * @author mauag
 */
public class DatosDesordenados {
    
    
     private int[] valores; 
    private int limiteSuperior; 
    private int size; 

    public DatosDesordenados(int limite, int size) {
        this.valores = new int[size];
        this.limiteSuperior = limite;
        this.size = size;
    }
    
    public void agregarDato(int valor){
        valores[size]= valor;
        size++;
    }
    
    public int getDato(int posicion){
        return valores[posicion];
    }
    
    public void generarValores(){
        for (int i=0; i < valores.length; i++){
            double aleatorio = Math.random() * limiteSuperior;
            valores[i] = (int) aleatorio + 1;
        }
    }
    
    public int getSize(){
        return size; 
    }
    
    public int getCapacidad(){
        return valores.length;
    }
    
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    
    
    public int[] getValores(){
        return valores;
    } 
    
    public int[] getCopiaValores(){
        int [] copia = new int[size];
        System.arraycopy(valores, 0, copia, 0, size);
        return copia;
    }
    
    
   
public DatosOrdenados bubbleSort() {
        int[] arreglo = this.getCopiaValores();
        int n = arreglo.length;
        int cont = 0;
        int ci = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                cont++;
                if (arreglo[j] > arreglo[j + 1]) {
                    // intercambiar: swap
                    ci++;
                    int temporal = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temporal;
                }
            }
        }
        System.out.println("BS-comparaciones = " + cont);
        System.out.println("BS-intercambios = " + ci);
        return new DatosOrdenados(arreglo);
        
    }

    public DatosOrdenados QuickSort() {
        int[] arreglo = this.getCopiaValores();

        QuickSort1(arreglo, 0, arreglo.length - 1);

        return new DatosOrdenados(arreglo);
    }

    private void QuickSort1(int arreglo[], int izq, int der) {

        int pivote = arreglo[izq];
        int i = izq;
        int j = der;
        int aux;
        while (i < j) {
            while (arreglo[i] <= pivote && i < j) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
            }
        }
        arreglo[izq] = arreglo[j];
        arreglo[j] = pivote;

        if (izq < j - 1) {
            QuickSort1(arreglo, izq, j - 1);
        }
        if (j + 1 < der) {
            QuickSort1(arreglo, j + 1, der);
        }
       
       

    }

    public DatosOrdenados ShellSort() {
        int[] S = this.getCopiaValores();
        int salto, aux, i;
        boolean cambio;

        for (salto = S.length / 2; salto != 0; salto /= 2) {
            cambio = true;

            while (cambio) { //mientras se intercambio algun elemento
                cambio = false;
                for (i = salto; i < S.length; i++) {
                    if (S[i - salto] > S[i]) {
                        aux = S[i];
                        S[i] = S[i - salto];
                        S[i - salto] = aux;
                        cambio = true;
                    }
                }
            }

        }
        return new DatosOrdenados(S);
    }

    public DatosOrdenados Radix() {
        int[] R = this.getCopiaValores();
        int[][] bucket = new int[10][R.length];
        int[] bucketOfElement = new int[10];
        int max = 0;
        // Encuentra el elemento más grande en la matriz
        for (int i = 0; i < R.length; i++) {
            if (R[i] > max) {
                max = R[i];
            }
        }
        // Calcula el número de bits del elemento más grande
        int maxLength = (max + "").length();
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            // Coloca los números en arr en los cubos correspondientes según sus unidades, decenas, centenas, etc.
            for (int i = 0; i < R.length; i++) {
                int digit = R[i] / n % 10;
                // Asignar el valor de arr [i] a la matriz bidimensional en el depósito
                bucket[digit][bucketOfElement[digit]] = R[i];
                bucketOfElement[digit]++;
            }
            int index = 0;
            // Leer los elementos en el depósito y reasignarlos a arr
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketOfElement[j]; k++) {
                    R[index] = bucket[j][k];
                    index++;
                }
                bucketOfElement[j] = 0;// Borrar el número de elementos en cada uno
            }
        }
        return new DatosOrdenados(R);
    }
}
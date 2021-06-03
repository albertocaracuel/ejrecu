/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizletras;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author alber
 */
public class MatrizLetras {

    private char matriz[][];
    //constructor
    public MatrizLetras() {
        this.matriz = new char[10][10];
        llenarAleatoriamente();
    }
    //metodo en el que hago u  for dentro de otro y voy rellenando la matriz
    //con la letra aleatoria que salga
    private void llenarAleatoriamente() {
        Random random = new Random();

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matriz[x][y] = (char) (random.nextInt(26) + 'A');
            }
        }
    }
    //metodo en el que recorro la matriz y voy mostrando
    //na mas empezar la fila pongo una barra y al finalizar pongo otra
    //entre columna hago una tabulacion
    //pero si es la ultima columna no la hago
    public void imprimir() {
        for (int x = 0; x < matriz.length; x++) {
            System.out.print("|");
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                if (y != matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
    //recorro la matriz 
    //y cojo cada fila y la ordeno
    public void ordenar(){
         for(char[] i: matriz){
        Arrays.sort(i);
    }
    }
    //metodo que ordena toda los valores de la matriz
    //sin respetar el orden de cada fila
//    public void ordenarMatrizEntera() {
//        char fila[] = new char[10 * 10];
//        String matrizClonada[][] = new String[matriz.length][matriz.length];
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz.length; j++) {
//
//                 fila[i * 10 + j] = (matriz[i][j]);
//            }
//        }
//
//        Arrays.sort(fila); // Se ordena el arreglo unidimensional
//
//        for (int i = 0; i < matriz.length; i++) // Se copia el array ordenado en la matriz
//        {
//            for (int j = 0; j < matriz.length; j++) {
//                matriz[i][j] = fila[i * 10 + j];
//            }
//        }
//
//        for (int x = 0; x < matrizClonada.length; x++) {
//            System.out.print("|");
//            for (int y = 0; y < matrizClonada[x].length; y++) {
//                System.out.print(matrizClonada[x][y]);
//                if (y != matrizClonada[x].length - 1) {
//                    System.out.print("\t");
//                }
//            }
//            System.out.println("|");
//        }
//
//    }
    //metodo en el que introduzco una letra
    //la convierto en mayuscula siempre
    //y a continuacion recorro la matriz para ver si en la posicion existe una letra
    //y si existe se suma 1 al contador
    //y te devuelve el numero
    public int contarCaracter(char X) {
        int contador = 0;

        String cadena = Character.toString(X);
        String mayus = cadena.toUpperCase();
        char letra = mayus.charAt(0);
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                if (matriz[x][y] == letra) {
                    contador++;
                }
            }
        }

        return contador;
    }
    //geter y seter
    public char[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(char[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public String toString() {
        return "MatrizLetras{" + "matriz=" + matriz + '}';
    }

}

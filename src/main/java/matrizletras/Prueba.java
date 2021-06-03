/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizletras;

/**
 *
 * @author alber
 */
public class Prueba {
    public static void main(String[] args) {
        MatrizLetras matriz = new MatrizLetras();
        //mostrar la matriz creada
        matriz.imprimir();
        System.out.println("----------------");
        //contar caracteres
        System.out.println(matriz.contarCaracter('f'));
        System.out.println("----------------------");
        //ordenar las filas y mostrarlo
        matriz.ordenar();
        matriz.imprimir();
        
    }
}

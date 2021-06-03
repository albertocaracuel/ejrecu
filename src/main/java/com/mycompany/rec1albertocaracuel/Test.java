/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rec1albertocaracuel;

/**
 *
 * @author alber
 */
public class Test {
    public static void main(String[] args) {
        ListaEnteros lista= new ListaEnteros();
        //bucle para que te pida el numero las 15 veces
        int contador=0;
        do{
            lista.insertarElemento(lista.leerEntero());
            contador++;
        }while(contador!=15);
        
        //mostrar la lista
        lista.mostrar();
        System.out.println("----------------------------");
        //insertar elemento en la posision 4
        lista.insertarElemento(24, 4);
        //mostrar la lista
        lista.mostrar();
        //obtener elemento de la posicion 2
        System.out.println("El elemento es:" + lista.obtenerElemento(2));
        //buscar el elemento 98
        System.out.println(lista.buscarElemento(98));
        //mustra de la suma de impares y los pares
        lista.mostrarSumaImpares();
        lista.mostrarSumaPares();
        //mostrar mayor y menor
        System.out.println("El numero mayor es: " + lista.getMayor());
        System.out.println("El numero menor es: " + lista.getMenor());
        //borrar elemento que ocupe la posicion 12
        lista.borrarElemento(12);
        //mostrar lista
        lista.mostrar();
    }
}

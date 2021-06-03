/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rec1albertocaracuel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author alber
 */
public class ListaEnteros {

    private ArrayList<Integer> lista;

    public ListaEnteros() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }

    public boolean insertarElemento(Integer i) {
        boolean correcto = false;
        if (i > 9 && i < 101) {
            lista.add(i);
            correcto = true;
        } else {
            correcto = false;
        }

        return correcto;
    }

    public boolean insertarElemento(Integer i, int pos) {
        boolean correcto = false;
        try{
        if (i > 9 && i < 101) {
            lista.add(pos, i);
            correcto = true;
        } else {
            correcto = false;
        }
        }catch(Exception o){
            correcto=false;
            
        }
        return correcto;
    }
    //metodo que cambia el elemento por otro
    public boolean cambiarElemento(Integer i, int pos) {
        boolean correcto = false;
        try{
        if (i > 9 && i < 101) {
            lista.add(pos, i);
            correcto = true;
        } else {
            correcto = false;
        }
        }catch(Exception o){
            correcto=false;
            
        }
        return correcto;
    }

    //metodo que introduciendo la posicion te devuelve el valor o nul si no existe
    public Integer obtenerElemento(int pos) {
        Integer valor = 0;

        try {
            return valor = lista.get(pos);
        } catch (Exception o) {
            
            valor=null;
        }
        return valor;

    }

    public int buscarElemento(Integer i) {
        
        int indice = lista.indexOf(i);
        try{
        if (indice != -1) {
            indice = lista.indexOf(i);
        } else {
            indice = -1;
        }
        }catch(Exception o){
            indice=-1;
            
        }
        return indice;
    }

    //metodo que llama a un sout y te devuelve el numero
    public Integer leerEntero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero que desea introducir entre 10 y 100");
        Integer numero = sc.nextInt();

        return numero;
    }

    //mostrar la lista
    public void mostrar() {

        System.out.println(lista);

    }
    //metodo que recorre la lista y si son pares las guarda en otra lista
    //y a continucacion sumo los valores de esa lista

    public void mostrarSumaPares() {
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (Integer o : lista) {

            if ((o % 2) == 0) {
                listaPares.add(o);
            }

        }

        int suma = 0;
        for (Integer i : listaPares) {
            suma += i;
        }

        System.out.println("La suma de los numeros pares es " + suma);
    }

    //metodo que recorre la lista y si son impares las guarda en otra lista
    //y a continucacion sumo los valores de esa lista
    public void mostrarSumaImpares() {
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (Integer o : lista) {

            if ((o % 2) != 0) {
                listaImpares.add(o);
            }

        }

        int suma = 0;
        for (Integer i : listaImpares) {
            suma += i;
        }

        System.out.println("La suma de los numeros impares es " + suma);
    }

    //metodo que utilizando un collections devuelve el mayor
    public int getMayor() {
        int mayor;

        mayor = Collections.max(lista);

        return mayor;
    }

    //metodo que utilizando un collections devuelve el menor
    public int getMenor() {
        int menor;

        menor = Collections.min(lista);

        return menor;
    }

    //metodo que devuelve la longitud
    public int getLongitud() {
        int longitud;
        longitud = lista.size();

        return longitud;
    }
    //metodo que verifica si esa posicionexiste con un if
    //despues llama al remove
    //y con un iterator reajusto la lista

    public boolean borrarElemento(int pos) {
        boolean correcto = false;
        if (lista.get(pos) != null) {
            lista.remove(pos);
            Iterator it = lista.iterator();
            while (it.hasNext()) {
                it.next();
            }
            correcto = true;
        } else {
            correcto = false;
        }
        return correcto;
    }
}

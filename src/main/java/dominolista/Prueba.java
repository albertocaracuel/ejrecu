/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominolista;

import java.util.Arrays;

/**
 *
 * @author alber
 */
public class Prueba {
    public static void main(String[] args) {
        //crear objeto
        Domino prueba = new Domino();
        prueba.getLista().forEach(System.out::println);
        //sacarFicha
        System.out.println("-------------");
        System.out.println(prueba.sacarFicha());
        //meter ficha
        System.out.println("----------------");
        prueba.meterFicha(new FichaDomino(1,0));
        prueba.getLista().forEach(System.out::println);
        //mezclar fichas
        System.out.println("-----------------");
        prueba.mezclarFichas();
        //repartir fichas
        System.out.println("-------------------");
        System.out.println(Arrays.toString(prueba.repartir(11)));
    }
}

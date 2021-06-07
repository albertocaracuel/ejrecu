/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author alberto
 */
public class Prueba {

    public static void main(String[] args) {
        //creo el objeto
        ListaProfesores listaMaestros = new ListaProfesores();
        //creo la lista
        ArrayList<Profesor> lista = new ArrayList<>();
        //añado los cinco elementos de cada
        lista.add(new ProfesorTitular(LocalDate.of(2010, Month.MARCH, 4), "3243", "", "123341", "", 32));
        lista.add(new ProfesorTitular(LocalDate.of(2000, Month.MARCH, 12), "2553", "", "127541", "", 32));
        lista.add(new ProfesorTitular(LocalDate.of(2000, Month.APRIL, 5), "3145", "", "643341", "", 32));
        lista.add(new ProfesorTitular(LocalDate.of(2000, Month.DECEMBER, 1), "7543", "", "127531", "", 32));
        lista.add(new ProfesorTitular(LocalDate.of(2000, Month.SEPTEMBER, 22), "4322", "", "174221", "", 32));

        lista.add(new ProfesorInterino(LocalDate.of(2000, Month.MARCH, 2), LocalDate.of(2020, Month.OCTOBER, 2), "1345", "", "754333", "", 12));
        lista.add(new ProfesorInterino(LocalDate.of(2010, Month.MARCH, 23), LocalDate.of(2020, Month.JULY, 2), "5321", "", "555341", "", 12));
        lista.add(new ProfesorInterino(LocalDate.of(2000, Month.MAY, 12), LocalDate.of(2020, Month.SEPTEMBER, 2), "3574", "", "166341", "", 12));
        lista.add(new ProfesorInterino(LocalDate.of(2004, Month.JULY, 6), LocalDate.of(2020, Month.MAY, 2), "9865", "", "", "123987", 12));
        lista.add(new ProfesorInterino(LocalDate.of(2000, Month.DECEMBER, 30), LocalDate.of(2020, Month.MARCH, 2), "2356", "", "153541", "", 12));

        //añadir lista a contructor
        listaMaestros.setListaProfesores(lista);
        //ordenar por dni
        listaMaestros.getListaProfesores().sort((o1, o2) -> o1.getDNI().compareTo(o2.getDNI()));
        //imprimir la lista
        listaMaestros.imprimir();
        System.out.println("---------------------------------");

        //calcular el importe total y mostrarlo
        double resultado = listaMaestros.calcularImporteLista(15000);
        //lo muestro
        System.out.println("La suma de todos los sueldos es: " + resultado);
        System.out.println("------------------nuevo-----------");
        //recorrer la lista y llamar al metodo que te calcula el tiempo
        listaMaestros.calcularTiempoTrabajando();
        
        ArrayList <ProfesorTitular> listaProfesoresTitulares = new ArrayList<>();
        for(Profesor o: listaMaestros.getListaProfesores()){
            if(o instanceof ProfesorTitular){
                listaProfesoresTitulares.add(((ProfesorTitular)o));
            }
        }
        //ordenar lista por fecha de toma de posesion e imprimirla
        Collections.sort(listaProfesoresTitulares);
        listaProfesoresTitulares.forEach(System.out::println);
        

    }
}

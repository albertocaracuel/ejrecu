/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominolista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author alber
 */
public class Domino {

    private Random random = new Random();
    private ArrayList<FichaDomino> lista;
//constructor

    public Domino() {
        this.lista = new ArrayList<>();
        rellenarTodaLaLista();

    }

    @Override
    public String toString() {
        return "Domino{" + "lista=" + lista + '}';
    }

    //metodo que añade la fichas a la lista
    private void rellenarTodaLaLista() {

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!purgarLista(i, j)) {
                    lista.add(new FichaDomino(i, j));
                }

            }
        }
        //purgarLista();
    }

    //metodo que mira si la ficha que se va a introducir existe
    //y si existe no lo añade
    private boolean purgarLista(int i, int j) {
        boolean existe = false;
        for (FichaDomino o : lista) {
            if (!existe) {
                existe = i == o.getValorB() && j == o.getValorA();
            }
        }
        return existe;
    }
////metodo que borraria la igual pero diferente ejemplo :[1|3] [3|1]
//    //lo que pasa que no lo hace porque la condicion no me funciona
//    private void purgarLista() {
//         
//        ArrayList<FichaDomino> listaCopia = new ArrayList<>();
//        
//        for (FichaDomino o : listaCopia) {
//            
//            for (FichaDomino f : lista) {
//
//               if (o.getValorA() == f.getValorB() && f.getValorA() == o.getValorB()) {
//
//                    listaCopia.add(o);
//
//                }
//
//            }
//        }
//
//        //listaCopia.forEach(System.out::println);
//        for (FichaDomino e : listaCopia) {
//            if (lista.contains(e)) {
//                lista.remove(e);
//
//            }
//        }
//      
//    }
    //metodo que hace un random cogiendo el intervalo del tamaño del array coje 
    //coge el elemento que este en esa posicion mira si existe 
    //y si existe lo borra y lo muestro

    public FichaDomino sacarFicha() {
        int enteroAleatorio = random.nextInt(lista.size());
        //FichaDomino entrada = new FichaDomino();
        FichaDomino salida = new FichaDomino();

        try {
            salida = lista.get(enteroAleatorio);
            //salida=entrada;
            if (lista.contains(salida)) {
                lista.remove(salida);
                return salida;
            }
        } catch (Exception o) {
            salida = null;
        }

        return salida;
    }

    //metodo que mira si la ficha existe y si no existe la añade
    public void meterFicha(FichaDomino f) {

        boolean existe = lista.contains(f);
        if (!existe) {
            lista.add(f);
        }

    }

    public void mezclarFichas() {
        Collections.shuffle(lista);
    }

    //metodo que pone como limite al dowhile el numero de fichas que quieres sacar
    //hace un random del tamaño del array
    //obtengo la ficha que este en la posicion y la añado a la lista
    public FichaDomino[] repartir(int numeroFichas) {
        FichaDomino listaRepartida[] = new FichaDomino[numeroFichas];
        int contador = 0;
        do {
            int indice = random.nextInt(lista.size());
            FichaDomino nueva= lista.get(indice);
            listaRepartida[contador] = nueva;
            contador++;
        } while (contador != numeroFichas);

        return listaRepartida;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public ArrayList<FichaDomino> getLista() {
        return lista;
    }

    public void setLista(ArrayList<FichaDomino> lista) {
        this.lista = lista;
    }
}

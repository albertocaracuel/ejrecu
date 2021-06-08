/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.io.IOException;

/**
 *
 * @author alberto
 */
public class Prueba {
    
    
    public static void main(String[] args) throws IOException {
        ServicioFicheros tarea =new ServicioFicheros();
        
        tarea.leerCSV("RegActForCep.csv");
        
        tarea.mostrarListaOrdenada();
        
        tarea.escribirFicheroTXT("./CursosAcabados.txt");
        
        tarea.leerTXT("./CursosAcabados.txt");
        
        tarea.escribirJSON("Cursos.json");
        
        tarea.leerJSON("Cursos.json");
    }
}

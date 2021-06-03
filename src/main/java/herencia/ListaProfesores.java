/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class ListaProfesores {
    private ArrayList<Profesor> listaProfesores;

    public ListaProfesores() {
        this.listaProfesores = new ArrayList<>();
    }

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    @Override
    public String toString() {
        return "ListaProfesores{" + "listaProfesores=" + listaProfesores + '}';
    }
    
    public double calcularImporteLista(double sueldoBase){
        
        double importe = 0;
        for(Profesor o: listaProfesores){
            importe+=o.importeNomina(sueldoBase);
        }
        
        return importe;
    }
    
    public void calcularTiempoTrabajando(){
        int tiempo=0;
        for(Profesor o: listaProfesores){
            if(o instanceof ProfesorTitular){
                LocalDate inicio= ((ProfesorTitular)o).getTomaPosesion();
                tiempo= (int) DAYS.between(inicio,LocalDate.now());
                System.out.println("El tiempo que ha trabajado " + o.getIdProfesor() + " es de " + tiempo);
            }
        }
       
    }
    
    public void imprimir(){
       getListaProfesores().forEach(System.out::println);
    }
    
}

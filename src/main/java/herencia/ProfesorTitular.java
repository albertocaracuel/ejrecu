/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.time.LocalDate;

/**
 *
 * @author alberto
 */
public class ProfesorTitular extends Profesor implements Comparable<ProfesorTitular>{
    private LocalDate tomaPosesion;

    public ProfesorTitular(LocalDate tomaPosesion, String idProfesor, String nombre, String DNI, String nacionalidad, int edad) {
        super(idProfesor, nombre, DNI, nacionalidad, edad);
        this.tomaPosesion = tomaPosesion;
    }

   
    public LocalDate getTomaPosesion() {
        return tomaPosesion;
    }

    public void setTomaPosesion(LocalDate tomaPosesion) {
        this.tomaPosesion = tomaPosesion;
    }

    @Override
    public String toString() {
        String atributoSuperClase;
        //igualo el string al toString de la clase Profesor
        atributoSuperClase = super.toString();
        //Concateno los atributos de la superclase con la subclase
        return atributoSuperClase + "tomaPosesion=" + tomaPosesion + '}';
    }
   
    @Override
    public int compareTo(ProfesorTitular o) {
        return this.tomaPosesion.compareTo(o.tomaPosesion);
    }
    @Override
     public double importeNomina(double sueldoBase){
        double sueldo=(sueldoBase*0.3)+sueldoBase;
        return sueldo;
    }
    
     
}

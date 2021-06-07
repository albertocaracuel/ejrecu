/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author alberto
 */
public abstract class Profesor extends Persona {
    private String idProfesor;

    public Profesor(String idProfesor, String nombre, String DNI, String nacionalidad, int edad) {
        super(nombre, DNI, nacionalidad, edad);
        this.idProfesor = idProfesor;
    }

   
    
    public double importeNomina(double sueldoBase){
        double sueldo=sueldoBase;
        return sueldo;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Override
    public String toString() {
         String atributoSuperClase;
        //igualo el string al toString de la clase Profesor
        atributoSuperClase = super.toString();
        return   atributoSuperClase + "idProfesor=" + idProfesor + '}';
    }
    
    
}

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
public class ProfesorInterino extends Profesor implements Comparable<ProfesorInterino> {

    private LocalDate fechaInicioInterinidad;
    private LocalDate fechaFinInterinidad;

    public ProfesorInterino(LocalDate fechaInicioInterinidad, LocalDate fechaFinInterinidad, String idProfesor, String nombre, String DNI, String nacionalidad, int edad) {
        super(idProfesor, nombre, DNI, nacionalidad, edad);
        this.fechaInicioInterinidad = fechaInicioInterinidad;
        this.fechaFinInterinidad = fechaFinInterinidad;
    }

    

   

    public LocalDate getFechaInicioInterinidad() {
        return fechaInicioInterinidad;
    }

    public void setFechaInicioInterinidad(LocalDate fechaInicioInterinidad) {
        this.fechaInicioInterinidad = fechaInicioInterinidad;
    }

    public LocalDate getFechaFinInterinidad() {
        return fechaFinInterinidad;
    }

    public void setFechaFinInterinidad(LocalDate fechaFinInterinidad) {
        this.fechaFinInterinidad = fechaFinInterinidad;
    }

    
     @Override
    public int compareTo(ProfesorInterino o) {
        return this.fechaInicioInterinidad.compareTo(o.fechaInicioInterinidad);
    }
    
    @Override
     public double importeNomina(double sueldoBase){
        double sueldo=(sueldoBase*0.15)+sueldoBase;
        return sueldo;
    }

    @Override
    public String toString() {
        return "ProfesorInterino{" + "fechaInicioInterinidad=" + fechaInicioInterinidad + ", fechaFinInterinidad=" + fechaFinInterinidad + '}';
    }
     
   
}

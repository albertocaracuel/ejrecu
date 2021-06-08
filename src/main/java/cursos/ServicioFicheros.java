/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author alberto
 */
public class ServicioFicheros {

    private ArrayList<ObjetoFichero> lista = new ArrayList<>();
    private ArrayList<ObjetoFichero> listaJSON = new ArrayList<>();
    

    public ServicioFicheros() {
    }

    public void leerCSV(String url) {

        String idFichero = url;

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");

                LocalDate localDate1 = LocalDate.parse(tokens[5].replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate localDate2 = LocalDate.parse(tokens[6].replaceAll("\"", ""), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                ObjetoFichero nuevo = new ObjetoFichero();
                nuevo.setEstado(tokens[4]);
                nuevo.setCentro(tokens[0]);
                nuevo.setCodigo(tokens[1]);
                nuevo.setDirigido(tokens[7]);
                nuevo.setFechaInicio(localDate1);
                nuevo.setFechafin(localDate2);
                nuevo.setModalidad(tokens[3]);
                nuevo.setTitulo(tokens[2]);

                lista.add(nuevo);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void mostrarListaOrdenada() {
        Collections.sort(lista);

        for(ObjetoFichero o : lista){
            System.out.println(o.toString());
        }
    }
    
    
    public void escribirFicheroTXT(String idFichero){
        
       
        LocalDate fecha =  LocalDate.parse("01/04/2020", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (ObjetoFichero o : lista){
                
                if(o.getFechafin().isBefore(fecha)){
                    flujo.write(o.getTitulo() + "\t" + String.valueOf(o.getFechafin()));
                }
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void leerTXT(String url){
        // Fichero a leer con datos de ejemplo
        

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + url);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(url), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split("\t");
               
               
                for (String string : tokens) {
                    
                    System.out.print(string + "\t");
                }
                
                 ObjetoFichero nuevo= new ObjetoFichero();
                nuevo.setTitulo(tokens[0]);
                nuevo.setFechafin(LocalDate.parse(tokens[1]));
                listaJSON.add(nuevo);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void escribirJSON(String idFichero) throws IOException{
         ObjectMapper mapeador = new ObjectMapper();
        
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idFichero), listaJSON);
    }
    
    
    public void leerJSON(String url) throws IOException{
         ObjectMapper mapeador = new ObjectMapper();
        mapeador.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        listaJSON = mapeador.readValue(new File(url),
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, ObjetoFichero.class));
    }
    
}

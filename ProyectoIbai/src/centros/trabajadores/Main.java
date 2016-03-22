package centros.trabajadores;

import Vista.*;
import Modelo.UML.*;
import Modelo.BD.*;
import Excepciones.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {

    private static VistaCentro vl;
    private static VistaTrabajador vt;
    private static Centro c;
    private static Trabajador t;
    private static ArrayList <Integer> listaIdCentros;
    private static ArrayList <String> listaDNITrabajadores;
    
    
    public static void main(String[] args){
        /*vl = new VistaCentro();
        rellenaCentros();
        vl.setVisible(true);
        vl.setVisible(true); */   
        mostrarPerfiles();
    }   
    
    public static void rellenaCentros(){
        try{
            listaIdCentros = CentroBD.getIdCentros();
            vl.setCentros(listaIdCentros.toArray());
        }
        catch(Exception e){
            System.out.println("Problemas al realizar query: "+e);
        }
    }
        
    public static void selectCentro(int index){
        vl.dispose();
        try{
            listaDNITrabajadores =TrabajadorBD.getTrabajadoresCentro(c.getIdCentro());
        }
        catch(Exception e){
            System.out.println("Problemas al realizar query: "+e);
        }
        mostrarPerfiles();
    }
    
    public static void mostrarPerfiles(){
        vt = new VistaTrabajador();
        java.sql.Date d = vt.getReady();
        if (d == null) {
            System.out.println("No date specified!");
        } else {
            java.sql.Date sqldate = new java.sql.Date(d.getTime());
            // Do something with sqldate
        }
    }
    
    public static String getCentro(int index){
        c = CentroBD.getCentro(listaIdCentros.get(index));
        return c.getNombreCen();
    }
    
    public static void acabar(){
        System.exit(0);
    }
    
    
}

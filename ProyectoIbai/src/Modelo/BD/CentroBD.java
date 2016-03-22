package Modelo.BD;

import Modelo.UML.Centro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CentroBD {
    public static ArrayList getIdCentros(){
        Connection conn = GenericoBD.startConn();
        ArrayList<Integer> tCentros = new ArrayList();
        try{
            try (Statement stmt = conn.createStatement()) {
                ResultSet rset = stmt.executeQuery("select idCentro from CENTRO");
                if(rset != null){
                    while (rset.next()){
                        tCentros.add(rset.getInt(1));
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Problemas al realizar query: "+e);
        }
        if(!GenericoBD.dropConn(conn)){
            System.out.println("Problemas al cerrar");
        }
        return tCentros;
    }
    
    public static Centro getCentro(int idCentro){
        Connection conn = GenericoBD.startConn();
        Centro c = null;
        try{
            try (Statement stmt = conn.createStatement()) {
                ResultSet rset = stmt.executeQuery("select idCentro, nombre, telefono, calle, numero, CP, ciudad, provincia from CENTRO where idCentro = "+idCentro);
                if(rset != null){
                    while (rset.next()){
                        c = new Centro(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Problemas al realizar query: "+e);
        }
        if(!GenericoBD.dropConn(conn)){
            System.out.println("Problemas al cerrar");
        }
        return c;
    }
}

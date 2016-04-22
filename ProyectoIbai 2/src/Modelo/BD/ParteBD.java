/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import java.sql.Connection;

/**
 *
 * @author andrés
 */
public class ParteBD {
    
public static ArrayList<Integer> rellenarTrabLog(int centro){
    ArrayList<Integer> nombresTrab = new ArrayList();   
    try{
        Connection conn = GenericoBD.startConn();
        CallableStatement cs = conn.prepareCall("{call PAC_TRABAJADOR.get_tipos_centro(?,?,?)}");
        cs.setInt(1, centro);
        cs.setString(2, "Logistica");
        cs.registerOutParameter(3, OracleTypes.CURSOR);
        cs.execute();
        ResultSet rs = (ResultSet) cs.getObject(3);
            while(rs.next()){
                nombresTrab.add(rs.getInt("idTrabajador"));
            }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"Problemas al realizar query: "+e);
    }
    return nombresTrab;
}
    
    
    
    
    
    
    
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modelo.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Persona;

/**
 *
 * @author Kelvin
 */
public class TestConexion {

    public static void main(String[] args) {
        String sql = "SELECT * FROM PERSONA";
        Connection cnn = null;
        ResultSet rs = null ;
        
        cnn = ConexionBDD.getConexion();
        try {
            rs = cnn.prepareStatement(sql).executeQuery();
            while(rs.next()){
                Persona persona = new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                System.out.println(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConexionBDD.cerrar(rs);
        }
    }
    
}

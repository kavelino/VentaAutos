/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Katiuska Marin Suarez
 * @author Darwin Guaman Pacalla
 * @author Kleber Avelino Mosquera
 */
public class Conexion {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBMS = "mysql";
    private static final String HOST = "us-cdbr-azure-southcentral-f.cloudapp.net";
    //private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "ventacarros";
    private static final String USER = "b4a1cb7ad2f685";
    private static final String PASSWORD = "b2d7ff0b";

    public static Connection conectar ()throws Exception{
     try {
         Class.forName(DRIVER);
     }catch(ClassNotFoundException ce){
         System.out.println("error en el driver: " +ce);
     }  

     try{
         System.out.println("Conectando a la base de datos");
         return DriverManager.getConnection("jdbc:" + DBMS + "://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);                
     }catch(SQLException exception){
         System.out.println("ERROR: NO SE PUDO CONECTAR CON LA BASE DE DATOS: "+exception);
         return null;
     }         
    }
}

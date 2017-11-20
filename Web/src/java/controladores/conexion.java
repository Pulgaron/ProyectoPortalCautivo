package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Esta es una clase java
public class conexion {
    private String USERNAME = "root"; //Usuario default para conexion a BD
    private String PASSWORD = "pekachu15"; // Contraseña a la conexion en MySQL
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "Veterinaria_computo";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?autoReconnect=true&useSSL=false";
    private Connection con;
    
    public conexion(){
        try{
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch(ClassNotFoundException e){
            System.err.println("ERROR"+e);
        } catch(SQLException e){
            System.err.println("ERROR"+e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    public static void main(String args[]){
        conexion con = new conexion();
    }
}
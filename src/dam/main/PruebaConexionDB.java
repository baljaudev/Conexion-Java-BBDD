package dam.main;

import dam.db.AccesoDB;

import java.sql.Connection;

public class PruebaConexionDB {
    public static void main(String[] args) {
        AccesoDB accesoDB = new AccesoDB(); // Crea una instancia de la clase AccesoDB
        Connection conexion = accesoDB.getConexion(); // Obtiene la conexión a la base de datos

        if (conexion != null) {
            System.out.println("Conexion establecida");
        }
    }

}

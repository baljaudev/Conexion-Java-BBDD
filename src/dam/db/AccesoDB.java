package dam.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
    private final String driver;
    private final String url;


    public AccesoDB(){
        driver = "org.sqlite.JDBC";
        url = "jdbc:sqlite:db/PruebaDB.db";
    }


    public Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            System.out.println("El driver indicado no es correcto");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("No es posible establecer la conexión con la base de datos");
            e.printStackTrace();
        }

        return conexion;
    }
}

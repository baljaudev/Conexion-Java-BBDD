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


    public Connection getConexion() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conexion = DriverManager.getConnection(url);

        return conexion;
    }
}

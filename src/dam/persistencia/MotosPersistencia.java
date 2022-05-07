package dam.persistencia;

import dam.db.AccesoDB;
import dam.model.Moto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MotosPersistencia {
    private final AccesoDB db;

    public MotosPersistencia() {
        db = new AccesoDB();
    }


    public ArrayList<Moto> selecccionarTodos() {
        ArrayList<Moto> listaMotos = new ArrayList<>();

        String query = "SELECT " + MotosContract.COLUMN_ID + ", " + MotosContract.COLUMN_MODELO + ", " + MotosContract.COLUMN_MARCA
                + " FROM " + MotosContract.NOMBRE_TABLA;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            con = db.getConexion();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            Moto moto;
            int idMoto;
            String modelo;
            String marca;

            while (rs.next()) {
                idMoto = rs.getInt(MotosContract.COLUMN_ID);
                modelo = rs.getString(MotosContract.COLUMN_MODELO);
                marca = rs.getString(MotosContract.COLUMN_MARCA);

                moto = new Moto(idMoto, modelo, marca);
                listaMotos.add(moto);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar el driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al acceder a la base de datos");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                } if (stmt != null) {
                    stmt.close();
                } if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaMotos;
    }
}

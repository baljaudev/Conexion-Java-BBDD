package dam.persistencia;

import dam.db.AccesoDB;
import dam.model.Moto;

import java.sql.*;
import java.util.ArrayList;

public class MotosPersistencia {
    private final AccesoDB db;

    public MotosPersistencia() {
        db = new AccesoDB();
    }


    public ArrayList<Moto> selecccionarTodos() {
        ArrayList<Moto> listaMotos = new ArrayList<>();

        String query = "SELECT " + MotosContract.COLUMN_ID + ", " + MotosContract.COLUMN_MODELO + ", " + MotosContract.COLUMN_MARCA + ", " + MotosContract.COLUMN_CC
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
            int cc;

            while (rs.next()) {
                idMoto = rs.getInt(MotosContract.COLUMN_ID);
                modelo = rs.getString(MotosContract.COLUMN_MODELO);
                marca = rs.getString(MotosContract.COLUMN_MARCA);
                cc = rs.getInt(MotosContract.COLUMN_CC);

                moto = new Moto(idMoto, modelo, marca, cc);
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

    public Moto seleccionarPorCilindrada(int cc) {
        Moto moto = null;

        String query = "SELECT " + MotosContract.COLUMN_ID + ", " + MotosContract.COLUMN_MODELO + ", " + MotosContract.COLUMN_MARCA + ", " + MotosContract.COLUMN_CC
                + " FROM " + MotosContract.NOMBRE_TABLA + " WHERE " + MotosContract.COLUMN_CC + " = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = db.getConexion();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cc);
            rs = pstmt.executeQuery();

            int idMoto;
            String modelo;
            String marca;

            if (rs.next()) {
                idMoto = rs.getInt(MotosContract.COLUMN_ID);
                modelo = rs.getString(MotosContract.COLUMN_MODELO);
                marca = rs.getString(MotosContract.COLUMN_MARCA);

                moto = new Moto(idMoto, modelo, marca, cc);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("El driver indicado no es correcto");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: error conexión, sentencia incorrecta");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                } if (pstmt != null) {
                    pstmt.close();
                } if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return moto;
    }
}

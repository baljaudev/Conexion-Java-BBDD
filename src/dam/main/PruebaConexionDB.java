package dam.main;

import dam.model.Moto;
import dam.persistencia.MotosPersistencia;

import java.util.ArrayList;

public class PruebaConexionDB {
    public static void main(String[] args) {
        MotosPersistencia ap = new MotosPersistencia();

        ArrayList<Moto> listaMotos = ap.selecccionarTodos();

        for (Moto moto : listaMotos) {
            System.out.println(moto);
        }
    }
}

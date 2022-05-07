package dam.main;

import dam.model.Moto;
import dam.persistencia.MotosPersistencia;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaConexionDB {
    public static void main(String[] args) {
        MotosPersistencia ap = new MotosPersistencia();

        ArrayList<Moto> listaMotos = ap.selecccionarTodos();

        for (Moto moto : listaMotos) {
            System.out.println(moto);
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la cilindrada:");
        int cilindrada = Integer.parseInt(sc.nextLine());
        Moto moto = ap.seleccionarPorCilindrada(cilindrada);

        if (moto != null) {

            for (Moto listaMoto : listaMotos) {
                if (listaMoto.getCilindrada() == cilindrada) {
                    System.out.println(listaMoto.getMarca() + " " + listaMoto.getModelo());
                }
            }
        } else {
            System.out.println("No hay ninguna moto con esa cilindrada");
        }


        sc.close();
    }
}

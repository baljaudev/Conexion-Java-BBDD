package dam.model;

public class Moto {
    private int idMoto;
    private String modelo;
    private String marca;

  public Moto( int idMoto, String modelo, String marca) {
    this.idMoto = idMoto;
    this.modelo = modelo;
    this.marca = marca;
  }

  public String toString() {
    return "Moto [idMoto=" + idMoto + ", modelo=" + modelo + ", marca=" + marca + "]";
  }

}

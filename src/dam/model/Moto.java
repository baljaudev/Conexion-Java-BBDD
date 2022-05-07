package dam.model;

public class Moto {
    private int idMoto;
    private String modelo;
    private String marca;
    private int cilindrada;
  public Moto( int idMoto, String modelo, String marca, int cilindrada) {
    this.idMoto = idMoto;
    this.modelo = modelo;
    this.marca = marca;
    this.cilindrada = cilindrada;
  }

  public String toString() {
    return "Moto [idMoto=" + idMoto + ", modelo=" + modelo + ", marca=" + marca + ", cilindrada=" + cilindrada + "]";
  }

    public int getIdMoto() {
        return idMoto;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}

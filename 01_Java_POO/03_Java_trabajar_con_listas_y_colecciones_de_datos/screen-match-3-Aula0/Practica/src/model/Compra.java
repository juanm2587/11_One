package model;

public class Compra implements Comparable<Compra>{
  private double valor;
  private String descripcion;

  public Compra(double valor, String descripcion) {
    this.valor = valor;
    this.descripcion = descripcion;
  }

  public double getValor() {
    return valor;
  }

  public String getDescripcion() {
    return descripcion;
  }

  @Override
  public String toString() {
    return "Compra: valor"+valor+
            ", descripcion= " + descripcion;
  }

    @Override
    public int compareTo(Compra otraCompra) {
    //aca hacemos un "Cast" a Double para poder hacer la comparacion de valor
      return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
    //TODO corregir error de compareTo, no ordena la lista por precio en el main
}

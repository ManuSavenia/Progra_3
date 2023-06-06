package Clases.Grafos.utils;
public class RutaMinima<T> {
  private ListaGenerica<T> ruta;
  private int boletos;
  private int peso;
  
  public RutaMinima() {
    ruta = new ListaGenericaEnlazada<T>();
    boletos = 0;
    peso = 0;
  }

  public RutaMinima(ListaGenerica<T> ruta, int boletos, int peso) {
    this.ruta = ruta;
    this.boletos = boletos;
    this.peso = peso;
  }

  public ListaGenerica<T> getRuta() {
    return ruta;
  }

  public void setRuta(ListaGenerica<T> ruta) {
    this.ruta = ruta;
  }

  public int getBoletos() {
    return boletos;
  }

  public void setBoletos(int boletos) {
    this.boletos = boletos;
  }

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public void agregar(T estacion) {
    ruta.agregarFinal(estacion);
  }

  public void agregarBoleto() {
    boletos++;
  }

  public void eliminarBoleto() {
    boletos--;
  }

  public void eliminar(int i) {
    ruta.eliminarEn(i);
  }

  public void agregarPeso(int peso) {
    this.peso += peso;
  }

  public void eliminarPeso(int peso) {
    this.peso -= peso;
  }

  public boolean getBoletoUnico() {
    return boletos == 1;
  }
}

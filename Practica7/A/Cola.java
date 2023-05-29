

public class Cola<T>{
  private ListaGenericaEnlazada<T> cola;

  public Cola() {
    cola = new ListaGenericaEnlazada<T>();
  }

  public void encolar(T dato) {
    cola.agregarFinal(dato);
  }

  public T desencolar() {
    T dato = cola.elemento(0);
    cola.eliminarEn(0);
    return dato;
  }

  public T tope() {
    return cola.elemento(0);
  }

  public boolean esVacia() {
    return cola.esVacia();
  }
}

package Clases.ListaGenerica.utils;
public class Cola<T> {
    private ListaGenericaEnlazada<T> lista;

    public Cola() {
        lista = new ListaGenericaEnlazada<T>();
    }

    public void encolar(T dato) {
        lista.agregarFinal(dato);
    }

    public T desencolar() {
        T dato = lista.elemento(0);
        lista.eliminarEn(0);
        return dato;
    }

    public T tope() {
        return lista.elemento(0);
    }

    public boolean esVacia() {
        return lista.esVacia();
    }
}
package Clases.ArbolBinario.utils;

import Clases.ArbolBinario.ArbolBinario;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Adivinanza {
    public Adivinanza() {
    }

    public ListaGenericaEnlazada<String> secuenciaConMasPreguntas(ArbolBinario<String> abinario) {
        if (abinario.esVacio()) {
            return null;
        }

        if (abinario.esHoja()) {
            ListaGenericaEnlazada<String> result = new ListaGenericaEnlazada<String>();
            result.agregarInicio(abinario.getDato());
            return result;
        }

        ListaGenericaEnlazada<String> izq = new ListaGenericaEnlazada<>();
        ListaGenericaEnlazada<String> der = new ListaGenericaEnlazada<>();

        if (abinario.tieneHijoIzquierdo())
            izq = secuenciaConMasPreguntas(abinario.getHijoIzquierdo());
        if (abinario.tieneHijoDerecho())
            der = secuenciaConMasPreguntas(abinario.getHijoDerecho());

        if (izq.tamanio() >= der.tamanio()) {
            izq.agregarInicio("SI");
            izq.agregarInicio(abinario.getDato());
            return izq;
        } else {
            izq.agregarInicio("NO");
            der.agregarInicio(abinario.getDato());
            return der;
        }
    }

    public static ListaGenericaEnlazada<ListaGenericaEnlazada<String>> secuenciaConMasPreguntas2(
      ArbolBinario<String> arbol) {
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> lista = new ListaGenericaEnlazada<>();
    if (arbol.esHoja()) {
      ListaGenericaEnlazada<String> aux = new ListaGenericaEnlazada<>();
      aux.agregarInicio(arbol.getDato());
      lista.agregarInicio(aux);
      System.out.println(arbol.getDato());
      return lista;
    }
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaIzq = new ListaGenericaEnlazada<>();
    ListaGenericaEnlazada<ListaGenericaEnlazada<String>> listaDer = new ListaGenericaEnlazada<>();

    if (arbol.tieneHijoIzquierdo()) {
      listaIzq = secuenciaConMasPreguntas2(arbol.getHijoIzquierdo());
      int i = 0;
      while (i < listaIzq.tamanio()) {
        listaIzq.elemento(i).agregarInicio(arbol.getDato());
        i++;
      }
    }

    if (arbol.tieneHijoDerecho()) {
      listaDer = secuenciaConMasPreguntas2(arbol.getHijoDerecho());
      int i = 0;
      while (i < listaDer.tamanio()) {
        listaDer.elemento(i).agregarInicio(arbol.getDato());
        i++;
      }
    }
    if (listaIzq.elemento(0) != null && listaDer.elemento(0) != null
        && listaIzq.elemento(0).tamanio() > listaDer.elemento(0).tamanio()) {
      return listaIzq;
    }
    if (listaDer.elemento(0) != null && listaIzq.elemento(0) != null
        && listaDer.elemento(0).tamanio() > listaIzq.elemento(0).tamanio()) {
      return listaDer;
    }
    for (int i = 0; i < listaIzq.tamanio(); i++) {
      lista.agregarFinal(listaIzq.elemento(i));
    }
    for (int i = 0; i < listaDer.tamanio(); i++) {
      lista.agregarFinal(listaDer.elemento(i));
    }

    return lista;
  }

}
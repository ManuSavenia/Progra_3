package Practica3.B.Ej2;

import Clases.ListaGenerica.ListaGenericaEnlazada;

public class MainEj2 {
    public static void main(String[] args) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
        ListaGenericaEnlazada<Integer> listaInvertida = new ListaGenericaEnlazada<Integer>();
        int cont = 0;
        lista.comenzar();
        listaInvertida.comenzar();
        lista.agregarFinal(78);
        lista.agregarFinal(98);
        lista.agregarFinal(99);
        lista.agregarFinal(34);
        lista.agregarFinal(521);
        System.out.println(lista.toString());
        listaInvertida = listaInvertida.invertir(lista, listaInvertida);
        System.out.println(listaInvertida.toString());
    }
}

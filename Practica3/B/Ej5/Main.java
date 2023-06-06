package Practica3.B.Ej5;

import Clases.ListaDeEnteros.ListaDeEnterosEnlazada;

public class Main {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista1 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada lista2 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada lista3 = new ListaDeEnterosEnlazada();

        lista1.comenzar();
        lista2.comenzar();
        lista3.comenzar();

        lista1.agregarFinal(1);
        lista1.agregarFinal(5);
        lista1.agregarFinal(6);
        lista1.agregarFinal(8);
        lista2.agregarFinal(2);
        lista2.agregarFinal(4);
        lista2.agregarFinal(7);
        lista2.agregarFinal(8);
        lista3 = lista1.combinarOrdenado(lista2);

        System.out.println(lista3.toString());
    }
}

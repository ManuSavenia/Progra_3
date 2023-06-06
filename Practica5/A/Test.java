package Practica5.A;

import Clases.ArbolGeneral.ArbolGeneral;

public class Test {
    public static void main(String[] args){
        ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(1);
        //hace un arbol random
        a.agregarHijo(new ArbolGeneral<Integer>(2));
        a.agregarHijo(new ArbolGeneral<Integer>(3));
        a.agregarHijo(new ArbolGeneral<Integer>(4));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Integer>(5));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(6));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Integer>(7));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(8));
        a.getHijos().elemento(1).getHijos().elemento(0).agregarHijo(new ArbolGeneral<Integer>(9));

        System.out.println("Altura del arbol: " + a.altura()); //3
        System.out.println("El arbol incluye el dato 2?: " + a.incluye(2));
        System.out.println("En que nivel se encuentra el dato 2?: " + a.nivel(2)); //2
        System.out.println("El ancho del arbol es: " + a.ancho()); //3
    }    
}
package Practica5.B;

import Clases.ArbolGeneral.ArbolGeneral;

public class Main {
    public static void main(String[] args) {
        ArbolGeneral<Empleado> a = new ArbolGeneral<Empleado>(new Empleado("Juan", 10, 1));
        a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Pedro", 5, 2)));
        a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Maria", 15, 2)));
        a.agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Jose", 20, 2)));
        a.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Ana", 10, 3)));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Luis", 5, 3)));
        a.getHijos().elemento(2).agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Marta", 15, 3)));
        a.getHijos().elemento(1).getHijos().elemento(0)
                .agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Pablo", 10, 4)));
        a.getHijos().elemento(1).getHijos().elemento(0)
                .agregarHijo(new ArbolGeneral<Empleado>(new Empleado("Sofia", 5, 4)));

        Empresa e = new Empresa(a);
        System.out.println(e.empleadosPorCategoria(2));
        System.out.println();
        System.out.println(e.categoriaConMasempleados());
        System.out.println();
        System.out.println(e.cantidadTotalDeEmpleados());
        System.out.println();
        e.imprimirporNivel();
        e.reemplazarPresidente2();
        System.out.println();
        System.out.println();
        e.imprimirporNivel();

        RedDeAguaPotable red = new RedDeAguaPotable();
        ArbolGeneral<Double> arbol = new ArbolGeneral<Double>(null);
        arbol.agregarHijo(new ArbolGeneral<Double>(null));
        arbol.agregarHijo(new ArbolGeneral<Double>(null));
        arbol.agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(0).agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(null));
        arbol.getHijos().elemento(1).agregarHijo(new ArbolGeneral<Double>(null));
        System.out.println();
        System.out.println();
        System.out.println(red.minimoCaudal(arbol, 4500.0));

        Tries trie = new Tries();
        trie.agregarPalabra("arbol");
        trie.agregarPalabra("araña");
        trie.agregarPalabra("arañita");
        trie.agregarPalabra("arar");
        trie.agregarPalabra("hola");
        trie.agregarPalabra("hoja");
        trie.agregarPalabra("homo");
        trie.imprimirporNivel();
        System.out.println();
        System.out.println(trie.palabrasQueEmpiezanCon("h"));

    }

}

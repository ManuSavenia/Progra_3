package Parciales;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.Grafos.utils.Costo;
import Clases.Grafos.utils.CostoTodosMinimos;
import Clases.Grafos.utils.Dijkstra;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Test2 {

    public static void main(String args[]) {
        Vertice<Datos2> sp = new VerticeImplListAdy<Datos2>(new Datos2("Suipacha", 3));
        Vertice<Datos2> ck = new VerticeImplListAdy<Datos2>(new Datos2("Carlos Keen", 5));
        Vertice<Datos2> m = new VerticeImplListAdy<Datos2>(new Datos2("Moreno", 4));
        Vertice<Datos2> q = new VerticeImplListAdy<Datos2>(new Datos2("Quilmes", 3));
        Vertice<Datos2> l = new VerticeImplListAdy<Datos2>(new Datos2("La Plata", 3));
        Vertice<Datos2> a = new VerticeImplListAdy<Datos2>(new Datos2("Abasto", 4));
        Vertice<Datos2> c = new VerticeImplListAdy<Datos2>(new Datos2("CaÃ±uelas", 2));
        Vertice<Datos2> n = new VerticeImplListAdy<Datos2>(new Datos2("Navarro", 1));
        Vertice<Datos2> sa = new VerticeImplListAdy<Datos2>(new Datos2("Saladillo", 2));
        Vertice<Datos2> lo = new VerticeImplListAdy<Datos2>(new Datos2("Lobos", 1));
        Vertice<Datos2> pi = new VerticeImplListAdy<Datos2>(new Datos2("Pinamar", 1));

        Grafo<Datos2> ciudades = new GrafoImplListAdy<Datos2>();

        ciudades.agregarVertice(sp);
        ciudades.agregarVertice(ck);
        ciudades.agregarVertice(m);
        ciudades.agregarVertice(q);
        ciudades.agregarVertice(l);
        ciudades.agregarVertice(a);
        ciudades.agregarVertice(c);
        ciudades.agregarVertice(n);
        ciudades.agregarVertice(sa);
        ciudades.agregarVertice(lo);
        ciudades.agregarVertice(pi);

        ciudades.conectar(sp, ck, 2);
        ciudades.conectar(ck, sp, 2);
        ciudades.conectar(sp, n, 1);
        ciudades.conectar(n, sp, 1);
        ciudades.conectar(ck, m, 2);
        ciudades.conectar(m, ck, 2);
        ciudades.conectar(m, q, 2);
        ciudades.conectar(q, m, 2);
        ciudades.conectar(q, l, 2);
        ciudades.conectar(l, q, 2);
        ciudades.conectar(l, a, 2);
        ciudades.conectar(a, l, 2);
        ciudades.conectar(a, m, 0);
        ciudades.conectar(m, a, 0);
        ciudades.conectar(a, c, 2);
        ciudades.conectar(c, a, 2);
        ciudades.conectar(c, n, 2);
        ciudades.conectar(n, c, 2);
        ciudades.conectar(n, sa, 2);
        ciudades.conectar(sa, n, 2);
        ciudades.conectar(n, lo, 0);
        ciudades.conectar(lo, n, 0);

        Parcial2 parcial = new Parcial2();
        System.out.println(parcial.resolver(ciudades, "Suipacha", "La Plata", 2));
    }

}

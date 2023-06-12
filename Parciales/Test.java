package Parciales;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.Grafos.utils.Costo;
import Clases.Grafos.utils.CostoTodosMinimos;
import Clases.Grafos.utils.Dijkstra;

public class Test {

    public static void main(String args[]) {
        Vertice<Datos> sp = new VerticeImplListAdy<Datos>(new Datos("Suipacha", 3));
        Vertice<Datos> ck = new VerticeImplListAdy<Datos>(new Datos("Carlos Keen", 2));
        Vertice<Datos> m = new VerticeImplListAdy<Datos>(new Datos("Moreno", 2));
        Vertice<Datos> q = new VerticeImplListAdy<Datos>(new Datos("Quilmes", 3));
        Vertice<Datos> l = new VerticeImplListAdy<Datos>(new Datos("La Plata", 1));
        Vertice<Datos> a = new VerticeImplListAdy<Datos>(new Datos("Abasto", 1));
        Vertice<Datos> c = new VerticeImplListAdy<Datos>(new Datos("CaÃ±uelas", 2));
        Vertice<Datos> n = new VerticeImplListAdy<Datos>(new Datos("Navarro", 1));
        Vertice<Datos> sa = new VerticeImplListAdy<Datos>(new Datos("Saladillo", 2));
        Vertice<Datos> lo = new VerticeImplListAdy<Datos>(new Datos("Lobos", 1));
        Vertice<Datos> pi = new VerticeImplListAdy<Datos>(new Datos("Pinamar", 1));

        Grafo<Datos> ciudades = new GrafoImplListAdy<Datos>();

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
        ciudades.conectar(a, m, 3);
        ciudades.conectar(m, a, 3);
        ciudades.conectar(a, c, 2);
        ciudades.conectar(c, a, 2);
        ciudades.conectar(c, n, 2);
        ciudades.conectar(n, c, 2);
        ciudades.conectar(n, sa, 2);
        ciudades.conectar(sa, n, 2);
        ciudades.conectar(n, lo, 4);
        ciudades.conectar(lo, n, 4);

        Parcial1 parcial = new Parcial1();
        System.out.println(parcial.resolver(ciudades, "Suipacha", "La Plata", 2));
    }

}
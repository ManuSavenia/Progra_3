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
public class Test4 {

  public static void main(String args[]) {
    Vertice<Datos2> sp = new VerticeImplListAdy<Datos2>(new Datos2("Suipacha", 3));
    Vertice<Datos2> ck = new VerticeImplListAdy<Datos2>(new Datos2("Carlos Keen", 5));
    Vertice<Datos2> m = new VerticeImplListAdy<Datos2>(new Datos2("Moreno", 4));
    Vertice<Datos2> q = new VerticeImplListAdy<Datos2>(new Datos2("Quilmes", 3));
    Vertice<Datos2> l = new VerticeImplListAdy<Datos2>(new Datos2("La Plata", 3));
    Vertice<Datos2> a = new VerticeImplListAdy<Datos2>(new Datos2("Abasto", 4));
    Vertice<Datos2> c = new VerticeImplListAdy<Datos2>(new Datos2("Ca単uelas", 2));
    Vertice<Datos2> n = new VerticeImplListAdy<Datos2>(new Datos2("Navarro", 2));
    Vertice<Datos2> sa = new VerticeImplListAdy<Datos2>(new Datos2("Saladillo", 2));
    Vertice<Datos2> lo = new VerticeImplListAdy<Datos2>(new Datos2("Lobos", 1));
    Vertice<Datos2> pi = new VerticeImplListAdy<Datos2>(new Datos2("Pinamar", 1));
    Vertice<Datos2> al = new VerticeImplListAdy<Datos2>(new Datos2("Altamirano", 1));


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
    ciudades.agregarVertice(al);

    ciudades.conectar(sp, ck, 2); // Suipacha - Carlos Keen
    ciudades.conectar(ck, sp, 2);

    ciudades.conectar(sp, n, 2); // Suipacha - Navarro
    ciudades.conectar(n, sp, 2);

    ciudades.conectar(ck, m, 2); // Carlos Keen - Moreno
    ciudades.conectar(m, ck, 2);

    ciudades.conectar(m, q, 2); // Moreno - Quilmes
    ciudades.conectar(q, m, 2);

    ciudades.conectar(q, l, 2); // Quilmes - La Plata
    ciudades.conectar(l, q, 2);

    ciudades.conectar(l, a, 0); // La Plata - Abasto
    ciudades.conectar(a, l, 0);

    ciudades.conectar(a, m, 2); // Abasto - Moreno
    ciudades.conectar(m, a, 2);

    ciudades.conectar(al, l, 1); // Altamirano - La Plata
    ciudades.conectar(l, al, 1);

    ciudades.conectar(al, c, 1); // Altamirano - Ca単uelas
    ciudades.conectar(c, al, 1);

    ciudades.conectar(c, n, 2); // Ca単uelas - Navarro
    ciudades.conectar(n, c, 2);

    ciudades.conectar(n, sa, 2); // Navarro - Saladillo
    ciudades.conectar(sa, n, 2);

    ciudades.conectar(n, lo, 0); // Navarro - Lobos
    ciudades.conectar(lo, n, 0);

    ciudades.conectar(l, c, 2); // La Plata - Ca単uelas
    ciudades.conectar(c, l, 2);

    Parcial4 parcial = new Parcial4();

   ListaGenerica<String> ciud = parcial.resolver(ciudades, "La Plata", "Suipacha");

    System.out.println(ciud);
  }
}

package Practica7.A;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.Grafos.utils.Recorridos;
import Clases.ListaGenerica.ListaGenerica;

public class RecorridosTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asunsion");
        Vertice<String> v6 = new VerticeImplListAdy<String>("La Habana");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Caracas");

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.conectar(v1, v2, 3);
        ciudades.conectar(v1, v3, 2);
        ciudades.conectar(v1, v4, 4);
        ciudades.conectar(v1, v5, 10);
        ciudades.conectar(v2, v5, 500);
        ciudades.conectar(v3, v5, 4);
        ciudades.conectar(v4, v5, 6);
        ciudades.conectar(v2, v6, 4);
        ciudades.conectar(v7, v5, 11);
        ciudades.conectar(v7, v6, 10);
        Recorridos<String> r = new Recorridos<String>();
        System.out.println("--- Se imprime el GRAFO con DFS ---");
        ListaGenerica<Vertice<String>> l = r.DFS(ciudades);
        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo().dato());
        }
        System.out.println();
        System.out.println("--- Se imprime el GRAFO con BFS ---");
        l = r.BFS(ciudades);
        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo().dato());
        }
        System.out.println();
    }
}

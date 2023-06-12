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

public class Test5 {
    public static void main(String[] args) {
     
        Vertice<String> v1 = new VerticeImplListAdy<String>(new String("La Plata"));
        Vertice<String> v2 = new VerticeImplListAdy<String>(new String("Pinamar"));
        Vertice<String> v3 = new VerticeImplListAdy<String>(new String("Quilmes"));
        Vertice<String> v4 = new VerticeImplListAdy<String>(new String("Abasto"));
        Vertice<String> v5 = new VerticeImplListAdy<String>(new String("Moreno"));
        Vertice<String> v6 = new VerticeImplListAdy<String>(new String("Cañuelas"));
        Vertice<String> v7 = new VerticeImplListAdy<String>(new String("Carlos Keen"));
        Vertice<String> v8 = new VerticeImplListAdy<String>(new String("Lobos"));
        Vertice<String> v9 = new VerticeImplListAdy<String>(new String("Navarro"));
        Vertice<String> v10 = new VerticeImplListAdy<String>(new String("Saladillo"));
        Vertice<String> v11 = new VerticeImplListAdy<String>(new String("Suipacha"));

        Grafo<String> ciudades = new GrafoImplListAdy<String>();
        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);
        ciudades.agregarVertice(v8);
        ciudades.agregarVertice(v9);
        ciudades.agregarVertice(v10);
        ciudades.agregarVertice(v11);

        ciudades.conectar(v1, v2, 1); // La Plata - Pinamar
        ciudades.conectar(v2, v1, 1);

        ciudades.conectar(v1, v3, 1); // La Plata - Quilmes
        ciudades.conectar(v3, v1, 1);

        ciudades.conectar(v1, v4, 1); // La Plata - Abasto
        ciudades.conectar(v4, v1, 1);

        ciudades.conectar(v3, v5, 1); // Quilmes - Moreno
        ciudades.conectar(v5, v3, 1);

        ciudades.conectar(v4, v5, 1); // Abasto - Moreno
        ciudades.conectar(v5, v4, 1);

        ciudades.conectar(v7, v5, 1); // Moreno - Carlos Keen
        ciudades.conectar(v5, v7, 1);

        ciudades.conectar(v4, v6, 1); // Abasto - Cañuelas
        ciudades.conectar(v6, v4, 1);

        ciudades.conectar(v9, v6, 1); // Cañuelas - Navarro
        ciudades.conectar(v6, v9, 1);

        ciudades.conectar(v9, v10, 1); // Navarro - Saladillo
        ciudades.conectar(v10, v9, 1);

        ciudades.conectar(v9, v8, 1); // Navarro - Lobos
        ciudades.conectar(v8, v9, 1);

        ciudades.conectar(v9, v11, 1); // Navarro - Suipacha
        ciudades.conectar(v11, v9, 1);

        ciudades.conectar(v7, v11, 1); // Suipacha - Carlos Keen
        ciudades.conectar(v11, v7, 1);

        Parcial5 P5 = new Parcial5();
        ListaGenerica<String> ciudadesObligatorias = new ListaGenericaEnlazada<String>();
        ciudadesObligatorias.agregarInicio(v3.dato()); // Quilmes
        ciudadesObligatorias.agregarInicio(v7.dato()); // Carlos Keen

        ListaGenerica<String> l = P5.resolver(ciudades, "La Plata", "Suipacha", ciudadesObligatorias);

        l.comenzar();
        while (!l.fin()) {
            System.out.print(" -> " + l.proximo());
        }
        System.out.println();
        // -> La Plata -> Quilmes -> Moreno -> Carlos Keen -> Suipacha
    }
}

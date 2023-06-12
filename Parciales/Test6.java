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
import Clases.ListaGenerica.utils.Cola;
public class Test6 {
    public static void main(String[] args) {
        Vertice<Integer> v1 = new VerticeImplListAdy<Integer>(1);
        Vertice<Integer> v2 = new VerticeImplListAdy<Integer>(2);
        Vertice<Integer> v3 = new VerticeImplListAdy<Integer>(3);
        Vertice<Integer> v4 = new VerticeImplListAdy<Integer>(4);
        Vertice<Integer> v5 = new VerticeImplListAdy<Integer>(5);
        Vertice<Integer> v6 = new VerticeImplListAdy<Integer>(6);
        Vertice<Integer> v7 = new VerticeImplListAdy<Integer>(7);
        Vertice<Integer> v8 = new VerticeImplListAdy<Integer>(8);
        Vertice<Integer> v9 = new VerticeImplListAdy<Integer>(9);
        Vertice<Integer> v10 = new VerticeImplListAdy<Integer>(10);
        Vertice<Integer> v11 = new VerticeImplListAdy<Integer>(11);
        Vertice<Integer> v12 = new VerticeImplListAdy<Integer>(12);

        Grafo<Integer> computadoras = new GrafoImplListAdy<Integer>();
        computadoras.agregarVertice(v1);
        computadoras.agregarVertice(v2);
        computadoras.agregarVertice(v3);
        computadoras.agregarVertice(v4);
        computadoras.agregarVertice(v5);
        computadoras.agregarVertice(v6);
        computadoras.agregarVertice(v7);
        computadoras.agregarVertice(v8);
        computadoras.agregarVertice(v9);
        computadoras.agregarVertice(v10);
        computadoras.agregarVertice(v11);
        computadoras.agregarVertice(v12);

        computadoras.conectar(v1, v2, 1);
        computadoras.conectar(v2, v1, 1);

        computadoras.conectar(v1, v3, 1);
        computadoras.conectar(v3, v1, 1);

        computadoras.conectar(v1, v4, 1);
        computadoras.conectar(v4, v1, 1);

        computadoras.conectar(v1, v5, 1);
        computadoras.conectar(v5, v1, 1);
        
        computadoras.conectar(v2, v5, 1);
        computadoras.conectar(v5, v2, 1);

        computadoras.conectar(v3, v5, 1);
        computadoras.conectar(v5, v3, 1);

        computadoras.conectar(v4, v5, 1);
        computadoras.conectar(v5, v4, 1);

        computadoras.conectar(v2, v6, 1);
        computadoras.conectar(v6, v2, 1);

        computadoras.conectar(v7, v5, 1);
        computadoras.conectar(v5, v7, 1);

        computadoras.conectar(v7, v6, 1);
        computadoras.conectar(v6, v7, 1);

        computadoras.conectar(v7, v8, 1);
        computadoras.conectar(v8, v7, 1);

        computadoras.conectar(v9, v8, 1);
        computadoras.conectar(v8, v9, 1);

        computadoras.conectar(v9, v10, 1);
        computadoras.conectar(v10, v9, 1);

        computadoras.conectar(v11, v10, 1);
        computadoras.conectar(v10, v11, 1);

        computadoras.conectar(v12, v11, 1);
        computadoras.conectar(v11, v12, 1);

        Parcial6<Integer> P6 = new Parcial6<Integer>();
        System.out.println("El virus tardara " + P6.resolver(computadoras, v1) + " segundos en expandirse.");
        //RTA: 7 segundos
    }

}

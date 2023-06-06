package Practica7.A;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.Grafos.utils.Algoritmos;

public class AlgoritmosTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
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
        ciudades.conectar(v2, v3, 2);
        ciudades.conectar(v3, v4, 4);
        ciudades.conectar(v4, v5, 60);
        ciudades.conectar(v4, v1, 80);

        Algoritmos<String> A = new Algoritmos<>();

        System.out.println("El grado del digrafo es " + A.subgrafoCuadrado(ciudades)); // RTA: true

        System.out.println("El grado del digrafo es " + A.getGrado(ciudades)); // RTA: 3

        System.out.println("¿El grafo tiene al menos un ciclo? " + A.tieneCiclo(ciudades)); // RTA: true
    }
}
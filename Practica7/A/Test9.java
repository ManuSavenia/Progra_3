package Practica7.A;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.Grafos.utils.GuiaDeTurismo;

public class Test9 {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("La Bombonera");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Palermo");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Teatro Colón");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Puerto Madero");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Obelisco");
        Vertice<String> v6 = new VerticeImplListAdy<String>("La Casa Rosada");
        Vertice<String> v7 = new VerticeImplListAdy<String>("El Barrio Chino");

        Grafo<String> lugares = new GrafoImplListAdy<String>();
        lugares.agregarVertice(v1);
        lugares.agregarVertice(v2);
        lugares.agregarVertice(v3);
        lugares.agregarVertice(v4);
        lugares.agregarVertice(v5);
        lugares.agregarVertice(v6);
        lugares.agregarVertice(v7);

        lugares.conectar(v1, v2, 30);
        lugares.conectar(v2, v1, 30);
        lugares.conectar(v1, v4, 10);
        lugares.conectar(v4, v1, 10);
        lugares.conectar(v1, v3, 15);
        lugares.conectar(v3, v1, 15);
        lugares.conectar(v2, v5, 60);
        lugares.conectar(v5, v2, 60);
        lugares.conectar(v2, v4, 25);
        lugares.conectar(v4, v2, 25);
        lugares.conectar(v4, v3, 40);
        lugares.conectar(v3, v4, 40);
        lugares.conectar(v4, v7, 35);
        lugares.conectar(v7, v4, 35);
        lugares.conectar(v3, v6, 20);
        lugares.conectar(v6, v3, 20);
        lugares.conectar(v5, v7, 20);
        lugares.conectar(v7, v5, 20);
        lugares.conectar(v6, v7, 30);
        lugares.conectar(v7, v6, 30);

        GuiaDeTurismo aux = new GuiaDeTurismo();
        System.out.println("El camino minimo para llegar desde La Bombonera hasta El Barrio Chino es: ");
        System.out.println(aux.caminoConMenorNrodeViajes(lugares, "La Bombonera", "El Barrio Chino").toString());

    }
}
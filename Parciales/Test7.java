package Parciales;

import Clases.Grafos.Grafo;
import Clases.Grafos.GrafoImplListAdy;
import Clases.Grafos.Vertice;
import Clases.Grafos.VerticeImplListAdy;
import Clases.ListaGenerica.ListaGenerica;

public class Test7 {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Stavenger");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Tromso");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Berger");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Lofoten");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Trondheim");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Nordland");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Masjeem");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Drammen");
        Vertice<String> v9 = new VerticeImplListAdy<String>("Oslo");

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


        ciudades.conectar(v1, v3, 0); //Stavenger - Berger
        ciudades.conectar(v3, v1, 0);

        ciudades.conectar(v1, v5, 2); //Stavenger - Trondheim
        ciudades.conectar(v5, v1, 2);

        ciudades.conectar(v1, v2, 0); //Stavenger - Tromso
        ciudades.conectar(v2, v1, 0);

        ciudades.conectar(v1, v4, 3); //Stavenger - Lofoten
        ciudades.conectar(v4, v1, 3);
        
        ciudades.conectar(v3, v9, 0); //Berger - Oslo
        ciudades.conectar(v9, v3, 0);

        ciudades.conectar(v5, v2, 1); //Trondheim - Tromso
        ciudades.conectar(v2, v5, 1);

        ciudades.conectar(v2, v7, 0); //Tromso - Masjeem
        ciudades.conectar(v7, v2, 0);

        ciudades.conectar(v4, v7, 3); //Lofoten - Masjeem
        ciudades.conectar(v7, v4, 3);

        ciudades.conectar(v4, v6, 1); //Lofoten - Nordland
        ciudades.conectar(v6, v4, 1);

        ciudades.conectar(v6, v7, 3); //Nordland - Masjeem
        ciudades.conectar(v7, v6, 3);

        ciudades.conectar(v8, v7, 1); //Drammen - Masjeem
        ciudades.conectar(v7, v8, 1);

        ciudades.conectar(v8, v9, 0); //Drammen - Oslo
        ciudades.conectar(v9, v8, 0);

        ciudades.conectar(v7, v9, 0); //Masjeem - Oslo
        ciudades.conectar(v9, v7, 0);


        Parcial7 P9 = new Parcial7(ciudades);
        ListaGenerica<ListaGenerica<String>> l = P9.devolverCaminos("Stavenger", "Oslo");
        l.comenzar();
        while (!l.fin()) {
            ListaGenerica<String> aux = l.proximo();
            aux.comenzar();
            while(!aux.fin()){
                System.out.print(" -> " + aux.proximo());
            }
            System.out.println();
        }
        System.out.println();
        
}
}

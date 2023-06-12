
package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class Parcial6<T> {

    public int resolver(Grafo<T> sistema, Vertice<T> CompuInfectada) {
        boolean[] visitados = new boolean[sistema.listaDeVertices().tamanio()];
        Cola<Vertice<T>> cola = new Cola<Vertice<T>>();
        int RES = 0;
        RES = BFS(sistema, CompuInfectada.posicion(), visitados, RES, cola);
        return RES;
    }

    private int BFS(Grafo<T> sistema, int posicion, boolean[] visitados, int RES, Cola<Vertice<T>> cola) {
        Vertice<T> vertice = sistema.listaDeVertices().elemento(posicion);
        cola.encolar(vertice);
        cola.encolar(null);
        visitados[posicion] = true;
        while (!cola.esVacia()) {
            Vertice<T> desencolado = cola.desencolar();
            if (desencolado != null) {
                ListaGenerica<Arista<T>> ady = sistema.listaDeAdyacentes(desencolado);
                ady.comenzar();
                while (!ady.fin()) {
                    Arista<T> arista = ady.proximo();
                    if (!visitados[arista.verticeDestino().posicion()]) {
                        cola.encolar(arista.verticeDestino());
                        visitados[arista.verticeDestino().posicion()] = true;
                    }
                }
            }
            else if (!cola.esVacia()) {
                RES++;
                cola.encolar(null);
            }
        }
        return RES;
    }
}

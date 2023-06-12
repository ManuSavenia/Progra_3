package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial2 {

    public ListaGenerica<String> resolver(Grafo<Datos2> ciudades, String origen, String destino, int minFase) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> aux = new ListaGenericaEnlazada<String>();
        boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
        boolean existe1 = false, existe2 = false;
        int posicion = 0, i;
        for (i = 0; i < ciudades.listaDeVertices().tamanio(); i++) {
            if (ciudades.listaDeVertices().elemento(i).dato().getnombreC() == origen) {
                posicion = i;
                existe1 = true;
            }
            if (ciudades.listaDeVertices().elemento(i).dato().getnombreC() == destino) {
                existe2 = true;
            }
        }
        if (!existe1 || !existe2)
            return null;
        visitados[posicion] = true;
        DFS(ciudades, destino, minFase, posicion, visitados, camino, aux);
        return camino;
    }

    private void DFS(Grafo<Datos2> ciudades, String destino, int minFase, int posicion, boolean[] visitados, ListaGenerica<String> camino, ListaGenerica<String> aux) {
        Vertice<Datos2> vertice = ciudades.listaDeVertices().elemento(posicion);
        if (vertice.dato().getnombreC().equals(destino)) {
            aux.agregarFinal(vertice.dato().getnombreC());
            copia(camino,aux);
            return;
        }
        aux.agregarFinal(vertice.dato().getnombreC());
        visitados[posicion] = true;
        ListaGenerica<Arista<Datos2>> ady = ciudades.listaDeAdyacentes(vertice);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Datos2> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()] && vertice.dato().getFase() >= minFase && arista.peso() > 0) {
                DFS(ciudades, destino, minFase, arista.verticeDestino().posicion(), visitados, camino, aux);
                visitados[arista.verticeDestino().posicion()] = false;
                aux.eliminarEn(aux.tamanio() - 1);
            }
        }
        return;
    }


    private void copia(ListaGenerica<String> camino,ListaGenerica<String> aux){
        camino.comenzar();
        while(!camino.fin()){
            camino.eliminarEn(0);
        }
        aux.comenzar();
        while(!aux.fin()){
            camino.agregarFinal(aux.proximo());
        }
        System.out.println("hola");
    }
}
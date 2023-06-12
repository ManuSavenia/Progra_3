package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;

public class Parcial1 {

    public int resolver(Grafo<Datos> ciudades, String origen, String destino, int maxControles) {
        boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
        boolean existe1 = false, existe2 = false;
        int posicion = 0, i, RES = 0;
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
            return 0;
        visitados[posicion] = true;
        RES = DFS(ciudades, destino, maxControles, posicion, visitados, RES, 0);
        return RES;
    }

    private int DFS(Grafo<Datos> ciudades, String destino, int maxControles, int posicion, boolean[] visitados, int RES,
            int act) {
        Vertice<Datos> vertice = ciudades.listaDeVertices().elemento(posicion);
        act += vertice.dato().getEstadia();
        if (vertice.dato().getnombreC().equals(destino)) {
            if (act > RES) {
                RES = act;
            }
            return RES;
        }
        visitados[posicion] = true;
        ListaGenerica<Arista<Datos>> ady = ciudades.listaDeAdyacentes(vertice);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Datos> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()] && arista.peso() <= maxControles) {
                RES = DFS(ciudades, destino, maxControles, arista.verticeDestino().posicion(), visitados, RES, act);
                visitados[arista.verticeDestino().posicion()] = false;
                act -= vertice.dato().getEstadia();
            }
        }
        return RES;
    }
}
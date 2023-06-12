package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial3 {

    public int[] resolver(Grafo<Datos2> ciudades, String origen, String destino) {
        int[] cantFases = new int[5];
        boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
        boolean[] condicion = new boolean[ciudades.listaDeVertices().tamanio()];
        boolean existe1 = false, existe2 = false;
        int posicion = 0, i;
        for (i = 0; i < 5; i++) {
            cantFases[i] = 0;
        }
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
        DFS(ciudades, destino, posicion, visitados, condicion, cantFases);
        return cantFases;
    }

    private int DFS(Grafo<Datos2> ciudades, String destino, int posicion, boolean[] visitados, boolean[] condicion,int[] cantFases) {
        Vertice<Datos2> vertice = ciudades.listaDeVertices().elemento(posicion);
        cantFases[vertice.dato().getFase() - 1]++;
        visitados[posicion] = true;
        if (vertice.dato().getnombreC().equals(destino)) {
            if (!condicion[posicion]) {
                condicion[posicion] = true;
            }
            else{
                cantFases[vertice.dato().getFase() - 1]--;
            }
            return vertice.dato().getFase();
        }
        ListaGenerica<Arista<Datos2>> ady = ciudades.listaDeAdyacentes(vertice);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Datos2> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()] && arista.peso() > 0) {
                int gradoAnt = DFS(ciudades, destino, arista.verticeDestino().posicion(), visitados, condicion, cantFases);
                if(condicion[arista.verticeDestino().posicion()]){
                    condicion[posicion] = true;
                }
                else{
                    cantFases[gradoAnt - 1]--;
                }    
                visitados[arista.verticeDestino().posicion()] = false;
            }
        }
        return vertice.dato().getFase();
    }

}

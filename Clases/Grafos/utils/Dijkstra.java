package Clases.Grafos.utils;
import java.util.PriorityQueue;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;

public class Dijkstra<T> {
    public Costo[] dijkstraSinHeap(Grafo<T> grafo, Vertice<T> v) {
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            costos[i] = new Costo();
            costos[i].setCostoMinimo(Integer.MAX_VALUE);
            costos[i].setPosVerticeAnterior(0);
        }
        costos[v.posicion()].setCostoMinimo(0);
        for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            int posMin = this.minimoNoMarcado(costos, marca);
            marca[posMin] = true;
            Vertice<T> vertice = grafo.listaDeVertices().elemento(posMin);
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<T> arista = adyacentes.proximo();
                int posAdy = arista.verticeDestino().posicion();
                if (!marca[posAdy]) {
                    int costoAdy = costos[posMin].getCostoMinimo() + arista.peso();
                    if (costoAdy < costos[posAdy].getCostoMinimo()) {
                        costos[posAdy].setCostoMinimo(costoAdy);
                        costos[posAdy].setPosVerticeAnterior(posMin);
                    }
                }
            }
        }
        return costos;
    }

    private int minimoNoMarcado(Costo[] costos, boolean[] marca) {
        int min = Integer.MAX_VALUE;
        int posMin = -1;
        for (int i = 0; i < costos.length; i++) {
            if (!marca[i] && costos[i].getCostoMinimo() < min) {
                min = costos[i].getCostoMinimo();
                posMin = i;
            }
        }
        return posMin;
    }

    // ------------------------------------------------------------------------------------------------
    public Costo[] dijkstraConHeap(Grafo<T> grafo, Vertice<T> v) {
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            costos[i] = new Costo();
            costos[i].setCostoMinimo(Integer.MAX_VALUE);
            costos[i].setPosVerticeAnterior(0);
        }
        PriorityQueue<Heap<T>> heap = new PriorityQueue<Heap<T>>();
        costos[v.posicion()].setCostoMinimo(0);
        heap.offer(new Heap<T>(v.posicion(), 0));
        while (!heap.isEmpty()) {
            Heap<T> min = heap.poll();
            if (min.getPos() == -1) {
                continue;
            }
            marca[min.getPos()] = true;
            Vertice<T> vertice = grafo.listaDeVertices().elemento(min.getPos());
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
            adyacentes.comenzar();
            while (!adyacentes.fin()) {
                Arista<T> arista = adyacentes.proximo();
                int posAdy = arista.verticeDestino().posicion();
                if (!marca[posAdy]) {
                    int costoAdy = costos[min.getPos()].getCostoMinimo() + arista.peso();
                    if (costoAdy < costos[posAdy].getCostoMinimo()) {
                        costos[posAdy].setCostoMinimo(costoAdy);
                        costos[posAdy].setPosVerticeAnterior(min.getPos());
                        heap.offer(new Heap<T>(posAdy, costos[posAdy].getCostoMinimo()));
                    }
                }
            }
        }
        return costos;
    }
//------------------------------------------------------------------------------------------------
public CostoTodosMinimos[] dijkstraTodosMinimos (Grafo<T> grafo, Vertice<T> v){
    CostoTodosMinimos[] costos = new CostoTodosMinimos[grafo.listaDeVertices().tamanio()];
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
        costos[i] = new CostoTodosMinimos();
        costos[i].setData(new Costo());
        costos[i].getData().setCostoMinimo(Integer.MAX_VALUE);
        costos[i].getData().setPosVerticeAnterior(0);
    }
    costos[v.posicion()].getData().setCostoMinimo(0);
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
        int posMin = this.minimoNoMarcado2(costos, marca);
        marca[posMin] = true;
        Vertice<T> vertice = grafo.listaDeVertices().elemento(posMin);
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<T> arista = adyacentes.proximo();
            int posAdy = arista.verticeDestino().posicion();
            if (!marca[posAdy]) {
                int costoAdy = costos[posMin].getData().getCostoMinimo() + arista.peso();
                if (costoAdy < costos[posAdy].getData().getCostoMinimo()) {
                    costos[posAdy].getData().setCostoMinimo(costoAdy);
                    costos[posAdy].getData().setPosVerticeAnterior(posMin);
                }
                if (costoAdy == costos[posAdy].getData().getCostoMinimo()) {
                    costos[posAdy].setRepetidos(costos[posAdy].getRepetidos() + 1);
                }
            }
        }
    }
    return costos;
}

private int minimoNoMarcado2(CostoTodosMinimos[] costos, boolean[] marca){
    int min = Integer.MAX_VALUE;
    int posMin = -1;
    for (int i = 0; i < costos.length; i++) {
        if (!marca[i] && costos[i].getData().getCostoMinimo() < min) {
            min = costos[i].getData().getCostoMinimo();
            posMin = i;
        }
    }
    return posMin;
}
}

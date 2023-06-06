package Clases.Grafos.utils;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class SortTopologico<T> {
  public ListaGenerica<Vertice<T>> sortTopologico(Grafo<T> grafo) {
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> lista = new ListaGenericaEnlazada<Vertice<T>>();
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
      if (!marca[i])
        this.sortTopologico(i, grafo, lista, marca);
    }
    return lista;
  }

  private void sortTopologico(int i, Grafo<T> grafo, ListaGenerica<Vertice<T>> lista, boolean[] marca) {
    marca[i] = true;
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
    ady.comenzar();
    while (!ady.fin()) {
      Arista<T> a = ady.proximo();
      if (!marca[a.verticeDestino().posicion()]) {
        int j = a.verticeDestino().posicion();
        this.sortTopologico(j, grafo, lista, marca);
      }
    }
    lista.agregarInicio(v);
  }
}

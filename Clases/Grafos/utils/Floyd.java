package Clases.Grafos.utils;
import Clases.Grafos.Grafo;
import Clases.ListaGenerica.ListaGenerica;
import Clases.Grafos.Arista;

public class Floyd<T> {
   public Costo[][] floyd(Grafo<T> grafo) {
        int i, j, k;
        Costo costos[][] = new Costo[grafo.listaDeVertices().tamanio()][grafo.listaDeVertices().tamanio()];
        for (i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            for (j = 0; j < grafo.listaDeVertices().tamanio(); j++) {
                costos[i][j] = new Costo();
                costos[i][j].setCostoMinimo(Integer.MAX_VALUE);
                costos[i][j].setPosVerticeAnterior(0);
                if(i == j){
                    costos[i][j].setCostoMinimo(0);
                }
            }
        }
        for (i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(grafo.listaDeVertices().elemento(i));
            ady.comenzar();
            while(!ady.fin()){
                Arista<T> arista = ady.proximo();
                costos[i][arista.verticeDestino().posicion()].setCostoMinimo(arista.peso());
            }
        }
        for (k = 0; k < grafo.listaDeVertices().tamanio(); k++) {
            for (i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
                for (j = 0; j < grafo.listaDeVertices().tamanio(); j++) {
                    if((costos[i][k].getCostoMinimo() != Integer.MAX_VALUE) && (costos[k][j].getCostoMinimo() != Integer.MAX_VALUE)){
                        if (costos[i][k].getCostoMinimo() + costos[k][j].getCostoMinimo() < costos[i][j].getCostoMinimo()) {
                            costos[i][j].setCostoMinimo(costos[i][k].getCostoMinimo() + costos[k][j].getCostoMinimo());
                            costos[i][j].setPosVerticeAnterior(k);
                        }
                    }
                   
                }
            }
        }
        return costos;
    }
}

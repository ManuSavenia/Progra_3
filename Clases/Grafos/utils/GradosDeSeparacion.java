package Clases.Grafos.utils;
import java.util.Arrays;
public class GradosDeSeparacion {
    int maximoGradoDeSeparacion(Grafo<String> grafo) {
        Cola<Vertice<String>> cola = new Cola<Vertice<String>>();
        int max = 0;
        int i;
        int distancias2[] = new int[grafo.listaDeVertices().tamanio()];
        for (i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            int distancias[] = new int[grafo.listaDeVertices().tamanio()];
            boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
            Vertice<String> v = grafo.listaDeVertices().elemento(i);
            visitados[i] = true;
                cola.encolar(v);
                while (!cola.esVacia()) {
                    Vertice<String> aux = cola.desencolar();
                    ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(aux);
                    ady.comenzar();
                    while (!ady.fin()) {
                        Arista<String> arista = ady.proximo();
                        Vertice<String> destino = arista.verticeDestino();
                        if (!visitados[destino.posicion()]) {
                            visitados[destino.posicion()] = true;
                            cola.encolar(destino);
                            distancias[destino.posicion()] = distancias[aux.posicion()] + 1;
                        }
                    }
                }
            distancias2[i] = Arrays.stream(distancias).max().getAsInt();
        }
        for (i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            if (distancias2[i] > max)
                max = distancias2[i];
        }
        return max;
    }
}

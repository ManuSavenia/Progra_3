package Clases.Grafos.utils;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;

public class Delta {

    public int maxIslasDistintas(Grafo<String> grafo) {
        int max = 0, i = 0;
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        visitados[0] = true;
        Vertice<String> vertice1 = grafo.listaDeVertices().elemento(0);
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(vertice1);
        ady.comenzar();
        int[] vector = new int[ady.tamanio()];
        while (!ady.fin()) {
            System.out.println("i: " + i);
            Arista<String> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()]) {
                maxIslasDistintas(grafo, visitados, i, vector, arista.verticeDestino());
            }
            vector[i]++;
            i++;
        }
        for (i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }
        return max;
    }

    private void maxIslasDistintas(Grafo<String> grafo, boolean[] visitados, int posicion, int[] vector,Vertice<String> v) {
        visitados[v.posicion()] = true;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()]) {
                vector[posicion]++;
                maxIslasDistintas(grafo, visitados, posicion, vector, arista.verticeDestino());
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------

public RutaMinima<String> caminoMasCorto(Grafo<String> grafo, String islaO, String islaD){
    RutaMinima<String> resul = new RutaMinima<String>(); 
    RutaMinima<String> caminoAux = new RutaMinima<String>();
    caminoAux.setBoletos(1);
    ListaGenerica<Vertice<String>> islas = grafo.listaDeVertices();
    boolean[] visitados = new boolean[islas.tamanio()];
    int i,posicion = 0;
    for (i = 0; i < islas.tamanio(); i++) {
        if (islas.elemento(i).dato().equals(islaO)){
            posicion = i;
            break;
        }
    }
    visitados[posicion] = true;
    caminoMasCorto(grafo,visitados,posicion,caminoAux,islaD,islaO,resul);
    return resul;
}

private void caminoMasCorto(Grafo<String> grafo, boolean[] visitados, int posicion,RutaMinima<String> caminoAux, String islaD,String islaO, RutaMinima<String> resul){
    Vertice<String> v = grafo.listaDeVertices().elemento(posicion);
    visitados[posicion] = true;
    caminoAux.getRuta().agregarFinal(v.dato());
    if (v.dato().equals(islaD)) {
        if ((resul.getRuta().tamanio() == 0) || (caminoAux.getPeso() < resul.getPeso())) {
            Copia(resul, caminoAux);
        }
        return;
    } 
        if(v.posicion() == 0 && !v.dato().equals(islaD)){
            caminoAux.agregarBoleto();
        }
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            int j = arista.verticeDestino().posicion();
            if (!visitados[j]) {
                caminoAux.agregarPeso(arista.peso());
                caminoMasCorto(grafo, visitados,j,caminoAux, islaD,islaO,resul);
                if (v.posicion() == 0 && !v.dato().equals(islaD)) {
                    caminoAux.eliminarBoleto();
                }
                visitados[j] = false;
                caminoAux.getRuta().eliminarEn(caminoAux.getRuta().tamanio() - 1);
                caminoAux.eliminarPeso(arista.peso());
            }
        }
}

private void Copia(RutaMinima<String> result, RutaMinima<String> l) {
    for (int i = result.getRuta().tamanio(); i >= 0; i--)
        result.getRuta().eliminarEn(result.getRuta().tamanio()-1);
    l.getRuta().comenzar();
    while (!l.getRuta().fin()) {
        result.getRuta().agregarFinal(l.getRuta().proximo());
    }
    result.setBoletos(l.getBoletos());
    result.setPeso(l.getPeso());
}

}



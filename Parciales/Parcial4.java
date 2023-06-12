package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial4 {

    public ListaGenerica<String> resolver(Grafo<Datos2> ciudades, String origen, String destino) {
        ListaGenerica<String> Ciudades = new ListaGenericaEnlazada<String>();
  		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
  		boolean[] condicion = new boolean[ciudades.listaDeVertices().tamanio()];
  		int i,posicion = 0;
  		boolean existe1 = false,existe2 = false;
  		for(i = 0;i < ciudades.listaDeVertices().tamanio(); i++){
  			if(ciudades.listaDeVertices().elemento(i).dato().getnombreC().equals(origen)){
  				posicion = i;
  				existe1 = true;
  			}
  			if(ciudades.listaDeVertices().elemento(i).dato().getnombreC().equals(destino)){
  				existe2 = true;
  			}
  		}
  		if(!existe1 || !existe2)
  			return null;
  		DFS(ciudades,destino,posicion,visitados,Ciudades,condicion);
  		return Ciudades;
  	}

    private void DFS(Grafo<Datos2> ciudades, String destino, int posicion, boolean[] visitados,ListaGenerica<String> Ciudades, boolean[] condicion) {
        Vertice<Datos2> vertice = ciudades.listaDeVertices().elemento(posicion);
        Ciudades.agregarFinal(vertice.dato().getnombreC());
        if (vertice.dato().getnombreC().equals(destino)) {
            if (!condicion[posicion]) {
                condicion[posicion] = true;
            } else {
                Ciudades.eliminarEn(Ciudades.tamanio() - 1);
            }
            return;
        }
        visitados[posicion] = true;
        ListaGenerica<Arista<Datos2>> ady = ciudades.listaDeAdyacentes(vertice);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<Datos2> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()] && arista.verticeDestino().dato().getFase() > 1 && arista.peso() > 0) {
                DFS(ciudades, destino, arista.verticeDestino().posicion(), visitados, Ciudades, condicion);
                if (condicion[arista.verticeDestino().posicion()]) {
                    condicion[posicion] = true;
                } else {
                    Ciudades.eliminarEn(Ciudades.tamanio() - 1);
                }
                visitados[arista.verticeDestino().posicion()] = false;
            }
        }
    }
}

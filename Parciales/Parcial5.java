package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial5 {

	public ListaGenerica<String> resolver(Grafo<String> ciudades, String origen, String destino,
			ListaGenerica<String> pasandoPor) {
		boolean[] visitados = new boolean[ciudades.listaDeVertices().tamanio()];
		boolean[] condicion = new boolean[ciudades.listaDeVertices().tamanio()];
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		boolean existe1 = false, existe2 = false;
		camino.comenzar();
		int i, posicion = 0;
		for (i = 0; i < ciudades.listaDeVertices().tamanio(); i++) {
			if (ciudades.listaDeVertices().elemento(i).dato().equals(origen)) {
				posicion = i;
				existe1 = true;
			}
			if (ciudades.listaDeVertices().elemento(i).dato().equals(destino)) {
				existe2 = true;
			}
		}
		if (!existe1 || !existe2) {
			return null;
		}
		DFS(ciudades, destino, pasandoPor, visitados, camino, posicion, condicion);
		return camino;
	}

	private boolean DFS(Grafo<String> ciudades, String destino, ListaGenerica<String> pasandoPor, boolean[] visitados,ListaGenerica<String> camino, int posicion, boolean[] condicion) {
		Vertice<String> vertice = ciudades.listaDeVertices().elemento(posicion);
		if(camino.incluye(vertice.dato())){
			return false;
		}
		camino.agregarFinal(vertice.dato());
		System.out.println("hols");
		if (vertice.dato().equals(destino)) {
			condicion[posicion] = true;
			while (!pasandoPor.fin()) {
				String ciudad = pasandoPor.proximo();
				if (!camino.incluye(ciudad)) {
					return false;
				}
			}
			return true;
		}
		visitados[posicion] = true;
		ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vertice);
		ady.comenzar();
		while (!ady.fin()) {
			Arista<String> arista = ady.proximo();
			if (!visitados[arista.verticeDestino().posicion()]) {
				if(DFS(ciudades, destino, pasandoPor, visitados, camino, arista.verticeDestino().posicion(), condicion)){
					return true;
				}
				if (condicion[arista.verticeDestino().posicion()]) {
					condicion[posicion] = true;
				} else {
					camino.eliminarEn(camino.tamanio() - 1);
				}
				visitados[arista.verticeDestino().posicion()] = false;
			}
		}
		return false;
	}
}
package Parciales;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class Parcial7{
	
	private Grafo<String> mapa;

    public Parcial7(Grafo<String> grafo){
        this.mapa = grafo;
    }

	public void setmapa(Grafo<String> mapa){
		this.mapa = mapa;
	}

	public Grafo<String> getmapa(){
		return this.mapa;
	}


	public ListaGenerica<ListaGenerica<String>> devolverCaminos(String Origen,String Destino){
        if(this.mapa == null){  
            return null;
        }
		ListaGenerica<ListaGenerica<String>> Caminos = new ListaGenericaEnlazada<ListaGenerica<String>>();
		ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
		boolean[] visitados = new boolean[this.mapa.listaDeVertices().tamanio()];
		boolean existe1 = false,existe2 =false;
		int i,posicion = 0;
		for(i = 0; i < this.mapa.listaDeVertices().tamanio(); i++){
			if(this.mapa.listaDeVertices().elemento(i).dato().equals(Origen)){
				posicion = i;
				existe1 = true;
			}
			if(this.mapa.listaDeVertices().elemento(i).dato().equals(Destino)){
				existe2 = true;
			}
		}
		if((!existe1 || !existe2)){
			return null;
		}
		devolverCaminos(Destino,visitados,posicion,Caminos,camino);
		return Caminos;
	}


	private void devolverCaminos(String Destino, boolean[] visitados, int posicion, ListaGenerica<ListaGenerica<String>> Caminos, ListaGenerica<String>camino){
		Vertice<String> vertice = this.mapa.listaDeVertices().elemento(posicion);
		camino.agregarFinal(vertice.dato());
		if(vertice.dato().equals(Destino)){
			Caminos.agregarFinal(copia(camino));
			return;
		}
		visitados[posicion] = true;
		ListaGenerica<Arista<String>> ady = this.mapa.listaDeAdyacentes(vertice);
		ady.comenzar();
		while(!ady.fin()){
			Arista<String> arista = ady.proximo();
			if(!visitados[arista.verticeDestino().posicion()] && arista.peso() == 0){
				devolverCaminos(Destino,visitados, arista.verticeDestino().posicion(), Caminos, camino);
                camino.eliminarEn(camino.tamanio() - 1);
                visitados[arista.verticeDestino().posicion()] = false;
			}
		}
	}

    private ListaGenerica<String> copia (ListaGenerica<String> lista){
        ListaGenerica<String> copia = new ListaGenericaEnlazada<String>();
        lista.comenzar();
        while(!lista.fin()){
            copia.agregarFinal(lista.proximo());
        }
        return copia;
    }
}

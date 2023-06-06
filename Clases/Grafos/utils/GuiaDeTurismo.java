package Clases.Grafos.utils;
public class GuiaDeTurismo {
    
   public ListaGenerica<String> caminoConMenorNrodeViajes(Grafo<String> grafo, String puntoInteresOrigen, String puntoInteresDestino){
        Viajes resul = new Viajes();
        ListaGenerica<Viajes> caminos = new ListaGenericaEnlazada<Viajes>();
        ListaGenerica<Vertice<String>> lugares = grafo.listaDeVertices();
        boolean[] visitados = new boolean[lugares.tamanio()];
        int i,posicion = 0;
        for (i = 0; i < lugares.tamanio(); i++) {
            if (lugares.elemento(i).dato().equals(puntoInteresOrigen)){
                posicion = i;
                break;
            }
        }
        Viajes camino = new Viajes();
        caminoConMenorNrodeViajes(grafo,visitados,posicion,puntoInteresDestino,puntoInteresOrigen,caminos,camino);
        int mayor = 0;
        while(!caminos.fin()){
            Viajes camino2 = caminos.proximo();
            if(camino2.getMenorPeso() > mayor){
                mayor = camino2.getMenorPeso();
                resul = camino2;
            }
        }
        return resul.camino;
   }

   private void caminoConMenorNrodeViajes(Grafo<String> grafo, boolean[] visitados, int posicion, String puntoInteresDestino, String puntoInteresOrigen, ListaGenerica<Viajes> caminos,Viajes camino){
        Vertice<String> v = grafo.listaDeVertices().elemento(posicion);
        visitados[v.posicion()] = true;
        camino.agregarPuntoDeInteres(v.dato());
        if(v.dato().equals(puntoInteresDestino)){
            agregarViaje(caminos,camino);
        }
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                if(!visitados[arista.verticeDestino().posicion()]){
                    int minimo = camino.getMenorPeso();
                    if(arista.peso() < minimo){
                        camino.setMenorPeso(arista.peso());
                    }
                    caminoConMenorNrodeViajes(grafo,visitados,arista.verticeDestino().posicion(),puntoInteresDestino,puntoInteresOrigen,caminos,camino);
                    visitados[arista.verticeDestino().posicion()] = false;
                    camino.eliminarPuntoDeInteres(camino.getCamino().tamanio()-1);
                    camino.setMenorPeso(minimo);
                }
            }
   }

   private void agregarViaje(ListaGenerica<Viajes> caminos, Viajes camino){
        Viajes copia = new Viajes();
        ListaGenerica<String> camino2 = new ListaGenericaEnlazada<String>();
        for(int i = 0;i< camino.getCamino().tamanio();i++){
            camino2.agregarFinal(camino.getCamino().elemento(i));
        }
        copia.setCamino(camino2);
        copia.setMenorPeso(camino.getMenorPeso());
        caminos.agregarFinal(copia);
   }
}

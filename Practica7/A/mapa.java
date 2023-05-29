public class mapa{
    Grafo<String> mapaCiudades;
    public mapa(Grafo<String> grafo){
        mapaCiudades = grafo;
    }
//----------------------------------------------------------------------------------------------------------------------
ListaGenerica<String> devolverCamino (String ciudad1, String ciudad2){
    ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    camino.comenzar();
    ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
    boolean[] visitados = new boolean[ciudades.tamanio()];
    int i;
    int posicion = 0;
    boolean encontrado = false;
    for(i = 0; i < ciudades.tamanio(); i++){
       if(ciudades.elemento(i).dato().equals(ciudad1))
            posicion = i;
            break;
    }
    encontrado = DFS(camino,visitados,posicion,ciudad1, ciudad2);
    
    return camino;
}
    
    private boolean DFS(ListaGenerica<String> res,boolean[] visitados,int i, String ciudad1, String ciudad2){
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if(!visitados[v.posicion()]){
            visitados[v.posicion()] = true;
            if(v.dato().equals(ciudad2)){
                res.agregarFinal(ciudad2);
                return true;
            }
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            ady.comenzar();
            while(!ady.fin()){
                Arista<String> arista = ady.proximo();
                if(!visitados[arista.verticeDestino().posicion()]){
                    if(DFS(res, visitados, arista.verticeDestino().posicion(), ciudad1, ciudad2)){
                    res.agregarInicio(v.dato());
                    return true;
                    }
                }
            }    
        }
        return false;
    }
//----------------------------------------------------------------------------------------------------------------------

ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2,ListaGenerica<String> ciudades){
    ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
    camino.comenzar();
    ListaGenerica<Vertice<String>> Ciudades = mapaCiudades.listaDeVertices();
    boolean[] visitados = new boolean[Ciudades.tamanio()];
    int i;
    int posicion = 0;
    boolean encontrado = false;
    for(i = 0; i < Ciudades.tamanio(); i++){
       if(Ciudades.elemento(i).dato().equals(ciudad1))
            posicion = i;
            break;
    }
    encontrado = DFS2(camino,visitados,posicion,ciudad1,ciudad2,ciudades);
    if(encontrado)
        return camino;
    else
        return null;
}

private boolean DFS2(ListaGenerica<String> res,boolean[] visitados,int i, String ciudad1, String ciudad2, ListaGenerica<String> ciudades){
    Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
    if(!visitados[v.posicion()]){
        visitados[v.posicion()] = true;
        if(ciudades.incluye(v.dato()))
            return false;
        if(v.dato().equals(ciudad2)){
            res.agregarFinal(ciudad2);
            return true;
        }
        ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()){
            Arista<String> arista = ady.proximo();
            if(!visitados[arista.verticeDestino().posicion()]){
                if(DFS2(res, visitados, arista.verticeDestino().posicion(), ciudad1, ciudad2, ciudades)){
                    res.agregarInicio(v.dato());
                    return true;
                }
            }
        }    
    }
    return false;
}
//----------------------------------------------------------------------------------------------------------------------


ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
    Cola <Vertice<String>> cola = new Cola<Vertice<String>>();
    ListaGenerica<String> res = new ListaGenericaEnlazada<String>();
    boolean[] visitados = new boolean[mapaCiudades.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<String>> Ciudades = mapaCiudades.listaDeVertices();
    Ciudades.comenzar();
    int i, posicion = 0;
    for(i = 0; i < Ciudades.tamanio(); i++){
        if(Ciudades.elemento(i).dato().equals(ciudad1))
             posicion = i;
             break;
    }
    for(i = posicion; i < mapaCiudades.listaDeVertices().tamanio(); i++){
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if(!visitados[v.posicion()]){
            visitados[v.posicion()] = true;
            if(v.dato().equals(ciudad2)){
                res.agregarFinal(ciudad2);
                return res;
            }
            cola.encolar(v);
            while(!cola.esVacia()){
                Vertice<String> aux = cola.desencolar();
                res.agregarFinal(aux.dato());
                ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(aux);
                ady.comenzar();
                while(!ady.fin()){
                    Arista<String> arista = ady.proximo();
                    Vertice<String> destino = arista.verticeDestino();
                    if(!visitados[destino.posicion()]){
                        visitados[destino.posicion()] = true;
                        cola.encolar(destino);
                    }
                }
            }
        }
    }
    return res;
}
}
    
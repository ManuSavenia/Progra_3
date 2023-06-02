public class Algoritmos<T> {
    public boolean subgrafoCuadrado(Grafo<T> grafo){
        boolean estado = false;
        int longitud = 0;
        Vertice<T> vertice1 = grafo.listaDeVertices().elemento(0);
        int posicion = vertice1.posicion();
        int posicionInicial = vertice1.posicion();
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        estado = false;
        estado = subgrafoCuadrado(grafo,visitados,longitud,posicion,posicionInicial,estado);
        return estado;
    }

private boolean subgrafoCuadrado(Grafo<T> grafo,boolean[] visitados,int longitud,int posicion,int posicionInicial,boolean estado){
    Vertice<T> v = grafo.listaDeVertices().elemento(posicion);
    if (!visitados[v.posicion()]) {
        visitados[v.posicion()] = true;
        if(longitud == 4 && v.posicion() == posicionInicial)
            return true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        if(longitud == 3){
            while(!ady.fin()){
                Arista<T> arista = ady.proximo();
                if(arista.verticeDestino().posicion() == posicionInicial)
                    return true;
            }
            posicionInicial++;
            while(!ady.fin()){
                Arista<T> arista = ady.proximo();
                if(!visitados[arista.verticeDestino().posicion()]){
                    estado = subgrafoCuadrado(grafo,visitados,longitud,arista.verticeDestino().posicion(),posicionInicial,estado);
                    if(estado == true)
                        return true;
            }
        }
        }
        else{
        while (!ady.fin()) {
            Arista<T> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()]) {
                estado = subgrafoCuadrado(grafo,visitados,longitud + 1,arista.verticeDestino().posicion(),posicionInicial,estado);
                if(estado == true)
                    return true;
            }
        }
    }
    }
    return estado;
}
//------------------------------------------------------------------------------------------------------------------------------------------

public int getGrado(Grafo<T> grafo){
    int[] grados = new int[grafo.listaDeVertices().tamanio()];
    for(int i = 0;i<grafo.listaDeVertices().tamanio();i++){
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        grados[i] += ady.tamanio(); 
        while(!ady.fin()){
            Arista<T> arista = ady.proximo();
            grados[arista.verticeDestino().posicion()]++;
        }
    }
    int max = 0;
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
        if (grados[i] > max)
            max = grados[i];
    }
    return max;
}  

// ------------------------------------------------------------------------------------------------------------------------------------------

public boolean tieneCiclo(Grafo<T> grafo){
    boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
    boolean[] enPila = new boolean[grafo.listaDeVertices().tamanio()];
    for(int i = 0;i<grafo.listaDeVertices().tamanio();i++){
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        if(!visitados[v.posicion()]){
            if(tieneCiclo(grafo,visitados,enPila,v.posicion()))
                return true;
        }
    }
    return false;
}

private boolean tieneCiclo(Grafo<T> grafo,boolean[] visitados,boolean[] enPila,int posicion){
    Vertice<T> v = grafo.listaDeVertices().elemento(posicion);
    if(!visitados[v.posicion()]){
        visitados[v.posicion()] = true;
        enPila[v.posicion()] = true;
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()){
            Arista<T> arista = ady.proximo();
            if(!visitados[arista.verticeDestino().posicion()] && tieneCiclo(grafo,visitados,enPila,arista.verticeDestino().posicion()))
                return true;
            else if(enPila[arista.verticeDestino().posicion()])
                return true;
        }
    }
    enPila[v.posicion()] = false;
    return false;
}
}

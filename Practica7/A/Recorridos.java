

public class Recorridos<T> {
ListaGenerica<Vertice<T>> DFS(Grafo<T> grafo){
    ListaGenerica<Vertice<T>> res = new ListaGenericaEnlazada<Vertice<T>>();
    boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    int i;
    for(i = 0; i < grafo.listaDeVertices().tamanio(); i++){
        if(!visitados[i])
            DFS(grafo, res, visitados,i);
    }
    return res;
}

private void DFS(Grafo<T> grafo, ListaGenerica<Vertice<T>> res,boolean[] visitados,int i){
    Vertice<T> v = grafo.listaDeVertices().elemento(i);
    if(!visitados[v.posicion()]){
        visitados[v.posicion()] = true;
        res.agregarFinal(v);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while(!ady.fin()){
            Arista<T> arista = ady.proximo();
            if(!visitados[arista.verticeDestino().posicion()]){
                DFS(grafo, res, visitados, arista.verticeDestino().posicion());
            }
        }
    }
}

ListaGenerica<Vertice<T>> BFS(Grafo<T> grafo){
    Cola <Vertice<T>> cola = new Cola<Vertice<T>>();
    ListaGenerica<Vertice<T>> res = new ListaGenericaEnlazada<Vertice<T>>();
    boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
    ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
    vertices.comenzar();
    int i;
    for(i = 0; i < grafo.listaDeVertices().tamanio(); i++){
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        if(!visitados[v.posicion()]){
            visitados[v.posicion()] = true;
            cola.encolar(v);
            while(!cola.esVacia()){
                Vertice<T> aux = cola.desencolar();
                res.agregarFinal(aux);
                ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(aux);
                ady.comenzar();
                while(!ady.fin()){
                    Arista<T> arista = ady.proximo();
                    Vertice<T> destino = arista.verticeDestino();
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


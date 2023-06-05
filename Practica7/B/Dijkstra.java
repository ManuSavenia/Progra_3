import java.util.PriorityQueue;
public class Dijkstra<T> {
    Costo [] dijkstraSinHeap (Grafo<T> grafo, Vertice<T> v){
        Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
            costos[i] = new Costo();
            costos[i].setCostoMinimo(Integer.MAX_VALUE);
            costos[i].setPosVerticeAnterior(0);
        }
        costos[v.posicion()].setCostoMinimo(0);
        for(int i = 0; i < grafo.listaDeVertices().tamanio();i++){
            int posMin = this.minimoNoMarcado(costos, marca);
            marca[posMin] = true;
            Vertice<T> vertice = grafo.listaDeVertices().elemento(posMin);
            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
            adyacentes.comenzar();
            while(!adyacentes.fin()){
                Arista<T> arista = adyacentes.proximo();
                int posAdy = arista.verticeDestino().posicion();
                if(!marca[posAdy]){
                    int costoAdy = costos[posMin].getCostoMinimo() + arista.peso();
                    if(costoAdy < costos[posAdy].getCostoMinimo()){
                        costos[posAdy].setCostoMinimo(costoAdy);
                        costos[posAdy].setPosVerticeAnterior(posMin);
                    }
                }
            }
        }
        return costos;
    }
    private int minimoNoMarcado(Costo[] costos, boolean[] marca){
        int min = Integer.MAX_VALUE;
        int posMin = -1;
        for(int i = 0; i < costos.length; i++){
            if(!marca[i] && costos[i].getCostoMinimo() < min){
                min = costos[i].getCostoMinimo();
                posMin = i;
            }
        }
        return posMin;
    }

//------------------------------------------------------------------------------------------------
Costo [] dijkstraConHeap (Grafo<T> grafo, Vertice<T> v){
    Costo[] costos = new Costo[grafo.listaDeVertices().tamanio()];
    boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
    for (int i = 0; i < grafo.listaDeVertices().tamanio(); i++) {
        costos[i] = new Costo();
        costos[i].setCostoMinimo(Integer.MAX_VALUE);
        costos[i].setPosVerticeAnterior(0);
        }
    costos[v.posicion()].setCostoMinimo(0);
    PriorityQueue<Heap<T>> heap = new PriorityQueue<Heap<T>>();
    for(int i = 0; i < grafo.listaDeVertices().tamanio();i++){
       costos[i] = new Costo();
    }
    costos[v.posicion()].setCostoMinimo(0);
    heap.offer(new Heap<T>(v.posicion(), 0));
    while(!heap.isEmpty()){
        Heap<T> min = heap.poll();
        if(min.getPos()==-1){
            continue;
        }
        marca[min.getPos()] = true;
        Vertice<T> vertice = grafo.listaDeVertices().elemento(min.getPos());
        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(vertice);
        adyacentes.comenzar();
        while(!adyacentes.fin()){
            Arista<T> arista = adyacentes.proximo();
            int posAdy = arista.verticeDestino().posicion();
            if(!marca[posAdy]){
                int costoAdy = costos[min.getPos()].getCostoMinimo() + arista.peso();
                if(costoAdy < costos[posAdy].getCostoMinimo()){
                    costos[posAdy].setCostoMinimo(costoAdy);
                    costos[posAdy].setPosVerticeAnterior(min.getPos());
                    //heap.add(new Heap<T>(costos[posAdy].getCostoMinimo(), posAdy));
                    heap.offer(new Heap<T>(posAdy, costos[posAdy].getCostoMinimo()));
                }
            }
        }
    }
    return costos;
}
}

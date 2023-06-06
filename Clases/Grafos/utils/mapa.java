package Clases.Grafos.utils;

import Clases.Grafos.Arista;
import Clases.Grafos.Grafo;
import Clases.Grafos.Vertice;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;

public class mapa {
    Grafo<String> mapaCiudades;

    public mapa(Grafo<String> grafo) {
        mapaCiudades = grafo;
    }

    // ----------------------------------------------------------------------------------------------------------------------
    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        camino.comenzar();
        ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[ciudades.tamanio()];
        int i;
        int posicion = 0;
        boolean encontrado = false;
        for (i = 0; i < ciudades.tamanio(); i++) {
            if (ciudades.elemento(i).dato().equals(ciudad1))
                posicion = i;
            break;
        }
        encontrado = DFS(camino, visitados, posicion, ciudad1, ciudad2);

        return camino;
    }

    private boolean DFS(ListaGenerica<String> res, boolean[] visitados, int i, String ciudad1, String ciudad2) {
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if (!visitados[v.posicion()]) {
            visitados[v.posicion()] = true;
            if (v.dato().equals(ciudad2)) {
                res.agregarFinal(ciudad2);
                return true;
            }
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                if (!visitados[arista.verticeDestino().posicion()]) {
                    if (DFS(res, visitados, arista.verticeDestino().posicion(), ciudad1, ciudad2)) {
                        res.agregarInicio(v.dato());
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // ----------------------------------------------------------------------------------------------------------------------

    public ListaGenerica<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        camino.comenzar();
        ListaGenerica<Vertice<String>> Ciudades = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[Ciudades.tamanio()];
        int i;
        int posicion = 0;
        boolean encontrado = false;
        for (i = 0; i < Ciudades.tamanio(); i++) {
            if (Ciudades.elemento(i).dato().equals(ciudad1))
                posicion = i;
            break;
        }
        encontrado = DFS2(camino, visitados, posicion, ciudad1, ciudad2, ciudades);
        if (encontrado)
            return camino;
        else
            return null;
    }

    private boolean DFS2(ListaGenerica<String> res, boolean[] visitados, int i, String ciudad1, String ciudad2,
            ListaGenerica<String> ciudades) {
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        if (!visitados[v.posicion()]) {
            visitados[v.posicion()] = true;
            if (ciudades.incluye(v.dato()))
                return false;
            if (v.dato().equals(ciudad2)) {
                res.agregarFinal(ciudad2);
                return true;
            }
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                if (!visitados[arista.verticeDestino().posicion()]) {
                    if (DFS2(res, visitados, arista.verticeDestino().posicion(), ciudad1, ciudad2, ciudades)) {
                        res.agregarInicio(v.dato());
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // ----------------------------------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[ciudades.tamanio()];
        int i;
        int posicion = 0;
        boolean encontrado = false;
        for (i = 0; i < ciudades.tamanio(); i++) {
            if (ciudades.elemento(i).dato().equals(ciudad1))
                posicion = i;
            break;
        }
        DFS3(camino, visitados, posicion, ciudad2, l);

        return camino;
    }

    private void DFS3(ListaGenerica<String> res, boolean[] visitados, int i, String ciudad2, ListaGenerica<String> l) {
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(i);
        visitados[i] = true;
        l.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((res.tamanio() == 0) || (l.tamanio() < res.tamanio())) {
                Copia(res, l);
            }
        } else {
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                int j = ady.proximo().verticeDestino().posicion();
                if (!visitados[j]) {
                    DFS3(res, visitados, j, ciudad2, l);
                    visitados[j] = false;
                    l.eliminarEn(l.tamanio() - 1);
                }
            }
        }
    }

    private void Copia(ListaGenerica<String> result, ListaGenerica<String> l) {
        for (int i = result.tamanio(); i >= 0; i--)
            result.eliminarEn(i);
        l.comenzar();
        while (!l.fin()) {
            result.agregarFinal(l.proximo());
        }
    }

    // ----------------------------------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        camino.comenzar();
        ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[ciudades.tamanio()];
        int i;
        int posicion = 0;
        boolean encontrado = false;
        for (i = 0; i < ciudades.tamanio(); i++) {
            if (ciudades.elemento(i).dato().equals(ciudad1))
                posicion = i;
            break;
        }
        encontrado = DFS4(camino, visitados, posicion, ciudad2, tanqueAuto);
        if (encontrado)
            return camino;
        else
            return null;
    }

    boolean DFS4(ListaGenerica<String> camino, boolean[] visitados, int posicion, String ciudad2, int tanqueAuto) {
        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(posicion);
        visitados[posicion] = true;
        if (v.dato().equals(ciudad2)) {
            camino.agregarFinal(ciudad2);
            return true;
        }
        ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin()) {
            Arista<String> arista = ady.proximo();
            if (!visitados[arista.verticeDestino().posicion()]) {
                if (arista.peso() <= tanqueAuto) {
                    if (DFS4(camino, visitados, arista.verticeDestino().posicion(), ciudad2,
                            tanqueAuto - arista.peso())) {
                        camino.agregarInicio(v.dato());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // ----------------------------------------------------------------------------------------------------------------------

    public ListaGenerica<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        ListaGenerica<String> camino = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> l = new ListaGenericaEnlazada<String>();
        camino.comenzar();
        ListaGenerica<Vertice<String>> ciudades = mapaCiudades.listaDeVertices();
        boolean[] visitados = new boolean[ciudades.tamanio()];
        int i;
        int posicion = 0;
        int cargas = 0, cargasAux = 0;
        for (i = 0; i < ciudades.tamanio(); i++) {
            if (ciudades.elemento(i).dato().equals(ciudad1)) {
                posicion = i;
                break;
            }
        }
        DFS5(camino, visitados, posicion, ciudad2, tanqueAuto, cargas, cargasAux, tanqueAuto, l);
        return camino;
    }

    void DFS5(ListaGenerica<String> res, boolean[] visitados, int posicion, String ciudad2, int tanqueAuto, int cargas,
            int cargasAux, int tanqueAutoMax, ListaGenerica<String> l) {

        Vertice<String> v = mapaCiudades.listaDeVertices().elemento(posicion);
        visitados[posicion] = true;
        l.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if (cargasAux < cargas || res.tamanio() == 0) {
                Copia(res, l);
                cargas = cargasAux;
            }
        } else {
            ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                Arista<String> arista = ady.proximo();
                if (!visitados[arista.verticeDestino().posicion()]) {
                    if ((tanqueAuto - arista.peso() < 0) && (tanqueAutoMax > arista.peso())) {
                        tanqueAuto = tanqueAutoMax;
                        cargasAux++;
                    }
                    if ((tanqueAutoMax > arista.peso())) {
                        DFS5(res, visitados, arista.verticeDestino().posicion(), ciudad2, tanqueAuto - arista.peso(),
                                cargas, cargasAux, tanqueAutoMax, l);
                        visitados[arista.verticeDestino().posicion()] = false;
                        l.eliminarEn(l.tamanio() - 1);
                    }
                }
            }
        }
    }
}

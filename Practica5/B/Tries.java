package Practica5.B;

import Clases.ArbolGeneral.ArbolGeneral;
import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class Tries {
    private ArbolGeneral<Character> trie;

    public Tries() {
        this.trie = new ArbolGeneral<Character>(null);
    }

    public Tries(ArbolGeneral<Character> trie) {
        this.trie = trie;
    }

    public ArbolGeneral<Character> agregarPalabra(String palabra) {
        ArbolGeneral<Character> arbol_aux = this.trie;

        for (int i = 0; i < palabra.length(); i++) {
            Character aux = palabra.charAt(i);
            ListaGenerica<ArbolGeneral<Character>> hijos = arbol_aux.getHijos();
            hijos.comenzar();

            for (int k = 0; k < hijos.tamanio(); k++) { // agrego un hijo nuevo y muevo los datos de todos los//

                if (hijos.elemento(k).getDato() == aux) {
                    arbol_aux = hijos.elemento(k);
                    break;
                }
                if (hijos.elemento(k).getDato() > aux) {
                    hijos.agregarEn(new ArbolGeneral<Character>(aux), k);
                    arbol_aux = hijos.elemento(k);
                    break;
                }
                if (k == hijos.tamanio() - 1) {
                    hijos.agregarFinal(new ArbolGeneral<Character>(aux));
                    arbol_aux = hijos.elemento(k + 1);
                    break;
                }
            }
            if (hijos.esVacia()) {
                hijos.agregarInicio(new ArbolGeneral<Character>(aux));
                arbol_aux = hijos.elemento(0);

            }

        }

        return arbol_aux;
    }

    public ListaGenerica<StringBuilder> palabrasQueEmpiezanCon(String prefijo) {
        ListaGenerica<ArbolGeneral<Character>> hijos = this.trie.getHijos();
        ListaGenerica<StringBuilder> lista = new ListaGenericaEnlazada<StringBuilder>();
        hijos.comenzar();
        for (int i = 0; i < prefijo.length(); i++) {
            Character aux = prefijo.charAt(i);
            for (int k = 0; k < hijos.tamanio(); k++) {
                if (hijos.elemento(k).getDato() == aux) {
                    hijos = hijos.elemento(k).getHijos();
                    hijos.comenzar();
                    break;
                } else if (k == hijos.tamanio() - 1) {
                    System.out.println("entro null");
                    return null;
                }
            }
        }

        StringBuilder aux = new StringBuilder(prefijo);
        this.palabrasQueEmpiezanCon(lista, hijos, aux);

        return lista;
    }

    private void palabrasQueEmpiezanCon(ListaGenerica<StringBuilder> lista,
            ListaGenerica<ArbolGeneral<Character>> hijos, StringBuilder prefijo) {
        hijos.comenzar();
        for (int i = 0; i < hijos.tamanio(); i++) {
            prefijo.append(hijos.elemento(i).getDato());
            System.out.println(prefijo);
            if (hijos.elemento(i).tieneHijos()) {
                this.palabrasQueEmpiezanCon(lista, hijos.elemento(i).getHijos(), prefijo);
            } else {
                System.out.println("es hoja");
                lista.agregarFinal(new StringBuilder(prefijo));
            }
            prefijo.deleteCharAt(prefijo.length() - 1);
        }
    }

    public void imprimirporNivel() {
        Cola<ArbolGeneral<Character>> cola = new Cola<ArbolGeneral<Character>>();
        ArbolGeneral<Character> arbol_aux;
        cola.encolar(this.trie);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                System.out.print(arbol_aux.getDato() + " ");
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Character>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                System.out.println();
            }
        }
    }

}
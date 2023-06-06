package Clases.ArbolBinario.utils;
public class Utiles {
    public Utiles() {
    }

    int sumaMaximaVertical(ArbolBinario<Integer> arbol, int max, int suma) {
        if (!arbol.esHoja()) {
            suma += arbol.getDato();
            if (arbol.tieneHijoIzquierdo()) {
                max = sumaMaximaVertical(arbol.getHijoIzquierdo(), max, suma);
            }
            if (arbol.tieneHijoDerecho()) {
                max = sumaMaximaVertical(arbol.getHijoDerecho(), max, suma);
            }

        } else {
            suma += arbol.getDato();
            if (suma > max) {
                max = suma;
            }
        }

        return max;
    }

    public int recorridoPorNiveles(ArbolBinario<Integer> arbol) {
        int max = 0;
        int suma = 0;
        Cola<ArbolBinario<Integer>> cola = new Cola<ArbolBinario<Integer>>();
        cola.encolar(arbol);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol = cola.desencolar();
            if (arbol != null) {
                System.out.print(arbol.getDato());
                suma += arbol.getDato();
                if (arbol.tieneHijoIzquierdo()) {
                    cola.encolar(arbol.getHijoIzquierdo());
                }
                if (arbol.tieneHijoDerecho()) {
                    cola.encolar(arbol.getHijoDerecho());
                }
            } else {
                if (!cola.esVacia()) {
                    System.out.println();
                    cola.encolar(null);
                    if (suma > max) {
                        max = suma;
                    }
                    suma = 0;
                }
            }
        }
        if (suma > max) {
            max = suma;
        }
        return max;
    }

    public ListaGenericaEnlazada<Integer> trayectoriaPesada1(ArbolBinario<Integer> abinario) {
        ListaGenericaEnlazada<Integer> lista = new ListaGenericaEnlazada<Integer>();
        ListaGenericaEnlazada<Integer> cont = new ListaGenericaEnlazada<Integer>();
        // int p;
        // lista.agregarInicio(0);
        if (!abinario.esHoja()) {

            if (abinario.tieneHijoIzquierdo()) {
                System.out.println("va a la izquierda");
                lista = trayectoriaPesada1(abinario.getHijoIzquierdo());
                System.out.println("vuelve al nodo anterior");

            }

            if (abinario.tieneHijoDerecho()) {
                System.out.println("va a la derecha");
                lista = trayectoriaPesada1(abinario.getHijoDerecho());
                System.out.println("vuelve al nodo anterior");

            }
            // p = lista.elemento(0);
            // lista.eliminarEn(0);
            // lista.agregarInicio(p + 1);
            System.out.println("lista tamanio: " + lista.tamanio());

        } else {

            lista.agregarFinal(abinario.getDato() * 2);
            System.out.println("agrega el elemento al final de la lista para usarlo para el calculo, en hoja: "
                    + (abinario.getDato() * 2));

        }

        return lista;
    }

    public ListaGenericaEnlazada<Integer> trayectoriaPesada2(ArbolBinario<Integer> arbol) {
        ListaGenericaEnlazada<Integer> res = new ListaGenericaEnlazada<Integer>();
        int nivel = 0;
        int suma = 0;
        trayectoriaPesada(arbol, res, nivel, suma);
        return res;
    }

    public void trayectoriaPesada(ArbolBinario<Integer> arbol, ListaGenericaEnlazada<Integer> res, int nivel,
            int suma) {
        if (arbol.esHoja()) {
            System.out.println(arbol.getDato());
            System.out.println("nivel: " + nivel);
            System.out.println(nivel * arbol.getDato() + suma);
            Integer valor = (nivel * arbol.getDato()) + suma;
            res.agregarFinal(valor);
        } else {
            Integer miSuma = suma + (nivel * arbol.getDato());
            nivel++;
            if (arbol.tieneHijoIzquierdo()) {
                trayectoriaPesada(arbol.getHijoIzquierdo(), res, nivel, miSuma);
            }
            if (arbol.tieneHijoDerecho()) {
                trayectoriaPesada(arbol.getHijoDerecho(), res, nivel, miSuma);
            }
        }
    }
}
package Clases.ArbolBinario;

import Clases.ListaGenerica.ListaGenerica;
import Clases.ListaGenerica.ListaGenericaEnlazada;
import Clases.ListaGenerica.utils.Cola;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;
	private ArbolBinario<T> hijoDerecho;

	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	public boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esLleno() {
		Cola<ArbolBinario<T>> cola = new Cola<ArbolBinario<T>>();
		boolean lleno = true;
		cola.encolar(this);
		while (!cola.esVacia() && lleno) {
			ArbolBinario<T> arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.getHijoIzquierdo() == null && arbol.getHijoDerecho() == null) {
					continue;
				} else if (arbol.getHijoIzquierdo() != null && arbol.getHijoDerecho() != null) {
					cola.encolar(arbol.getHijoIzquierdo());
					cola.encolar(arbol.getHijoDerecho());
				} else {
					lleno = false;
				}
			}
		}
		return lleno;
	}

	boolean esCompleto() {
		return false;
	}

	// imprime el arbol en preorden
	public void printPreorden() {
		if (!esHoja()) {
			System.out.println(this.getDato());
			if (tieneHijoIzquierdo()) {
				getHijoIzquierdo().printPreorden();
			}
			if (tieneHijoDerecho()) {
				getHijoDerecho().printPreorden();
			}

		} else
			System.out.println(this.getDato());
	}

	// imprime el arbol en postorden
	public void printInorden() {
		if (!esHoja()) {
			if (tieneHijoIzquierdo()) {
				getHijoIzquierdo().printInorden();
			}
			System.out.println(this.getDato());
			if (tieneHijoDerecho()) {
				getHijoDerecho().printInorden();
			}

		} else
			System.out.println(this.getDato());
	}

	// imprime el arbol en postorden
	public void printPostorden() {
		if (!esHoja()) {
			if (tieneHijoIzquierdo()) {
				getHijoIzquierdo().printPostorden();
			}
			if (tieneHijoDerecho()) {
				getHijoDerecho().printPostorden();
			}
			System.out.println(this.getDato());

		} else
			System.out.println(this.getDato());
	}

	public void recorridoPorNiveles() {

	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		if (!esHoja()) {
			if (this.tieneHijoIzquierdo()) {
				l = this.getHijoIzquierdo().frontera();
			}
			if (tieneHijoDerecho()) {
				l = this.getHijoDerecho().frontera();

			}
		} else {
			l.agregarFinal(this.getDato());
		}
		return l;
	}

	public int contarHojas() {
		int cont = 0;
		if (!esHoja()) {
			if (tieneHijoIzquierdo()) {
				cont += getHijoIzquierdo().contarHojas();
			}
			if (tieneHijoDerecho()) {
				cont += getHijoDerecho().contarHojas();
			}

		} else
			return 1;
		return cont;
	}

}

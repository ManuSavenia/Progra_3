package Practica4;

import Clases.ArbolBinario.ArbolBinario;

public class Main {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioA = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdo = new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> nietoIzquierdo = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> nietoDerecho = new ArbolBinario<Integer>(4);
		hijoIzquierdo.agregarHijoIzquierdo(nietoIzquierdo);
		hijoIzquierdo.agregarHijoDerecho(nietoDerecho);
		hijoDerecho.agregarHijoIzquierdo(nietoIzquierdo);
		hijoDerecho.agregarHijoDerecho(nietoDerecho);
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		int hojas;
		boolean lleno;
		hojas = arbolBinarioA.contarHojas();
		System.out.println("La cantidad de hojas es: " + hojas);
		lleno = (arbolBinarioA.esLleno());
		System.out.println("El arbol es lleno: " + lleno);
	}
}

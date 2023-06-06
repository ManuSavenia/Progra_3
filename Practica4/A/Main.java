package Practica4.A;

import Clases.ArbolBinario.ArbolBinario;

public class Main {
	public static void main(String[] args) {
		ArbolBinario<Integer> arbolBinarioB = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdoB = new ArbolBinario<Integer>(2);
		hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
		hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
		ArbolBinario<Integer> hijoDerechoB = new ArbolBinario<Integer>(6);
		hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

		int hojas;
		hojas = arbolBinarioB.contarHojas();
		System.out.println("La cantidad de hojas es: " + hojas);
		System.out.println(arbolBinarioB.frontera());
		//lleno = (arbolBinarioA.esLleno());
		//System.out.println("El arbol es lleno: " + lleno);
	}
}

package Practica4.B;

import Clases.ArbolBinario.ArbolBinario;
import Clases.ArbolBinario.utils.Adivinanza;
import Clases.ArbolBinario.utils.Utiles;

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
		arbolBinarioA.agregarHijoIzquierdo(hijoIzquierdo);
		arbolBinarioA.agregarHijoDerecho(hijoDerecho);

		Utiles utiles = new Utiles();
		int max2;
		System.out.println(utiles.sumaMaximaVertical(arbolBinarioA, 0, 0));
		max2 = utiles.recorridoPorNiveles(arbolBinarioA);
		System.out.println("------------------------------------------------------");
		System.out.println(max2);

		Adivinanza adivinanza = new Adivinanza();
		ArbolBinario<String> arbolBinarioB = new ArbolBinario<String>("¿Es un animal?");
		ArbolBinario<String> hijoIzquierdoB = new ArbolBinario<String>("¿Es un perro?");
		ArbolBinario<String> hijoDerechoB = new ArbolBinario<String>("¿Es un reptil?");
		ArbolBinario<String> nietoIzquierdoC = new ArbolBinario<String>("¿Es malo?");
		ArbolBinario<String> nietoIzquierdoB = new ArbolBinario<String>("si");
		ArbolBinario<String> nietoDerechoB = new ArbolBinario<String>("no");
		nietoIzquierdoC.agregarHijoIzquierdo(nietoIzquierdoB);
		nietoIzquierdoC.agregarHijoDerecho(nietoDerechoB);
		hijoIzquierdoB.agregarHijoIzquierdo(nietoIzquierdoC);
		hijoIzquierdoB.agregarHijoDerecho(nietoDerechoB);
		hijoDerechoB.agregarHijoIzquierdo(nietoIzquierdoB);
		arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
		arbolBinarioB.agregarHijoDerecho(hijoDerechoB);

		System.out.println(adivinanza.secuenciaConMasPreguntas(arbolBinarioB));
		System.out.println(utiles.trayectoriaPesada2(arbolBinarioA));
	}
}

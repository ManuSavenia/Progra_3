package Practica5.B;
public class RedDeAguaPotable {
    private ArbolGeneral<Double> tuberias;

    public RedDeAguaPotable() {
    }

    public RedDeAguaPotable(ArbolGeneral<Double> tuberias) {
        this.tuberias = tuberias;
    }

    public Double minimoCaudal(ArbolGeneral<Double> tuberias, Double litros) {
        Double minimo = 9999.9;
        Cola<ArbolGeneral<Double>> cola = new Cola<ArbolGeneral<Double>>();
        ArbolGeneral<Double> arbol_aux = new ArbolGeneral<Double>(null);
        // agregar n a la raiz de tuberias
        tuberias.setDato(litros);
        cola.encolar(tuberias);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (arbol_aux != null) {
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Double>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    ArbolGeneral<Double> D = new ArbolGeneral<Double>(arbol_aux.getDato() / hijos.tamanio());
                    for (int i = 0; i < hijos.tamanio(); i++) {
                        hijos.elemento(i).setDato(D.getDato());
                        cola.encolar(hijos.proximo());
                    }

                } else {
                    if (arbol_aux.getDato() < minimo)
                        minimo = arbol_aux.getDato();
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
            }
        }
        return minimo;
    }
}
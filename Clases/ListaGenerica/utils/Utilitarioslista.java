package Clases.ListaGenerica.utils;
public class Utilitarioslista {

    public static ListaDeEnterosEnlazada OrdenarNashe(ListaDeEnterosEnlazada l1, int p, int r) {
        int q;
        if (p < r) {
            q = (p + r) / 2;
            OrdenarNashe(l1, p, q);
            l1 = l1.ordenar();
            OrdenarNashe(l1, q + 1, r);
            l1 = l1.ordenar();
            l1.combinarOrdenado(l1);
        }
        return l1;
    }
}

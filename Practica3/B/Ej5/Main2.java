package Practica3.B.Ej5;
public class Main2 {
    public static void main(String[] args) {
        ListaDeEnterosEnlazada lista1 = new ListaDeEnterosEnlazada();
        lista1.comenzar();
        lista1.agregarFinal(5);
        lista1.agregarFinal(1);
        lista1.agregarFinal(4);
        lista1.agregarFinal(3);
        lista1.agregarFinal(2);
        lista1.agregarFinal(6);
        lista1 = lista1.ordenar();
        lista1 = Utilitarioslista.OrdenarNashe(lista1, 0, lista1.tamanio());
        System.out.println(lista1.toString());
    }
}

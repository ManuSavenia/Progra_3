public class MainEj3 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<Integer>();
        pila.apilar(78);
        pila.apilar(98);
        pila.apilar(99);
        pila.apilar(34);
        pila.apilar(521);
        System.out.println(pila.toString());
        pila.desapilar();
        pila.desapilar();
        pila.desapilar();
        pila.desapilar();
        System.out.println(pila.toString());
        System.out.println(pila.tope());

    }
}

package Practica3.B.Ej4;
public class MainEj4 {
    public static void main(String[] args) {
        Pila<Character> pila = new Pila<Character>();
        String nashe = "}}}}";
        System.out.println(armonioso(nashe, pila));
    }

    public static boolean armonioso(String cadena, Pila<Character> pila) {
        char l, c;
        for (int i = 0; i < cadena.length(); i++) {
            c = cadena.charAt(i);
            if ((c == '{') || (c == '(') || (c == '[')) {
                pila.apilar(c);
            }
            if ((c == '}') || (c == ')') || (c == ']')) {
                if (pila.esVacia()) {
                    return false;
                }
                l = pila.desapilar();
                if (!((l == '{' && c == '}') || (l == '(' && c == ')') || (l == '[' && c == ']'))) {
                    return false;
                }
            }
        }

        return true;
    }

}

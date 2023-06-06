package Practica7.A;
public class DeltaTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Maldivas");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Hawai");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Bali");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Creta");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Ibiza");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Sicilia");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Galápagos");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Tasmania");
        Vertice<String> v9 = new VerticeImplListAdy<String>("Islas Vírgenes Británicas");
        Vertice<String> v10 = new VerticeImplListAdy<String>("Jamaica");

        Grafo<String> islas = new GrafoImplListAdy<String>();
        islas.agregarVertice(v1);
        islas.agregarVertice(v2);
        islas.agregarVertice(v3);
        islas.agregarVertice(v4);
        islas.agregarVertice(v5);
        islas.agregarVertice(v6);
        islas.agregarVertice(v7);
        islas.agregarVertice(v8);
        islas.agregarVertice(v9);
        islas.agregarVertice(v10);

        islas.conectar(v1, v2, 3);
        islas.conectar(v2, v1, 3);
        islas.conectar(v2, v3, 2);
        islas.conectar(v3, v2, 2);
        islas.conectar(v3, v4, 4);
        islas.conectar(v4, v3, 4);
        islas.conectar(v3, v5, 8);
        islas.conectar(v5, v3, 8);
        islas.conectar(v5, v6, 9);
        islas.conectar(v6, v5, 9);

        islas.conectar(v1, v7, 11);
        islas.conectar(v7, v1, 11);
        islas.conectar(v7, v8, 1);
        islas.conectar(v8, v7, 1);
        islas.conectar(v8, v10, 1);
        islas.conectar(v10, v8, 1);
        islas.conectar(v7, v9, 15);
        islas.conectar(v9, v7, 15);
        islas.conectar(v7, v10, 1100);
        islas.conectar(v10, v7, 1100);
        Delta D = new Delta();

        System.out.println(
                "El numero maximo de islas que se puede recorrer con un unico boleto es " + D.maxIslasDistintas(islas)); // RTA:
                                                                                                                         // 5

        RutaMinima<String> rutMin = D.caminoMasCorto(islas, "Hawai", "Bali");
        System.out.println("El camino mas corto para llegar de Hawai a Jamaica es " + rutMin.getRuta().toString()); 
        if (rutMin.getBoletoUnico())
            System.out.println("Solo es necesario comprar un unico boleto.");
        else
            System.out.println("Es necesario comprar mas de un boleto.");

    }
}
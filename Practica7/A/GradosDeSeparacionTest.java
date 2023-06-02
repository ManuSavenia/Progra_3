public class GradosDeSeparacionTest {
    public static void main(String[] args) {
        Vertice<String> v1 = new VerticeImplListAdy<String>("Lionel Messi");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Agustin Murray");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Ivan Polanis");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Mateo Romero");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Manu Savenia");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Ramiro Cabral");
        Vertice<String> v7 = new VerticeImplListAdy<String>("Gonzalo Blasco");
        Vertice<String> v8 = new VerticeImplListAdy<String>("Juan Roman Riquelme");
        Vertice<String> v9 = new VerticeImplListAdy<String>("Abdul Bari");
        Vertice<String> v10 = new VerticeImplListAdy<String>("Duki");

        Grafo<String> red = new GrafoImplListAdy<String>();
        red.agregarVertice(v1);
        red.agregarVertice(v2);
        red.agregarVertice(v3);
        red.agregarVertice(v4);
        red.agregarVertice(v5);
        red.agregarVertice(v6);
        red.agregarVertice(v7);

        red.conectar(v1, v2, 1);
        red.conectar(v2, v1, 1);
        red.conectar(v1, v4, 1);
        red.conectar(v4, v1, 1);
        red.conectar(v1, v3, 1);
        red.conectar(v3, v1, 1);
        red.conectar(v2, v5, 1);
        red.conectar(v5, v2, 1);
        red.conectar(v2, v4, 1);
        red.conectar(v4, v2, 1);
        red.conectar(v4, v3, 1);
        red.conectar(v3, v4, 1);
        red.conectar(v4, v7, 1);
        red.conectar(v7, v4, 1);
        red.conectar(v3, v6, 1);
        red.conectar(v6, v3, 1);
        red.conectar(v5, v7, 1);
        red.conectar(v7, v5, 1);
        red.conectar(v7, v8, 1);
        red.conectar(v8, v7, 1);
        red.conectar(v8, v9, 1);
        red.conectar(v9, v8, 1);
        red.conectar(v8, v10, 1);
        red.conectar(v10, v8, 1);

        GradosDeSeparacion aux = new GradosDeSeparacion();
        System.out.println("El grado de separacion maxima es: " + aux.maximoGradoDeSeparacion(red));

    }
}
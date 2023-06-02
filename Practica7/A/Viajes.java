public class Viajes {
    ListaGenerica<String> camino;
    int menorPeso;

    public Viajes() {
        this.camino = new ListaGenericaEnlazada<String>();
        this.menorPeso = Integer.MAX_VALUE;
    }

    public Viajes(ListaGenerica<String> camino, int menorPeso) {
        this.camino = camino;
        this.menorPeso = menorPeso;
    }

    public ListaGenerica<String> getCamino() {
        return camino;
    }

    public void setCamino(ListaGenerica<String> camino) {
        this.camino = camino;
    }

    public int getMenorPeso() {
        return menorPeso;
    }

    public void setMenorPeso(int menorPeso) {
        this.menorPeso = menorPeso;
    }

    public void agregarPuntoDeInteres(String puntoDeInteres) {
        this.camino.agregarFinal(puntoDeInteres);
    }

    public void eliminarPuntoDeInteres(int i) {
        this.camino.eliminarEn(i);
    }

}
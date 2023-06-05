public class Costo {
    private int costoMinimo;
    private int PosVerticeAnterior;

    public Costo() {
    }

    public Costo(int costoMinimo, int PosVerticeAnterior) {
        this.costoMinimo = costoMinimo;
        this.PosVerticeAnterior = PosVerticeAnterior;
    }

    public int getCostoMinimo() {
        return costoMinimo;
    }

    public void setCostoMinimo(int costoMinimo) {
        this.costoMinimo = costoMinimo;
    }

    public int getPosVerticeAnterior() {
        return PosVerticeAnterior;
    }

    public void setPosVerticeAnterior(int PosVerticeAnterior) {
        this.PosVerticeAnterior = PosVerticeAnterior;
    }
    
    public String toString(){
        return "Costo minimo: " + this.costoMinimo + " Posicion vertice anterior: " + this.PosVerticeAnterior;
    }

}



package Clases.Grafos.utils;

public class CostoTodosMinimos {
    private Costo Data = new Costo();
    private int repetidos;


    public CostoTodosMinimos() {
    }

    public CostoTodosMinimos(Costo Data, int repetidos) {
        this.Data = Data;
        this.repetidos = repetidos;
    }

    public Costo getData() {
        return Data;
    }

    public void setData(Costo Data) {
        this.Data = Data;
    }

    public int getRepetidos() {
        return repetidos;
    }

    public void setRepetidos(int repetidos) {
        this.repetidos = repetidos;
    }

    public String toString() {
        return "Costo minimo: " + this.Data.getCostoMinimo() + " Posicion vertice anterior: " + this.Data.getPosVerticeAnterior() + " Repetidos: " + this.repetidos;
    }
}

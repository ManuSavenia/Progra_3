package Parciales;

public class Datos2 {
    private String nombreC;
    private int Fase;

    public Datos2(){}

    public Datos2(String nombreC, int Fase){
        this.nombreC = nombreC;
        this.Fase = Fase;
    }

    public String getnombreC() {
        return this.nombreC;
    }

    public int getFase() {
        return this.Fase;
    }

    public void setnombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public void setFase(int Fase) {
        this.Fase = Fase;
    }
}

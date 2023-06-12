package Parciales;

public class Datos {
    private String nombreC;
    private int Estadia;

    public Datos(){}
    public Datos(String nombreC, int Estadia){
        this.nombreC = nombreC;
        this.Estadia = Estadia;
    }
    public String getnombreC(){
        return this.nombreC;
    }
    public int getEstadia(){
        return this.Estadia;
    }
    public void setnombreC(String nombreC){
        this.nombreC = nombreC;
    }
    public void setEstadia(int Estadia){
        this.Estadia = Estadia;
    }
}




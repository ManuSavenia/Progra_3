package Practica2;
public class tablet {
  
	  private String marca;
	  private String sistemaOperativo;
	  private String modelo;
	  private double costo;
	  private float pulgadas; 
	  
	

	public void tablet() {}
	  
	  public tablet(String marca,String sistemaOperativo, String modelo, double costo, float pulgadas) {
	        this.modelo = modelo;
	        this.marca = marca;
	        this.costo = costo;
	        this.sistemaOperativo = sistemaOperativo;
	        this.pulgadas = pulgadas;
	    }
	  
	  
	  public String devolverDatos() {
	        String datos = "Modelo: " + modelo + ", marca: " + marca + ", Precio: " + costo + ",Sistema operativo: " + sistemaOperativo +",Pulgadas: " +pulgadas;
	        return datos;
	    }
	
	  
	  
	  

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		sistemaOperativo = sistemaOperativo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public float getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(float pulgadas) {
		this.pulgadas = pulgadas;
	}
	  
	  
	  
  }


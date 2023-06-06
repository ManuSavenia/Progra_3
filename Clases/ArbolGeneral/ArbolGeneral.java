

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}
	
	public Integer altura() {
		if(this.esHoja())
		  return 0;
		else {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			hijos.comenzar();
			Integer altura = 0;
			while(!hijos.fin()) {
				ArbolGeneral<T> hijo = hijos.proximo();
				Integer alturaHijo = hijo.altura();
				if(alturaHijo > altura)
					altura = alturaHijo;
			}
			return altura + 1;
		}

	}

		public Integer nivel(Integer dato){
			if(this.getDato().equals(dato)){
				return 0;
			}
			else{
				if(this.tieneHijos()){
					
					ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
					hijos.comenzar();
					while(!hijos.fin()){
						ArbolGeneral<T> hijo = hijos.proximo();
						Integer nivelHijo = hijo.nivel(dato);
						if(nivelHijo!=-1)
							return nivelHijo+1;
					}
			}
			return -1;
		}
	}

	public Integer ancho() {
		ListaGenerica<T> result = new ListaGenericaEnlazada<T>();
		Cola<ArbolGeneral<T>> cola= new Cola<ArbolGeneral<T>>();
 		ArbolGeneral<T> arbolAux;
		cola.encolar(this);
		cola.encolar(null);
		int max=0;
		while(!cola.esVacia()){
			arbolAux = cola.desencolar();
			if(arbolAux!=null){
				result.agregarFinal(arbolAux.getDato());
				if(arbolAux.tieneHijos()){
					ListaGenericaEnlazada<ArbolGeneral<T>> hijos = (ListaGenericaEnlazada<ArbolGeneral<T>>) arbolAux.getHijos();
					hijos.comenzar();
					while(!hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}
			}
			else{
				if(!cola.esVacia()){
					cola.encolar(null);
					if(max < result.tamanio())
						max = result.tamanio();
					result = new ListaGenericaEnlazada<T>();
				}
			}
		}

		return max;
	}

	public boolean incluye(Integer dato){
			if(this.getDato().equals(dato)){
				return true;
			}
			else{
				if(this.tieneHijos()){
					
					ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
					hijos.comenzar();
					while(!hijos.fin()){
						ArbolGeneral<T> hijo = hijos.proximo();
						if(hijo.incluye(dato))
							return true;
					}
				}
				return false;
			}
		}

		
	}
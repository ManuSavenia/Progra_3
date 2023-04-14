public class Empresa{
    private ArbolGeneral<Empleado> empleados;


    public Empresa(){
    }
    public Empresa(ArbolGeneral<Empleado> empleados){
        this.empleados = empleados;
    }
    public int empleadosPorCategoria(int categoria){
        int categoriaAct=0;
        int cant=0;
        Cola<ArbolGeneral<Empleado>> cola= new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if(arbol_aux==null){
                categoriaAct++;
                arbol_aux=cola.desencolar();
            }else{
              cant++;
              if(arbol_aux.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                }
                cola.encolar(null);
                if (categoriaAct == categoria) {
                return cant;
            }
            categoriaAct++;
            cant = 0;
            }
        }
        }
        return cant;
        }
        
    


    public void categoriaConMasempleados(){
       
    }


    public void cantidadTotalDEempleados(){
       
    }

    public void reemplazarPresidente(){
       
    }



    public void porNivel(){
        ListaGenerica<Empleado> result = new ListaGenericaEnlazada<Empleado>();
        Cola<ArbolGeneral<Empleado>> cola= new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            result.agregarFinal(arbol_aux.getDato());
            if (arbol_aux.tieneHijos()) {
                ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.encolar(hijos.proximo());
                }
                cola.encolar(null);
            }
        }
        System.out.println(result.toString());
    }

}
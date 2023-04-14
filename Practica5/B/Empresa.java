public class Empresa {
    private ArbolGeneral<Empleado> empleados;

    public Empresa() {
    }

    public Empresa(ArbolGeneral<Empleado> empleados) {
        this.empleados = empleados;
    }

    public int empleadosPorCategoria(int categoria) {
        int categoriaAct = 1;
        int cant = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                cant++;
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }

                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                if (categoriaAct == categoria) {
                    return cant;
                }
                categoriaAct++;
                cant = 0;
            }
        }
        return cant;
    }

    public int categoriaConMasempleados() {
        int categoriaAct = 1;
        int cant = 0;
        int categoriaMax = 0;
        int cantMax = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                cant++;
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }

                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                if (cant > cantMax) {
                    cantMax = cant;
                    categoriaMax = categoriaAct;
                }
                categoriaAct++;
                cant = 0;
            }
        }
        return categoriaMax;
    }

    public int cantidadTotalDeEmpleados() {
        int total = 0;
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                total++;
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }

                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
            }
        }
        return total;
    }

    public void reemplazarPresidente() {
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        int antiguedadMax = 0;
        int categoriaAct = 1;
        ArbolGeneral<Empleado> promovido = null;
        String nombreReemplazo = "";
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                    if (arbol_aux.getDato().getAntiguedad() > antiguedadMax) {
                        antiguedadMax = arbol_aux.getDato().getAntiguedad();
                        nombreReemplazo = arbol_aux.getDato().getNombre();
                        promovido = arbol_aux;
                    }
                }
                if (arbol_aux.getDato().getAntiguedad() > antiguedadMax) {
                    antiguedadMax = arbol_aux.getDato().getAntiguedad();
                    nombreReemplazo = arbol_aux.getDato().getNombre();
                    promovido = arbol_aux;
                    if (!(promovido.tieneHijos())) {
                        arbol_aux.eliminarHijo(promovido);
                    }
                }

            } else if (!cola.esVacia()) {
                cola.encolar(null);
                this.empleados.getDato().setNombre(nombreReemplazo);
                this.empleados.getDato().setAntiguedad(antiguedadMax);
                this.empleados.getDato().setCategoria(categoriaAct);
                categoriaAct++;
                if (promovido != null) {
                    promovido.eliminarHijo(promovido);
                }

            }
        }
    }

    public void reemplazarPresidente2() {
        ArbolGeneral<Empleado> aux = this.empleados;

        if (aux.esHoja()) {
            aux = null;
        }

        while (true) {
            ArbolGeneral<Empleado> emp = aux.getHijos().elemento(0);
            for (int i = 1; i < aux.getHijos().tamanio(); i++) {
                if (emp.getDato().getAntiguedad() < aux.getHijos().elemento(i).getDato().getAntiguedad()) {
                    emp = aux.getHijos().elemento(i);
                }
            }
            emp.getDato().setCategoria(emp.getDato().getCategoria() - 1);
            aux.setDato(emp.getDato());
            if (emp.esHoja()) {
                aux.eliminarHijo(emp);
                break;
            }
            aux = emp;
        }

    }

    public void imprimirporNivel() {
        Cola<ArbolGeneral<Empleado>> cola = new Cola<ArbolGeneral<Empleado>>();
        ArbolGeneral<Empleado> arbol_aux;
        cola.encolar(this.empleados);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbol_aux = cola.desencolar();
            if (!(arbol_aux == null)) {
                System.out.print(arbol_aux.getDato().getNombre() + " ");
                if (arbol_aux.tieneHijos()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            } else if (!cola.esVacia()) {
                cola.encolar(null);
                System.out.println();
            }
        }
    }
}
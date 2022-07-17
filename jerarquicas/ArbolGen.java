/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;


public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean exito = false;
        NodoGen nuevoNodo;

        if (this.raiz == null) {
            nuevoNodo = new NodoGen(elemNuevo, null, null);
            this.raiz = nuevoNodo;
            exito = true;
        } else {
            //busco al obtenerNodo
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);

            if (padre != null) {

                exito = true;

                if (padre.getHijoIzquierdo() == null) {
                    nuevoNodo = new NodoGen(elemNuevo, null, null);
                    padre.setHijoIzquierdo(nuevoNodo);

                } else {
                    NodoGen hijoDerecho = padre.getHijoIzquierdo();
                    while (hijoDerecho.getHermanoDerecho() != null) {
                        hijoDerecho = hijoDerecho.getHermanoDerecho();
                    }
                    nuevoNodo = new NodoGen(elemNuevo, null, null);
                    hijoDerecho.setHermanoDerecho(nuevoNodo);
                }
            }

        }
        return exito;

    }

    public boolean pertenece(Object aBuscar) {
        boolean existe = false;
        if (aBuscar != null && this.raiz != null) {
            NodoGen x = obtenerNodo(this.raiz, aBuscar);
            if (x != null) {
                existe = true;
            }
        }
        return existe;

    }

    public void vaciar() {
        this.raiz = null;
    }

    private NodoGen obtenerNodo(NodoGen n, Object aBuscar) {
        NodoGen encontrado = null;

        if (n != null) {

            if (n.getElem().equals(aBuscar)) {
                encontrado = n;

            } else {

                if (n.getHijoIzquierdo() != null) {

                    encontrado = obtenerNodo(n.getHijoIzquierdo(), aBuscar);

                }
                if (n.getHermanoDerecho() != null && encontrado == null) {
                    NodoGen drecho = n.getHermanoDerecho();

                    encontrado = obtenerNodo(drecho, aBuscar);

                }

            }
        }

        return encontrado;

    }

    public String toString() {
        return toString(this.raiz);

    }

    private String toString(NodoGen n) {
        String s = " ";

        if (n != null) {
            s = s + n.getElem().toString() + " ==> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s = s + hijo.getElem().toString() + " , ";
                hijo = hijo.getHermanoDerecho();
            }

            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s = s + "\n " + toString(hijo);
                hijo = hijo.getHermanoDerecho();

            }
        }
        return s;

    }

    public ArbolGen clone() {
        ArbolGen arbolClone = new ArbolGen();

        if (this.raiz != null) {
            NodoGen primerElemento = new NodoGen(this.raiz.getElem(), null, null);
            arbolClone.raiz = primerElemento;

            cloneAux(this.raiz.getHijoIzquierdo(), arbolClone.raiz);
        }
        return arbolClone;

    }

    private void cloneAux(NodoGen n, NodoGen clonado) {
        NodoGen aux;
        if (n != null) {

            aux = new NodoGen(n.getElem(), null, null);
            clonado.setHijoIzquierdo(aux);

            if (n.getHijoIzquierdo() != null) {

                cloneAux(n.getHijoIzquierdo(), clonado.getHijoIzquierdo());

            }

            if (n.getHermanoDerecho() != null) {
                //busco her
                NodoGen mover = n.getHermanoDerecho();
                clonado = clonado.getHijoIzquierdo();
                boolean corte = true;
                while (mover != null && corte) {
                    aux = new NodoGen(mover.getElem(), null, null);
                    clonado.setHermanoDerecho(aux);
                    //llamada

                    cloneAux(mover.getHijoIzquierdo(), clonado.getHermanoDerecho());
                    corte = false;
                    if (mover.getHermanoDerecho() != null) {
                        mover = mover.getHermanoDerecho();
                        clonado = clonado.getHermanoDerecho();
                        corte = true;
                    }

                }

            }

        }

    }

    public int altura() {
        int res;

        res = alturaAux(this.raiz);
        return res;

    }

    private int alturaAux(NodoGen n) {
        int res, aux;
        NodoGen hijo;
        res = -1;
        aux = -1;
        if (n != null) {
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                aux = alturaAux(hijo);
                if (aux > res) {
                    res = aux;
                }

                hijo = hijo.getHermanoDerecho();
            }
            res++;

        }

        return res;

    }

    public Object padre(Object hijo) {
        Object padreEncontrado = null;
        NodoGen nodoPadre = null;
        if (hijo != null && this.raiz != null) {
            if (!this.raiz.getElem().equals(hijo)) {
                nodoPadre = padreAux(this.raiz.getHijoIzquierdo(), this.raiz, hijo);

            }

            if (nodoPadre != null) {
                padreEncontrado = nodoPadre.getElem();
            }
        }
        return padreEncontrado;
    }

    private NodoGen padreAux(NodoGen n, NodoGen anterior, Object hijo) {
        NodoGen padre = null;

        if (n != null) {

            if (n.getElem().equals(hijo)) {
                padre = anterior;
            } else {

                padre = padreAux(n.getHijoIzquierdo(), anterior.getHijoIzquierdo(), hijo);

                if (n.getHermanoDerecho() != null) {
                    NodoGen aux = n.getHermanoDerecho();
                    while (padre == null && aux != null) {

                        if (aux.getElem().equals(hijo)) {
                            padre = anterior;

                        } else {

                            padre = padreAux(aux.getHijoIzquierdo(), aux, hijo);

                            if (padre == null) {
                                aux = aux.getHermanoDerecho();
                            }

                        }

                    }
                }

            }
        }
        return padre;

    }

    public boolean sonFrontera(Lista ls) {
        boolean esFrontera = false;
        if (ls.longitud() > 0 && this.raiz != null) {
            Lista clone = ls.clone();
            sonFronteraAux(this.raiz, clone);

            if (clone.longitud() == 0) {
                esFrontera = true;
            }
        }
        return esFrontera;
    }

    private void sonFronteraAux(NodoGen n, Lista ls) {

        if (n != null && ls.longitud() > 0) {
            sonFronteraAux(n.getHijoIzquierdo(), ls);

            //encontre una hoja
            if (n.getHijoIzquierdo() == null) {

                Object elemento = n.getElem();

                int resLocalizar = ls.localizar(elemento);

                if (resLocalizar != -1) {

                    ls.eliminar(resLocalizar);

                }
            }

            if (n.getHermanoDerecho() != null) {

                //recorro hermanos
                sonFronteraAux(n.getHermanoDerecho(), ls);

            }

        }

    }

    public int nivel(Object elemento) {
        int res = -1;

        if (this.raiz != null && elemento != null) {
            res = nivelAux(this.raiz, elemento);
        }
        return res;
    }

    private int nivelAux(NodoGen n, Object elemento) {
        int res = -1;

        if (n != null) {

            if (n.getElem().equals(elemento)) {

                res = 0;

            } else {
                if (n.getHijoIzquierdo() != null) {
                    res = nivelAux(n.getHijoIzquierdo(), elemento);
                    if (res >= 0) {
                        //empezar a sumar
                        res = res + 1;
                    }
                }
                if (n.getHermanoDerecho() != null && res == -1) {
                    NodoGen mover = n.getHermanoDerecho();
                    res = nivelAux(mover, elemento);
                }

            }

        }
        return res;

    }

    public Lista listarInorden() {
        Lista ls = new Lista();
        listarInordenAux(this.raiz, ls);
        return ls;

    }

    private void listarInordenAux(NodoGen n, Lista ls) {

        if (n != null) {

            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);

            }
            ls.insertar(n.getElem(), ls.longitud() + 1);

            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();

                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();

                }

            }

        }

    }

    public Lista listarPreorden() {
        Lista ls = new Lista();
        listarPreordenAux(this.raiz, ls);

        return ls;

    }

    private void listarPreordenAux(NodoGen n, Lista ls) {

        if (n != null) {

            ls.insertar(n.getElem(), ls.longitud() + 1);
            if (n.getHijoIzquierdo() != null) {
                listarPreordenAux(n.getHijoIzquierdo(), ls);

            }
            if (n.getHermanoDerecho() != null) {
                listarPreordenAux(n.getHermanoDerecho(), ls);
            }

        }

    }

    public Lista listarPosorden() {
        Lista ls = new Lista();
        listarPosordenAux(this.raiz, ls);
        return ls;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {

        if (n != null) {

            if (n.getHijoIzquierdo() != null) {
                listarPosordenAux(n.getHijoIzquierdo(), ls);
            }
            ls.insertar(n.getElem(), ls.longitud() + 1);

            if (n.getHermanoDerecho() != null) {
                listarPosordenAux(n.getHermanoDerecho(), ls);
            }

        }

    }

    public Lista listarPorNiveles() {
        Cola cola = new Cola();
        Lista lista = new Lista();
        cola.poner(this.raiz);
        while (cola.esVacia() != true) {
            NodoGen nodo = (NodoGen) cola.obtenerFrente();
            cola.sacar();
            lista.insertar(nodo.getElem(), lista.longitud() + 1);
            if (nodo.getHijoIzquierdo() != null) {
                cola.poner(nodo.getHijoIzquierdo());
            }
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return lista;
    }

    public Lista ancestros(Object elemento) {

        Lista ls = new Lista();
        if (elemento != null && this.raiz != null) {
            ancestroAux(this.raiz, ls, elemento);
            ls.eliminar(1);

        }
        return ls;
    }

    private void ancestroAux(NodoGen n, Lista ls, Object elemento) {

        if (n != null) {

            if (n.getElem().equals(elemento)) {
                ls.insertar(n.getElem(), ls.longitud() + 1);
            }
            if (n.getHijoIzquierdo() != null && ls.longitud() == 0) {
                ancestroAux(n.getHijoIzquierdo(), ls, elemento);

                if (ls.longitud() > 0) {

                    ls.insertar(n.getElem(), ls.longitud() + 1);
                }
            }
            if (n.getHermanoDerecho() != null && ls.longitud() == 0) {
                NodoGen mover = n.getHermanoDerecho();
                if (mover.getElem().equals(elemento)) {
                    ls.insertar(n.getElem(), ls.longitud() + 1);
                } else {
                    ancestroAux(n.getHermanoDerecho(), ls, elemento);
                }

            }
        }

    }

    public boolean esVacio() {

        return this.raiz == null;
    }

    public void alturaArbol() {
        int valor = 0;
        valor = calcularAlturaAux(this.raiz, 0, valor);
        System.out.println("vlor " + valor);
    }

    private int calcularAlturaAux(NodoGen n, int cant, int res) {

        if (n != null) {

            cant = cant + 1;
            System.out.println(n.getElem() + " altura**** " + cant);
            res = calcularAlturaAux(n.getHijoIzquierdo(), cant, res);
            System.out.println(n.getElem() + " altura " + cant);
            System.out.println("res " + res + " y cant " + cant);
            if (cant > res) {
                res = cant;

                System.out.println("234234 " + res);
            }
            if (n.getHermanoDerecho() != null) {
                NodoGen moverD = n.getHermanoDerecho();
                System.out.println("Nodo izq " + n.getElem());
                System.out.println("primer hermano derecho   " + moverD.getElem());
                while (moverD != null) {

                    if (moverD.getHijoIzquierdo() != null) {
                        System.out.println(moverD.getElem() + " altura " + cant);
                        res = calcularAlturaAux(moverD.getHijoIzquierdo(), cant, res);
                    }
                    moverD = moverD.getHermanoDerecho();

                }
            }

        }
        return res;
    }

    public void alturaArbol2() {
        int valor = 0;
        valor = calcularAlturaAux2(this.raiz, 0);
        System.out.println("vlor " + valor);
    }

    private int calcularAlturaAux2(NodoGen n, int altura) {
        int res, anterior;
        res = 0;
        anterior = 0;
        System.out.println("altura " + altura);
        if (n != null) {

            //   res =1+calcularAlturaAux2(n.getHijoIzquierdo(), altura);
            //A == 1 RES
            // B == 2 RES
            // E == 3 RES
            // NULL ==0 RES
            //     res =calcularAlturaAux2(n.getHijoIzquierdo(), altura)+1;
            //E == 1 RES
            // B == 2 RES
            //A == 3 RES
            res = 1 + calcularAlturaAux2(n.getHijoIzquierdo(), altura);
            //calcularAlturaAux2(n.getHijoIzquierdo(), altura) == res
            System.out.println("res " + res + "  NODO " + n.getElem().toString());

            if (n.getHermanoDerecho() != null) {
                NodoGen moverD = n.getHermanoDerecho();

                while (moverD != null) {

                    if (moverD.getHijoIzquierdo() != null) {

                        anterior = res;
                        res = calcularAlturaAux2(moverD.getHijoIzquierdo(), altura);

                        if (anterior > res) {
                            res = anterior;
                        }

                    }
                    moverD = moverD.getHermanoDerecho();

                }
            }

        }
        return res;
    }

    public boolean esHermanosAnterior(Object a, Object b) {
        boolean res = false;
        if (this.raiz != null && a != null && b != null) {
            res = esHermanosAnteriorAux(this.raiz.getHijoIzquierdo(), a, b);

        }
        return res;
    }

    private boolean esHermanosAnteriorAux(NodoGen n, Object a, Object b) {
        boolean encontrado = false;
        boolean mayor = false;
        boolean corte = true;
        if (n != null) {

            NodoGen aux = n;
            while (aux != null && !encontrado) {
  

                if (aux.getElem().equals(a)) {
                    mayor = true;
                } else {
                    if (mayor && aux.getElem().equals(b)) {
                        encontrado = true;

                    }
                }
        

                aux = aux.getHermanoDerecho();

            }
            while (corte && !encontrado) {
                //bajo por el hijo izquierdo
                encontrado = esHermanosAnteriorAux(n.getHijoIzquierdo(), a, b);

                if (!encontrado && n.getHermanoDerecho() != null) {
                    n = n.getHermanoDerecho();
                } else {
                    corte = false;
                }
            }

        }
        return encontrado;
    }
    
    
    public int suma(int maximo){
        
        
        int cant=0;
        int i=1;
        
        
        if(i<=maximo){
           cant=cant*3;
            cant=cant+suma(maximo);
        }
       
        return cant;
        
    }
    
    
    
    




}

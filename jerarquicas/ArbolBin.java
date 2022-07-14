/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author juanc
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;

    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {

        //Insertar elemNuevo como hijo del primer nodo encontrado en preOrden
        //Igual a elemPadre, como hijo izquierdo (i) o derecho (d), segun
        //lo indique el parametro lugar
        boolean exito = true;
        if (this.raiz == null) {
            //si el arbol esta vacio, ponemos el elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //si no esta vacio, se busca el padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //si el padre exite y no tiene HI se lo agrego

                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));

                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //si el padre existe y no tiene hermano derecho se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        //si el padre no existe o ya tiene hijos da error.
                        exito = false;

                    }

                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscando) {
        //metodo Privado que busca un elemento y devuelve el nodo
        //que tiene. Si no se encuentra buscado devuelve null
        NodoArbol resultado = null;

        if (n != null) {
            if (n.getElem().equals(buscando)) {
                resultado = n;
            } else {
                //no es el buscado: buscar primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscando);
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscando);
                }
            }
        }
        return resultado;
    }

    public Lista listarPosorden() {
        //Metodo que devuelva una Lista, con los elementos ordenados en PosOrden.
        Lista lis = new Lista();
        auxListarPosOrden(this.raiz, lis);
        return lis;

    }

    private void auxListarPosOrden(NodoArbol nodo, Lista lis) {
        //Metodo que carga en una Lista los elementos ordenados en Posorden.
        if (nodo != null) {
            // visita el elemento en el nodo

            auxListarPosOrden(nodo.getIzquierdo(), lis);

            //recorre a su hermano derecho
            auxListarPosOrden(nodo.getDerecho(), lis);//(3)

            //recorre al padre
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }

    }

    public Lista listarInorden() {
        //Metodo que devuelva una Lista, con los elementos ordenados en Inorden.
        Lista lis = new Lista();
        if (this.raiz != null) {
            auxListarInorden(this.raiz, lis);
        }

        return lis;

    }

    private void auxListarInorden(NodoArbol nodo, Lista lis) {
//Metodo que carga en una Lista los elementos ordenados en Inorden.
        if (nodo != null) {
            // visita el elemento en el nodo

            auxListarInorden(nodo.getIzquierdo(), lis);//(2)

            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(1)
            auxListarInorden(nodo.getDerecho(), lis);//(3)

            //recorre a sus hijos en preOrden
        }

    }

    public Lista listarPreorden() {
        //Metodo que devuelva una Lista, con los elementos ordenados en Preorden.
        Lista lis = new Lista();
        listarPreOrdenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreOrdenAux(NodoArbol nodo, Lista lis) {
//Metodo que carga en una Lista los elementos ordenados en Preorden.

        if (nodo != null) {
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(1)

            //recorre a sus hijos en preOrden
            listarPreOrdenAux(nodo.getIzquierdo(), lis);//(2)

            listarPreOrdenAux(nodo.getDerecho(), lis);//(3)

        }

    }

    public Object padre(Object hijo) {
        //Metodo que devuelve el objeto ancestro, del que recibe por parametro.
        Object padre = null;

        if ((this.raiz != null) && (!this.raiz.getElem().equals(hijo))) {

            padre = auxPadre(this.raiz, hijo, this.raiz.getElem());

        }
        return padre;
    }

    private Object auxPadre(NodoArbol n, Object hijo, Object padre) {
        //Metodo que busca al padre.
        Object resultado = null;

        //paso el hijo devuelve el padre
        if (n != null) {
            if (n.getElem().equals(hijo)) {
                //encontrado

                resultado = padre;

            } else {

                resultado = auxPadre(n.getIzquierdo(), hijo, n.getElem());

                if (resultado == null) {
                    //lado derecho
                    resultado = auxPadre(n.getDerecho(), hijo, n.getElem());
                }

            }

        }
        return resultado;
    }

    public void vaciar() {
        //Metodo que vacia la estructura arbol binario,

        this.raiz = null;
    }

    public boolean esVacio() {
        //Metodo esVacio verifica si la encuentra arbol binario, se encuentran sin elementos
        //retorna booleano

        return this.raiz == null;
    }

    public int altura() {
        // Metodo que dada una estructura de tipo Arbol Binario, recorre la misma para determinar la altura del arbol.
        // Es decir la longitud del camino mas largo desde la raiz hasta una hoja.
        // Si el arbol esta vacio tiene altura -1, una hoja tiene altura 0.

        int x = -1;
        if (this.raiz != null) {
            x = alturaAux(this.raiz, x);
        }

        return x;
    }

    private int alturaAux(NodoArbol n, int altura) {
        // Metodo privado recursivo que recibe por parametro un nodo de tipo NodoArbol junto a un valor de tipo int
        // que determina la altura de un arbol.
        // Zona de declaracion de variables
        int ladoDerecho, ladoIzquierdo;

        if (n != null) {
            ladoIzquierdo = alturaAux(n.getIzquierdo(), altura) + 1;
            ladoDerecho = alturaAux(n.getDerecho(), altura) + 1;

            if (ladoIzquierdo > ladoDerecho) {
                altura = ladoIzquierdo;
            } else {
                altura = ladoDerecho;
            }
        }
        return altura;

    }

    public int nivel(Object elem) {
        // Metodo que dada una estructura de tipo Arbol Binario, recibe por parametro un elemento de tipo Object
        // y busca en que nivel se encuentra. Invoca al metodo nivelAux.
        // Zona de declaracion de variable
        int resultado;
        // Zona de inicializacion de variable
        resultado = -1;

        if (this.raiz != null) {
            resultado = nivelAux(this.raiz, elem, -1);
        }
        return resultado;
    }

    private int nivelAux(NodoArbol nodo, Object buscado, int nivel) {
        // Metodo privado recursivo que recibe un nodo de tipo NodoArbol junto a, un valor de tipo int con un elemento
        // de tipo Object. Se busca en la estructura este ultimo, en caso de hallarse se cuentan los niveles desde
        // la raiz hasta dicho elemento.

        if (nodo != null) {
            if (nodo.getElem().equals(buscado)) {
                // si el buscado es n, lo devuelve
                nivel++;
            } else {
                nivel = nivelAux(nodo.getIzquierdo(), buscado, nivel);
                if (nivel != -1) {
                    nivel++;
                } else {
                    nivel = nivelAux(nodo.getDerecho(), buscado, nivel);
                    if (nivel != -1) {
                        nivel++;
                    }
                }
            }
        }
        return nivel;
    }

    public ArbolBin clone() {
        //Metodo clone, llama al metodo auxiliar clonarAux.
        ArbolBin nuevo = new ArbolBin();
        if (this.raiz != null) {
            nuevo.raiz = clonarAux(this.raiz);
        }

        return nuevo;
    }

    private NodoArbol clonarAux(NodoArbol aux) {
        //Metodo clonarAux, se encarga de copiar los elementos a una nueva estructura.
        NodoArbol hijo = null;
        if (aux != null) {
            hijo = new NodoArbol(aux.getElem(), clonarAux(aux.getIzquierdo()), clonarAux(aux.getDerecho()));
        }
        return hijo;
    }

    public Lista listarPorNiveles() {
        //Metodo que devuelve una cadena de caracteres, organizando a los objetos segun el nivel del nodo.
        Lista lista = new Lista();
        Cola aux = new Cola();
        NodoArbol nodo = this.raiz;

        int index = 1;
        if (nodo != null) {

            aux.poner(nodo);

            while (!aux.esVacia()) {
                nodo = (NodoArbol) aux.obtenerFrente();
                lista.insertar(nodo.getElem(), index);

                aux.sacar();

                index++;
                if (nodo.getIzquierdo() != null) {
                    aux.poner(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    aux.poner(nodo.getDerecho());
                }
            }
        }
        return lista;
    }

    public Lista frontera() {
        // Retorna una lista con los nodos hojas del arbol
        Lista lis = new Lista();
        if (this.raiz != null) {
            fronteraAux(this.raiz, lis);
        }
        return lis;
    }

    private void fronteraAux(NodoArbol nodo, Lista lis) {
        // Metodo recursivo privado porque recibe por parametro un nodo de tipo NodoArbol, ademas recibe una lista.
        // Recorre el arbol completo buscando los nodos hoja, y los inserta en la lista
        // Zona de declaracion de variables
        NodoArbol nodoIzq, nodoDer;

        if (nodo != null) {
            // Obtengo los nodos hijo izquierdo e hijo derecho de mi nodo actual
            nodoIzq = nodo.getIzquierdo();
            nodoDer = nodo.getDerecho();

            // Si los hijos izquierdo y derecho son nulos a la vez
            // entonces mi nodo actual es un nodo hoja y lo visito
            if (nodoIzq == null && nodoDer == null) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            } else {
                // Sino busco primero por los hijos de la izquierda, y luego por la derecha
                fronteraAux(nodoIzq, lis);
                fronteraAux(nodoDer, lis);
            }
        }
    }

    public String toString() {
        //Metodo que devuelve una cadena de caracteres.
        //Metodo que llama al modulo auxToString.

        String cadena = "";

        if (this.raiz != null) {
            cadena = auxToString(this.raiz);
        } else {
            cadena = "arbol vacio";
        }

        return cadena;

    }

    private String auxToString(NodoArbol n) {
        //Metodo que recorre la estructura y almacena los elementos en una cadena de caracteres.
        String r = "";
        if (n != null) {
            if ((n.getDerecho() != null) || (n.getIzquierdo() != null)) {

                r += n.getElem();
                if (n.getIzquierdo() != null) {
                    r += "\tHI: " + n.getIzquierdo().getElem();

                } else {
                    r += "HI: -  ";
                }
                if (n.getDerecho() != null) {
                    r += "\t HD: " + n.getDerecho().getElem() + "\n";

                } else {
                    r += "\t HD: - " + "\n";
                }

                r = r + auxToString(n.getIzquierdo());
                r = r + auxToString(n.getDerecho());

            } else {
                r = n.getElem() + "\tHI: -    HD: - " + "\n";
            }
        }

        return r;
    }

}

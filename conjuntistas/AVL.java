/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conjuntistas.ArbolAVL.NodoAVL;
import lineales.dinamicas.Lista;

/**
 *
 * @author juanc
 */
public class AVL {

    private NodoAVL raiz;

    public AVL() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;

        if (this.raiz == null) {
            this.raiz = new NodoAVL(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoAVL nodo, Comparable elemento) {
        // precondicion: nodo no es nulo
        boolean exito = true;
        NodoAVL izquierdo = nodo.getIzquierdo();
        NodoAVL derecho = nodo.getDerecho();
        Comparable contenido = nodo.getElemento();

        if (elemento.equals(contenido)) {
            // reportar error: elemento repetido
            exito = false;
        } else {
            if (elemento.compareTo(contenido) < 0) {
                // elemento es menor que contenido. Si tiene HI baja a la izquierda, sino agrega elemento
                if (izquierdo != null) {
                    exito = insertarAux(izquierdo, elemento);
                } else {
                    nodo.setIzquierdo(new NodoAVL(elemento));
                }
            } else {
                // elemento es mayor que contenido. Si tiene HD baja a la derecha, sino agrega elemento
                if (derecho != null) {
                    exito = insertarAux(derecho, elemento);
                } else {
                    nodo.setDerecho(new NodoAVL(elemento));
                }
            }
        }
        if (exito) {
            nodo.recalcularAltura();
            balancear(nodo);
        }
        return exito;
    }

    public boolean eliminar(Comparable x) {
        return eliminarAux(this.raiz, null, x);
    }

    // baja hasta encontrar el nodo
    private boolean eliminarAux(NodoAVL nodo, NodoAVL padre, Comparable x) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                // elimina el nodo
                exito = eliminarNodo(nodo, padre);
            } else if (elemento.compareTo(x) > 0) {
                // desciende por la izquierda del arbol (es menor)
                exito = eliminarAux(nodo.getIzquierdo(), nodo, x);
            } else {
                // desciende por la derecha del arbol (es mayor)
                exito = eliminarAux(nodo.getDerecho(), nodo, x);
            }
        }
        if (exito) {
            if (padre != null) {
                padre.recalcularAltura();
            }
            if (nodo != null) {
                nodo.recalcularAltura();
                balancear(nodo);
            }
        }
        return exito;
    }

    // determina el tipo de eliminacion
    private boolean eliminarNodo(NodoAVL nodo, NodoAVL padre) {
        NodoAVL izquierdo = nodo.getIzquierdo();
        NodoAVL derecho = nodo.getDerecho();
        // determino el caso a eliminar
        if (izquierdo == null && derecho == null) {
            // elimino un nodo hoja (sin hijos)
            eliminarHoja(nodo, padre);
        } else if (izquierdo != null && derecho != null) {
            // elimino un nodo con dos hijos
            eliminarConDosHijos(nodo);
        } else {
            // elimino un nodo con un hijo, uno izquierdo o derecho, pero no ambos
            eliminarConUnHijo(nodo, padre);
        }
        return true;
    }

    // caso 1
    private void eliminarHoja(NodoAVL hijo, NodoAVL padre) {
        if (padre == null) {
            // caso especial un unico elemento
            this.raiz = null;
        } else if (padre.getIzquierdo() == hijo) {
            padre.setIzquierdo(null);
        } else {
            padre.setDerecho(null);
        }
    }

    // caso 2
    private void eliminarConUnHijo(NodoAVL hijo, NodoAVL padre) {
        NodoAVL izquierdo = hijo.getIzquierdo();
        NodoAVL derecho = hijo.getDerecho();
        if (padre == null) {
            // caso especial de la raiz con un hijo
            this.raiz = (izquierdo != null) ? izquierdo : derecho;
        } else if (izquierdo != null) {
            padre.setIzquierdo(izquierdo);
        } else {
            padre.setDerecho(derecho);
        }
    }

    // caso 3
    private void eliminarConDosHijos(NodoAVL nodo) {
        NodoAVL candidato = nodo.getDerecho();
        NodoAVL padreCandidato = nodo;
        // obtengo el menor de los mayores (candidato)
        while (candidato.getIzquierdo() != null) {
            padreCandidato = candidato;
            candidato = candidato.getIzquierdo();
        }
        // remplazo el valor del nodo a eliminar por el valor del candidato
        nodo.setElemento(candidato.getElemento());
        // hijo pude ser null o no
        NodoAVL hijoCandidato = candidato.getDerecho();
        // elimina el nodo
        // el candidato es el hijo derecho del nodo a eliminar?
        if (nodo.getDerecho() == candidato) {
            // caso especial, el candidato es hijo del nodo
            nodo.setDerecho(hijoCandidato);
        } else {
            // caso comun, el candidato no es hijo del nodo
            padreCandidato.setIzquierdo(hijoCandidato);
        }
    }

    private void balancear(NodoAVL nodo) {
        int balancePadre = nodo.calcularBalance();
        int balanceHijo;
        if (balancePadre > 1) {
            // desbalanceado a la izquierda
            balanceHijo = nodo.getIzquierdo().calcularBalance();
            // determino si aplico rotacion simple o doble
            if (balanceHijo >= 0) {
                rotarDerecha(nodo);
            } else {
                rotarIzquierdaDerecha(nodo);
            }
        } else if (balancePadre < -1) {
            // desbalanceado a la derecha
            balanceHijo = nodo.getDerecho().calcularBalance();
            // determino si aplico rotacion simple o doble
            if (balanceHijo <= 0) {
                rotarIzquierda(nodo);
            } else {
                rotarDerechaIzquierda(nodo);
            }
        }
    }

    private NodoAVL rotarIzquierda(NodoAVL nodo) {
        // pivot
        NodoAVL hijoDerecho = nodo.getDerecho();
        // temporal
        NodoAVL hijoIzquierdo = hijoDerecho.getIzquierdo();
        hijoDerecho.setIzquierdo(nodo);
        nodo.setDerecho(hijoIzquierdo);
        // recalculo altura de nodo y su "hijo"
        nodo.recalcularAltura();
        hijoDerecho.recalcularAltura();
        return hijoDerecho;
    }

    private NodoAVL rotarDerecha(NodoAVL nodo) {
        // pivot
        NodoAVL hijoIzquierdo = nodo.getIzquierdo();
        // temporal
        NodoAVL hijoDerecho = hijoIzquierdo.getDerecho();
        hijoIzquierdo.setDerecho(nodo);
        nodo.setIzquierdo(hijoDerecho);
        // recalculo altura del nodo y su "hijo"
        nodo.recalcularAltura();
        hijoIzquierdo.recalcularAltura();
        return hijoIzquierdo;
    }

    private NodoAVL rotarIzquierdaDerecha(NodoAVL nodo) {
        nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
        return rotarDerecha(nodo);
    }

    private NodoAVL rotarDerechaIzquierda(NodoAVL nodo) {
        nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
        return rotarIzquierda(nodo);
    }

    public Lista listar() {
        Lista lista = new Lista();
        listarAux(this.raiz, lista);
        return lista;
    }

    public void listarAux(NodoAVL nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemento(), 1);
            listarAux(nodo.getIzquierdo(), lista);
        }
    }

    public boolean pertenece(Comparable x) {
        boolean pertenece = false;
        NodoAVL nodo = this.raiz;
        Comparable elemento;
        while (nodo != null && !pertenece) {
            elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                pertenece = true;
            } else if (elemento.compareTo(x) > 0) {
                nodo = nodo.getIzquierdo();
            } else if (elemento.compareTo(x) < 0) {
                nodo = nodo.getDerecho();
            }
        }
        return pertenece;
    }

    public Comparable minimoElem() {
        Comparable elemento = null;
        NodoAVL nodo = this.raiz;
        // bajada por la izquierda
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximoElem() {
        Comparable elemento = null;
        NodoAVL nodo = this.raiz;
        // bajada por la derecha
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    public Lista listarRango(int minimo, int maximo) {
        Lista lista = new Lista();
        listarRangoAux(this.raiz, lista, minimo, maximo);
        return lista;
    }

    private void listarRangoAux(NodoAVL nodo, Lista lista, int minimo, int maximo) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(maximo) < 0) {
                listarRangoAux(nodo.getDerecho(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                lista.insertar(elemento, 1);
            }
            if (elemento.compareTo(minimo) > 0) {
                listarRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
            }
        }
    }

    // utilidad, no prestar antencion
    public void llenar(int[] num) {

        for (int i = 0; i < num.length; i++) {
            insertar(num[i]);
        }
    }

    // copiado de arbol binario
    public String toString() {
        String res = " ";
        if (this.raiz != null) {
            toStringAux(this.raiz, res);
        }
        return res;
    }

    // copiado de arbol binario
    private String toStringAux(NodoAVL nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            System.out.println("2323423");
            if (nodo.getIzquierdo()!=null) {
                   System.out.println("actual "+nodo.getIzquierdo().getElemento());
            }
            NodoAVL izquierdo = nodo.getIzquierdo();
            //  System.out.println("izq  "+izquierdo.getElemento());
            NodoAVL derecho = nodo.getDerecho();
            s += "HI: " + ((izquierdo != null) ? izquierdo.getElemento() : "-") + "\t"
                    + "HD: " + ((derecho != null) ? derecho.getElemento() : "-");
         //   System.out.println("vaorrr de s " + s);
            s =  toStringAux(nodo.getIzquierdo(), s);
            s =  toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

}

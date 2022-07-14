/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author juanc
 */
public class NodoArbol {

    private Comparable elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Comparable x, NodoArbol izq, NodoArbol drcho) {
        this.elemento = x;
        this.derecho = drcho;
        this.izquierdo = izq;
    }

    public Comparable getElemento() {
        return elemento;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

}

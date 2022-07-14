/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jerarquicas;

/**
 *
 * @author juanc
 */
public class NodoArbol {

    //Atributos
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    //Constructor
    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;

    }

    //Metodo observadores
    public Object getElem() {
        return this.elem;
    }

    public NodoArbol getIzquierdo() {
        return this.izquierdo;

    }

    public NodoArbol getDerecho() {
        return this.derecho;
    }

    //Metodo modificadores
    public void setElem(NodoArbol x) {
        this.elem = x;
    }

    public void setDerecho(NodoArbol drcho) {
        this.derecho = drcho;
    }

    public void setIzquierdo(NodoArbol izq) {
        this.izquierdo = izq;
    }

}

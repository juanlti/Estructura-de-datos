/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author juanc
 */
public class NodoVert {
    
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;
    private Lista refAdy;

    public NodoVert(Object elem, NodoVert sigVertice, NodoAdy primerAdy) {
        this.elem = elem;
        this.sigVertice = sigVertice;
        this.primerAdy = primerAdy;
        this.refAdy=null;
    }

    public Lista getRefAdy() {
        return refAdy;
    }

    public void setRefAdy(Lista refAdy) {
        this.refAdy = refAdy;
    }

    
    
    public Object getElem() {
        return elem;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }
    
    
    
}

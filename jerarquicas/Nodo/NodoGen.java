/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/*
Integrantes :
Juan Cruz, Barrera. FAI-2121.
Bruno, Terrazas. FAI-2585.

*/
public class NodoGen {
    
    
    private Object elem;
    private NodoGen izquierdo;
    private NodoGen derecho;
    
    
    public NodoGen(Object elemento,NodoGen izq,NodoGen drcho){
        elem=elemento;
       izquierdo=izq;
       derecho=drcho;
        
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoGen getHijoIzquierdo() {
        return izquierdo;
    }

    public void setHijoIzquierdo(NodoGen izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return derecho;
    }

    public void setHermanoDerecho(NodoGen derecho) {
        this.derecho = derecho;
    }
    
    
}

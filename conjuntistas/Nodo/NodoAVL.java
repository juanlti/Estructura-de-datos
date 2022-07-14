/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.ArbolAVL;
import java.lang.Math;

public class NodoAVL {
    
    private int altura;
    private Comparable elemento;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(Comparable elemento, NodoAVL izquierdo, NodoAVL derecho) {
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        recalcularAltura();
    }

    public NodoAVL(Comparable elemento) {
        this(elemento, null, null);
    }

    public int getAltura() {
        return this.altura;
    }

    public void recalcularAltura() {
        // en caso de no tener hijos se dará la cuenta -1 + 1 = 0
        this.altura = Math.max((this.izquierdo == null) ? -1 : this.izquierdo.altura, (this.derecho == null) ? -1 : this.derecho.altura) + 1;
    }

    public Comparable getElemento() {
        return this.elemento;
    }

    public void setElemento(Comparable elemento) {
        this.elemento = elemento;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }

    public int calcularBalance() {
        return ((this.izquierdo == null) ? -1 : this.izquierdo.altura) - ((this.derecho == null) ? -1 : this.derecho.altura);
    }

}
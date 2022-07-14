/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.staticas;


/**
 *  Juan Cruz, Barrera Liberati. FAI-2121.
  corregido con fecha 03/07
 * @author juanc
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int tamanio = 10;

    public Pila() {
        this.arreglo = new Object[tamanio];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito = false;

        if (this.tope + 1 < tamanio) {
            this.tope++;
            arreglo[this.tope] = nuevoElem;
            exito = true;

        }
        return exito;

    }

    public boolean desapilar() {
        boolean exito = false;
        if (this.tope >= 0) {

            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;

        }
        return exito;

    }

    public String toString() {

        String cadena = "pila vacia";
        if (this.tope > -1) {
            cadena = "[ ";
            for (int i = 0; i <= this.tope; i++) {

                if (this.arreglo[i] != null) {

                    cadena = cadena + arreglo[i];

                    if (i < this.tope) {
                        cadena = cadena + ", ";
                    }

                }
            }
            cadena = cadena + "] ";

        }
        return cadena;
    }

    public Object obtenerTope() {
        Object topePila = null;
        if (this.tope > -1) {
            topePila = arreglo[this.tope];
        }

        return topePila;

    }

    public boolean esVacia() {
        boolean esVacio = true;
        if (this.tope >= 0) {
            esVacio = false;

        }

        return esVacio;

    }

    public void vaciar() {

        while (this.tope > -1) {

            this.arreglo[this.tope] = null;
            this.tope--;

        }

    }

    public Pila clone() {

        Pila pilaClonada = new Pila();
        pilaClonada.tope = this.tope;

        for (int i = 0; i <= this.tope; i++) {

            pilaClonada.arreglo[i] = this.arreglo[i];

        }
        return pilaClonada;

    }

}

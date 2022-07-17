/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;

    }

    public boolean apilar(Object nuevoElemento) {

        //crear un nodo nuevo, le asigna el elemento y el enlace nulo
        Nodo nuevo = new Nodo(nuevoElemento, null);

        // actualiza el tope para que apunte al nuevo nodo
        if (this.tope != null) {

            nuevo.setEnlace(this.tope);

        }
        this.tope = nuevo;

        return true;

    }

    public boolean desapilar() {
        boolean desapilado = false;

        if (this.tope != null) {

            this.tope = this.tope.getEnlace();

            desapilado = true;
        }

        return desapilado;

    }

    public Object obtenerTope() {
        Object tope = null;

        if (this.tope != null) {
            tope = this.tope.getElem();
        }
        return tope;
    }

    public boolean esVacia() {
        boolean esVacia = true;

        if (this.tope != null) {
            esVacia = false;
        }
        return esVacia;
    }

    public void vaciar() {
        this.tope = null;
    }

    public String toString() {

        String cadenaNodos = "Pila vacia";
        if (this.tope != null) {
            cadenaNodos = "";
            Nodo aux = this.tope;

            while (aux != null) {

                cadenaNodos = aux.getElem().toString() + cadenaNodos;
                aux = aux.getEnlace();
                if (aux != null) {
                    cadenaNodos = "," + cadenaNodos;
                }

            }
            cadenaNodos = "[" + cadenaNodos + "]";

        }
        return cadenaNodos;
    }

    public Pila clone() {

        Pila pilaClone = new Pila();

        if (this.tope != null) {

            Nodo auxOriginal = this.tope;

            Nodo auxClone = new Nodo(auxOriginal.getElem(), null);

            pilaClone.tope = auxClone;
            while (auxOriginal.getEnlace() != null) {

                auxOriginal = auxOriginal.getEnlace();

                Nodo auxIterador = new Nodo(auxOriginal.getElem(), null);

                auxClone.setEnlace(auxIterador);
                auxClone = auxClone.getEnlace();

            }

        }
        return pilaClone;
    }

}

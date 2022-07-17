/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.staticas;

import java.util.Arrays;


public class Cola {

    private static final int tamanio = 10;
    private int frente;
    private int fin;
    private Object[] arreglo;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.frente;
        hash = 31 * hash + this.fin;
        hash = 31 * hash + Arrays.deepHashCode(this.arreglo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cola other = (Cola) obj;
        return true;
    }

    public Cola() {

        this.arreglo = new Object[this.tamanio];
        this.fin = 0;
        this.frente = 0;
    }

    public boolean poner(Object tipoElemento) {
        boolean agregado = false;

        if (((this.fin + 1) % tamanio != this.frente)) {

            this.arreglo[this.fin] = tipoElemento;
            this.fin++;
            this.fin = this.fin % tamanio;
            agregado = true;

        }

        return agregado;
    }

    public String toString() {
        int index = this.frente;

        String resultado = " ";
        boolean rotacion = false;
        if (this.frente == this.fin) {

            resultado = "Cola vacia ";
        } else {
            while (index != this.fin) {
                if (index + 1 == tamanio) {

                    resultado = resultado + " " + this.arreglo[index];

                    index = ((index + 1) % tamanio);

                    rotacion = true;

                } else {

                    resultado = resultado + " " + this.arreglo[index];
                    index++;

                }

            }
        }
        return resultado;
    }

    public boolean sacar() {

        boolean sacado = false;
        if (this.fin != this.frente) {

            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % tamanio;

            sacado = true;

        }
        return sacado;
    }

    public Object obtenerFrente() {
        Object frente = null;

        if (this.frente != this.fin) {

            frente = this.arreglo[this.frente];

        }
        return frente;

    }

    public Cola clone() {
        Cola colaClonada = new Cola();
        int tamanioOringal = this.arreglo.length;
        int finalOriginal = this.fin;

        int index = this.frente;
        colaClonada.frente = index;
        colaClonada.fin = finalOriginal;

        while ((index != finalOriginal)) {

            if (index + 1 == tamanioOringal) {
                Object auxNodoClone = this.arreglo[index];
                colaClonada.arreglo[index] = auxNodoClone;
                index = ((index + 1) % tamanioOringal);

            } else {
                Object auxNodoClone = this.arreglo[index];
                colaClonada.arreglo[index] = auxNodoClone;
                index = index + 1;

            }

        }

        return colaClonada;

    }

    public boolean esVacia() {

        boolean esVacia = false;
        if (this.frente == this.fin) {
            esVacia = true;
        }
        return esVacia;
    }

    public void vaciar() {
        int index = this.frente;
        int indexFin = this.fin;
        for (int i = index; i < indexFin; i++) {
            this.arreglo[i] = null;

        }
        this.fin = 0;
        this.frente = 0;
    }

}

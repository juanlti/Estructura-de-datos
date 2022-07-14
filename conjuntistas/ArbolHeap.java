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
public class ArbolHeap {

    private static final int TAMANIO = 15;
    private final Comparable[] heap;

    private int ultimo = 0;

    public ArbolHeap() {
        this.heap = new Comparable[TAMANIO];
    }

    public boolean insertar(Comparable x) {
        boolean agregado = false;

        if (this.ultimo < this.heap.length - 1) {
            this.ultimo++;

            this.heap[this.ultimo] = x;

            agregado = true;

            if (this.ultimo > 1) {
                balanceo(this.heap[this.ultimo], this.heap[this.ultimo / 2], this.ultimo, this.ultimo / 2);
            }
          //  System.out.println("ultimo " + this.heap[this.ultimo] + " pos " + this.ultimo);

        }
        return agregado;

    }

    private void balanceo(Comparable hijo, Comparable padre, int posHijo, int posPadre) {

        while ((hijo.compareTo(padre) < 0) && (posPadre >= 1)) {

            // si el hijo es menor a su padre lo cambio 
            Comparable x = padre;
            this.heap[posPadre] = hijo;
            this.heap[posHijo] = x;

            if ((posPadre / 2) >= 1) {
                posHijo = posPadre;
                posPadre = posPadre / 2;
                hijo = this.heap[posHijo];
                padre = this.heap[posPadre];

            } else {
                posPadre = -1;
            }

        }

    }

    public boolean eliminarCima() {

        //llamo al hacer bajar
        boolean res = false;
        if (this.ultimo > 0) {

            hacerBajar(this.heap[this.ultimo], 1);
            res = true;

        }
        return res;
    }

    private void hacerBajar(Comparable cima, int posCima) {
        this.ultimo--;
        Comparable auxHijo;

        boolean eliminado = true;
        while (eliminado) {
            eliminado = false;
            if (this.heap[posCima * 2].compareTo(cima) < 0 && posCima * 2 <= this.ultimo) {
                //intercambio cima x hijoI

                //intercambio
                auxHijo = this.heap[posCima * 2];
                this.heap[posCima * 2] = cima;
                this.heap[posCima] = auxHijo;

                posCima = posCima * 2;
                cima = this.heap[posCima];
                //  posBajar=posBajar*2;
                eliminado = true;
            } else {
                if (this.heap[(posCima * 2) + 1].compareTo(cima) < 0 && posCima * 2 + 1 <= this.ultimo) {
                    //intercambio
                    auxHijo = this.heap[(posCima * 2) + 1];

                    this.heap[(posCima * 2) + 1] = cima;

                    this.heap[posCima] = auxHijo;
                    posCima = posCima * 2 + 1;
                    cima = this.heap[posCima];
                    //  posBajar=posBajar*2;
                    eliminado = true;

                }

            }

        }

    }

    public Comparable recuperarCima() {
        Comparable cima = null;
        if (this.ultimo > 0) {
            cima = this.heap[1];
        }
        return cima;
    }

    public String toString() {
        String res = " ";

        if (this.ultimo > 0) {
            int i = 1;


            while (i <= this.ultimo) {
                res = res + " | " + this.heap[i];
                i++;

            }
            System.out.println("Comparable " + this.heap[this.ultimo] + " pos " + this.ultimo);
        }
        return res;
    }

    public ArbolHeap clone() {

        ArbolHeap heapClonado = new ArbolHeap();

        for (int i = 1; i <= this.ultimo; i++) {
            heapClonado.ultimo = i;
            heapClonado.heap[i] = this.heap[i];

        }

        return heapClonado;
    }

    public Comparable recuperar(Comparable x) {
        int i = 1;
        Comparable encontrado = null;
        while (i <= this.ultimo) {

            if ((x.compareTo(this.heap[i])) == 0) {
                encontrado = this.heap[i];

                i = this.ultimo + 1;
            } else {
                i++;
            }

        }
        return encontrado;
    }

}

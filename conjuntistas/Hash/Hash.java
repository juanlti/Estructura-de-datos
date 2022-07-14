/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.Hash;

/**
 *
 * @author juanc
 */
public class Hash {

    private int TAMANIO = 7;
    private Nodo[] tablaHash;
    private int cant;

    public Hash() {
        this.tablaHash = new Nodo[TAMANIO];
        cant = 0;

    }

    public boolean insertar(Object nuevoElem) {
        boolean encontrado = false;
        if (this.cant < this.TAMANIO) {

            int pos;

            pos = perteneceAux(nuevoElem);

            if (pos > -1) {

                Nodo aux02 = this.tablaHash[pos];

                Nodo elmentoAgregar = new Nodo(nuevoElem, null);

                elmentoAgregar.setEnlace(aux02);
                this.tablaHash[pos] = elmentoAgregar;
                encontrado = true;
                this.cant++;

            }
        }
        return encontrado;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < this.TAMANIO; i++) {
            Nodo aux = tablaHash[i];
            System.out.println("");

            if (aux != null) {
                System.out.print("pos " + i + " : ");
                while (aux != null) {

                    System.out.print(aux.getElem().toString() + ", ");

                    aux = aux.getEnlace();
                }

            } else {
                System.out.println("pos " + i);
            }
        }
        return res;
    }

    public void funcionHashMod(Object x) {

        int resto = x.hashCode() % this.TAMANIO;
        System.out.println("111 " + resto);

    }

    public boolean pertenece(Object x) {

        //llamo a un metodo privado
        int pos;
        pos = perteneceAux(x);
        boolean existe = false;
        if (pos == -1) {
            existe = true;
        }
        return existe;
    }

    private int perteneceAux(Object x) {

        int pos = x.hashCode() % this.TAMANIO;

        Nodo aux = this.tablaHash[pos];
        boolean encontrado = false;

        while ((!encontrado) && (aux != null)) {
            if (aux.getElem().equals(x)) {
                encontrado = true;
                pos = -1;
            }
            aux = aux.getEnlace();

        }

        return pos;

    }

    public boolean eliminar(Object x) {
        int pos = x.hashCode() % this.TAMANIO;
        boolean eliminado = false;

        Nodo aux = this.tablaHash[pos];

        if (aux.getElem().equals(x)) {
            this.tablaHash[pos] = this.tablaHash[pos].getEnlace();
            eliminado = true;

        } else {

            while (!eliminado && aux != null) {

                if (aux.getEnlace().getElem().equals(x)) {

                    aux.setEnlace(aux.getEnlace().getEnlace());

                    eliminado = true;
                }

                aux = aux.getEnlace();

            }

        }
        if (eliminado) {
            this.cant--;
        }
        return eliminado;
    }

    public Hash clone() {

        Hash cloneHeap = new Hash();

        cloneHeap.cant = this.cant;

        for (int j = 0; j < this.cant; j++) {

            Nodo auxMover = this.tablaHash[j];

            if (auxMover != null) {
                cloneHeap.tablaHash[j] = new Nodo(this.tablaHash[j].getElem(), null);
                Nodo auxClone = cloneHeap.tablaHash[j];
                auxMover = auxMover.getEnlace();

                while (auxMover != null) {

                    Nodo nodoClone = new Nodo(auxMover.getElem(), null);

                    auxClone.setEnlace(nodoClone);

                    auxMover = auxMover.getEnlace();
                    auxClone = auxClone.getEnlace();

                }

            }
        }
        return cloneHeap;
    }

}

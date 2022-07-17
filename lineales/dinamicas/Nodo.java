/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*



 */
package lineales.dinamicas;

public class Nodo {

    private Object elemen;
    private Nodo enlance;

    public Nodo(Object elemen, Nodo enlance) {
        this.elemen = elemen;
        this.enlance = enlance;
    }

    public Object getElem() {
        return elemen;
    }

    public void setElemen(Object elemen) {
        this.elemen = elemen;
    }

    public Nodo getEnlace() {
        return enlance;
    }

    public void setEnlace(Nodo enlance) {
        this.enlance = enlance;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author juanc
 */
public class NodoAdy {
    
    
    private NodoVert vertice;
    private NodoAdy sigAdyancete;
    private Object etiqueta;

    public NodoAdy(NodoVert vertice, NodoAdy sigAdyancete) {
        this.vertice = vertice;
        this.sigAdyancete = sigAdyancete;
      
    }

    public NodoAdy(NodoVert vertice, NodoAdy sigAdyancete, Object etiqueta) {
        this.vertice = vertice;
        this.sigAdyancete = sigAdyancete;
        this.etiqueta = etiqueta;
    }

    public Object getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Object etiqueta) {
        this.etiqueta = etiqueta;
    }
    

    public NodoVert getVertice() {
        return vertice;
    }

    public NodoAdy getSigAdyancete() {
        return sigAdyancete;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public void setSigAdyancete(NodoAdy sigAdyancete) {
        this.sigAdyancete = sigAdyancete;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

import conjuntistas.Hash.Nodo;



/*
Integrantes :
Juan Cruz, Barrera. FAI-2121.
Bruno, Terrazas. FAI-2585.

*/
public class Cola {
    private Nodo fin;
    private Nodo frente;
    public Cola()
    {
       this.frente=null;
       this.fin=null;
    }

    public Object obtenerFrente()
    {
     Object valueFrente=null;
     if(!this.esVacia())
         valueFrente=this.frente.getElem();
     
     
     return valueFrente;
    }
    public boolean esVacia()
    {
      return this.frente==null;    
    }
    public void vaciar()
   {
     this.frente=null;
     this.fin=null;
   
   }
        public boolean sacar()
    {
      boolean exito=true;
      if(this.frente==null)
      {
        exito =false;
      }
      else
      {
        //al menos hay un elemento
        //quita el primer elemento y actualiza frente (y fin se queda vacia)
         this.frente=this.frente.getEnlace();
         if(this.frente==null)
             this.fin=null;                 
      }
      return exito;
    }
    public boolean poner(Object elem)
    {
      boolean exito;
      exito=true;
      Nodo nuevo=new Nodo(elem,null);
      if(this.frente==null)
      {
        //Caso 1: pila vacia
         this.frente=nuevo;
      }
      else
      {
        //Caso 2 : mas de un elemento
         this.fin.setEnlace(nuevo);          
      }
      this.fin=nuevo;
      
      return exito;
    
    }

    public String toString()
    {
      String cadena="";
      Nodo aux;
      aux=this.frente;
      if(this.esVacia())
      {
       cadena="Cola vacia";
      }
      else{
      while(aux!=null)
      {
        cadena+=aux.getElem();
        aux.getElem();
      
      }
      }
     return cadena;
     
     
    }
    public Cola clone()
    {
        Cola copia=new Cola(); 
        if(!this.esVacia())
        {
        Nodo aux_original,aux_copia,nuevo;
        aux_original=this.frente;
        copia.fin=new Nodo(this.frente.getElem(),null);
        aux_original=aux_original.getEnlace();
        aux_copia=copia.frente;
        while(aux_original!=null)
        { 
          nuevo=new Nodo(aux_original.getElem(),null);
          aux_copia.setEnlace(nuevo);
          aux_original=aux_original.getEnlace();
          aux_copia=aux_copia.getEnlace();
          
        }
        }
    return copia;
    
    
    }
    
}

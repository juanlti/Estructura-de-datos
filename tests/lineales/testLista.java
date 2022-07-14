/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author juanc
 */
public class testLista {

    public static void main(String[] args) {

        /*
        
         Lista l1 = new Lista();
         System.out.println(l1.insertar('A', 1));
         System.out.println(l1.insertar('B', 2));
         System.out.println(l1.insertar('C', 3));
         System.out.println(l1.toString());
         System.out.println("muestro");
         System.out.println(l1.insertar('T', 1));
        
         System.out.println(l1.toString());
        
         System.out.println("Clono una lista");
        
         Lista l2=l1.clone();
         l1.insertar("$",2);

         l1.vaciar();
         System.out.println(l1.toString());
         System.out.println("muestro Lista Clonada");
         System.out.println(l2.toString());
         */
        Lista ls = new Lista();
        /*
         System.out.println(ls.insertar('A', 1));
         System.out.println(ls.insertar('B', 2));
         System.out.println(ls.insertar('A', 3));
         System.out.println(ls.insertar('A', 4));
         System.out.println(ls.insertar('E', 5));

         System.out.println(ls.insertar('F', 6));
         System.out.println(ls.insertar('G', 7));
         System.out.println(ls.insertar('A', 8));
         System.out.println(ls.insertar('I', 9));
         System.out.println(ls.insertar('A', 10));

         System.out.println("muestro ls creada");
         System.out.println(ls.toString());
         Lista multiplos = ls.obtenerMultiplos(3);
         System.out.println("muestro lista multiplos de 3");
         System.out.println(multiplos.toString());
         System.out.println("sin apareciones : "+ls.toString());
         System.out.println("Eliminar apareciones de A");
     
        
         System.out.println("sin apareciones : "+ls.toString());
         */
        System.out.println(ls.insertar('1', 1));
        System.out.println(ls.insertar('5', 2));
        System.out.println(ls.insertar('T', 3));
        System.out.println(ls.insertar('Q', 4));
        System.out.println(ls.insertar('K', 5));
        System.out.println(ls.insertar('7', 6));
                                   
       // System.out.println(ls.toString());

        System.out.println("Localizar Q res posicion 4");


          System.out.println(ls.toString());
         // System.out.println(ls.localizar('7'));
        System.out.println(ls.eliminar(1));
        System.out.println(ls.toString());

    }

}

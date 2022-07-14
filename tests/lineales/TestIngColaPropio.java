/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import lineales.staticas.Cola;


//import lineales.dinamicas.Cola;


/**
 *
 * @author juanc
 */
public class TestIngColaPropio {

    public static void main(String[] arg) {
        
        // Test Estatica
        

        Cola c1 = new Cola();

        System.out.println(c1.poner('X'));
        System.out.println(c1.poner('Y'));
        System.out.println(c1.poner('W'));
        System.out.println(c1.poner('Z'));
        System.out.println(c1.poner(5));
        System.out.println(c1.poner(6));

        System.out.println(c1.poner(7));
        System.out.println(c1.poner(8));
        System.out.println(c1.poner(9));
        System.out.println(c1.toString());
        for (int i = 0; i < 4; i++) {
            c1.sacar();
        }
        //System.out.println("3234234");
        System.out.println(c1.poner('A'));
        System.out.println(c1.poner('B'));
        System.out.println(c1.poner('-'));
        System.out.println(c1.poner('+'));

        //System.out.println("frente==> "+c1.obtenerFrente());
        System.out.println(c1.toString());
         Cola colaClonada=c1.clone();
         
             
            System.out.println("longitud de ColaClonada "+colaClonada.toString());
            System.out.println("borro la cola clonada");
            colaClonada.vaciar();
            System.out.println("muestro cola clonada vacia resultado cola vacia ?:  "+colaClonada.toString());
        // Test Dinamica
        /*
           Cola c1 = new Cola();
           c1.poner('A');
           c1.poner('B');
             c1.poner('C');
               c1.poner('T');
           System.out.println(c1.toString());
           
           Cola c2=c1.clone();
           c1.sacar();
           c1.vaciar();
           System.out.println(c1.toString());
           //c2.vaciar();
           System.out.println("muestro c2 "+c2.toString());
           
        */

    }

}

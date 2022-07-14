/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import java.util.Scanner;
import lineales.dinamicas.Pila;
//import lineales.staticas.Pila;

/**
 *
 * @author juanc
 */
public class testPila {

    public static void main(String[] args) {
        // TEST PILA ESTATICA PROPIO
        /*
         Scanner sc = new Scanner(System.in);
         Pila pila = new Pila();
         System.out.println("apilooo " + pila.apilar(1));
         System.out.println("apilooo " + pila.apilar(2));
         System.out.println("apilooo " + pila.apilar(3));
         System.out.println("apilooo " + pila.apilar(4));
         System.out.println("apilooo " + pila.apilar(5));
         System.out.println("muestro original " + pila.mostrar());

         System.out.println("informacion de clonado");
         Pila clonada = pila.clone2();
         pila.vaciar();
         System.out.println(clonada.esVacio());

         System.out.println("Pila original debe estar vacia ==> " + pila.mostrar());
         System.out.println("Pila clonada ==> " + clonada.mostrar());

         /* 
         System.out.println("vaciar pila");
         pila.vaciar();
         System.out.println(pila.vacio());
         System.out.println("Vuelvo a mostrar las pilas");
         System.out.println("Pila original debe estar vacia ==> "+pila.mostrar());
         System.out.println("Pila clonada ==> "+clonada.mostrar());
         */

        /*
         Pila auxiliarClone = clonada.cloneInvertida();
         System.out.println("mostrar invertido "+auxiliarClone.mostrar());
         System.out.println("pila es capicua ? "+ esCapicuaPila(clonada,auxiliarClone));
         */
        // TEST PILA DINAMICA PROPIO
        Pila p1 = new Pila();
        System.out.println(p1.apilar(1));
        System.out.println(p1.apilar(-1));
        System.out.println(p1.apilar(10));
            
 
        Pila p2=p1.clone();
        System.out.println("Original [10, -1 ,1] ==> " + p1.toString());
        p1.desapilar();
              System.out.println(" Original Modificado [ 10 , -1] ==> " +p1.toString());
 
              System.out.println("Clone [10, -1 ,1] ==> " + p2.toString());
        
    }

    /*
     public static boolean esCapicuaPila(Pila p1, Pila AuxInvertida) {
     boolean corte = true;
     Object auxTopeP1, auxTopeInvertida;

     while (corte && !p1.esVacio() && !AuxInvertida.esVacio()) {
     //exite elementos
     auxTopeP1 = p1.obtenerTope();
     auxTopeInvertida = AuxInvertida.obtenerTope();
     System.out.println("auxTopeP1 = "+auxTopeP1 + " auxTopeInvertida "+auxTopeInvertida);
     if (auxTopeP1 != auxTopeInvertida) {
     corte = false;

     } else {
     p1.desapilar();
     AuxInvertida.desapilar();

     }
     }
     return corte;

     }
     */
}

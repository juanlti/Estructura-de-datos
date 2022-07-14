/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author juanc
 */
public class testArbolGen {

    public static void main(String[] args) {

        ArbolGen ag = new ArbolGen();

        System.out.println(ag.insertar('Q', null));
        System.out.println(ag.insertar('M', 'Q'));
        System.out.println(ag.insertar('B', 'Q'));
        System.out.println(ag.insertar('K', 'Q'));
        System.out.println(ag.insertar('Y', 'Q'));
        System.out.println(ag.insertar('H', 'M'));
        System.out.println(ag.insertar('V', 'M'));
        System.out.println(ag.insertar('A', 'H'));
        System.out.println(ag.insertar('1', 'B'));

        System.out.println(ag.insertar('2', 'B'));
        System.out.println(ag.insertar('3', 'B'));
        System.out.println(ag.insertar('T', 'B'));
        System.out.println(ag.insertar('8', '1'));
        System.out.println(ag.insertar('J', 'Y'));

        System.out.println(ag.toString());
        System.out.println(ag.esHermanosAnterior('1', 'T'));
      

        /*
         System.out.println(ag.insertar('B', 'A'));
         System.out.println(ag.insertar('C', 'A'));
         System.out.println(ag.insertar('D', 'A'));
         System.out.println(ag.insertar('E', 'B'));
        

         System.out.println(ag.insertar('F', 'B'));
         System.out.println(ag.insertar('G', 'B'));
         System.out.println(ag.insertar('H', 'D'));

         System.out.println(ag.insertar('T', 'F'));
         System.out.println(ag.insertar('K', 'T'));
         System.out.println(ag.insertar('Q', 'G'));

         /* 
         System.out.println("clonado");
         ArbolGen clonado;
         clonado=ag.clone();
         ag.vaciar();
         ag.insertar('T', null);
         System.out.println("muestro clonado");
         System.out.println(clonado.toString());
         */
        //Lista ls = new Lista();
        /*
         System.out.println(ls.insertar('Q', 1));
         System.out.println(ls.insertar('K', 2));
         System.out.println(ls.insertar('E', 3));
         System.out.println(ls.insertar('H', 4));
         */
        /*
         System.out.println(ls.insertar('E', 1));
         System.out.println(ls.insertar('K', 1));
         System.out.println(ls.insertar('Q', 1));
         System.out.println(ls.insertar('H', 1));
         */
        // System.out.println(ls.insertar('F', 5));
        // System.out.println("muestro lista");
        // System.out.println(ls.longitud());
        // System.out.println(ag.sonFrontera(ls));
        // System.out.println(ag.nivel('Y'));
        /*
         Lista lsPreOrden, lsPosOrden, lsPorNivel;
         lsPreOrden = ag.listarPreorden();
         System.out.println("muestro lista en preOrden ");
         System.out.println(lsPreOrden.toString());
         System.out.println("OK");
         lsPosOrden = ag.listarPosorden();
         System.out.println("muestro lista en posOrden ");
         System.out.println(lsPosOrden.toString());
         System.out.println("OK");
         lsPorNivel = ag.listarPorNiveles();
         System.out.println("muestro lista en porNivel ");
         System.out.println(lsPorNivel.toString());
         System.out.println("OK");
         System.out.println("2323232");
         System.out.println(ag.listarPorNiveles().toString());
         */
    }

    public static double suma(int maximo) {

        double cant = 0;
        int i = 1;

        if (i <= maximo) {
            cant = cant+1;
            cant = cant + suma(maximo);
        }

        return cant;
    }
}

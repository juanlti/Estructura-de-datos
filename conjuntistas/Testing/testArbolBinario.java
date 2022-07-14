/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;

/**
 *
 * @author juanc
 */
public class testArbolBinario {

    public static void main(String[] args) {

        ArbolBB abb = new ArbolBB();

        System.out.println(abb.insertar(20));
        System.out.println(abb.insertar(14));
        System.out.println(abb.insertar(44));
        System.out.println(abb.insertar(8));
        System.out.println(abb.insertar(18));
        System.out.println(abb.insertar(22));
        System.out.println(abb.insertar(50));
        System.out.println(abb.insertar(1));
        System.out.println(abb.insertar(16));
        System.out.println(abb.insertar(19));
        System.out.println(abb.toString());
        System.out.println("mostrar arbol");
        Lista listadosMayorQue=abb.listarMayoresQue(15, 14);
        System.out.println("Mostrar lista "+listadosMayorQue.toString());
        //abb.eliminarMinimo();
        //ArbolBB modificado=abb.invertirClonParcial(8995);

        /*
         int res = abb.sumarPreOrden(14, 22);
        
         System.out.println(res);
   

         /*
         System.out.println(abb.insertar(56));
         System.out.println(abb.insertar(13));

         System.out.println(abb.insertar(78));

         System.out.println(abb.insertar(7));
         System.out.println(abb.insertar(24));
         System.out.println(abb.insertar(100));

         System.out.println(abb.toString());
         System.out.println("134123424");
         //System.out.println(abb.insertar(5));
         String resultado = abb.ConcatenerPreOrden(13, 8);
         System.out.println(resultado);
         abb.prueba(false, 1);
         /*
         System.out.println(abb.toString());
         ArbolBB abbInvertido;
         abbInvertido = abb.clonarInvertir(56);
         System.out.println("21231231");
         System.out.println(abbInvertido.toString());
         /*
         System.out.println("parcial invertido ");
         ArbolBB abbInvertido;
         abbInvertido = abb.clonarInvertir(13);
         System.out.println(abbInvertido.toString());
         /*
         System.out.println(abb.insertar(16));

         System.out.println(abb.insertar(13));
         System.out.println(abb.insertar(5));
         System.out.println(abb.insertar(3));
         System.out.println(abb.insertar(25));
         System.out.println(abb.insertar(22));
         System.out.println(abb.insertar(14));
         System.out.println(abb.insertar(15));
         System.out.println(abb.insertar(55));
         System.out.println(abb.insertar(52));
         System.out.println(abb.insertar(20));
         System.out.println(abb.insertar(18));
         System.out.println(abb.insertar(17));
         System.out.println(abb.insertar(10));
        
         System.out.println(abb.insertar(21));
         System.out.println(abb.insertar(24));

         /*
         //System.out.println(abb.pertenece(20));
         System.out.println("elimino 9 " + abb.eliminar(9));
        
         System.out.println(abb.toString());
         System.out.println("elimino 5 " + abb.eliminar(5));
         System.out.println(abb.toString());
         System.out.println("elimino 52 " + abb.eliminar(52));
         System.out.println(abb.toString());
         */
        //System.out.println(abb.listarRango(5, 20));
    }

}

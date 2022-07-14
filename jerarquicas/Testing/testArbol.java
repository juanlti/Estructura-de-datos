/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;

import Jerarquicas.ArbolBin;



/**
 *
 * @author juanc
 *
 */
public class testArbol {

    public static void main(String[] arg) {

        ArbolBin ab = new ArbolBin();

        System.out.println(ab.insertar('1', null, 'T'));
        System.out.println(ab.insertar('5', '1', 'I'));
        System.out.println(ab.insertar('3', '1', 'D'));
        System.out.println(ab.insertar('K', '5', 'I'));
        System.out.println(ab.insertar('4', 'K', 'I'));
        System.out.println(ab.insertar('9', '5', 'D'));
        System.out.println("mostrar arbol");

        System.out.println(ab.toString());
        System.out.println(ab.nivel('5'));
        System.out.println("clono el ab");
        ArbolBin abClone;
        abClone = ab.clone();

        ab.vaciar();
        System.out.println(ab.insertar('U', null, 'T'));
        System.out.println("Muestro abClone");
        System.out.println(abClone.toString());
        System.out.println("Muestro ab original vacio");
        System.out.println(ab.toString());

        /*
         System.out.println("Muestro Lista de Arbol");
         System.out.println(ab.listarPreorden());
         System.out.println("to String");
         System.out.println(ab.toString());
         Lista ls = new Lista();
         System.out.println(ls.insertar('1', 1));
         System.out.println(ls.insertar('5', 2));
         System.out.println(ls.insertar('9', 3));
         System.out.println("resultado ");
         System.out.println("limite de lista "+ls.longitud());
         System.out.println(ab.verificarPatron(ls));
         */
        
        System.out.println("busco nivel del 9 resultado: 2");
        System.out.println(abClone.nivel('3'));
        System.out.println("altura");
        System.out.println(abClone.altura());
    }

}

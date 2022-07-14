/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo.Testing;

import Grafo.Grafo;

/**
 *
 * @author juanc
 */
public class testGrafo {

    public static void main(String[] args) {

        Grafo g = new Grafo();

        System.out.println(g.insertarVertice('A'));
        System.out.println(g.insertarVertice('B'));

        System.out.println(g.insertarVertice('C'));
        System.out.println(g.insertarVertice('F'));
        System.out.println(g.insertarVertice('D'));
        System.out.println(g.insertarVertice('G'));
        System.out.println(g.insertarVertice('E'));
        System.out.println(g.insertarVertice('H'));

        System.out.println(g.insertarArco('A', 'B', false, 35));

        System.out.println(g.insertarArco('B', 'D', false, 100));
        System.out.println(g.insertarArco('D', 'G', false, 50));
        System.out.println(g.insertarArco('D', 'E', false, 90));

        System.out.println(g.insertarArco('B', 'F', false, 75));

        System.out.println(g.insertarArco('C', 'F', false, 10));

        System.out.println(g.insertarArco('C', 'A', false, 90));
        System.out.println(g.insertarArco('C', 'H', false, 20));
        System.out.println(g.insertarArco('G', 'E', false, 15));
        System.out.println(g.toString());
        System.out.println(g.existeVertice('G'));
        g.eliminarArco('C', 'H');
        System.out.println("eliminar vertice 'F' ");
        System.out.println(g.eliminarVertice('F'));

        System.out.println(g.toString());
        System.out.println("Recorrido");

    }
}

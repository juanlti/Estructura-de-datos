/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author juanc
 */
public class testConjuntista {

    public static void main(String[] args) {

        ArbolHeap a1 = new ArbolHeap();
        System.out.println(a1.insertar(20));
        System.out.println(a1.insertar(14));
        System.out.println(a1.insertar(44));
        System.out.println(a1.insertar(8));
        System.out.println(a1.insertar(18));
        System.out.println(a1.insertar(22));
        System.out.println(a1.insertar(50));
        System.out.println(a1.insertar(1));
        System.out.println(a1.insertar(16));
        System.out.println(a1.insertar(19));
         System.out.println(a1.toString());
        /*
         System.out.println(a1.insertar(2));
         System.out.println(a1.insertar(6));
         System.out.println(a1.insertar(3));
         System.out.println(a1.insertar(7));
         System.out.println(a1.insertar(8));
         System.out.println(a1.insertar(6));
         System.out.println(a1.insertar(19));
         System.out.println(a1.insertar(7));
         System.out.println(a1.insertar(9));
         System.out.println(a1.insertar(10));
         System.out.println(a1.insertar(5));
         System.out.println(a1.insertar(1));
         System.out.println(a1.toString());
         /*
         System.out.println(heap.insertar(16));
         System.out.println(heap.insertar(14));
         System.out.println(heap.insertar(10));
         System.out.println(heap.insertar(8));
         System.out.println(heap.insertar(7));
         System.out.println(heap.insertar(9));
         System.out.println(heap.insertar(3));
        
         System.out.println(heap.insertar(2));
         System.out.println(heap.insertar(4));
         System.out.println(heap.insertar(1));
         System.out.println(heap.insertar(2));
         System.out.println(heap.insertar(85));
         
         //System.out.println(heap.insertar(86));
         System.out.println(heap.insertar(6));

         System.out.println(heap.insertar(5));
         System.out.println(heap.insertar(9));
         System.out.println(heap.toString());

         System.out.println(heap.insertar(3));
         System.out.println(heap.insertar(8));
         System.out.println(heap.insertar(1));
         System.out.println(heap.insertar(2));
         System.out.println(heap.insertar(11));
         System.out.println(heap.insertar(0));
         System.out.println(heap.insertar(66));
         System.out.println(heap.toString());
         System.out.println("borro");
         System.out.println(heap.eliminarCima());
         System.out.println(heap.toString());
         System.out.println("Recupero cima " + heap.recuperarCima());
         System.out.println("Clono");
         ArbolHeap heapClonado;

         System.out.println(heapClonado = heap.clone());
         System.out.println("borro");
         System.out.println(heap.eliminarCima());
         System.out.println(heapClonado = heap.clone());
         */
    }
}

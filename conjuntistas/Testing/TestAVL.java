/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import conjuntistas.ArbolAVL.NodoAVL;

/**
 *
 * @author juanc
 */
public class TestAVL {

    public static void main(String[] args) {
        AVL a = new AVL();
        int[] num = {15, 9, 4, 3, 7, 12, 13, 50, 24, 17, 57, 53, 67};
        a.llenar(num);
        System.out.println(a.toString());
        System.out.println("listar: " + a.listar());
        System.out.println("pertenece: " + a.pertenece(3));
        System.out.println("elemento minimo: " + a.minimoElem());
        System.out.println("elemento maximo: " + a.maximoElem());
        System.out.println("listar rango: " + a.listarRango(2, 9));
        int n = 9;
        System.out.println("elimina: " + n);
        System.out.println("eliminar: " + a.eliminar(n));
        System.out.println(a);
    }

}

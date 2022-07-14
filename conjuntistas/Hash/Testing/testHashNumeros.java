/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.Hash;

/**
 *
 *
 * @author juanc
 */
public class testHashNumeros {

    public static void main(String[] args) {

        Hash hash01 = new Hash();

        System.out.println(hash01.insertar(63));
        System.out.println(hash01.insertar(26));
        System.out.println(hash01.insertar(3));
        System.out.println(hash01.insertar(96));
        System.out.println(hash01.insertar(47));
        System.out.println(hash01.insertar(54));
        System.out.println(hash01.insertar(89));

        System.out.println("original");
        System.out.println(hash01.toString());
        System.out.println("clonado");
        Hash cloneHash;
        cloneHash = hash01.clone();
        System.out.println("elimino un elemento existente en el hash01");
        System.out.println(hash01.eliminar(54));
        System.out.println("muestro clonado");

        System.out.println(cloneHash.toString());
        System.out.println("muestro hash01 con un elemento menos - '-54' ");
        System.out.println(hash01.toString());

    }
}

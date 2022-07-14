/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.Hash;

/**
 *
 * @author juanc
 */
public class TestHashPersona {

    public static void main(String[] args) {

        Hash x = new Hash();

        Persona p01, p02;

        p01 = new Persona(36742021, "dni");
        p02 = new Persona(37851557, "dni");

        x.insertar(p01);
        x.insertar(p02);
        System.out.println("muestro a persona p01 " + x.toString());
        /*
         Object [] p01,p02,p03,p04,p05,p06,p07,p08,p09,p010;
         */

    }
}

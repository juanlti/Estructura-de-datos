/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas.Hash;

import java.util.Objects;

/**
 *
 * @author juanc
 */
public class Persona {
private String nombre;
private int dni;
private String tipoDni;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.dni;
      
        hash = 53 * hash + Objects.hashCode(this.tipoDni);
        System.out.println("clave genera por hash "+hash );
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.dni != other.dni) {
            return false;
        }
        if (!Objects.equals(this.tipoDni, other.tipoDni)) {
            return false;
        }
        return true;
    }

    public Persona(int dni, String tipoDni) {
        this.dni = dni;
        this.tipoDni = tipoDni;
    }



    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", tipoDni=" + tipoDni + '}';
    }



}

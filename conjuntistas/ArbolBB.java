/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import conjuntistas.NodoArbol;

/**
 *
 * @author juanc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author juanc
 */
public class ArbolBB {

    private NodoArbol raiz;

    public void ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean agregado;

        NodoArbol x;

        if (this.raiz == null) {
            x = new NodoArbol(elemento, null, null);
            this.raiz = x;
            agregado = true;
        } else {
            //metodo privado
            agregado = insertarAux(this.raiz, elemento);
        }
        return agregado;

    }

    private boolean insertarAux(NodoArbol n, Comparable hijo) {
        NodoArbol agregar = null;
        boolean agregado = false;
        if (n != null && hijo.compareTo(n.getElemento()) != 0) {
                System.out.println("valor de hijo "+hijo.toString() +" y se compara con  "+n.getElemento()+ " y su resultado es "+hijo.compareTo(n.getElemento()));
            if (hijo.compareTo(n.getElemento()) < 0) {
                //hijo es menor al padre
                //hijo se agrega al lado izq
                if (n.getIzquierdo() == null) {
                    agregar = new NodoArbol(hijo, null, null);
                    n.setIzquierdo(agregar);
                    agregado = true;
                } else {

                    agregado = insertarAux(n.getIzquierdo(), hijo);
                }

            } else {

                if (hijo.compareTo(n.getElemento()) > 0) {
                    //hijo es mayor al padre
                    //hijo se agrega al lado drcho
                    if (n.getDerecho() == null) {
                        agregar = new NodoArbol(hijo, null, null);
                        n.setDerecho(agregar);
                        agregado = true;
                    } else {
                        agregado = insertarAux(n.getDerecho(), hijo);
                    }

                }
            }
        }
        return agregado;
    }

    public String toString() {
        //Metodo que devuelve una cadena de caracteres.
        //Metodo que llama al modulo auxToString.

        String cadena = "";

        if (this.raiz != null) {
            cadena = auxToString(this.raiz);
        } else {
            cadena = "arbol vacio";
        }

        return cadena;

    }

    private String auxToString(NodoArbol n) {
        //Metodo que recorre la estructura y almacena los elementos en una cadena de caracteres.
        String r = "";
        if (n != null) {
            if ((n.getDerecho() != null) || (n.getIzquierdo() != null)) {

                r += n.getElemento();
                if (n.getIzquierdo() != null) {
                    r += "\tHI: " + n.getIzquierdo().getElemento();

                } else {
                    r += "\tHI: - ";
                }
                if (n.getDerecho() != null) {
                    r += "\tHD: " + n.getDerecho().getElemento() + "\n";

                } else {
                    r += "\tHD: - " + "\n";
                }

                r = r + auxToString(n.getIzquierdo());
                r = r + auxToString(n.getDerecho());

            } else {
                r = n.getElemento() + "\tHI: -   HD: - " + "\n";
            }
        }

        return r;
    }

    public boolean pertenece(Comparable x) {
        boolean agregado = false;
        if (this.raiz != null) {
            NodoArbol encontrado;
            encontrado = perteneceAux(this.raiz, x);
            if (encontrado != null) {
                agregado = true;
            }
        }
        return agregado;
    }

    private NodoArbol perteneceAux(NodoArbol n, Comparable aBuscar) {

        NodoArbol encontrado = null;
        if (n != null) {
            if (aBuscar.compareTo(n.getElemento()) == 0) {
                encontrado = n;

            } else {

                if (aBuscar.compareTo(n.getElemento()) < 0) {

                    encontrado = perteneceAux(n.getIzquierdo(), aBuscar);

                } else {

                    encontrado = perteneceAux(n.getDerecho(), aBuscar);

                }
            }
        }
        return encontrado;
    }

    private void eliminarAuxPadre(NodoArbol padre) {

        if (padre.getIzquierdo() == null && padre.getDerecho() == null) {
            this.raiz = null;

        } else {
            if (padre.getIzquierdo() != null && padre.getDerecho() == null) {
                this.raiz = this.raiz.getIzquierdo();

            } else {
                if (padre.getIzquierdo() == null && padre.getDerecho() != null) {
                    this.raiz = this.raiz.getDerecho();

                } else {
                    if (padre.getIzquierdo().getDerecho() == null) {
                        this.raiz.setElemento(padre.getIzquierdo().getElemento());
                        padre.setIzquierdo(null);
                    } else {
                        maximoIzquierdoYeliminacion(padre.getIzquierdo(), padre);
                    }

                }

            }
        }

    }

    public boolean eliminar(Comparable elemento) {

        boolean resultado = false;
        int res;
        res = -1;
        if (this.raiz != null) {
            //Si el elemento a eliminar es igual se encuentra en la raiz.
            if (this.raiz.getElemento().compareTo(elemento) == 0) {
                //padre
                eliminarAuxPadre(this.raiz);
            } else {
                //Para cualquier otro caso, utiliza la siguiente sentencia
                res = eliminarCasoAux(this.raiz, elemento, this.raiz);

            }
            //si el la variable 'res' es mayor a 0, entonces se elimino el elemento, de manera satisfactoria

            if (res > 0) {
                // cambiando el valor de resultado por true
                resultado = true;
            }

        }
        return resultado;
    }

    private int eliminarCasoAux(NodoArbol n, Comparable aBuscar, NodoArbol anterior) {
        //aBuscar == elemento a eliminar
        int res = 0;
        if (n != null) {

            if (aBuscar.compareTo(n.getElemento()) <= 0) {
                //si aBuscar es menor o igual al nodo actual, llama por rama izquierda
                if (aBuscar.compareTo(n.getElemento()) == 0) {
                    //elemento encontrado
                    res = 1;

                } else {
                    //llama por rama izquierda
                    res = eliminarCasoAux(n.getIzquierdo(), aBuscar, anterior);
                    // si 'res==1' entonces el elemento a eliminar se encuentra del lado izq,
                    // puede ser una hoja,padre con 1 hijo, padre con 2 hijos
                    if (res == 1) {

                        res = eliminarAuxBis(n, n.getIzquierdo(), true);

                    }
                }

            } else {

                // caso contrario llamo con drcho
                res = eliminarCasoAux(n.getDerecho(), aBuscar, anterior);
                // si 'res==1' entonces el elemento a eliminar se encuentra del lado dercho,
                // puede ser una hoja,padre con 1 hijo, padre con 2 hijos
                if (res == 1) {

                    res = eliminarAuxBis(n, n.getDerecho(), false);

                }

            }
        }
        return res;
    }

    private int eliminarAuxBis(NodoArbol nodoPadre, NodoArbol auxEliminar, boolean esIzquierdo) {
        //Aclaracion de los valores a retornar en la variable 'res'
        // si 'res' devuelve >0, la eliminacion fue un exito, si 'res' ==0 entonces la eliminacion fallo.
        //res toma varios valores, con el proposito de testear en particular cada caso.
        int res = 0;
        if (auxEliminar.getIzquierdo() == null && auxEliminar.getDerecho() == null) {

            if (esIzquierdo) {
                nodoPadre.setIzquierdo(null);

            } else {
                nodoPadre.setDerecho(null);

            }
            res = 2;

        } else {
            if (auxEliminar.getIzquierdo() != null && auxEliminar.getDerecho() == null) {
                res = 2;
                if (esIzquierdo) {
                    nodoPadre.setIzquierdo(nodoPadre.getIzquierdo().getIzquierdo());
                } else {
                    nodoPadre.setDerecho(nodoPadre.getDerecho().getIzquierdo());
                }

            } else {
                if (auxEliminar.getIzquierdo() == null && auxEliminar.getDerecho() != null) {
                    res = 2;
                    if (esIzquierdo) {
                        nodoPadre.setIzquierdo(nodoPadre.getIzquierdo().getDerecho());
                    } else {
                        nodoPadre.setDerecho(nodoPadre.getDerecho().getDerecho());
                    }

                } else {

                    maximoIzquierdoYeliminacion(nodoPadre.getDerecho(), auxEliminar);

                }
            }

        }
        return res;

    }
// corregir si el candidato es uno solo

    private void maximoIzquierdoYeliminacion(NodoArbol n, NodoArbol aEliminar) {
        aEliminar.setElemento(n.getElemento());

        // caso base
        if (n.getDerecho() != null) {

            if (n.getDerecho().getDerecho() == null) {

                aEliminar.setElemento(n.getDerecho().getElemento());

                if (n.getDerecho().getIzquierdo() != null) {
                    n.setDerecho(n.getDerecho().getIzquierdo());

                } else {
                    n.setDerecho(null);
                }

            } else {
                maximoIzquierdoYeliminacion(n.getDerecho(), aEliminar);
            }

        }

    }

    public Lista listar() {
        
        //nivel
        Lista ls = new Lista();

        if (this.raiz != null) {
            listarAux(this.raiz, ls);
        }
        return ls;

    }

    public Lista listarRango(Comparable min, Comparable max) {
        Lista ls = new Lista();
        listarAuxRango(this.raiz, ls, min, max);
        return ls;
    }

    private void listarAuxRango(NodoArbol n, Lista ls, Comparable min, Comparable max) {

        if (n != null) {

            if (n.getElemento().compareTo(max) <= 0 && n.getElemento().compareTo(min) >= 0) {
                listarAuxRango(n.getIzquierdo(), ls, min, max);
                ls.insertar(n.getElemento(), ls.longitud() + 1);
                listarAuxRango(n.getDerecho(), ls, min, max);

            } else {
                if (max.compareTo(n.getElemento()) <= 0) {
                    listarAuxRango(n.getIzquierdo(), ls, min, max);
                } else {
                    listarAuxRango(n.getDerecho(), ls, min, max);
                }

            }

        }

    }

    private void listarAux(NodoArbol n, Lista ls) {

        if (n != null) {

            listarAux(n.getIzquierdo(), ls);

            // agrega
            ls.insertar(n.getElemento(), ls.longitud() + 1);
            listarAux(n.getDerecho(), ls);

        }

    }

    public ArbolBB clonarOInvertido(Comparable x) {
        ArbolBB arbolParcialInvertido = new ArbolBB();
        if (x != null && this.raiz != null) {
            System.out.println("22323f wdfw");
            NodoArbol arbolClone = arbolParcialInvertido.raiz;
            clonarInvertidoAux(false, 0, this.raiz, x, arbolClone, this.raiz, arbolParcialInvertido);

        }

        return arbolParcialInvertido;
    }

    private boolean clonarInvertidoAux(boolean encontrado, int posicion, NodoArbol n, Comparable e, NodoArbol cloneInvertido, NodoArbol aux, ArbolBB p) {

        if (n != null) {

            if (n.getElemento().compareTo(e) == 0 || encontrado) {
                System.out.println(" 5 " + n.getElemento());

                NodoArbol temp = new NodoArbol(n.getElemento(), null, null);
                if (cloneInvertido == null) {
                    cloneInvertido = temp;
                    System.out.println(cloneInvertido.getElemento());
                } else {
                    encontrado = true;
                    System.out.println(" padre 7  " + cloneInvertido.getElemento());

                    System.out.println("nodo ? " + n.getElemento().toString() + " posicion " + posicion);
                    System.out.println(cloneInvertido.getElemento());

                    //posicion es true => hjo izq
                    if (posicion == 1) {
                        cloneInvertido.setDerecho(temp);
                        System.out.println("3333333333   8945 " + cloneInvertido.getElemento());
                        System.out.println("3333333333    " + cloneInvertido.getDerecho().getElemento());
                    } else {
                        if (posicion == 2) {
                            cloneInvertido.setIzquierdo(temp);
                        }
                    }
                    //  System.out.println(" padre 7  " + cloneInvertido.getIzquierdo().getElemento());

                }

            }

            if (e.compareTo(n.getElemento()) <= 0 || encontrado) {
                if (encontrado) {
                    encontrado = clonarInvertidoAux(encontrado, 1, n.getIzquierdo(), e, cloneInvertido.getIzquierdo(), aux, p);
                } else {
                    encontrado = clonarInvertidoAux(encontrado, 1, n.getIzquierdo(), e, cloneInvertido, aux, p);
                }

            } else {
                if (encontrado) {
                    encontrado = clonarInvertidoAux(encontrado, 2, n.getDerecho(), e, cloneInvertido.getDerecho(), aux, p);
                } else {
                    encontrado = clonarInvertidoAux(encontrado, 2, n.getDerecho(), e, cloneInvertido, aux, p);
                }

            }

        }
        return encontrado;
    }

    private boolean clonarInvertidoAux01(boolean encontrado, int posicion, NodoArbol n, Comparable e, NodoArbol cloneInvertido, NodoArbol aux, ArbolBB p) {

        if (n != null) {

            if (n.getElemento().compareTo(e) == 0 || encontrado) {
                System.out.println(" 5 " + n.getElemento());

                NodoArbol temp = new NodoArbol(n.getElemento(), n.getDerecho(), n.getIzquierdo());
                if (cloneInvertido == null) {
                    cloneInvertido = temp;
                    System.out.println(cloneInvertido.getElemento());
                    encontrado = true;
                }

            }

            if (e.compareTo(n.getElemento()) <= 0 || encontrado) {
                if ((encontrado) && (n.getIzquierdo() != null)) {
                    encontrado = clonarInvertidoAux01(encontrado, 1, n.getIzquierdo(), e, cloneInvertido.getIzquierdo(), aux, p);
                } else {
                    encontrado = clonarInvertidoAux01(encontrado, 1, n.getIzquierdo(), e, cloneInvertido, aux, p);
                }

            } else {
                if (encontrado) {
                    encontrado = clonarInvertidoAux01(encontrado, 2, n.getDerecho(), e, cloneInvertido.getDerecho(), aux, p);
                } else {
                    encontrado = clonarInvertidoAux01(encontrado, 2, n.getDerecho(), e, cloneInvertido, aux, p);
                }

            }

        }
        return encontrado;
    }

    public ArbolBB clonarInvertir(Comparable e) {
        ArbolBB arbolInvertido = new ArbolBB();

        if (this.raiz != null) {
            NodoArbol ref = perteneceAux(this.raiz, e);

            if (ref != null) {

                NodoArbol nuevoArbolInvertido = new NodoArbol(ref.getElemento(), null, null);
                arbolInvertido.raiz = nuevoArbolInvertido;
                auxI(ref, arbolInvertido.raiz);
            }

        }
        return arbolInvertido;

    }

    private void auxI(NodoArbol n, NodoArbol padre) {

        if (n != null) {

            if (n.getIzquierdo() != null) {
                padre.setDerecho(new NodoArbol(n.getIzquierdo().getElemento(), null, null));

                if (n.getIzquierdo().getIzquierdo() != null || n.getIzquierdo().getDerecho() != null) {

                    auxI(n.getIzquierdo(), padre.getDerecho());
                }

            }
            if (n.getDerecho() != null) {

                padre.setIzquierdo(new NodoArbol(n.getDerecho().getElemento(), null, null));

                if (n.getDerecho().getDerecho() != null || n.getDerecho().getIzquierdo() != null) {
                    auxI(n.getDerecho(), padre.getIzquierdo());
                }
            }

        }

    }

    public String ConcatenerPreOrden(Comparable car, int maximo) {
        String resultado = "";
        int cant = 0;
        int compesacion = 0;
        if (this.raiz != null) {
            NodoArbol ref = perteneceAux(this.raiz, car);

            if (ref != null) {
                resultado = auxConcatenerPreOrden(ref, maximo, cant);
                System.out.println("valor actulizado de cant ? " + cant);

            }

            compesacion = (resultado.length()) - maximo;
            System.out.println("comepsacion " + compesacion);
            if (compesacion < 0) {
                compesacion = compesacion * -1;
                for (int i = 0; i < compesacion; i++) {
                    resultado = "# " + resultado;
                }
            }

        }
        return resultado;
    }

    private String auxConcatenerPreOrden(NodoArbol n, int maximo, int cant) {
        String res = "";

        if (n != null && cant <= maximo) {

            res = res + n.getElemento();
            cant = cant + 1;
            res = res + auxConcatenerPreOrden(n.getIzquierdo(), maximo, cant);

            res = res + auxConcatenerPreOrden(n.getDerecho(), maximo, cant);
        }

        return res;
    }

    public int prueba(boolean valores, int mover) {
        int res = 0;
        if (mover == 30) {
            valores = true;
            //mostrar
            System.out.println("valores " + valores);
            res = mover;
        } else {

            System.out.println("valores " + valores);
            System.out.println("valor de res " + res);
            res = prueba(valores, mover + 1);
            System.out.println("valor de res " + res);
            res = 80;
            System.out.println("valores " + valores);
            if (mover <= res) {
                valores = true;
                System.out.println("valores  232323" + valores + " 30 ? " + res + " y mover 29 " + mover);
            }

        }
        return res;
    }

    public int sumarPreOrden(Comparable elemento, int maximo) {
        int res = 0;
        if (this.raiz != null) {
            NodoArbol ref = perteneceAux(this.raiz, elemento);

            if (ref != null) {

                res = sumarPreOrdenAux2(ref, maximo, res);
                System.out.println("valor de res " + res);
            }

        }
        return res;
    }

    private int sumarPreOrdenAux(NodoArbol n, int maximo) {

        int cant = 0;

        if (n != null) {

            cant = cant + (int) n.getElemento();
            System.out.println("cant: " + cant + " nodo " + n.getElemento());

            cant = (int) n.getElemento() + sumarPreOrdenAux(n.getIzquierdo(), maximo);
            System.out.println("valor de cant " + cant);

            System.out.println("23234");
            System.out.println("cant: " + cant + " nodo " + n.getElemento());

        }

        return cant;
    }

    private int sumarPreOrdenAux2(NodoArbol n, int maximo, int cant) {
        int res = 0;
        if (n != null) {
            System.out.println("nodo " + n.getElemento());

            cant = cant + (int) n.getElemento();
            res = cant;
            System.out.println("cant: " + cant + " nodo " + n.getElemento());
            if (cant <= maximo) {
                System.out.println("88 " + sumarPreOrdenAux2(n.getIzquierdo(), maximo, cant));
                res = res + sumarPreOrdenAux2(n.getIzquierdo(), maximo, cant);
                System.out.println("82618 " + sumarPreOrdenAux2(n.getIzquierdo(), maximo, cant));
                System.out.println("valor de res " + res + " nodo " + n.getElemento());
                if (res < maximo) {
                    sumarPreOrdenAux2(n.getDerecho(), maximo, cant);

                    System.out.println("23234");
                    System.out.println("cant: " + cant + " nodo " + n.getElemento());

                }

                System.out.println("232343 r23tr4t4");
                System.out.println("canteq3r2 3r23r: " + cant + " nodo " + n.getElemento());

            }

        }
        return res;
    }

    public void eliminarHoja(Comparable min, Comparable max) {

        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() == null && this.raiz.getDerecho() == null && this.raiz.getElemento().compareTo(min) > 0 && this.raiz.getElemento().compareTo(max) < 0) {
                this.raiz = null;
            } else {

                if (this.raiz.getIzquierdo() != null) {

                    eliminarHojaAux(this.raiz.getIzquierdo(), min, max);
                }
                if (this.raiz.getDerecho() != null) {
                    eliminarHojaAux(this.raiz.getDerecho(), min, max);
                }

            }

        }
    }

    private void eliminarHojaAux(NodoArbol n, Comparable min, Comparable max) {

        if (n != null) {

            if (n.getIzquierdo().getElemento().compareTo(min) > 0 && n.getIzquierdo().getElemento().compareTo(max) < 0) {

                NodoArbol NI = n.getIzquierdo();
                if (NI.getIzquierdo() == null && NI.getDerecho() == null) {

                    n.setIzquierdo(null);
                } else {
                    eliminarHojaAux(n.getIzquierdo(), min, max);
                }

            }

            if (n.getDerecho().getElemento().compareTo(min) > 0 && n.getDerecho().getElemento().compareTo(max) < 0) {
                //recursivo
                NodoArbol ND = n.getDerecho();
                if (ND.getIzquierdo() == null && ND.getDerecho() == null) {
                    //elimino
                    n.setDerecho(null);
                } else {
                    eliminarHojaAux(n.getDerecho(), min, max);
                }

            }

        }

    }

    public void eliminarMinimo() {

        if (this.raiz != null) {
            eliminarMinimoAux(this.raiz);
        }
    }

    private void eliminarMinimoAux(NodoArbol n) {

        if (n != null) {

            if (n.getIzquierdo() != null) {
                NodoArbol t = n.getIzquierdo();
                if (t.getIzquierdo() == null && t.getDerecho() == null) {
                    System.out.println("que elemento elimino ");
                    n.setIzquierdo(null);
                } else {

                    if (t.getIzquierdo() == null && t.getDerecho() != null) {
                        n.setIzquierdo(t.getDerecho());

                    } else {
                        eliminarMinimoAux(n.getIzquierdo());
                    }
                }

            }

        }

    }

    public ArbolBB invertirClonParcial(Comparable p) {
        ArbolBB nuevoAbb = new ArbolBB();

        if (this.raiz != null) {
            NodoArbol res = this.perteneceAux(this.raiz, p);

            if (res != null) {
                //creo la raiz

                NodoArbol raizClone = new NodoArbol(res.getElemento(), null, null);
                nuevoAbb.raiz = raizClone;
                invertirCloneAuxParcial(res, raizClone);

            }
        }

        return nuevoAbb;
    }

    private void invertirCloneAuxParcial(NodoArbol n, NodoArbol p) {

        if (n != null) {

            NodoArbol i = n.getIzquierdo();
            NodoArbol d = n.getDerecho();

            if (i != null) {
                p.setDerecho(new NodoArbol(i.getElemento(), null, null));
                //llamo 
                invertirCloneAuxParcial(n.getIzquierdo(), p.getDerecho());
            }
            if (d != null) {
                p.setIzquierdo(new NodoArbol(d.getElemento(), null, null));
                invertirCloneAuxParcial(n.getDerecho(), p.getIzquierdo());
            }

        }
    }

    public Lista listarMayoresQue(Comparable p, Comparable aBuscar) {
        Lista ls = new Lista();

        if (this.raiz != null) {
            NodoArbol aux = perteneceAux(this.raiz, aBuscar);
          //  System.out.println("encontrado ? " + aux.getElemento());
            if (aux != null) {
                if (aux.getElemento().compareTo(p) >= 0) {
                    ls.insertar(aux.getElemento(), ls.longitud() + 1);
                    listarMayoresQueAux(aux, p, ls);
                } else {
                    listarMayoresQueAux(aux, p, ls);
                }
            }

        }
        return ls;
    }

    private void listarMayoresQueAux(NodoArbol n, Comparable p, Lista ls) {

        if (n != null) {
            System.out.println("valor " + n.getElemento());
            if (n.getIzquierdo() != null && p.compareTo(n.getIzquierdo().getElemento()) <= 0) {
                ls.insertar(n.getIzquierdo().getElemento(), ls.longitud() + 1);
                listarMayoresQueAux(n.getIzquierdo(), p, ls);

            }

            if (n.getDerecho() != null && p.compareTo(n.getDerecho().getElemento()) <= 0) {
                ls.insertar(n.getDerecho().getElemento(), ls.longitud() + 1);
                listarMayoresQueAux(n.getDerecho(), p, ls);

            }

        }

    }

    public boolean esVacio() {

        return this.raiz == null;
    }

    public Lista listarPreorden() {
        Lista ls = new Lista();

        if (this.raiz != null) {
            NodoArbol NodoAux = this.raiz;

            //System.out.println("nodo raiz " + NodoAux.getElemento());
            //ls.insertar(NodoAux.getElemento(), 1);
            this.auxPreOrden(NodoAux, ls, 0);

        }

        return ls;
    }

    private void auxPreOrden(NodoArbol NodoAux, Lista ls, int pos) {
        if (NodoAux != null) {
           
            Object aux = NodoAux.getElemento();
            ls.insertar(aux, pos+1);
             auxPreOrden(NodoAux.getIzquierdo(), ls, pos);
                 auxPreOrden(NodoAux.getDerecho(), ls, pos);

        }

         
         
         

        
       
    }
        public Lista listarInorden() {
        Lista ls = new Lista();

        if (this.raiz != null) {
            NodoArbol NodoAux = this.raiz;

            //System.out.println("nodo raiz " + NodoAux.getElemento());

            this.auxInorden(NodoAux, ls, 0);

        }

        return ls;
    }
            private void auxInorden(NodoArbol NodoAux, Lista ls, int pos) {
                 Object aux ;
        if (NodoAux.getIzquierdo()!= null) {
         auxPreOrden(NodoAux.getIzquierdo(), ls, pos);
  
        }                     pos++;
             aux = NodoAux.getElemento();
            ls.insertar(aux, pos);
        
        
        
    
       
    }
        
}

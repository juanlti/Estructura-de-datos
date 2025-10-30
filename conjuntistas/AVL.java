package services;
//avl listo

import services.conjuntistas.NodoAVL;

public class AVL {

    private NodoAVL raiz = null;

    public AVL() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public boolean eliminar(Comparable x) {
        this.raiz = eliminarAux(this.raiz, x);
        return true;
    }

    public boolean insertar(Comparable elemento) {
        this.raiz = insertarAux(this.raiz, elemento);
        return true; // si querés detectar duplicado, podés agregar un flag
    }

    private NodoAVL insertarAux(NodoAVL nodo, Comparable elemento) {
        // 1) Caso base
        if (nodo == null) {
            return new NodoAVL(elemento);
        }

        Comparable contenido = nodo.getElemento();

        if (elemento.compareTo(contenido) < 0) {
            // 2) Bajar por izquierda con ramificación "separada"
            if (nodo.getIzquierdo() != null) {
                nodo.setIzquierdo(insertarAux(nodo.getIzquierdo(), elemento)); // reconectar
            } else {
                nodo.setIzquierdo(new NodoAVL(elemento));
            }
        } else if (elemento.compareTo(contenido) > 0) {
            // 2) Bajar por derecha con ramificación "separada"
            if (nodo.getDerecho() != null) {
                nodo.setDerecho(insertarAux(nodo.getDerecho(), elemento)); // reconectar
            } else {
                nodo.setDerecho(new NodoAVL(elemento));
            }
        } else {
            // duplicado: no cambies estructura
            return nodo;
        }

        nodo.recalcularAltura();
        //return this.balancear(nodo);
        //return this.balancear(nodo);
        return nodo;
        //return nodo; // cuando actives AVL: return balancear(nodo);
    }

    // baja hasta encontrar el nodo
    private NodoAVL eliminarAux(NodoAVL nodo, Comparable x) {
        if (nodo == null) {
            return null;
        }

        int cmp = x.compareTo(nodo.getElemento());
        if (cmp < 0) {
            nodo.setIzquierdo(eliminarAux(nodo.getIzquierdo(), x));
            return balancear(nodo);
        } else if (cmp > 0) {
            nodo.setDerecho(eliminarAux(nodo.getDerecho(), x));
            return balancear(nodo);
        } else {

            // Reutilizá tus helpers aquí si querés:
            // return eliminarNodoYDevolverNuevaRaiz(nodo);  // si lo implementás
            // O directamente inline como arriba (0/1/2 hijos) y:
            // return balancear(nodo);
            // (lo de arriba ya te lo dejé resuelto)
            // --- Inline tal cual lo dejé arriba es más simple y seguro ---
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            NodoAVL suc = minimo(nodo.getDerecho());
            nodo.setElemento(suc.getElemento());
            nodo.setDerecho(eliminarAux(nodo.getDerecho(), suc.getElemento()));
            return balancear(nodo);
        }
    }

    private NodoAVL minimo(NodoAVL n) {
        while (n.getIzquierdo() != null) {
            n = n.getIzquierdo();
        }
        return n;
    }

    private boolean eliminarNodo(NodoAVL nodo, NodoAVL padre) {
        NodoAVL izquierdo = nodo.getIzquierdo();
        NodoAVL derecho = nodo.getDerecho();
        // determino el caso a eliminar
        if (izquierdo == null && derecho == null) {
            // elimino un nodo hoja (sin hijos)
            eliminarHoja(nodo, padre);
        } else if (izquierdo != null && derecho != null) {
            // elimino un nodo con dos hijos
            eliminarConDosHijos(nodo);
        } else {
            // elimino un nodo con un hijo, uno izquierdo o derecho, pero no ambos
            eliminarConUnHijo(nodo, padre);
        }
        return true;
    }

    // caso 1
    private boolean eliminarHoja(NodoAVL hijo, NodoAVL padre) {
        boolean eliminado = false;
        if (padre == null) {
            // caso especial un unico elemento
            this.raiz = null;
        } else if (padre.getIzquierdo() == hijo) {
            padre.setIzquierdo(null);
            eliminado = true;
        } else {
            padre.setDerecho(null);
            eliminado = true;
        }
        return eliminado;
    }

    // caso 2
    private boolean eliminarConUnHijo(NodoAVL hijo, NodoAVL padre) {
        NodoAVL izquierdo = hijo.getIzquierdo();
        NodoAVL derecho = hijo.getDerecho();
        boolean eliminado = false;
        if (padre == null) {
            // caso especial de la raiz con un hijo
            this.raiz = (izquierdo != null) ? izquierdo : derecho;
        } else if (izquierdo != null) {
            padre.setIzquierdo(izquierdo);
            eliminado = true;
        } else {
            padre.setDerecho(derecho);
            eliminado = true;
        }
        return eliminado;
    }

    // caso 3
    private boolean eliminarConDosHijos(NodoAVL nodo) {
        NodoAVL candidato = nodo.getDerecho();
        NodoAVL padreCandidato = nodo;
        boolean eliminado = false;
        // obtengo el menor de los mayores (candidato)
        while (candidato.getIzquierdo() != null) {
            padreCandidato = candidato;
            candidato = candidato.getIzquierdo();
        }
        // remplazo el valor del nodo a eliminar por el valor del candidato
        nodo.setElemento(candidato.getElemento());
        // hijo pude ser null o no
        NodoAVL hijoCandidato = candidato.getDerecho();
        // elimina el nodo
        // el candidato es el hijo derecho del nodo a eliminar?
        if (nodo.getDerecho() == candidato) {
            // caso especial, el candidato es hijo del nodo
            nodo.setDerecho(hijoCandidato);
            eliminado = true;
        } else {
            // caso comun, el candidato no es hijo del nodo
            padreCandidato.setIzquierdo(hijoCandidato);
            eliminado = true;
        }
        return eliminado;
    }

    /*
    private NodoAVL balancear(NodoAVL nodo) {
        if (nodo == null) {
            return null;
        }

        // 1) Recalcular antes de leer el balance
        nodo.recalcularAltura();
        int balancePadre = nodo.calcularBalance(); // convención: altura(izq) - altura(der)

        // Si ya está dentro de [-1, 1], no toco nada
        if (balancePadre >= -1 && balancePadre <= 1) {
            return nodo;
        }

        // 2) Desbalance a la izquierda (LL/LR)
        if (balancePadre > 1) {
            int balanceHijo = (nodo.getIzquierdo() != null) ? nodo.getIzquierdo().calcularBalance() : 0;
            // LR si el hijo izq está cargado a la derecha
            if (balanceHijo < 0) {
                return rotarIzquierdaDerecha(nodo);
            } else {
                return rotarDerecha(nodo);
            }
        }

        // 3) Desbalance a la derecha (RR/RL)
        if (balancePadre < -1) {
            int balanceHijo = (nodo.getDerecho() != null) ? nodo.getDerecho().calcularBalance() : 0;
            // RL si el hijo der está cargado a la izquierda
            if (balanceHijo > 0) {
                return rotarDerechaIzquierda(nodo);
            } else {
                return rotarIzquierda(nodo);
            }
        }

        return nodo; // por completitud
    }
     */
    private NodoAVL balancear(NodoAVL n) {
        if (n == null) {
            return null;
        }
        n.recalcularAltura();
        int b = n.calcularBalance(); // izq - der

        if (b > 1) {
            if (n.getIzquierdo().calcularBalance() < 0) {
                n.setIzquierdo(rotarIzquierda(n.getIzquierdo())); // LR
            }
            return rotarDerecha(n); // LL
        }
        if (b < -1) {
            if (n.getDerecho().calcularBalance() > 0) {
                n.setDerecho(rotarDerecha(n.getDerecho())); // RL
            }
            return rotarIzquierda(n); // RR
        }
        return n;
    }

    private NodoAVL rotarIzquierda(NodoAVL nodo) {
        // pivot
        NodoAVL h = nodo.getDerecho();
        // temporal
        NodoAVL temp = h.getIzquierdo();
        h.setIzquierdo(nodo);
        nodo.setDerecho(temp);
        // recalculo altura de nodo y su "hijo"
        nodo.recalcularAltura();
        h.recalcularAltura();
        return h;
    }

    private NodoAVL rotarDerecha(NodoAVL nodo) {
        // pivot
        NodoAVL h = nodo.getIzquierdo();
        // temporal
        NodoAVL temp = h.getDerecho();
        h.setDerecho(nodo);
        nodo.setIzquierdo(temp);
        // recalculo altura del nodo y su "hijo"
        nodo.recalcularAltura();
        h.recalcularAltura();
        return h;
    }

    private NodoAVL rotarIzquierdaDerecha(NodoAVL nodo) {
        nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
        return rotarDerecha(nodo);
    }

    private NodoAVL rotarDerechaIzquierda(NodoAVL nodo) {
        nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
        return rotarIzquierda(nodo);
    }

    public Lista listar() {
        Lista lista = new Lista();
        listarAux(this.raiz, lista);
        return lista;
    }

    public void listarAux(NodoAVL nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemento(), 1);
            listarAux(nodo.getIzquierdo(), lista);
        }
    }

    public boolean pertenece(Comparable x) {
        boolean pertenece = false;
        NodoAVL nodo = this.raiz;
        Comparable elemento;
        while (nodo != null && !pertenece) {
            elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                pertenece = true;
            } else if (elemento.compareTo(x) > 0) {
                nodo = nodo.getIzquierdo();
            } else if (elemento.compareTo(x) < 0) {
                nodo = nodo.getDerecho();
            }
        }
        return pertenece;
    }

    public Comparable minimoElem() {
        Comparable elemento = null;
        NodoAVL nodo = this.raiz;
        // bajada por la izquierda
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximoElem() {
        Comparable elemento = null;
        NodoAVL nodo = this.raiz;
        // bajada por la derecha
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    public Lista listarRango(int minimo, int maximo) {
        Lista lista = new Lista();
        listarRangoAux(this.raiz, lista, minimo, maximo);
        return lista;
    }

    private void listarRangoAux(NodoAVL nodo, Lista lista, int minimo, int maximo) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(maximo) < 0) {
                listarRangoAux(nodo.getDerecho(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                lista.insertar(elemento, 1);
            }
            if (elemento.compareTo(minimo) > 0) {
                listarRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
            }
        }
    }

    // utilidad, no prestar antencion
    public void llenar(int[] num) {

        for (int i = 0; i < num.length; i++) {
            insertar(num[i]);
        }
    }

    // copiado de arbol binario
    public String toString() {
        String res = " ";
        if (this.raiz != null) {
            res = toStringAux(this.raiz, res);
        }
        return res;
    }

    // copiado de arbol binario
    private String toStringAux(NodoAVL nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            /// System.out.println("2323423");
            if (nodo.getIzquierdo() != null) {
                System.out.println("actual " + nodo.getIzquierdo().getElemento());
            }
            NodoAVL izquierdo = nodo.getIzquierdo();
            //  System.out.println("izq  "+izquierdo.getElemento());
            NodoAVL derecho = nodo.getDerecho();
            s += "HI: " + ((izquierdo != null) ? izquierdo.getElemento() : "-") + "\t"
                    + "HD: " + ((derecho != null) ? derecho.getElemento() : "-");
            //   System.out.println("vaorrr de s " + s);
            s = toStringAux(nodo.getIzquierdo(), s);
            s = toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

}

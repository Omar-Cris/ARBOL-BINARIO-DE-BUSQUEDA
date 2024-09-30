public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            raiz = new Nodo(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = insertarRecursivo(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = insertarRecursivo(raiz.derecho, valor);
        }

        return raiz;
    }

    public void inorden() {
        inordenRecursivo(raiz);
    }

    private void inordenRecursivo(Nodo raiz) {
        if (raiz != null) {
            inordenRecursivo(raiz.izquierdo);
            System.out.print(raiz.valor + " ");
            inordenRecursivo(raiz.derecho);
        }
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor) != null;
    }

    private Nodo buscarRecursivo(Nodo raiz, int valor) {
        if (raiz == null || raiz.valor == valor) {
            return raiz;
        }
        if (valor < raiz.valor) {
            return buscarRecursivo(raiz.izquierdo, valor);
        }
        return buscarRecursivo(raiz.derecho, valor);
    }

    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.izquierdo = eliminarRecursivo(raiz.izquierdo, valor);
        } else if (valor > raiz.valor) {
            raiz.derecho = eliminarRecursivo(raiz.derecho, valor);
        } else {
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            raiz.valor = valorMinimo(raiz.derecho);
            raiz.derecho = eliminarRecursivo(raiz.derecho, raiz.valor);
        }

        return raiz;
    }

    private int valorMinimo(Nodo raiz) {
        int minv = raiz.valor;
        while (raiz.izquierdo != null) {
            minv = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return minv;
    }
}

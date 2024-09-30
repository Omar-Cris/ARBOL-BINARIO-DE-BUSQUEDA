public class Main {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.insertar(90);
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(100);
        arbol.insertar(60);
        arbol.insertar(80);
        arbol.insertar(10);

        System.out.println("Recorrido en orden:");
        arbol.inorden();
        System.out.println("\n¿Existe el valor 70?: " + arbol.buscar(70));
        System.out.println("Eliminando el valor 40...");
        arbol.eliminar(40);
        System.out.println("Nuevo recorrido en orden:");
        arbol.inorden();
    }
}

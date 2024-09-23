package e2;


import java.util.LinkedList;
import java.util.Queue;

public class mapa {
    private nodo nodoRaiz;
    public void setNodoRaiz(nodo nodo){
        nodoRaiz = nodo;
    }
    public void simularIncursion(flota A){
        nodoRaiz.simular(A);
        if(A.nodoFinal.getTipo().equals("Nodo de Fin")){
            System.out.println("Resultado de la Incursión:\n\tEXITO\n\tUltimo nodo visitado: " + A.nodoFinal.getNombre() +"\n\tHP final: "+ A.getHp());
        }
        else System.out.println("Resultado de la Incursión:\n\tFALLO\n\tUltimo nodo visitado: " + A.nodoFinal.getNombre() +"\n\tHP final: "+ A.getHp());

    }
    public int minNodo() {

        Queue<nodo> cola = new LinkedList<>();
        Queue<Integer> longitudCola = new LinkedList<>();
        cola.add(nodoRaiz);
        longitudCola.add(1);

        while (!cola.isEmpty()) {
            nodo actual = cola.poll();
            int longitudActual = longitudCola.poll();

            if (actual.getTipo().equals("Nodo de Fin")) {
                return longitudActual;
            }
            if (actual.getHijoIzquierda() != null) {
                cola.add(actual.getHijoIzquierda());
                longitudCola.add(longitudActual + 1);
            }
            if (actual.getHijoDerecha() != null) {
                cola.add(actual.getHijoDerecha());
                longitudCola.add(longitudActual + 1);
            }
        }
        return -1;
    }

    public void printMinNodo(){
        System.out.println("Smallest Node Count to End: "+ minNodo());
    }
    public void printNewick(){
        System.out.println(nodoRaiz.toNewick());
    }
}

package e2;

public class avistamiento extends nodo implements Estrategia{
        private final int distancia;
        private nodo nodoIzquierdo;
        private nodo nodoDerecho;
        public avistamiento(Character nombre, int distancia) {
            setNombre(nombre);
            this.distancia = distancia;
        }
        @Override
        public String getTipo() {
            return "Avistamiento";
        }

        @Override
        public void simular(flota flota) {
            if(flota.getVision()>=distancia) nodoIzquierdo.simular(flota);
            else nodoDerecho.simular(flota);
        }
        @Override
        public void setHijoIzquierda(nodo nodo) {
            nodoIzquierdo = nodo;
        }

        @Override
        public void setHijoDerecha(nodo nodo) {
            nodoDerecho = nodo;
        }

        @Override
        public nodo getHijoIzquierda() {
            return nodoIzquierdo;
        }

        @Override
        public nodo getHijoDerecha() {
            return nodoDerecho;
        }
    }

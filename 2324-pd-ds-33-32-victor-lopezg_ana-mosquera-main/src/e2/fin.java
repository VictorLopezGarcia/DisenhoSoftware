package e2;

public class fin extends nodo implements Estrategia {
    public fin(Character nombre) {
        setNombre(nombre);
    }

    @Override
    public String getTipo() {
        return "Nodo de Fin";
    }

    @Override
    public void simular(flota flota) {
        flota.nodoFinal = this;
    }

    @Override
    public void setHijoIzquierda(nodo nodo){}

    @Override
    public void setHijoDerecha(nodo nodo){}

    @Override
    public nodo getHijoIzquierda() {
        return null;
    }

    @Override
    public nodo getHijoDerecha() {
        return null;
    }
}

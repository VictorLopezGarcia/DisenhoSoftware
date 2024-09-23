package e2;

public class tormentaMarina extends nodo implements Estrategia {
    private final int fuerza;
    private nodo nodoHijo;

    public tormentaMarina(Character nombre, int fuerza) {
        setNombre(nombre);
        this.fuerza = fuerza;
    }

    @Override
    public String getTipo() {
        return "Tormenta Marina";
    }

    @Override
    public void simular(flota flota) {
        if (flota.getVision() < fuerza) flota.dano(10);
        if (flota.getHp() > 0) nodoHijo.simular(flota);
        else flota.nodoFinal = this;
    }

    @Override
    public void setHijoIzquierda(nodo nodo) {
        nodoHijo = nodo;
    }

    @Override
    public void setHijoDerecha(nodo nodo) {
        nodoHijo = nodo;
    }

    @Override
    public nodo getHijoIzquierda() {
        return nodoHijo;
    }

    @Override
    public nodo getHijoDerecha() {
        return null;
    }
}

package e2;

public abstract class nodo implements Estrategia {
    private Character nombre;
    public nodo() {
    }

    public abstract String getTipo();
    public void setNombre(Character nombre){
        this.nombre = nombre;
    }

    public abstract void setHijoIzquierda(nodo nodo);

    public abstract void setHijoDerecha(nodo nodo);

    public abstract nodo getHijoIzquierda();

    public abstract nodo getHijoDerecha();

    public String toNewick() {
        StringBuilder newickBuilder = new StringBuilder();


        newickBuilder.append("(");
        if (this instanceof fin) {
            newickBuilder.append(nombre).append(" ").append(getTipo());

        } else newickBuilder.append(nombre).append(" ").append(getTipo()).append(", ");
        boolean firstChild = true;
        if (getHijoIzquierda() != null) {
            newickBuilder.append(getHijoIzquierda().toNewick());
            firstChild = false;
        }
        if (getHijoDerecha() != null) {
            if (!firstChild) {
                newickBuilder.append(", ");
            }
            newickBuilder.append(getHijoDerecha().toNewick());
        }

        if (this instanceof fin) {
            newickBuilder.append(")");

        } else newickBuilder.append(")");

        return newickBuilder.toString();
    }

    public Character getNombre() {
        return nombre;
    }
}
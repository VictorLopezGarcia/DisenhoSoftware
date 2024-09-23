package e2;

public class flota {
    private int hp;
    private final int blindaje;
    private final int poder;
    private final int antiaereo;
    private final int vision;
    public nodo nodoFinal;
    public flota(int hp, int blindaje, int poder, int antiaereo, int vision){
        this.hp = hp;
        this.blindaje = blindaje;
        this.poder = poder;
        this.antiaereo = antiaereo;
        this.vision = vision;
    }
    public void dano(int valor){
        hp -= valor;
    }
    public int getHp() {
        return hp;
    }
    public int getBlindaje() {
        return blindaje;
    }
    public int getPoder() {
        return poder;
    }
    public int getAntiaereo() {
        return antiaereo;
    }
    public int getVision() {
        return vision;
    }
}


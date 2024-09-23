package e2;
abstract class Objetos {
    protected String codename;

    public Objetos (String codename){
        this.codename = codename;

    }

    public abstract void usar();

}

//Clases para representar objeto ataque
class ObjetoAtaque extends Objetos {
    protected int dano;
    protected int danoI;
    protected int minMana;
    protected int usos;
    protected int maxUsos;



    public ObjetoAtaque(String codename, int dano, int minMana, int usos) {
        super(codename);
        this.dano = dano;
        this.danoI = dano;
        this.minMana = minMana;
        this.usos = usos;
        this.maxUsos = usos;
    }


    @Override
    public void usar() {
        if (usos > 0) {
            if (codename.contentEquals("Wand") && usos == maxUsos) {
                dano = dano*2;
            }
            else if (codename.contentEquals("Wand") && usos != maxUsos) {
                dano = danoI;
            }
            else if (codename.contentEquals("FireBallSpell") && usos == 1) {
                dano = dano-1;
            }
            else if (codename.contentEquals("FireBallSpell") && usos != 1) {
                dano = danoI;
            }
            System.out.println(codename + " ataca haciendo un daño de " + dano);
            usos--;
        } else {
            System.out.println(codename + " se quedó sin usos ");
        }
    }
}
class ObjetoProteccion extends Objetos{
    protected int proteccion;
    protected int minFuerza;
    public ObjetoProteccion(String codename, int proteccion, int minFuerza) {
        super(codename);
        this.proteccion = proteccion;
        this.minFuerza = minFuerza;

    }
    @Override
    public void usar() {
        System.out.println("¡Protección con " + codename + "! Protección: " + proteccion);
    }

}




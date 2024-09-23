package e2;

public class Personajes {

    protected  String nombre;
    protected int vida;
    protected int fuerza;
    protected  int mana;
    protected ObjetoProteccion[] objetosDefensivos;
    protected ObjetoAtaque[] objetosAtaques;

    public int getVida() {
        return vida;
    }

    public String getNombre() {
        return nombre;
    }


    public Personajes(String nombre, int vida, int fuerza, int mana){
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.mana = mana;
        this.objetosDefensivos = new ObjetoProteccion[5];
        this.objetosAtaques = new ObjetoAtaque[5];
    }

    public void escogerObjetosDefensivos(ObjetoProteccion objetos){
        for(int i = 0; i < objetosDefensivos.length;i++){
            if(objetosDefensivos[i] == null){
                objetosDefensivos[i] = objetos;
            }
        }
        System.out.println(getNombre() + " se definede con el objeto " + objetos.codename);
    }


    public void escogerObjetosAtaque(ObjetoAtaque objetos) {
        for (int i = 0; i < objetosAtaques.length; i++) {
            if (objetosAtaques[i] == null) {
                objetosAtaques[i] = objetos;
            }
        }

        System.out.println(getNombre() + " ataca con el objeto " + objetos.codename);
    }


    public void recibirdano(int dano){
        this.vida += calculoProteccion() - dano;
    }

    int calculoProteccion() {
        for (ObjetoProteccion Objeto : objetosDefensivos) {
            if (Objeto != null) {
                return Objeto.proteccion;
            }
        }
        return 0;
    }
}

//Personaje tipo Wizard

class Wizard extends Personajes{

    public Wizard(String nombre, int vida, int fuerza, int mana){
        super(nombre, vida, fuerza, mana);
    }

}
//Persoje tipo Warrior
class Warrior extends Personajes{
    public Warrior(String nombre, int vida, int fuerza, int mana){
        super(nombre, vida, fuerza, mana);
    }


}
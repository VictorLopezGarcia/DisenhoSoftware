package e4P1;

public enum BolaBillar {

    BLANCA(BolaN.CERO, BolaC.BLANCO, BolaT.LISA),
    BOLA1(BolaN.UNO, BolaC.AMARILLO, BolaT.LISA),
    BOLA2(BolaN.DOS, BolaC.AZUL, BolaT.LISA),
    BOLA3(BolaN.TRES, BolaC.ROJO, BolaT.LISA),
    BOLA4(BolaN.CUATRO, BolaC.VIOLETA, BolaT.LISA),
    BOLA5(BolaN.CINCO, BolaC.NARANJA, BolaT.LISA),
    BOLA6(BolaN.SEIS, BolaC.VERDE, BolaT.LISA),
    BOLA7(BolaN.SIETE, BolaC.GRANATE, BolaT.LISA),
    BOLA8(BolaN.OCHO, BolaC.NEGRO, BolaT.LISA),
    BOLA9(BolaN.NUEVE, BolaC.AMARILLO, BolaT.RAYADA),
    BOLA10(BolaN.DIEZ, BolaC.AZUL, BolaT.RAYADA),
    BOLA11(BolaN.ONCE, BolaC.ROJO, BolaT.RAYADA),
    BOLA12(BolaN.DOCE, BolaC.VIOLETA, BolaT.RAYADA),
    BOLA13(BolaN.TRECE, BolaC.NARANJA, BolaT.RAYADA),
    BOLA14(BolaN.CATORCE, BolaC.VERDE, BolaT.RAYADA),
    BOLA15(BolaN.QUINCE, BolaC.GRANATE, BolaT.RAYADA);

    public enum BolaN {
        CERO, UNO,
        DOS, TRES,
        CUATRO, CINCO,
        SEIS, SIETE,
        OCHO, NUEVE,
        DIEZ, ONCE,
        DOCE, TRECE,
        CATORCE, QUINCE;
    }

    public enum BolaC {
        BLANCO, AMARILLO,
        AZUL, ROJO,
        VIOLETA, NARANJA,
        VERDE, GRANATE,
        NEGRO;
    }

    public enum BolaT {
        RAYADA,
        LISA;
    }

    private final BolaN num;
    private final BolaC color;
    private final BolaT tipo;


    private BolaBillar(BolaN num, BolaC color, BolaT tipo) {
        this.num = num;
        this.color = color;
        this.tipo = tipo;
    }


    protected BolaT getBolaT() {
        return this.tipo;
    }

    protected BolaN getBolaN() {
        return this.num;
    }

    protected BolaC getBolaC() {
        return this.color;
    }

}

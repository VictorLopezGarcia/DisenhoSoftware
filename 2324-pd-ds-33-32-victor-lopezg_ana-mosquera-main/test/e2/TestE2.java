package e2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestE2 {
    static nodo nodoA;
    static nodo nodoB;
    static nodo nodoC;
    static nodo nodoD;
    static nodo nodoE;
    static nodo nodoF;
    static nodo nodoG;
    static nodo nodoH;
    static nodo nodoI;
    static nodo nodoK;
    static mapa mapa;
    static flota A;
    static flota B;
    static flota C;
    static flota D;
    static mapa mapa2;
    static nodo nodo1;
    static nodo nodo2;
    static nodo nodo3;
    static nodo nodo4;
    static nodo nodo5;
    @BeforeAll
    static void setup(){
        nodoA = new avistamiento('A', 28);
        nodoB = new Batalla('B', 20, 30, 25);
        nodoC = new tormentaMarina('C', 20);
        nodoD = new fin('D');
        nodoE = new ataqueAereo('E',151);
        nodoF = new Batalla('F',30, 17, 41);
        nodoG = new tormentaMarina('G', 67);
        nodoH = new fin('H');
        nodoI = new fin('I');
        nodoK = new fin('K');


        nodoA.setHijoIzquierda(nodoB);
        nodoA.setHijoDerecha(nodoC);
        nodoB.setHijoIzquierda(nodoD);
        nodoB.setHijoDerecha(nodoE);
        nodoC.setHijoIzquierda(nodoF);
        nodoE.setHijoIzquierda(nodoK);
        nodoF.setHijoIzquierda(nodoH);
        nodoF.setHijoDerecha(nodoG);
        nodoG.setHijoIzquierda(nodoI);

        mapa = new mapa();
        mapa.setNodoRaiz(nodoA);

        A = new flota(11, 42, 47, 0, 0);
        B = new flota(1, 25, 0, 46, 28);
        C = new flota(1, 24, 0, 0, 28);
        D = new flota(10, 0, 0, 0, 19);

        nodo1 = new avistamiento('A', 10);
        nodo2 = new tormentaMarina('B', 10);
        nodo3 = new ataqueAereo('C', 100);
        nodo4 = new fin('D');
        nodo5 = new fin('E');

        nodo1.setHijoIzquierda(nodo2);
        nodo2.setHijoDerecha(nodo4);
        nodo1.setHijoDerecha(nodo5);
        nodo1.setHijoDerecha(nodo3);
        nodo3.setHijoDerecha(nodo5);

        mapa2 = new mapa();
        mapa2.setNodoRaiz(nodo1);
    }
    @Test
    public void simular() {

        //No deberia de dejar añadir hijos a nodos de fin
        nodoK.setHijoIzquierda(nodoI);
        nodoK.setHijoDerecha(nodoF);
        assertNull(nodoK.getHijoIzquierda());
        assertNull(nodoK.getHijoDerecha());



        mapa.simularIncursion(A);
        assertEquals(1, A.getHp());
        assertEquals('H', A.nodoFinal.getNombre());
        mapa.simularIncursion(B);
        assertEquals(-33, B.getHp());
        assertEquals('E', B.nodoFinal.getNombre());
        mapa.simularIncursion(C);
        assertEquals(0, C.getHp());
        assertEquals('B', C.nodoFinal.getNombre());
        mapa.simularIncursion(D);
        assertEquals(0, D.getHp());
        assertEquals('C', D.nodoFinal.getNombre());

    }
    @Test
    public void nodeCount() {
        assertEquals(3, mapa.minNodo());
        mapa.printMinNodo();

        assertEquals(3, mapa2.minNodo());
        mapa2.printMinNodo();

    }
    @Test
    public void newick(){
        String newick = "(A Avistamiento, (B Batalla, (D Nodo de Fin), (E Ataque Aereo, (K Nodo de Fin))), (C Tormenta Marina, (F Batalla, (H Nodo de Fin), (G Tormenta Marina, (I Nodo de Fin)))))";
        mapa.printNewick();
        assertEquals(newick, nodoA.toNewick());

        String newick2 = "(A Avistamiento, (B Tormenta Marina, (D Nodo de Fin)), (C Ataque Aereo, (E Nodo de Fin)))";
        mapa2.printNewick();
        assertEquals(newick2, nodo1.toNewick());
    }
}
package e3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GestorTest {

    private static List<artista> artistas;
    private static final List<Double> puntuacionesColdplay = new ArrayList<>();
    private static final List<String> cancionesColdplay = new ArrayList<>();
    private static final List<String> generosColdplay = new ArrayList<>();
    private static final List<Double> puntuacionesSnoopDog = new ArrayList<>();
    private static final List<String> cancionesSnoopDog = new ArrayList<>();
    private static final List<String> generosSnoopDog = new ArrayList<>();
    private static final List<Double> puntuacionesPinkFloyd = new ArrayList<>();
    private static final List<String> cancionesPinkFloyd = new ArrayList<>();
    private static final List<String> generosPinkFloyd = new ArrayList<>();
    private static final List<Double> puntuacionesQueen = new ArrayList<>();
    private static final List<String> cancionesQueen = new ArrayList<>();
    private static final List<String> generosQueen = new ArrayList<>();

    @BeforeAll
    public static void setup(){
        puntuacionesColdplay.add(4.7);
        puntuacionesColdplay.add(4.5);
        puntuacionesColdplay.add(4.9);
        puntuacionesColdplay.add(4.6);
        puntuacionesColdplay.add(4.8);

        cancionesColdplay.add("Yellow");
        cancionesColdplay.add("Fix You");
        cancionesColdplay.add("Viva la Vida");
        cancionesColdplay.add("Clocks");
        cancionesColdplay.add("The Scientist");

        generosColdplay.add("Alternative Rock");
        generosColdplay.add("Pop");
        generosColdplay.add("Pop Rock");
        generosColdplay.add("Rock");
        generosColdplay.add("Britpop");

        puntuacionesSnoopDog.add(4.5);
        puntuacionesSnoopDog.add(4.2);
        puntuacionesSnoopDog.add(4.7);
        puntuacionesSnoopDog.add(4.0);
        puntuacionesSnoopDog.add(4.3);

        cancionesSnoopDog.add("Gin and Juice");
        cancionesSnoopDog.add("Drop It Like It's Hot");
        cancionesSnoopDog.add("Beautiful");
        cancionesSnoopDog.add("Who Am I (What's My Name)?");
        cancionesSnoopDog.add("Young, Wild & Free");

        generosSnoopDog.add("Hip Hop");
        generosSnoopDog.add("Rap");
        generosSnoopDog.add("Gangsta Rap");
        generosSnoopDog.add("West Coast Hip Hop");
        generosSnoopDog.add("Reggae");

        puntuacionesPinkFloyd.add(4.8);
        puntuacionesPinkFloyd.add(4.6);
        puntuacionesPinkFloyd.add(4.9);

        cancionesPinkFloyd.add("Comfortably Numb");
        cancionesPinkFloyd.add("Wish You Were Here");
        cancionesPinkFloyd.add("Time");

        generosPinkFloyd.add("Rock Progresivo");
        generosPinkFloyd.add("Art Rock");
        generosPinkFloyd.add("Rock Psicodélico");

        puntuacionesQueen.add(4.9);
        puntuacionesQueen.add(4.7);
        puntuacionesQueen.add(4.8);
        puntuacionesQueen.add(4.5);
        puntuacionesQueen.add(4.6);

        cancionesQueen.add("Bohemian Rhapsody");
        cancionesQueen.add("We Will Rock You");
        cancionesQueen.add("Another One Bites the Dust");
        cancionesQueen.add("Radio Ga Ga");
        cancionesQueen.add("Under Pressure");


        generosQueen.add("Rock");
        generosQueen.add("Rock Opera");
        generosQueen.add("Glam Rock");

        artista coldplay = new artista("0000 0001 1551 394X", "Coldplay",puntuacionesColdplay,generosColdplay,cancionesColdplay,1996);
        artista SnoopDog = new artista("0000 0001 2026 9646", "SnoopDog",puntuacionesSnoopDog,generosSnoopDog,cancionesSnoopDog,1990);
        artista pinkFloyd = new artista("0000 0001 0939 7559", "Pink Floyd", puntuacionesPinkFloyd, generosPinkFloyd, cancionesPinkFloyd, 1965);
        artista queen = new artista("0000 0001 1526 5309", "Queen", puntuacionesQueen, generosQueen, cancionesQueen, 1970);

        artistas = new ArrayList<>();
        artistas.add(coldplay);
        artistas.add(SnoopDog);
        artistas.add(pinkFloyd);
        artistas.add(queen);
    }

    @Test
    public void sortOrdenNatural() {
        Collections.sort(artistas);
        for (int i = 0; i < artistas.size() - 1; i++) {
            assertTrue(artistas.get(i).getId().compareTo(artistas.get(i + 1).getId()) <= 0);
        }
    }

    @Test
    void sortComparator() {
        boolean ordenados = true;
        Gestor.sortComparator(artistas, new comparadorPuntuacion());
        for (int i = 0; i < artistas.size() - 1; i++) {
            if(artistas.get(i).getMedia() <  (artistas.get(i + 1).getMedia()))
            {
                ordenados = false;
                break;
            }
        }
        assertTrue(ordenados);

        Gestor.sortComparator(artistas, new comparadorNombre());
        for (int i = 0; i < artistas.size() - 1; i++) {
            assertTrue(artistas.get(i).getNombre().compareTo(artistas.get(i + 1).getNombre()) <= 0);
        }

        Gestor.sortComparator(artistas, new comparadorCanciones());
        for (int i = 0; i < artistas.size() - 1; i++) {
            if(artistas.get(i).getCanciones().size() < (artistas.get(i + 1).getCanciones().size())){
                ordenados = false;
                break;
            }
        }
        assertTrue(ordenados);

        Gestor.sortComparator(artistas, new comparadorFundacion());
        for (int i = 0; i < artistas.size() - 1; i++) {
            if(artistas.get(i).getFundacion() > (artistas.get(i + 1).getFundacion())){
                ordenados = false;
                break;
            }
        }
        assertTrue(ordenados);

        Gestor.sortComparator(artistas, new comparadorGeneros());
        for (int i = 0; i < artistas.size() - 1; i++) {
            if(artistas.get(i).getGeneros().size() < (artistas.get(i + 1).getGeneros().size())){
                ordenados = false;
                break;
            }
        }
        assertTrue(ordenados);
    }

    @Test
    public void testHashCode() {
        artista artista1 = new artista("0000 0001 1551 394X", "Coldplay",puntuacionesColdplay,generosColdplay,cancionesColdplay,1996);
        artista artista2 = new artista("0000 0001 1551 394X", "Coldplay",puntuacionesColdplay,generosColdplay,cancionesColdplay,1996);

        // Verifica que los hash codes sean iguales para dos artistas con los mismos atributos
        assertEquals(artista1.hashCode(), artista2.hashCode());
    }
}

package e3;

import java.util.Comparator;

public class comparadorNombre implements Comparator<artista> {
    public int compare(artista o1, artista o2) {
        return CharSequence.compare(o1.getNombre(), o2.getNombre());
    }
}

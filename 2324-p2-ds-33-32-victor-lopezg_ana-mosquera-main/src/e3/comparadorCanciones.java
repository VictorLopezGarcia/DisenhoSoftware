package e3;

import java.util.Comparator;

public class comparadorCanciones implements Comparator<artista> {
    @Override
    public int compare(artista o1, artista o2) {
        return Integer.compare(o2.getCanciones().size(), o1.getCanciones().size());
    }
}

package e3;

import java.util.Comparator;

public class comparadorPuntuacion implements Comparator<artista> {

    @Override
    public int compare(artista o1, artista o2){
        return Double.compare(o2.getMedia(), o1.getMedia());
    }
}

package e3;

import java.util.Comparator;

public class comparadorGeneros implements Comparator<artista> {
    @Override
    public int compare(artista o1, artista o2){
        return Integer.compare(o2.getGeneros().size(), o1.getGeneros().size());
    }
}

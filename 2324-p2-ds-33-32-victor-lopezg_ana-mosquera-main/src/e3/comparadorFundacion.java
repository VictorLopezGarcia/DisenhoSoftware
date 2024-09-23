package e3;

import java.util.Comparator;

public class comparadorFundacion implements Comparator<artista> {
    @Override
    public int compare(artista o1, artista o2){
        return Integer.compare(o1.getFundacion(), o2.getFundacion());
    }
}

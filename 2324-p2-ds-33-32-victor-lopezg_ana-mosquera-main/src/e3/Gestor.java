package e3;
import java.util.Comparator;
import java.util.List;
public class Gestor {
    public static void sortComparator(List<artista> artistas, Comparator<artista> comparator) {
        artistas.sort(comparator);
    }
}

package e3P1;


import java.util.*;

public class Release {
    private String id;
    private String artist;
    private String title;
    private List<Track> tracklist;

    public Release(String id) {
        this.id = id;
        this.tracklist = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }


    public void addTrack(Track track) {
        tracklist.add(track);
    }

    // El método toString() lo utilizamos para devolver
    // una representación en forma de cadena de texto de un objeto
    //creamos una instancia StringBuilder para construir la cadena de texto de salida
    //Agregamos cada Track al StringBuilder y la obtenemos utilizando el método
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Release ID: ").append(id).append("\n");
        sb.append("Artist: ").append(artist).append("\n");
        sb.append("Title: ").append(title).append("\n\n");
        sb.append("Tracklist:\n");
        for (Track track : tracklist) {
            sb.append("Track Number: ").append(track.getNumeroPista()).append("\n");
            sb.append("Track ID: ").append(track.getId()).append("\n");
            sb.append("Track Artist: ").append(track.getArtista()).append("\n");
            sb.append("Track Title: ").append(track.getTitulo()).append("\n");
            sb.append("Track Duration: ").append(track.getDuracion());
            sb.append("\n\n");
        }
        return sb.toString();
    }


    //Creamos compruebaTracks para comprobar si las listas tienen tamaños diferentes y decir que no son iguales.
    //Pasamos a convertir las listas a Sets con HashSet para eliminar los duplicados y hacer que el orden no nos importe
    // por último comparamos para saber si son iguales o no
    // este método lo utilizamos en equals().

    private boolean compruebaTracks(List<Track> list1, List<Track> list2) {
        if (list1.size() != list2.size()) {
            return false; // Si las listas tienen tamaños diferentes, no son iguales
        }

        // Convierte ambas listas a conjuntos (sets) para eliminar duplicados y el orden no importe
        Set<Track> set1 = new HashSet<>(list1);
        Set<Track> set2 = new HashSet<>(list2);

        // Compara si los conjuntos de grabaciones son iguales
        return set1.equals(set2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  return true;

        if (o == null || getClass() != o.getClass()) return false;

        Release release = (Release) o;

        return compruebaTracks(this.tracklist, release.tracklist);


    }

    @Override
    public int hashCode() {
        return Objects.hash(tracklist.getClass());
    }

}

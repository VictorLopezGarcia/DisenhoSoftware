package e3P1;

import java.util.Objects;

public class Track {
    private String NumeroPista;
    private String Id;
    private String artista;
    private String titulo;
    private int duracion;


    public Track(String NumeroPista, String Id, String artista, String titulo, int duracion) {
        this.NumeroPista = NumeroPista;
        this.Id = Id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public String getNumeroPista() {
        return NumeroPista;
    }

    public  String getId() {
        return Id;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    //El método toma un objeto Track
    // como argumento y devuelve un valor de tipo String en este caso el ID.
    public static String getRecordingId(Track track) {
        if (track != null) {
            return track.getId();
        }
        throw new IllegalArgumentException(); // O un valor predeterminado en caso de que track sea null
    }



    /*Este método y el método hashCode()
    se encargan de comparar dos objetos Track y
    verificar si son iguales en base a todos
    los atributos de la clase.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Track track = (Track) obj;
        String recordingId = Track.getRecordingId((Track) obj);


        return Objects.equals(getRecordingId((Track) this), Track.getRecordingId((Track) obj));
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}

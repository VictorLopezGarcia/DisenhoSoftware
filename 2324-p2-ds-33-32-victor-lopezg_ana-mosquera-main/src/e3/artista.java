package e3;

import java.util.List;
import java.util.Objects;

public class artista implements Comparable<artista>{
    private final String id;
    private final String nombre;
    private final List<Double> Puntuacion;
    private final List<String> generos;
    private final List<String> canciones;
    private final int fundacion;
    public artista (String id, String nombre, List<Double> Puntuacion, List<String> generos,List<String> canciones, int fundacion){
        this.id = id;
        this.nombre = nombre;
        this.Puntuacion = Puntuacion;
        this.generos = generos;
        this.canciones = canciones;
        this.fundacion = fundacion;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public List<String> getGeneros() {
        return generos;
    }
    public double getMedia() {
        double total = 0.0;
        for (Double rating : Puntuacion) {
            total += rating;
        }
        return total / Puntuacion.size();
    }
    public List<String> getCanciones(){
        return canciones;
    }
    public int getFundacion() {
        return fundacion;
    }
    @Override
    public int compareTo(artista o2) {
        return this.id.compareTo(o2.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, Puntuacion, generos, canciones, fundacion);
    }
}

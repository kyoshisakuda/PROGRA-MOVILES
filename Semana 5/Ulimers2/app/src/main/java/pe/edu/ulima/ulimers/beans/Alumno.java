package pe.edu.ulima.ulimers.beans;

/**
 * Created by hquintana on 3/05/16.
 */
public class Alumno {
    private String id;
    private String nombre;
    private String codigo;
    private int puntos;
    private String urlFoto;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String codigo, int puntos, String urlFofo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.puntos = puntos;
        this.urlFoto = urlFofo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFofo) {
        this.urlFoto = urlFofo;
    }
}

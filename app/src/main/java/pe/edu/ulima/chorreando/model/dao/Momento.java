package pe.edu.ulima.chorreando.model.dao;

/**
 * Created by hquintana on 26/09/15.
 */
public class Momento {
    private Long idMomento;
    private String lugar;
    private String fecha;
    private String urlImagen;
    private int latitud;
    private int longitud;
    private Usuario usuario;

    public Momento() {
    }

    public Momento(Long idMomento, String lugar, String fecha, String urlImagen, int latitud, int longitud) {
        this.idMomento = idMomento;
        this.lugar = lugar;
        this.fecha = fecha;
        this.urlImagen = urlImagen;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Long getIdMomento() {
        return idMomento;
    }

    public void setIdMomento(Long idMomento) {
        this.idMomento = idMomento;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

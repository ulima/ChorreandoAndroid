package pe.edu.ulima.chorreando.model.dao;

/**
 * Created by hquintana on 22/09/15.
 */
public class Usuario {
    private Long idUsuario;
    private String nombre;
    private String pais;
    private String urlFoto;

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nombre, String pais, String urlFoto) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.pais = pais;
        this.urlFoto = urlFoto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}

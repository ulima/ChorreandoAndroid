package pe.edu.ulima.chorreando.model.dto;

/**
 * Created by hquintana on 12/09/15.
 */
public class LoginRequest {
    private String usuario;
    private String password;

    public LoginRequest(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

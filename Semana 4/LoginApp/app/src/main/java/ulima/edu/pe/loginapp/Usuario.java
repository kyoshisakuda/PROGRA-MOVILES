package ulima.edu.pe.loginapp;

import java.io.Serializable;

/**
 * Created by W3129 on 29/04/2016.
 */
public class Usuario implements Serializable{

    private String username;
    private String password;

    public Usuario() {}

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package ca.ucareer.computerfactory.model.loginrequest;

import org.springframework.stereotype.Service;

@Service
public class LoginRequestBody {

    private String username;

    private String password;

    public LoginRequestBody() {
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

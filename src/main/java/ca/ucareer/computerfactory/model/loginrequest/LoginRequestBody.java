package ca.ucareer.computerfactory.model.loginrequest;

import org.springframework.stereotype.Service;

@Service
public class LoginRequestBody {

    private Integer id;

    private String password;

    public LoginRequestBody() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package proyecto_2.proyecto_2;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
// or import javax.faces.bean.SessionScoped;

@Named("user") // or @ManagedBean(name="user")
@SessionScoped
public class Login implements Serializable {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newValue) {
        password = newValue;
    }

    public String includeUser() {
        return "chat.xhtml";
    }

}

package com.corejsf;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Login implements Serializable {

    private String username;

    @Inject
    private AllLogIn allLogin;

    public String login() {
        User user = new User(username);
        allLogin.addUser(user);
        return "allLoggedIn.xhtml?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

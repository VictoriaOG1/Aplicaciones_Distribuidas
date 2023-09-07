package com.corejsf;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("allLogIn")
@ApplicationScoped
public class AllLogIn implements Serializable {

    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        userList.add(user);
    }

    public void setUserList(List<User> userList){
        this.userList = userList;
    }
    public List<User> getUserList() {
        return userList;
    }
}

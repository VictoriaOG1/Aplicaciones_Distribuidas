package proyecto_2.proyecto_2;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ChatAppBean implements Serializable{

    String name;

    private String message;
    List<Users> loggedInUsers = new ArrayList<>();

    @Inject
    @Push(channel="push")
    private PushContext push;

    public String endSession(){
        return "login.xhtml";
    }

    public void  updateTable(String name){
        Users user = new Users();
        user.setUserName(name);
        user.setMessage(this.message);
        loggedInUsers.add(user);
        push.send("updateNotifications");
        this.message = "";
    }

    public List<Users> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void setLoggedInUsers(List<Users> loggedInUsers) {
        this.loggedInUsers = loggedInUsers;
    }
    public String getMessage() { return message; }
    public void setMessage(String newMessage) { message = newMessage; }
}

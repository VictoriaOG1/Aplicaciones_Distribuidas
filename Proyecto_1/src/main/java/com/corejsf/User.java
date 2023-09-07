package com.corejsf;
import java.io.Serializable;
import javax.inject.Named;

@Named("User")
public class User implements Serializable {

   private String name;

   public User() {}

   public User(String name) {
      this.name = name;
   }

   public void setName(String name){
      this.name = name;
   }
   public String getUsername() {
      return name;
   }
}

package com.edu.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by bikash.rajguru on 2/20/16.
 */
@XmlRootElement
public class Login {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public Login(String email, String password)
    {
     this.email=email;
     this.password=password;
    }

    public Login(){

    }
}

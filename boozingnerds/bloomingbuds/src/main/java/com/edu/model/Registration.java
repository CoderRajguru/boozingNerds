package com.edu.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by bikash.rajguru on 2/27/16.
 */
@XmlRootElement
public class Registration {

    String fullname;
    String email;
    String password;
    String phone;
    String dob;

    public Registration(){}


    public Registration(String email, String password , String fullname , String dob , String phone)
    {
        this.dob=dob;
        this.email=email;
        this.fullname=fullname;
        this.phone=phone;
        this.dob=dob;
    }

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package com.edu.service;

import com.edu.database.singletonDatabase;

import com.edu.model.Login;
import com.edu.model.LoginData;

/**
 * Created by bikash.rajguru on 2/20/16.
 */
public class LoginService {


    singletonDatabase SingletonDbObject= singletonDatabase.getInstance();



    public LoginData validateLogin(Login login){


        LoginData loginData=SingletonDbObject.LoginDb(login);
        return loginData;
    }
}

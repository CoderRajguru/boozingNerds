package com.edu.service;

import com.edu.database.singletonDatabase;
import com.edu.model.Login;
import com.edu.model.LoginData;
import com.edu.model.Registration;
import com.edu.model.RegistrationData;

/**
 * Created by bikash.rajguru on 2/27/16.
 */
public class RegistrationService {

    singletonDatabase SingletonDbObject= singletonDatabase.getInstance();


    public RegistrationData newRegistration(Registration registration) throws Exception{

        RegistrationData registrationdata=SingletonDbObject.registrationDB(registration);
        return registrationdata;
    }
}

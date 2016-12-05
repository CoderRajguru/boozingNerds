package com.edu.model;

/**
 * Created by bikash.rajguru on 2/27/16.
 */
public class RegistrationData {

    int id;
    String Logintoken;

    public String getLogintoken() {
		return Logintoken;
	}

	public void setLogintoken(String logintoken) {
		Logintoken = logintoken;
	}

	public RegistrationData()
    {

    }

    public RegistrationData(int id,String Logintoken) {
        this.id = id;
        this.Logintoken=Logintoken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

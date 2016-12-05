package com.edu.model;

/**
 * Created by bikash.rajguru on 2/25/16.
 */
public class LoginData {
	
    int loginId;
    String Logintoken;

    public LoginData()
    {

    }

    public LoginData(int idloginId,String Logintoken)
    {
        this.loginId=loginId;
        this.Logintoken=Logintoken;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    
	public String getLogintoken() {
		return Logintoken;
	}

	public void setLogintoken(String logintoken) {
		Logintoken = logintoken;
	}
    
}

package com.edu.service;

import com.edu.database.singletonDatabase;
import com.edu.model.LoginData;
import com.edu.model.MyDashboardData;

public class DashboardService {
	
	singletonDatabase SingletonDbObject= singletonDatabase.getInstance();
	
	public MyDashboardData getdashboardData(LoginData login){
		
		MyDashboardData dashboardDataObject=SingletonDbObject.getDashboardData(login);
        return dashboardDataObject;
		
	}

}

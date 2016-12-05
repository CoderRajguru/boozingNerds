package com.edu.database;

import com.edu.helpers.RandomString;
import com.edu.model.Login;
import com.edu.model.LoginData;
import com.edu.model.MyDashboardData;
import com.edu.model.Registration;
import com.edu.model.RegistrationData;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by bikash.rajguru on 2/20/16.
 */
public class singletonDatabase {

    private static singletonDatabase jdbc;
    //static String JdbcUrlString="jdbc:postgresql://";
    //static String DatabaseURl=JdbcUrlString+"pellefant.db.elephantsql.com:5432/djslqcbg";
    //static String Username="djslqcbg";
    //static String Password="OymPDp_MLarHzjEqBFvqW6aHVM53p7oP";
    private static final Logger logger = Logger.getLogger(singletonDatabase.class.getSimpleName());


    private singletonDatabase() {

    }

    public static singletonDatabase getInstance() {
        if (jdbc == null) {
        	System.out.println("Single Db");
            jdbc = new singletonDatabase();
        }
        return jdbc;
    }


    private static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection con = null;
        System.out.println("Db connected 1");
        System.out.println("testing");
        Class.forName("org.postgresql.Driver");
        System.out.println("Db connected 2");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webservice", "postgres", "admin");
    //   con = DriverManager.getConnection(DatabaseURl,Username,Password);
        System.out.println("Connection established");
        return con;

    }

    public LoginData LoginDb(Login login)
    {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int Response=0;
        int id=0;
        String Logintoken=null;
        
        String email=login.getEmail();
        String password=login.getPassword();
        try {
            System.out.println("In login db class NEW");
            con = singletonDatabase.getConnection();
            RandomString RandomStringObject=new RandomString();
            String LoginToken=RandomStringObject.RandomStringValue();
            //With Login Token
//            ps=con.prepareStatement("update login set logintoken='"+LoginToken+"' where email='"+ email+"'");
//            ps.executeUpdate();
            
            //Without Login Token
            System.out.println("select * from login where email='"+email+"' and password='"+password+"'");
            ps = con.prepareStatement("select * from login where email='"+email+"'and password='"+password+"'");
            System.out.println("In Ps");
            rs=ps.executeQuery();
            rs.next();
            id=Integer.parseInt(rs.getString(3));
            Logintoken=rs.getString(4);
            System.out.println("In response" + id );
            if(id < 0)
            {
                Response=0;
            }
            Response=1;

        }
        catch (Exception e)
        {
            logger.severe(e.getMessage());
            //e.printStackTrace();
        }

        LoginData logindataObj=new LoginData(id,Logintoken);
        return logindataObj;
    }

    public RegistrationData registrationDB(Registration registration) throws Exception
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int Response=0;
        int id=0;
        String Logintoken=null;
        
        String email=registration.getEmail();
        String password=registration.getPassword();
        String fullname=registration.getFullname();
        String dob=registration.getDob();
//        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//        Date date = format.parse(dob);


        Long phone=Long.parseLong(registration.getPhone());
        Date createdDate=new Date();
        String created=createdDate.toString();

        try {
            con = singletonDatabase.getConnection();
            System.out.println("insert into registration values('"+fullname+"','"+email+"','"+password+"',"+phone+",'"+dob+"','"+created+"'");
            ps = con.prepareStatement("insert into registration values('"+fullname+"','"+email+"','"+password+"',"+phone+",'"+dob+"','"+created+"')");
            System.out.println("In Ps");
            ps.executeUpdate();
            RandomString RandomStringObject=new RandomString();
            String LoginToken=RandomStringObject.RandomStringValue();
            
            //With Login Token
            
//            ps=con.prepareStatement("insert into login(email,password,logintoken) values('"+email+"','"+password+"','"+LoginToken+"')");
//            ps.executeUpdate();
            
            //Without Login Token
            ps=con.prepareStatement("insert into login(email,password) values('"+email+"','"+password+"')");
            ps.executeUpdate();
            
            ps = con.prepareStatement("select * from login where email='"+email+"'and password='"+password+"'");
            System.out.println("In Ps 2");
            rs=ps.executeQuery();
            System.out.println("In Ps 3");
            rs.next();
            System.out.println("In Ps 4");
            id=Integer.parseInt(rs.getString(3));
            Logintoken=rs.getString(4);
            System.out.println("In response" + id );
            System.out.println("In response" + rs.getString(4) );
            System.out.println("In response" + Logintoken );

        }
        catch (Exception e)
        {
            logger.severe(e.getMessage());
            //e.printStackTrace();
        }

        RegistrationData registrationDataObj=new RegistrationData(id,Logintoken);
        return registrationDataObj;

    }
    
    public MyDashboardData getDashboardData(LoginData login){
    	
    	DashboardDatabase dashboardDbObject=new DashboardDatabase();
    	MyDashboardData dashboardData=null;
    	try{

	    	Connection con = singletonDatabase.getConnection();
	    	System.out.println("we are here with connection with login_id" + login.getLoginId());
	    	dashboardData=dashboardDbObject.getDatafromDatabase(con,login);
    }
    catch(Exception e){
    }
    	
    		return dashboardData;
    
}
}

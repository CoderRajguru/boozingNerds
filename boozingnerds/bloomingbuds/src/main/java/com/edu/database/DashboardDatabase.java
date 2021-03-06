/**
 * 
 */
package com.edu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.model.LoginData;
import com.edu.model.MyDashboardData;
import com.edu.model.MyHomeWorKData;
import com.edu.model.MyNoticeData;

/**
 * @author bikash.rajguru
 *
 */
public class DashboardDatabase {
	

	public MyDashboardData getDatafromDatabase(Connection con,LoginData login) {
		
		PreparedStatement ps=null;
		int loginID=login.getLoginId();
		ResultSet rs=null;
		int student_ID,class_ID,notice_ID;
		MyDashboardData dashboardDataObject=new MyDashboardData();
		MyHomeWorKData homeworkData=new MyHomeWorKData();
		MyNoticeData noticeData=new MyNoticeData();
		
		try{
			
        ps = con.prepareStatement("select * from student_id_details where login_id = ?");
        ps.setInt(1,loginID);
        System.out.println("select * from student_id_details where login_id = "+loginID);
        rs=ps.executeQuery();
        System.out.println("Check point 1");
        rs.next();
        System.out.println("Check point 2");
        student_ID=Integer.parseInt(rs.getString(1));
        class_ID=Integer.parseInt(rs.getString(3));
        notice_ID=Integer.parseInt(rs.getString(4));
        System.out.println("Student iD " +student_ID + " Class ID = " + class_ID + "Notice_ID= "+ notice_ID);
        homeworkData=getDbHomeWorkDetails(con, class_ID);
        noticeData=getDbNoticeDetails(con, notice_ID);

        dashboardDataObject.setClass_ID(class_ID);
        dashboardDataObject.setHomeworkData(homeworkData);
        dashboardDataObject.setNoticeData(noticeData);
        
        
		}
		catch(Exception e){
			
		}
		return dashboardDataObject;
	}
	
	public MyHomeWorKData getDbHomeWorkDetails(Connection con,int classID){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		int homework_id;
		String homework_details=null;
		MyHomeWorKData homeworkDataObj=new MyHomeWorKData();
		try{
		ps = con.prepareStatement("select * from homework_db_id where class_id = ?");
        ps.setInt(1,classID);
        rs=ps.executeQuery();
        rs.next();
        homework_id=Integer.parseInt(rs.getString(1));
        
		ps = con.prepareStatement("select * from homework_details where homework_id = ?");
        ps.setInt(1,homework_id);
        rs=ps.executeQuery();
        rs.next();
        homework_details=rs.getString(3);
        homeworkDataObj.setHomework_details(homework_details);
        homeworkDataObj.setHomework_id(homework_id);
		}
		catch(Exception e){
			
		}
		
		return homeworkDataObj;
	}
	
	public MyNoticeData getDbNoticeDetails(Connection con,int notice_id){
		
		MyNoticeData noticedata=new MyNoticeData();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String notice_Details;
		
		try {
			ps = con.prepareStatement("select * from notice_table where notice_id = ?");
	        ps.setInt(1,notice_id);
	        rs=ps.executeQuery();
	        rs.next();
	        System.out.println("Notice id here = "+ notice_id);
	        notice_Details=rs.getString(2);
	        noticedata.setMyNotice_id(notice_id);
	        noticedata.setNotice_details(notice_Details);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticedata;
		
	}

}

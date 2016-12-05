/**
 * 
 */
package com.edu.model;

/**
 * @author bikash.rajguru
 *
 */
public class MyDashboardData {
	
int class_ID;	
MyHomeWorKData homeworkData;
MyNoticeData noticeData;

public MyNoticeData getNoticeData() {
	return noticeData;
}
public void setNoticeData(MyNoticeData noticeData) {
	this.noticeData = noticeData;
}
public int getClass_ID() {
	return class_ID;
}
public void setClass_ID(int class_ID) {
	this.class_ID = class_ID;
}
public MyHomeWorKData getHomeworkData() {
	return homeworkData;
}
public void setHomeworkData(MyHomeWorKData homeworkData) {
	this.homeworkData = homeworkData;
}


}

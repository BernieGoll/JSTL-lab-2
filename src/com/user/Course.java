package com.user;

import java.util.ArrayList;

public class Course
{
	public Course()
	{
		
	}
	
	private String courseName;
	private String professor;
	private ArrayList <WeekDay> occurances;
	private String time;
	private String roomNumber;
	private String startDate;
	//WeekDay weekDay = new (WeekDay);
		
public void Course (String courseName, String professor, String occurances,
String time, String roomNumber, String startDate)
{
	this.courseName = courseName;
	this.professor = professor;
	this.time = time;
	this.roomNumber = roomNumber;
	this.startDate = startDate;	
	
}
public void setCourseName(String courseName)
{	
	this.courseName = courseName;
}			
public String getCourseName() {
	return courseName;
}
public String getProfessor() {
	return professor;
}
public void setProfessor(String professor) {
	this.professor = professor;
}
public ArrayList getOccurances() {
	return occurances;
}
public void setOccurances(ArrayList occurances) {
	this.occurances = occurances;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(String roomNumber) {
	this.roomNumber = roomNumber;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}	
	
}

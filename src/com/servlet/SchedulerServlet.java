package com.servlet;

import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Course;
//import com.user.Student;
import com.user.WeekDay;

@WebServlet("/SchedulerServlet")
public class SchedulerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public SchedulerServlet() 
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Course course = new Course();
		course.setCourseName(request.getParameter("courseName"));
		course.setProfessor(request.getParameter("professor"));
		course.setTime(request.getParameter("time"));
		course.setRoomNumber(request.getParameter("roomNumber"));
		course.setStartDate(request.getParameter("startDate"));


		response.getWriter().append("Served at: ").append(request.getContextPath());


		String[] weekDays = request.getParameterValues("weekday");

		ArrayList <WeekDay> weekdayList = new ArrayList<>();	

		for(int i =0; i < weekDays.length;i++)
		{
			if(WeekDay.Monday.toString().equals(weekDays[i]))
			{
				weekdayList.add(WeekDay.Monday);
			}
			if(WeekDay.Tuesday.toString().equals(weekDays[i]))
			{
				weekdayList.add(WeekDay.Tuesday);
			}	
			if(WeekDay.Wednesday.toString().equals(weekDays[i]))
			{
				weekdayList.add(WeekDay.Wednesday);
			}
			if(WeekDay.Thursday.toString().equals(weekDays[i]))
			{
				weekdayList.add(WeekDay.Thursday);
			}
			else if(WeekDay.Friday.toString().equals(weekDays[i]))
			{
				weekdayList.add(WeekDay.Friday);
			}
		}

		course.setOccurances(weekdayList);
		
		HttpSession session = request.getSession(true);
		@SuppressWarnings("unchecked")
		ArrayList <Course> courses = (ArrayList<Course>)session.getAttribute("courses");
		if(courses==null)
		{
			courses= new ArrayList<Course>();
		}
		courses.add(course);
		
		session.setAttribute("courses", courses);
		
		
		RequestDispatcher rs= request.getRequestDispatcher("course.jsp");
		rs.forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}



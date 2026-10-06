package com.rays.ctl;

import java.io.IOException;

import com.rays.util.ServletUtility;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//doGet method handle HTTP GET request (HTTP GET request is a default request)
//doPost method handle HTTP POST request (When you submit request with parameter and form data when call HTTP POST request)

@WebServlet("/WelcomeCtl") 
public class WelcomeCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
//		
//		rd.forward(request, response);
		
		ServletUtility.forward("WelcomeView.jsp", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
//		
//		rd.forward(request, response);
		
		ServletUtility.forward("WelcomeView.jsp", request, response);
	}
}

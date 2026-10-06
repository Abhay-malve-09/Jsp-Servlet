package com.rays.ctl;

import java.io.IOException;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//doGet method handle HTTP GET request (HTTP GET request is a default request)
//doPost method handle HTTP POST request (When you submit request with parameter and form data when call HTTP POST request)

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("operation");
		
		if(op != null) {
			
			HttpSession session = request.getSession();
			
			session.invalidate();
			
		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
//		
//		rd.forward(request, response);
		
		ServletUtility.forward("LoginView.jsp", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean bean = new UserBean();
		UserModel model = new UserModel(); 
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			
		bean = model.authenticate(login, password);
		
		if(bean != null) {
			
			session.setAttribute("user", bean);
			
			response.sendRedirect("WelcomeCtl");
			
			return;
			
		} else {
			
//			request.setAttribute("errorMsg", "Invalid Login Or Password");
			
			ServletUtility.setErrorMessage("Invalid Login Or Password", request);
		}
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
//		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
//		
//		rd.forward(request, response);
		
		ServletUtility.forward("LoginView.jsp", request, response);
	}
}

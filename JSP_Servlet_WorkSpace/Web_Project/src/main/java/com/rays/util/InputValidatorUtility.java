package com.rays.util;

import javax.servlet.http.HttpServletRequest;

public class InputValidatorUtility {

	public static boolean loginValidator(HttpServletRequest request) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean pass = true;

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		}
//			else if (password.length() < 8 || password.length() > 12) {
//			pass = false;
//			request.setAttribute("password", "password length should be > 8 or == 12");
//		}

		return pass;
	}

	public static boolean UserRegistrationValidator(HttpServletRequest request) {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		boolean pass = true;

		if (firstName.equals("")) {
			pass = false;
			request.setAttribute("firstName", "firstName is required");
		} else if (firstName.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("firstName", "Numbers is not accepted");
		}

		if (lastName.equals("")) {
			pass = false;
			request.setAttribute("lastName", "LastName is required");
		} else if (lastName.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("lastName", "Number is not accepted");
		}
		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "login is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		}

		else if (password.length() < 8 || password.length() > 12) {
			pass = false;
			request.setAttribute("password", "password length should be > 8 or == 12");
		}

		if (dob.equals("")) {
			pass = false;
			request.setAttribute("dob", " dob is required");
		}

		return pass;
	}
	
	public static boolean BranchValidator(HttpServletRequest request) {

		String branchName = request.getParameter("branchName");
		String city = request.getParameter("city");
		String managerName = request.getParameter("managerName");
		String contactNo = request.getParameter("contactNo");
		
		boolean pass = true;

		if (branchName.equals("")) {
			pass = false;
			request.setAttribute("branchName", "branchName is required");
		} 
		else if (branchName.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("branchName", "Numbers is not accepted");
		}

		if (city.equals("")) {
			pass = false;
			request.setAttribute("city", "city is required");
		} 
		else if (city.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("city", "Numbers is not accepted");
		}
		
		if (managerName.equals("")) {
			pass = false;
			request.setAttribute("managerName", "managerName is required");
		}
		else if (managerName.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("managerName", "Numbers is not accepted");
		}

		if (contactNo.equals("")) {
			pass = false;
			request.setAttribute("contactNo", "contactNo is required");
		}

		else if (contactNo.matches("[a-z A-Z ]+")) {
			pass = false;
			request.setAttribute("contactNo", "alphabets is not accepted");
		}
		
		else if (contactNo.length() == 10) {
			pass = false;
			request.setAttribute("contactNo", "contactNo length should be  == 10");
		}
		


		return pass;
	}
	
	public static boolean VehicleValidator(HttpServletRequest request) {

		String vehicleName = request.getParameter("vehicleName");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		
		boolean pass = true;

		if (vehicleName.equals("")) {
			pass = false;
			request.setAttribute("vehicleName", "vehicleName is required");
			
		}else if (vehicleName.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("vehicleName", "Numbers is not accepted");
		}

		if (model.equals("")) {
			pass = false;
			request.setAttribute("model", "model is required");
			
		} else if (model.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("model", "Numbers is not accepted");
		}
		
		if (color.equals("")) {
			pass = false;
			request.setAttribute("color", "color is required");
			
		} else if (color.matches("[0-9]+")) {
			pass = false;
			request.setAttribute("color", "Numbers is not accepted");
		}
		
		if (price.equals("")) {
			pass = false;
			request.setAttribute("price", "price is required");
			
		} else if (price.matches("[a-z A-Z ]+")) {
			pass = false;
			request.setAttribute("price", "Numbers is not accepted");
		}

		return pass;
	}
}

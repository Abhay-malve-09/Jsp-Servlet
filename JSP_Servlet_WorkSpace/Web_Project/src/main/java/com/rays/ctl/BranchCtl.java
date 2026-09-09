package com.rays.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BranchBean;
import com.rays.model.BranchModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

@WebServlet("/BranchCtl")
public class BranchCtl extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			if(InputValidatorUtility.BranchValidator(request) == false) {
				ServletUtility.forward("BranchView.jsp", request, response);
				return;
			}
		}
		super.service(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("BranchView.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		BranchBean bean = new BranchBean();
		BranchModel model = new BranchModel();

		String branchName = request.getParameter("branchName");
		String city = request.getParameter("city");
		String managerName = request.getParameter("managerName");
		String contactNo = request.getParameter("contactNo");

		try {

			bean.setBranchName(branchName);
			bean.setCity(city);
			bean.setManagerName(managerName);
			bean.setContactNo(contactNo);
			model.add(bean);
			request.setAttribute("successMsg", "branch add successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "BranchId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("BranchView.jsp", request, response);
	}

}

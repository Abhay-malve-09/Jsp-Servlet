 package com.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.VehicleBean;
import com.rays.model.VehicleModel;
import com.rays.util.InputValidatorUtility;
import com.rays.util.ServletUtility;

//@WebServlet("/VehicleCtl")
@WebServlet("/VehicleCtl.do")
public class VehicleCtl extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("request method == " + request.getMethod());
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			if(InputValidatorUtility.VehicleValidator(request) == false) {
				ServletUtility.forward("VehicleView.jsp", request, response);
				return;
			}
		}
		super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("VehicleView.jsp", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		VehicleBean bean = new VehicleBean();
		VehicleModel m = new VehicleModel();

		String vehicleName = request.getParameter("vehicleName");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String price = request.getParameter("price");

		try {

			bean.setVehicleName(vehicleName);
			bean.setModel(model);
			bean.setColor(color);
			bean.setPrice(Double.parseDouble(price));
		
			m.add(bean);
			request.setAttribute("successMsg", "Vehicle add successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "VehicleName already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("VehicleView.jsp", request, response);
	}
}

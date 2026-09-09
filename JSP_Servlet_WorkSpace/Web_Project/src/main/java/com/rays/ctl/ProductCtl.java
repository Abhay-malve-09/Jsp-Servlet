package com.rays.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;
import com.rays.util.ServletUtility;

@WebServlet("/ProductCtl")
public class ProductCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("ProductView.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");

		try {

			bean.setProductName(productName);
			bean.setPrice(Double.parseDouble(price));
			bean.setQuantity(Integer.parseInt(quantity));
			bean.setCategory(category);
			model.add(bean);
			request.setAttribute("successMsg", "product add successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "ProductId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("ProductView.jsp", request, response);
	}

}

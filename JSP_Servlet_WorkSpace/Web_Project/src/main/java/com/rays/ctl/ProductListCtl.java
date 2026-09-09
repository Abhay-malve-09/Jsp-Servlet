package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;
import com.rays.util.ServletUtility;


@WebServlet("/ProductListCtl")
public class ProductListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		ProductModel model = new ProductModel();
		ProductBean bean = new ProductBean();
		
		try {
			List<ProductBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	ServletUtility.forward("ProductListView.jsp", request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

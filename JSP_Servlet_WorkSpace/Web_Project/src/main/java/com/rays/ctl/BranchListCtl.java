package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.BranchBean;
import com.rays.model.BranchModel;
import com.rays.util.ServletUtility;

@WebServlet("/BranchListCtl")
public class BranchListCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BranchModel model = new BranchModel();
		BranchBean bean = new BranchBean();
		
		try {
			List<BranchBean> list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ServletUtility.forward("BranchListView.jsp", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Department;


public class DeleteDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			Department dt = new Department() ;
			ArrayList<Department> dlist = dt.Show() ;
			request.setAttribute("dlist", dlist);
			request.getRequestDispatcher("DepDelete.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

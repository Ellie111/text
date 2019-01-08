package com.hzyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Emp;

public class Chaxunemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		try {
			Emp emp = new Emp();
			List<Emp> aList = emp.query();
			
			request.setAttribute("aList", aList);
			request.getRequestDispatcher("new_showemp.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

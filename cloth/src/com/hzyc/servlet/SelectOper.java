package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Operation;

public class SelectOper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String choose = request.getParameter("choose") ;
			String needvalue = request.getParameter("needvalue") ;
			
			Operation ot = new Operation() ;
			String sql = "select * from OPST where " + choose + " = '"+needvalue+"'" ;
			System.out.println(sql);
			ArrayList<Operation> olist = ot.Select(sql);
			request.setAttribute("olist", olist);
			request.getRequestDispatcher("ShowOperation.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

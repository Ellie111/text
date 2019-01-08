package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hzyc.jdbc.JDBC;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String name = request.getParameter("name");
		session.setAttribute("username1", name);
		String password = request.getParameter("password");
		String sql = "select * from zhuce where name = '"+name+"' and password = '"+password+"'";
		JDBC db =new JDBC();
		List list = db.query(sql);
		if(list.isEmpty()){
			response.sendRedirect("loginfail.jsp");
		}else{
			response.sendRedirect("main.jsp");
		}
	   
		
	}

}

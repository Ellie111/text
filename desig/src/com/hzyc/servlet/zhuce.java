package com.hzyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;


public class zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// insert into zhuce (name,password) values ('Ëï³É¾õ','123456');
		String sql = " insert into zhuce (name,password) values('"+name+"','"+password+"'); ";
		JDBC db =new JDBC();
		int result = db.update(sql);
		if(result > 0){
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("zhucefail.jsp");
		}
	}

}

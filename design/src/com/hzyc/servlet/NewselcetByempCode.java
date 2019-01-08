package com.hzyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Emp;


public class NewselcetByempCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			//接收用户的请求
			String empCode = request.getParameter("empCode");
			System.out.println(empCode);
			//选择一个合适的模型
			Emp emp = new Emp();
			emp= emp.queryById(empCode);
			System.out.println(emp);
			//选择合适的视图
			request.setAttribute("emp",emp);
			request.getRequestDispatcher("new_updateEmp.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

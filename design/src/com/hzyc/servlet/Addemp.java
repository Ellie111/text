package com.hzyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Emp;


public class Addemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String empCode=request.getParameter("empCode");
			String empName=request.getParameter("empName");
			String empSex=request.getParameter("empSex");
			String password=request.getParameter("password");
			String empTel=request.getParameter("empTel");
			String memo=request.getParameter("memo");
			String state=request.getParameter("state");
			
			Emp emp = new Emp();
			emp.setEmpCode(empCode);
			emp.setEmpName(empName);
			emp.setEmpSex(empSex);
			emp.setEmpState(state);
			emp.setPassword(password);
			emp.setEmpTel(empTel);
			emp.setMemo(memo);
			//System.out.println("1");
			Boolean result = emp.addemp();
			
			if(result){
				response.sendRedirect("add_succeed.jsp");
				//System.out.println("1");
			}else{
				
				response.sendRedirect("add_failure.jsp");
				//System.out.println("2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

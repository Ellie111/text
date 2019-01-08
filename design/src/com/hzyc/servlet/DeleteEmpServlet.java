package com.hzyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;


public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// delete from emp where empName = 'jjj'and empCode = '2';
		String demo = "delete from emp where  ";
		String empCode= request.getParameter("empCode");
		String empName = request.getParameter("empName");
		System.out.println(empCode);
		if(empCode.isEmpty() && !empName.isEmpty() ){
			String demo1 = demo + "empName = " + "'"+ empName +"'"; 
			//System.out.println(demo);
			JDBC jdbc = new JDBC();
			int result = jdbc.update(demo1);
			if(result > 0){
				
				response.sendRedirect("Delete_succeed.jsp");
			}
			
		}
		if(!empCode.isEmpty() && empName.isEmpty()){
			String demo2 = demo + "empCode = " + "'"+ empCode +"'";
			JDBC jdbc = new JDBC();
			int result = jdbc.update(demo2);
			if(result > 0){
				response.sendRedirect("Delete_succeed.jsp");
			}
		}
		/*if(!(empCode.isEmpty() && empName.isEmpty())){
			String demo3 = demo + "empCode = " + "'"+ empCode +"'"+"and"+" "+"empName = " + "'"+ empName +"'";
	         System.out.println(demo3);
	         JDBC jdbc = new JDBC();
				int result = jdbc.update(demo3);
				if(result > 0){
					response.sendRedirect("Delete_succeed.jsp");
				}	
		}*/
	}

}

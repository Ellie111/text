package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Department;


public class AddDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		try {
			String deptCode = request.getParameter("deptCode") ;
			String deptName = request.getParameter("deptName") ;
			String Depac = request.getParameter("Depac") ;
			
			if(!(("".equals(deptCode)) && ("".equals(deptName)) &&  ("".equals(Depac)))){
				String sql = "insert into DEPT value ('"+deptCode+"' , '"+deptName+" ' , '"+Depac+"' )" ;
				System.out.println(sql);
				Department dt = new Department() ;
				boolean sign = dt.Update(sql) ;
				if(sign){
					ArrayList<Department> dlist = dt.Show() ;
					request.setAttribute("dlist", dlist);
					request.getRequestDispatcher("ShowDepartment.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("fail.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

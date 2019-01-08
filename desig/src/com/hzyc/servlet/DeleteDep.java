package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Department;


public class DeleteDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		try {
			String deptCode = request.getParameter("deptCode") ;
			
			if(!("--«Î—°‘Ò--".equals(deptCode))){
				String sql = "delete from DEPT where deptCode = '"+deptCode+"'" ;
				System.out.println(sql);
				Department dt = new Department() ;
				boolean sign = dt.Update(sql) ;
				if(sign){
					ArrayList<Department> dlist = dt.Show() ;
					request.setAttribute("dlist", dlist);
					request.getRequestDispatcher("ShowDepartment.jsp").forward(request, response);
				}else{
					response.sendRedirect("fail.jsp");
				}
			}else{
				response.sendRedirect("fail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

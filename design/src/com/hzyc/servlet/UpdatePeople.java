package com.hzyc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Emp;


public class UpdatePeople extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String password=request.getParameter("password");
			String tel=request.getParameter("tel");
			String memo=request.getParameter("memo");
			String state=request.getParameter("state");
			//String privilege=request.getParameter("privilege");
			
			
			
			
			Emp emp = new Emp();
			emp.setEmpCode(id);
			emp.setEmpName(name);
			emp.setEmpSex(sex);
			emp.setPassword(password);
			emp.setEmpTel(tel);
			emp.setMemo(memo);
			emp.setEmpState(state);
			//pp.setPrivilege(privilege);
			
			boolean result=emp.updatepeople();
			if(result){
				
			List<Emp> sList=emp.query();
			request.setAttribute("sList", sList);
			request.getRequestDispatcher("Update_succeed.jsp").forward(request, response);
			}
			} catch (Exception e) {
				e.printStackTrace();
		}
	}

}

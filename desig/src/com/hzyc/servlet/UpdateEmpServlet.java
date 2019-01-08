package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;
import com.hzyc.models.Emp;


public class UpdateEmpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String demo = "select * from emp where empCode =  ";
			String empCode = request.getParameter("empCode");
			System.out.println("111111111111111");
			demo = demo + "'"+ empCode + "'";
			JDBC jdbc = new JDBC();
			ArrayList<HashMap<String,String>> list= jdbc.query(demo);
			System.out.println("2222222222222222");
			Emp emp = assemblToEmp(list);
			emp.setEmpName(request.getParameter("empName"));
			emp.setEmpSex(request.getParameter("empSex"));
			emp.setEmpState(request.getParameter("empType"));
			emp.setPassword(request.getParameter("Password"));
			emp.setEmpTel(request.getParameter("empTel"));
			emp.setMemo(request.getParameter("Memo"));
			System.out.println("33333333333");
			
			String demo1 = "empName = " +"'"+ emp.getEmpName()+"' ," + "empType = " + "'" + emp.getEmpState() +"' ," + "Password = " + "'" +emp.getPassword()+"' ," + "empTel = " +"'"+emp.getEmpTel()+"'" +"," +"empSex = " +"'"+ emp.getEmpSex()+"'";  
			String updateSql = "update emp set " + demo1 + "where empCode = " + "'"+ emp.getEmpCode() +"'";
			System.out.println(updateSql);
			if(jdbc.update(updateSql) > 0){
				
				response.sendRedirect("Update_succeed.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	private Emp assemblToEmp(List<HashMap<String,String>> list){
		
		Emp emp = new Emp();
		for(HashMap item :list){
			emp.setEmpCode(item.get("empCode").toString());
			emp.setEmpName(item.get("empName").toString());
			emp.setEmpSex(item.get("empSex").toString());
			emp.setEmpState(item.get("empType").toString());
			emp.setEmpTel(item.get("empTel").toString());
			emp.setMemo(item.get("Memo").toString());
			emp.setPassword(item.get("Password").toString());
		}
		return emp;		
	}	
	
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
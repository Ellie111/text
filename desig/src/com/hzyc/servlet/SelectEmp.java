package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;
import com.hzyc.models.Emp;


public class SelectEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String demo = "select * from emp where ";
			String minNum = request.getParameter("minNum");
			String maxNum = request.getParameter("maxNum");
			String name = request.getParameter("name");
			if(!(minNum.equals("") && maxNum.equals(""))){
				//System.out.println("²âÊÔ");
				String demo1 = demo + "empCode > " +minNum + " and " + "empCode < " + maxNum ; 
				System.out.println(demo1);
				JDBC jdbc = new JDBC();
				ArrayList<HashMap<String, String>> rsList = jdbc.query(demo1);
				ArrayList<Emp> gList = new ArrayList<Emp>();
				for(int i = 0;i < rsList.size();i++){
					HashMap<String, String> rsMap = rsList.get(i);
					Emp emp = new Emp();
					emp.setEmpCode(rsMap.get("empCode"));                             
					emp.setEmpName(rsMap.get("empName"));                      
					emp.setEmpSex(rsMap.get("empSex"));                                      
					emp.setPassword(rsMap.get("password"));                   
					emp.setEmpTel(rsMap.get("empTel"));                     
					emp.setMemo(rsMap.get("memo"));  
					emp.setEmpState(rsMap.get("empState")); 
					gList.add(emp);
				}
				
				request.setAttribute("gList", gList);
				request.getRequestDispatcher("select_succeed.jsp").forward(request, response);
			}
			
			if(!("".equals(name))){
				// select * from emp where empName like  '%s%';
				String demo2 = demo + "empName" +" " +"like"+ "'"+ "%" + name + "%"+"'";
				System.out.println(demo2);
				JDBC jdbc = new JDBC();
				ArrayList<HashMap<String, String>> rsList = jdbc.query(demo2);
				ArrayList<Emp> gList = new ArrayList<Emp>();
				for(int i = 0;i < rsList.size();i++){
					HashMap<String, String> rsMap = rsList.get(i);
					Emp emp = new Emp();
					emp.setEmpCode(rsMap.get("empCode"));                             
					emp.setEmpName(rsMap.get("empName"));                      
					emp.setEmpSex(rsMap.get("empSex")); 
					emp.setPassword(rsMap.get("password"));                   
					emp.setEmpTel(rsMap.get("empTel"));                     
					emp.setMemo(rsMap.get("memo"));  
					emp.setEmpState(rsMap.get("empState"));  
					gList.add(emp);
				}
				
				
				request.setAttribute("gList", gList);
				request.getRequestDispatcher("selectsucceedbyname.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

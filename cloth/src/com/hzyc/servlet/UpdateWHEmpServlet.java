package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Warehouse;


public class UpdateWHEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			request.getAttribute("wlist") ;
			String whID = request.getParameter("whID");
			String whPerson = request.getParameter("whPerson") ;
			if(!("--请选择--".equals(whID))){
				Warehouse wh = new Warehouse();
				String sql = "update WH set whPerson = '"+whPerson+"' where whID = '"+whID+"'" ;
				System.out.println(sql);
				boolean sign = wh.Update(sql);
				if(sign){
					ArrayList<Warehouse> wlist = wh.Show() ;
					request.setAttribute("wlist", wlist);
					request.getRequestDispatcher("ShowWH.jsp").forward(request, response);
				}else{
					response.sendRedirect("fail.jsp");
					System.out.println("改保管人员失败");
				}
			}else{
				response.sendRedirect("fail.jsp");
				System.out.println("没写仓库号失败");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

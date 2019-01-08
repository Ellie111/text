package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Warehouse;


public class UpdateServletwh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String whID = request.getParameter("whID") ;
			String whAddr = request.getParameter("whAddr") ;
			
			Warehouse wh = new Warehouse() ;
			if(!("--«Î—°‘Ò--".equals(whID))){
			String sql ="update wh set whAddr = '"+whAddr+"' where whID = '"+whID+"'" ;
			System.out.println(sql);
			boolean sign = wh.Update(sql);
			
			if(sign){
				ArrayList<Warehouse> wlist = wh.Show() ;
				request.setAttribute("wlist", wlist);
				request.getRequestDispatcher("ShowWH.jsp").forward(request, response);
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

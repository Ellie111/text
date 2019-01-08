package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Warehouse;


public class DeleteWh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String whID = request.getParameter("whID") ;
			
			if(!("--«Î—°‘Ò--".equals(whID))){
				String sql = "delete from WH where whID = '"+whID+"'" ;
				Warehouse wh = new Warehouse() ;
				boolean sign = wh.Delete(sql);
				
				if(sign){
					ArrayList<Warehouse> wlist = wh.Show() ;
					request.setAttribute("wlist", wlist);
					request.getRequestDispatcher("ShowWH.jsp").forward(request, response);
				}
				}else{
					response.sendRedirect("fail.jsp");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

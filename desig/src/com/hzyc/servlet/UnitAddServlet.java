package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Unit;


public class UnitAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		try {
			String unitID = request.getParameter("unitID") ;
			String unitName = request.getParameter("unitName") ;
			if(!(("".equals(unitID)) && "".equals(unitName))){
				String sql = "insert into UNIT value ('"+unitID+"' , '"+unitName+"' )" ;
				Unit ut = new Unit() ;
				boolean sign = ut.Update(sql) ;
				if(sign){
					ArrayList<Unit> ulist = ut.Show();
					request.setAttribute("ulist", ulist);
					request.getRequestDispatcher("ShowUnit.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("fail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

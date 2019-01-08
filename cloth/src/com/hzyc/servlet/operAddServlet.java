package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Operation;


public class operAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8") ;
		try {
			String opeTypeID = request.getParameter("opeTypeID") ;
			String opeTypeNa = request.getParameter("opeTypeNa") ;
			System.out.println(opeTypeID);
			if(!(("".equals(opeTypeID)) && "".equals(opeTypeNa))){
				String sql = "insert into OPST value ('"+opeTypeID+"' , '"+opeTypeNa+"' )" ;
				Operation ot = new Operation() ;
				boolean sign = ot.Add(sql) ;
				if(sign){
					ArrayList<Operation> olist = ot.Show() ;
					request.setAttribute("olist", olist);
					request.getRequestDispatcher("ShowOperation.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("fail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

}

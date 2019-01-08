package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.MoveStock;


public class MoveAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String autoid = request.getParameter("autoid") ;
			String goodesid = request.getParameter("goodesid") ;
			String source = request.getParameter("source") ;
			String target = request.getParameter("target") ;
			String unit = request.getParameter("unit") ;
			String quantity = request.getParameter("quantity") ;
			String opDate = request.getParameter("opDate") ;
			String operator = request.getParameter("operator") ;
			
			if(!(("".equals(autoid)) && ("".equals(goodesid)) &&  ("".equals(source))&&  ("".equals(target))&&  ("".equals(unit))&&  ("".equals(quantity))&&  ("".equals(opDate)) && ("".equals(operator)))){
				String sql = "insert into MOVESTOCK value ('"+autoid+"' , '"+goodesid+" ' , '"+source+"','"+target+"','"+unit+"','"+quantity+"','"+opDate+"','"+operator+"' )" ;
				System.out.println(sql);
				MoveStock mt = new MoveStock() ;
				boolean sign = mt.Update(sql) ;
				if(sign){
					ArrayList<MoveStock> mlist = mt.Show() ;
					request.setAttribute("mlist", mlist);
					request.getRequestDispatcher("ShowMoveStock.jsp").forward(request, response);
				}
			}else{
				response.sendRedirect("fail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

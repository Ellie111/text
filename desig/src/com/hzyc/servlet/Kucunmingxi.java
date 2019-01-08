package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Kuncunmingxi;
import com.hzyc.models.Stock;


public class Kucunmingxi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			
			String Code = request.getParameter("Code");
			String goodsID = request.getParameter("goodsID");
			String Unit = request.getParameter("Unit");
			String Price = request.getParameter("Price");
			String Quantity = request.getParameter("Quantity");
			
			Kuncunmingxi kuncun = new Kuncunmingxi();
			
			kuncun.setCode(Code);
			kuncun.setGoodsID(goodsID);
			kuncun.setUnit(Unit);
			kuncun.setPrice(Price);
			kuncun.setQuantity(Quantity);
			
			String sql = "insert into STOCK values ('"+Code+"','"+goodsID+"' ,'"+Unit+"','"+Price+"','"+Quantity+"')" ;

			boolean sign = kuncun.Update(sql);
			if(sign){
				ArrayList<Kuncunmingxi> slist = kuncun.Show() ;
				request.setAttribute("slist", slist);
				request.getRequestDispatcher("ShowKuncunmingxi.jsp").forward(request, response);
			}else{
				response.sendRedirect("fail.jsp");
			}
			
		} catch (Exception e) {
			
		}
	}

}

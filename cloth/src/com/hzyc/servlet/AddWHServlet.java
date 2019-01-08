package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Warehouse;


public class AddWHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String whID = request.getParameter("whID") ;
			String Name = request.getParameter("Name") ;
			String whPerson = request.getParameter("whPerson") ;
			String whAddr = request.getParameter("whAddr") ;
			
			Warehouse wh = new Warehouse();
			
			wh.setWhID(whID) ;
			wh.setName(Name);
			wh.setWhPerson(whPerson);
			wh.setWhAddr(whAddr);
			
			boolean sign = wh.Add() ;
			
			if(sign){
				ArrayList<Warehouse> wlist = wh.Show() ;
				request.setAttribute("wlist", wlist);
				request.getRequestDispatcher("ShowWH.jsp").forward(request, response);
			}else{
				response.sendRedirect("fail.jsp");
				System.out.println("ÃÌº” ß∞‹");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Good;
import com.hzyc.models.Ruku;


public class RukuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String autoid = request.getParameter("autoid") ;
			String goodesid = request.getParameter("goodesid") ;
			String source = request.getParameter("source") ;
			String unit = request.getParameter("unit") ;
			String quantity = request.getParameter("quantity") ;
			String opDate = request.getParameter("opDate") ;
			String operator = request.getParameter("operator") ;
			
			Ruku ruku = new Ruku() ;
			String sql = "insert into ADDSTOCK values('"+autoid+"','"+goodesid+"','"+source+"','"+unit+"','"+quantity+"','"+opDate+"','"+operator+"')" ;
			System.out.println(sql);
			Good goods = new Good() ;
			String sql1 = "select nowQuantity from GDMESS where goodsID = '"+goodesid+"'" ;
			ArrayList<Good> glist = goods.Select(sql1);
			goods = glist.get(0) ;
			String nowQuantity = goods.getNowQuantity() ;
			Integer newQuantity = Integer.parseInt(nowQuantity) + Integer.parseInt(quantity);
			String sql2 = "update GDMESS set nowQuantity = '"+newQuantity+"' where goodsID = '"+goodesid+"'" ;
			System.out.println(sql2);
			goods.AddGoods(sql2) ;
			
			
			boolean sign = ruku.Update(sql);
			if(sign){
				ArrayList<Ruku> dlist = ruku.Show() ;
				request.setAttribute("dlist", dlist);
				request.getRequestDispatcher("rukushow.jsp").forward(request, response);
			}else{
				response.sendRedirect("fail.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

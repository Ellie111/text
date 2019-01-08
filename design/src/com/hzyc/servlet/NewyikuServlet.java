package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Good;
import com.hzyc.models.MoveStock;

public class NewyikuServlet extends HttpServlet {
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
				
			}
			
			Good goods = new Good() ;
			
			String sql1 = "select nowQuantity from GDMESS where goodsID = '"+goodesid+"'" ;
			System.out.println(sql1);
			ArrayList<Good> glist = goods.Select(sql1);
			goods = glist.get(0) ;
			String nowQuantity = goods.getNowQuantity() ;
			Integer newQuantity = Integer.parseInt(nowQuantity) - Integer.parseInt(quantity);
			String sql2 = "update GDMESS set nowQuantity = '"+newQuantity+"' where goodsID = '"+goodesid+"'" ;
			System.out.println(sql2);
			//String sql2 = "update GDMESS set nowQuantity = '"+newQuantity+"' where goodsID = '"+goodesid+"'" ;
			goods.AddGoods(sql2) ;
			
			
			
			
			//select goodesID from movestock where target = '0004'
			//String sql3 = "select nowQuantity from GDMESS where goodsID = (select goodesID from movestock where target = '"+target+"' )";
			String sql3 = "select nowQuantity from GDMESS where whID ='"+target+"' ";
			System.out.println(sql3);
			//goods.AddGoods(sql3) ;
			
			//String sql3 = "select nowQuantity from GDMESS where goodsID = (select goodsID  where target = '"+target+"' )";
			ArrayList<Good> glist1 = goods.Select(sql3);
			goods = glist1.get(0) ;
			String nowQuantity1 = goods.getNowQuantity() ;
			Integer newQuantity1 = Integer.parseInt(nowQuantity1) + Integer.parseInt(quantity);
			//String sql4 = "update GDMESS set nowQuantity = '"+newQuantity1+"' where goodsID = (select goodesID  from movestock where target = '"+target+"' )" ;
			String sql4 = "update GDMESS set nowQuantity = '"+newQuantity1+"' where  whID ='"+target+"' ";
			System.out.println(sql4);
			//String sql4 = "update GDMESS set where goodsID = (select goodsID  where target = '"+target+"'")");
			//String sql5 = "select goodsID where where target = '"+target+"'";
			//goods.AddGoods(sql3);
			goods.AddGoods(sql4) ;
			
			//String sql5 = "delete from movestock where  goodesID = '"+goodesid+"'" ;
			//System.out.println(sql5);
			//goods.AddGoods(sql5) ;
			
			
			
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
}

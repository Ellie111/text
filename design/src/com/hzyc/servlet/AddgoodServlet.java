package com.hzyc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.models.Good;


public class AddgoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String goodsID=request.getParameter("goodsID");
		String goodsName=request.getParameter("goodsName");
		String shortName=request.getParameter("shortName");
		String goodsClass=request.getParameter("goodsClass");
		String goodsStd=request.getParameter("goodsStd");
		String price=request.getParameter("price");
		String weight=request.getParameter("weight");
		String volume=request.getParameter("volume");
		String unitID=request.getParameter("unitID");
		String vendor=request.getParameter("vendor");
		String lowQuantity=request.getParameter("lowQuantity");
		String highQuantity=request.getParameter("highQuantity");
		String safeQuantity=request.getParameter("safeQuantity");
		String whID=request.getParameter("whID");
		String highPrice=request.getParameter("highPrice");
		String lowPrice=request.getParameter("lowPrice");
		String builder=request.getParameter("builder");
		String modiPerson=request.getParameter("modiPerson");
		String modiTime=request.getParameter("modiTime");
		String nowQuantity=request.getParameter("nowQuantity");
		String lastCleckTime=request.getParameter("lastCleckTime");
		
		Good good = new Good();
		
		good.setGoodsID(goodsID);
		good.setGoodsName(goodsName);
		good.setShortName(shortName);
		good.setGoodsClass(goodsClass);
		good.setGoodsStd(goodsStd);
		good.setPrice(price);
		good.setWeight(weight);
		good.setVolume(volume);
		good.setUnitID(unitID);
		good.setVendor(vendor);
		good.setLowQuantity(lowQuantity);
		good.setHighQuantity(highQuantity);
		good.setSafeQuantity(safeQuantity);
		good.setWhID(whID);
		good.setHighPrice(highPrice);
		good.setLowPrice(lowPrice);
		good.setBuilder(builder);
		good.setModiPerson(modiPerson);
		good.setModiTime(modiTime);
		good.setNowQuantity(nowQuantity);
		good.setLastCleckTime(lastCleckTime);
		
		boolean result = good.addGood();
		
		request.setAttribute("safe", safeQuantity);
		
		if(result){
			//request.getRequestDispatcher("addgood_succeed.jsp");
			response.sendRedirect("addgood_succeed.jsp");
			//System.out.println("1");
		}else{
			request.getRequestDispatcher("addgood_failure.jsp");
		}

	}

}

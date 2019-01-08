package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;
import com.hzyc.models.Emp;
import com.hzyc.models.Good;


public class SelectGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			
			String demo = "select * from gdmess where ";
			String minNum = request.getParameter("minNum");
			String maxNum = request.getParameter("maxNum");
			String goodsID = request.getParameter("goodsID");
			String goodsClass = request.getParameter("goodsClass");
			System.out.println(goodsClass);
			if(!(minNum.equals("") && maxNum.equals(""))){
				
				demo = demo + "Price > " +minNum + " and " + "Price < " + maxNum ; 
				System.out.println("minNum≤‚ ‘" + demo);
				JDBC jdbc = new JDBC();
				ArrayList<HashMap<String, String>> rsList = jdbc.query(demo);
				ArrayList<Good> gList = new ArrayList<Good>();
				for(int i = 0;i < rsList.size();i++){
					HashMap<String, String> rsMap = rsList.get(i);
					Good good = new Good();
					good.setGoodsID(rsMap.get("goodsID"));
					good.setGoodsName(rsMap.get("goodsName"));
					good.setShortName(rsMap.get("shortName"));
					good.setGoodsClass(rsMap.get("goodsClass"));
					good.setGoodsStd(rsMap.get("goodsStd"));
					good.setPrice(rsMap.get("Price"));
					good.setWeight(rsMap.get("Weight"));
					good.setVolume(rsMap.get("Volume"));
					good.setUnitID(rsMap.get("unitID"));
					good.setVendor(rsMap.get("Vendor"));
					good.setLowQuantity(rsMap.get("lowQuantity"));
					good.setHighQuantity(rsMap.get("highQuantity"));
					good.setSafeQuantity(rsMap.get("safeQuantity"));
					good.setWhID(rsMap.get("whID"));
					good.setHighPrice(rsMap.get("highPrice"));
					good.setLowPrice(rsMap.get("lowPrice"));
					good.setBuilder(rsMap.get("Builder"));
					good.setModiPerson(rsMap.get("modiPerson"));
					good.setModiTime(rsMap.get("modiTime"));
					good.setNowQuantity(rsMap.get("nowQuantity"));
					good.setLastCleckTime(rsMap.get("lastCleckTime"));
					
					gList.add(good);
				}
				request.setAttribute("gList", gList);
				request.getRequestDispatcher("selectgood_succeed.jsp").forward(request, response);

			}
			
			if(!goodsID.equals("")){
				demo = demo + "goodsID =" + goodsID;
				
				System.out.println("goodsID≤‚ ‘ "+ demo);
				
				JDBC jdbc = new JDBC();
				ArrayList<HashMap<String, String>> rsList = jdbc.query(demo);
				ArrayList<Good> gList = new ArrayList<Good>();
				for(int i = 0;i < rsList.size();i++){
					HashMap<String, String> rsMap = rsList.get(i);
					Good good = new Good();
					good.setGoodsID(rsMap.get("goodsID"));
					good.setGoodsName(rsMap.get("goodsName"));
					good.setShortName(rsMap.get("shortName"));
					good.setGoodsClass(rsMap.get("goodsClass"));
					good.setGoodsStd(rsMap.get("goodsStd"));
					good.setPrice(rsMap.get("Price"));
					good.setWeight(rsMap.get("Weight"));
					good.setVolume(rsMap.get("Volume"));
					good.setUnitID(rsMap.get("unitID"));
					good.setVendor(rsMap.get("Vendor"));
					good.setLowQuantity(rsMap.get("lowQuantity"));
					good.setHighQuantity(rsMap.get("highQuantity"));
					good.setSafeQuantity(rsMap.get("safeQuantity"));
					good.setWhID(rsMap.get("whID"));
					good.setHighPrice(rsMap.get("highPrice"));
					good.setLowPrice(rsMap.get("lowPrice"));
					good.setBuilder(rsMap.get("Builder"));
					good.setModiPerson(rsMap.get("modiPerson"));
					good.setModiTime(rsMap.get("modiTime"));
					good.setNowQuantity(rsMap.get("nowQuantity"));
					good.setLastCleckTime(rsMap.get("lastCleckTime"));
					
					gList.add(good);
				}
				
				request.setAttribute("gList", gList);
				request.getRequestDispatcher("selectgood_succeed.jsp").forward(request, response);
			}
			
			//System.out.println("111111111111111");
			if(!goodsClass.equals("")){
				System.out.println("22222211111111111");
				demo = demo + "goodsClass =" +"'"+ goodsClass+"'";
				System.out.println("goodsClass≤‚ ‘" + demo);
				System.out.println("11111111111");
				JDBC jdbc = new JDBC();
				System.out.println(demo);
				ArrayList<HashMap<String, String>> rsList = jdbc.query(demo);
				ArrayList<Good> gList = new ArrayList<Good>();
				for(int i = 0;i < rsList.size();i++){
					HashMap<String, String> rsMap = rsList.get(i);
					Good good = new Good();
					good.setGoodsID(rsMap.get("goodsID"));
					good.setGoodsName(rsMap.get("goodsName"));
					good.setShortName(rsMap.get("shortName"));
					good.setGoodsClass(rsMap.get("goodsClass"));
					good.setGoodsStd(rsMap.get("goodsStd"));
					good.setPrice(rsMap.get("Price"));
					good.setWeight(rsMap.get("Weight"));
					good.setVolume(rsMap.get("Volume"));
					good.setUnitID(rsMap.get("unitID"));
					good.setVendor(rsMap.get("Vendor"));
					good.setLowQuantity(rsMap.get("lowQuantity"));
					good.setHighQuantity(rsMap.get("highQuantity"));
					good.setSafeQuantity(rsMap.get("safeQuantity"));
					good.setWhID(rsMap.get("whID"));
					good.setHighPrice(rsMap.get("highPrice"));
					good.setLowPrice(rsMap.get("lowPrice"));
					good.setBuilder(rsMap.get("Builder"));
					good.setModiPerson(rsMap.get("modiPerson"));
					good.setModiTime(rsMap.get("modiTime"));
					good.setNowQuantity(rsMap.get("nowQuantity"));
					good.setLastCleckTime(rsMap.get("lastCleckTime"));
					
					gList.add(good);
				}
				
				request.setAttribute("gList", gList);
				request.getRequestDispatcher("selectgood_succeed.jsp").forward(request, response);
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

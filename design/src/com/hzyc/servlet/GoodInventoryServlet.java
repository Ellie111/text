package com.hzyc.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hzyc.jdbc.JDBC;
import com.hzyc.models.Good;


public class GoodInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			String demo = " select * from gdmess";
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

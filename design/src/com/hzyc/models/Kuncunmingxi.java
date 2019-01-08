package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Kuncunmingxi {
	
	private String Code;
	private String goodsID;
	private String Unit;
	private String Price;
	private String Quantity;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	
	
	public boolean Update(String sql){
		boolean sign = false ;
		try {
			JDBC jt = new JDBC() ;
			int result = jt.update(sql);
			if(result == 1){
				sign = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign ;
	}
	
	public ArrayList<Kuncunmingxi> Show(){
		ArrayList<Kuncunmingxi> slist = new ArrayList<Kuncunmingxi>();
		try {
			String sql = "select * from STOCK " ;
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				//Stock st = new Stock();
				Kuncunmingxi kuncun = new Kuncunmingxi();
				kuncun.setCode(hmap.get("Code"));
				kuncun.setGoodsID(hmap.get("goodsID"));
				kuncun.setUnit(hmap.get("Unit"));
				kuncun.setPrice(hmap.get("Price"));
				kuncun.setQuantity(hmap.get("Quantity"));
				
				slist.add(kuncun);
				
			}
			return slist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}


}

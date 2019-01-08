package com.hzyc.servlet;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Chuku {
	
	private String  autoid;
	private String  goodesid;
	private String  source;
	private String  unit;
	private String  quantity;
	private String  opDate;
	private String  operator;
	public String getAutoid() {
		return autoid;
	}
	public void setAutoid(String autoid) {
		this.autoid = autoid;
	}
	public String getGoodesid() {
		return goodesid;
	}
	public void setGoodesid(String goodesid) {
		this.goodesid = goodesid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getOpDate() {
		return opDate;
	}
	public void setOpDate(String opDate) {
		this.opDate = opDate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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

	public ArrayList<Chuku> Select(String sql){
		ArrayList<Chuku> dlist = new ArrayList<Chuku>() ;
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Chuku chuku = new Chuku() ;
				chuku.setAutoid(hmap.get("autoid"));
				chuku.setGoodesid(hmap.get("goodesid"));
				chuku.setSource(hmap.get("source"));
				chuku.setUnit(hmap.get("unit"));
				chuku.setQuantity(hmap.get("quantity"));
				chuku.setOpDate(hmap.get("opDate"));
				chuku.setOperator(hmap.get("operator"));
				dlist.add(chuku);
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public ArrayList<Chuku> Show(){
		ArrayList<Chuku> dlist = new ArrayList<Chuku>() ;
		try {
			String sql = "select * from  DELETESTOCK " ;
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Chuku chuku = new Chuku() ;
				chuku.setAutoid(hmap.get("autoid"));
				chuku.setGoodesid(hmap.get("goodesid"));
				chuku.setSource(hmap.get("source"));
				chuku.setUnit(hmap.get("unit"));
				chuku.setQuantity(hmap.get("quantity"));
				chuku.setOpDate(hmap.get("opDate"));
				chuku.setOperator(hmap.get("operator"));
				dlist.add(chuku) ;
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public Chuku Query(String autoid){
		try {
			String sql = "select * from DELETESTOCK where autoid = '"+autoid+"'" ;
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			HashMap<String,String> hmap = alist.get(0) ;
			Chuku chuku = new Chuku() ;
			chuku.setAutoid(hmap.get("autoid"));
			chuku.setGoodesid(hmap.get("goodesid"));
			chuku.setSource(hmap.get("source"));
			chuku.setUnit(hmap.get("unit"));
			chuku.setQuantity(hmap.get("quantity"));
			chuku.setOpDate(hmap.get("opDate"));
			chuku.setOperator(hmap.get("operator"));
			return chuku ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}


}

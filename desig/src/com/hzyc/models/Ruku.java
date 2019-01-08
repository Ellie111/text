package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Ruku {
	
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

	public ArrayList<Ruku> Select(String sql){
		ArrayList<Ruku> dlist = new ArrayList<Ruku>() ;
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Ruku ruku = new Ruku() ;
				ruku.setAutoid(hmap.get("autoid"));
				ruku.setGoodesid(hmap.get("goodesid"));
				ruku.setSource(hmap.get("source"));
				ruku.setUnit(hmap.get("unit"));
				ruku.setQuantity(hmap.get("quantity"));
				ruku.setOpDate(hmap.get("opDate"));
				ruku.setOperator(hmap.get("operator"));
				dlist.add(ruku);
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public ArrayList<Ruku> Show(){
		ArrayList<Ruku> dlist = new ArrayList<Ruku>() ;
		try {
			String sql = "select * from  ADDSTOCK " ;
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Ruku ruku = new Ruku() ;
				ruku.setAutoid(hmap.get("autoid"));
				ruku.setGoodesid(hmap.get("goodesid"));
				ruku.setSource(hmap.get("source"));
				ruku.setUnit(hmap.get("unit"));
				ruku.setQuantity(hmap.get("quantity"));
				ruku.setOpDate(hmap.get("opDate"));
				ruku.setOperator(hmap.get("operator"));
				dlist.add(ruku) ;
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public Ruku Query(String autoid){
		try {
			String sql = "select * from ADDSTOCK where autoid = '"+autoid+"'" ;
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			HashMap<String,String> hmap = alist.get(0) ;
			Ruku ruku = new Ruku() ;
			ruku.setAutoid(hmap.get("autoid"));
			ruku.setGoodesid(hmap.get("goodesid"));
			ruku.setSource(hmap.get("source"));
			ruku.setUnit(hmap.get("unit"));
			ruku.setQuantity(hmap.get("quantity"));
			ruku.setOpDate(hmap.get("opDate"));
			ruku.setOperator(hmap.get("operator"));
			return ruku ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}


}

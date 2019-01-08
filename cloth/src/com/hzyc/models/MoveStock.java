package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class MoveStock {
	
	private String autoid ;
	private String goodesid ;
	private String source ;
	private String target ;
	private String unit ;
	private String quantity ;
	private String opDate ;
	private String operator ;
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
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
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
			if( result == 1){
				sign = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign ;
	}
	
	
	public ArrayList<MoveStock> Select(String sql){
		ArrayList<MoveStock> mlist = new ArrayList<MoveStock>() ;
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				MoveStock mt = new MoveStock() ;
				mt.setAutoid(hmap.get("autoid"));
				mt.setGoodesid(hmap.get("goodesid"));
				mt.setSource(hmap.get("source"));
				mt.setTarget(hmap.get("target"));
				mt.setUnit(hmap.get("unit"));
				mt.setQuantity(hmap.get("quantity"));
				mt.setOpDate(hmap.get("opDate"));
				mt.setOperator(hmap.get("operator"));
				mlist.add(mt);
			}
			return mlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	
	public ArrayList<MoveStock> Show(){
		ArrayList<MoveStock> mlist = new ArrayList<MoveStock>() ;
		try {
			JDBC jt = new JDBC() ;
			String sql = "select * from MOVESTOCK " ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				MoveStock mt = new MoveStock() ;
				mt.setAutoid(hmap.get("autoid"));
				mt.setGoodesid(hmap.get("goodesid"));
				mt.setSource(hmap.get("source"));
				mt.setTarget(hmap.get("target"));
				mt.setUnit(hmap.get("unit"));
				mt.setQuantity(hmap.get("quantity"));
				mt.setOpDate(hmap.get("opDate"));
				mt.setOperator(hmap.get("operator"));
				mlist.add(mt);
			}
			return mlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}


}

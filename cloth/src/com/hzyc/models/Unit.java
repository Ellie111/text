package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Unit {
	private String unitID ;
	private String unitName ;
	public String getUnitID() {
		return unitID;
	}
	public void setUnitID(String unitID) {
		this.unitID = unitID;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	
	public ArrayList<Unit> Show(){
		ArrayList<Unit> ulist = new ArrayList<Unit>();
		try {
			String sql = "select * from UNIT " ;
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				Unit ut = new Unit();
				ut.setUnitID(hmap.get("unitID"));
				ut.setUnitName(hmap.get("unitName"));
				ulist.add(ut);
			}
			return ulist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	
}

package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Operation {
	private String opeTypeID ;
	private String opeTypeNa ;
	
	public String getOpeTypeID() {
		return opeTypeID;
	}
	public void setOpeTypeID(String opeTypeID) {
		this.opeTypeID = opeTypeID;
	}
	public String getOpeTypeNa() {
		return opeTypeNa;
	}
	public void setOpeTypeNa(String opeTypeNa) {
		this.opeTypeNa = opeTypeNa;
	}
	
	public boolean Add(String sql){
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
	public ArrayList<Operation> Select(String sql){
		ArrayList<Operation> olist = new ArrayList<Operation>() ;
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Operation ot = new Operation() ;
				ot.setOpeTypeID(hmap.get("opeTypeID"));
				ot.setOpeTypeNa(hmap.get("opeTypeNa"));
				olist.add(ot);
			}
			return olist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	public ArrayList<Operation> Show(){
		ArrayList<Operation> olist = new ArrayList<Operation>() ;
		try {
			String sql = "select * from OPST " ;
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Operation ot = new Operation() ;
				ot.setOpeTypeID(hmap.get("opeTypeID"));
				ot.setOpeTypeNa(hmap.get("opeTypeNa"));
				olist.add(ot);
			}
			return olist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
}

package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Warehouse {
	
	private String whID ;
	private String Name ;
	private String whPerson ;
	private String whAddr ;
	public String getWhID() {
		return whID;
	}
	public void setWhID(String whID) {
		this.whID = whID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getWhPerson() {
		return whPerson;
	}
	public void setWhPerson(String whPerson) {
		this.whPerson = whPerson;
	}
	public String getWhAddr() {
		return whAddr;
	}
	public void setWhAddr(String whAddr) {
		this.whAddr = whAddr;
	}
	
	public boolean Add(){
		boolean sign = false ;
		try {
			JDBC jt = new JDBC() ;
			String sql = "insert into WH values ('"+whID+"' , '"+Name+"' ,'"+whPerson+"' , '"+whAddr+"')" ;
			int result = jt.update(sql);
			if(result == 1){
				sign = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign ;
	}
	
	public boolean Update(String sql){
		boolean sign =  false ;
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
	
	public boolean Delete(String sql){
		boolean sign = false ;
		try {
			
			JDBC jt = new JDBC();
			int result = jt.update(sql) ;
			if(result == 1){
				sign = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign ;
	}
	
	
	
	
	public ArrayList<Warehouse> Select(String sql){
		try {
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			ArrayList<Warehouse> wlist = new ArrayList<Warehouse>();
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				Warehouse wh = new Warehouse();
				wh.setWhID(hmap.get("whID"));
				wh.setName(hmap.get("Name"));
				wh.setWhPerson(hmap.get("whPerson"));
				wh.setWhAddr(hmap.get("whAddr"));
				wlist.add(wh);
			}
			return wlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public ArrayList<Warehouse> Show(){
		try {
			String sql = "select * from WH" ;
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			ArrayList<Warehouse> wlist = new ArrayList<Warehouse>();
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				Warehouse wh = new Warehouse() ;
				wh.setWhID(hmap.get("whID"));
				wh.setName(hmap.get("Name"));
				wh.setWhPerson(hmap.get("whPerson"));
				wh.setWhAddr(hmap.get("whAddr"));
				wlist.add(wh);
			}
			return wlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}


}

package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Department {
	
	private String deptCode ;
	private String deptName ;
	private String Depac ;
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDepac() {
		return Depac;
	}
	public void setDepac(String depac) {
		Depac = depac;
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
	
	
	public ArrayList<Department> Select(String sql){
		ArrayList<Department> dlist = new ArrayList<Department>() ;
		try {
			JDBC jt = new JDBC() ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Department dt = new Department() ;
				dt.setDeptCode(hmap.get("deptCode"));
				dt.setDeptName(hmap.get("deptName"));
				dt.setDepac(hmap.get("Depac"));
				dlist.add(dt) ;
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	public ArrayList<Department> Show(){
		ArrayList<Department> dlist = new ArrayList<Department>() ;
		try {
			JDBC jt = new JDBC() ;
			String sql = "select * from DEPT " ;
			ArrayList<HashMap<String ,String>> alist =jt.query(sql);
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i) ;
				Department dt = new Department() ;
				dt.setDeptCode(hmap.get("deptCode"));
				dt.setDeptName(hmap.get("deptName"));
				dt.setDepac(hmap.get("Depac"));
				dlist.add(dt) ;
			}
			return dlist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

}

package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hzyc.jdbc.JDBC;

public class Emp {
	private String empCode;
	private String empName;
	private String empSex;
	private String empState;
	private String password;
	private String empTel;
	private String memo;
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getEmpState() {
		return empState;
	}
	public void setEmpState(String empState) {
		this.empState = empState;
	}
	
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	
	
	
	public boolean addemp(){
		boolean sign=false;
		
		try {
				String sql="insert into EMP values('"+empCode+"','"+empName+"','"+empSex+"','"+password+"','"+empTel+"','"+memo+"','"+empState+"')";
				JDBC db =new JDBC();
				int result=db.update(sql);
				if(result!=-1){
					sign=true;
				}
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sign;
	}
	
	
	
	public List<Emp> query(){
		List<Emp> aList = new ArrayList<Emp>();
		try {
			JDBC jt = new JDBC();
			ArrayList<HashMap<String,String>> rsList = jt.query("select * from emp");
			for(int i = 0;i < rsList.size();i++){
				HashMap<String,String> rsMap = rsList.get(i);
				Emp emp = new Emp();
				emp.setEmpCode(rsMap.get("empCode"));
				emp.setEmpName(rsMap.get("empName"));
				emp.setEmpSex(rsMap.get("empSex"));
				emp.setPassword(rsMap.get("password"));
				emp.setEmpTel(rsMap.get("empTel"));
				emp.setMemo(rsMap.get("memo"));
				emp.setEmpState(rsMap.get("empState"));
				aList.add(emp);
			}
			
			return aList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
public Emp queryById(String empCode){
		
		try {
			JDBC jt = new JDBC();
			ArrayList<HashMap<String,String>> rsList = jt.query("select * from emp where empCode = '"+empCode+"'");
			
				//由于只能得到一条记录，所以不必遍历，取get(0)
				HashMap<String,String> rsMap = rsList.get(0);
				Emp emp = new Emp();
				emp.setEmpCode(rsMap.get("empCode"));
				emp.setEmpName(rsMap.get("empName"));
				emp.setEmpSex(rsMap.get("empSex"));
				emp.setEmpState(rsMap.get("empState"));
				emp.setPassword(rsMap.get("password"));
				emp.setEmpTel(rsMap.get("empTel"));
				emp.setMemo(rsMap.get("memo"));
				
		
			
			return emp;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

      
public boolean updatepeople(){
	boolean sign=false;
	try {
		
		String sql="update EMP set empName='"+empName+"',empSex='"+empSex+"',Password='"+password+"',empTel='"+empTel+"',memo='"+memo+"',empState='"+empState+"' where empCode='"+empCode+"'";
		System.out.println(sql);
		JDBC db=new JDBC();
		int result=db.update(sql);
		if(result!=-1){
			sign=true;
		
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return sign;
}
	
	
	
	
}

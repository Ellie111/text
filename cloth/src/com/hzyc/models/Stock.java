package com.hzyc.models;

import java.util.ArrayList;
import java.util.HashMap;

import com.hzyc.jdbc.JDBC;

public class Stock {
	private String Code ;
	private String opeTypeID ;
	private String vouchType ;
	private String whID ;
	private String Depart ;
	private String Clerk ;
	private String Operator ;
	private String opTime ;
	private String Vendor ;
	private String Customer ;
	private String Summ ;
	private String orderCode ;
	private String receiveCode ;
	private String invoiceCode ;
	private String dispathCode ;
	private String Memo ;
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getOpeTypeID() {
		return opeTypeID;
	}
	public void setOpeTypeID(String opeTypeID) {
		this.opeTypeID = opeTypeID;
	}
	public String getVouchType() {
		return vouchType;
	}
	public void setVouchType(String vouchType) {
		this.vouchType = vouchType;
	}
	public String getWhID() {
		return whID;
	}
	public void setWhID(String whID) {
		this.whID = whID;
	}
	public String getDepart() {
		return Depart;
	}
	public void setDepart(String depart) {
		Depart = depart;
	}
	public String getClerk() {
		return Clerk;
	}
	public void setClerk(String clerk) {
		Clerk = clerk;
	}
	public String getOperator() {
		return Operator;
	}
	public void setOperator(String operator) {
		Operator = operator;
	}
	public String getOpTime() {
		return opTime;
	}
	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}
	public String getVendor() {
		return Vendor;
	}
	public void setVendor(String vendor) {
		Vendor = vendor;
	}
	public String getCustomer() {
		return Customer;
	}
	public void setCustomer(String customer) {
		Customer = customer;
	}
	public String getSumm() {
		return Summ;
	}
	public void setSumm(String summ) {
		Summ = summ;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getReceiveCode() {
		return receiveCode;
	}
	public void setReceiveCode(String receiveCode) {
		this.receiveCode = receiveCode;
	}
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getDispathCode() {
		return dispathCode;
	}
	public void setDispathCode(String dispathCode) {
		this.dispathCode = dispathCode;
	}
	public String getMemo() {
		return Memo;
	}
	public void setMemo(String memo) {
		Memo = memo;
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

	
	public ArrayList<Stock> Show(){
		ArrayList<Stock> slist = new ArrayList<Stock>();
		try {
			String sql = "select * from MSTOCK " ;
			JDBC jt = new JDBC();
			ArrayList<HashMap<String ,String>> alist = jt.query(sql);
			
			for(int i = 0 ; i < alist.size() ; i++){
				HashMap<String ,String> hmap = alist.get(i);
				Stock st = new Stock();
				st.setCode(hmap.get("Code"));
				st.setOpeTypeID(hmap.get("opeTypeID"));
				st.setVouchType(hmap.get("vouchType"));
				st.setWhID(hmap.get("whID"));
				st.setDepart(hmap.get("Depart"));
				st.setClerk(hmap.get("Clerk"));
				st.setOperator(hmap.get("Operator"));
				st.setOpTime(hmap.get("opTime"));
				st.setVendor(hmap.get("Vendor"));
				st.setCustomer(hmap.get("Customer"));
				st.setSumm(hmap.get("Summ"));
				st.setOrderCode(hmap.get("orderCode"));
				st.setReceiveCode(hmap.get("receiveCode"));
				st.setInvoiceCode(hmap.get("invoiceCode"));
				st.setDispathCode(hmap.get("dispatchCode"));
				st.setMemo(hmap.get("Memo"));
				slist.add(st);
				
			}
			return slist ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}



}

package com.ascent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.ascent.bean.Usr;
import com.ascent.util.DataAccess;
public class LoginDAO  {
       
	public Usr login(String user, String password){
		Connection con = DataAccess.getConnection();
		
		System.out.println("con:"+con);
		System.out.println("user:"+user+"\n password:"+password);
		
		String sql = "select * from usr where username=? and password=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		Usr pu = null;
		try{
		pst = con.prepareStatement(sql);
		pst.setString(1, user); //getObject(1)
		pst.setString(2, password);
		rs = pst.executeQuery(); 
		
		if(rs.next()){
		pu = new Usr();
		pu.setId(rs.getInt("id"));
		pu.setSuperuser(rs.getString("superuser"));
		pu.setUsername(rs.getString("username"));
		pu.setEmail(rs.getString("email"));
		pu.setTel(rs.getString("tel"));
		pu.setCompanyname(rs.getString("companyname"));
		pu.setCompanyaddress(rs.getString("companyaddress"));}
		}catch(SQLException e){
		e.printStackTrace();
		}finally{
		try{
		if(rs!=null){
		rs.close();
		}
		if(pst!=null){
		pst.close();
		}
		if(con!=null){
		con.close();
		}
		}catch (Exception e2){
		e2.printStackTrace();
		}
		}
		
		return pu;
		}
		
		}
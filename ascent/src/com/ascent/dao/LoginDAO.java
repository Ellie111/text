package com.ascent.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ascent.bean.Usr;
import com.ascent.util.DataAccess;

public class LoginDAO extends HttpServlet {
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
		//使用JDBC连接数据库需要四步，第一步加载驱动程序；第二步，连接数据库；第三步，访问数据库；第四步，执行查询；其中在第四步执行查询时，要用statement类的executeQuery()方法来下达select指令以查询数据库，
		//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用。
		//即语句：String sql="select * from"+tableName; ResultSet rs=s.executeQuery(sql);
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

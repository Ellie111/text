package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

import tools.DBManager;

public class UserDAO {
	     // 登陆验证
	     public boolean login(String uName, String uPass)
	     {
	     boolean flag = false;
	    //String sql = "SELECT * FROM user where u_name = ? and u_pass = ?";
	    // String sql = "SELECT * FROM user where u_name = ? and u_pass = ?";
String sql = "SELECT * FROM user WHERE u_name = '" + uName + "' and u_pass = '"+uPass+"'";
	     flag = DBManager.preSelect(sql, uName,uPass);
//flag = DBManager.preselect(sql);
	     return flag;
	     }
	     
	     // 注册
	     public boolean addUser(User user)
	     {
	     boolean flag = false;
	     String sql = "";
	       sql = "INSERT INTO user VALUES('" + user.getuID() + "','"
	            + user.getuName() + "','" + user.getuPassword() + "','"
	            + user.getuRealName() + "','" + user.getuSex() + "','"
	            + user.getuPhone() + "','" + user.getuEmail() + "','"
	            + user.gettName() + "','" + user.gettNo()
	            + "')";
	     flag = DBManager.update(sql);
	     return flag;
	     }
	     
	     // 查询信息
	     public User query(String uName)
	     {
	     User user      = new User();
	     String sql = "SELECT * FROM user WHERE u_name = '" + uName + "'";
	     try (ResultSet rs = DBManager.select(sql))
	     {
	       while (rs.next())
	       {
	            if (!uName.equals(rs.getString("u_name")))
	            {
	            throw new SQLException("查询用户信息出错");
	            }
	            user.setuID(rs.getString("u_id"));
	            user.setuName(uName);
	            user.setuRealName(rs.getString("u_real_name"));
	            user.setuSex(rs.getString("u_sex"));
	            user.setuPhone(rs.getString("u_phone"));
	            user.setuEmail(rs.getString("u_email"));
	            user.settName(rs.getString("t_name"));
	            user.settNo(rs.getString("t_no"));
	       }
	       return user;
	     }
	     catch(SQLException sqle)
	     {
	          System.out.println("查询用户信息出错!");
	          sqle.printStackTrace();
	          return null;
	     }
	     }
	     // 修改信息
	     public boolean update(User user)
	     {
	     boolean flag = false;
	     String sql = "UPDATE user SET u_phone = '" + user.getuPhone() + "',u_email = '" + user.getuEmail() + "' WHERE u_name = '" + user.getuName() + "'"; 
	     flag = DBManager.update(sql);
	     return flag;
	     }
	    /*   public static void main(String[] args)
	     {
	     UserDAO u = new UserDAO();
	    System.out.println(u.login("sliver.two", "123456")); // 测试登陆
	     // 测试注册
	   User user = new User("430524198955253365","ittwo","987456321abc","王老五","男","13142311559","5461578@qq.com");
	     if(u.addUser(user))
	          System.out.println("恭喜，注册成功!");
	     else 
	          System.out.println("抱歉，注册失败!");
	   // 查询测试
	    User user2 = u.query("ittwo");
	     System.out.println(user2.getuRealName());
	     // 测试修改
	     user2.setuPhone("18142611739");
	     System.out.println(u.update(user2));
	     } */ 
	
}

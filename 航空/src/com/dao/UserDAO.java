package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;

import tools.DataAccess;

public class UserDAO {
	     // 登陆验证
	 public boolean login(String uName, String uPass){
             Connection con =DataAccess.getConnection();
             boolean flag=false;
             String sql ="select * from User where uName=? and uPassword=?";
             PreparedStatement pst = null;
             ResultSet rs = null ;
             User u = null ;
             try {
                       pst = con.prepareStatement(sql);
                       pst.setString(1, uName);
                       pst.setString(2, uPass);
                       rs = pst.executeQuery();
                       if (rs.next()) {
                       u = new User();
                       u.setuID(rs.getString("uID"));
                       u.setuName(rs.getString("uName"));
                       flag=false;
                     }
             } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
          }
             return flag;
    }
	     // 注册信息
	     public boolean Register(User u){
	         Connection con = DataAccess.getConnection();
	         boolean flag=false;
	         String sql = "insert into User(uID,uName,uPassword,uRealName,uSex,uPhone,uEmail) values(?,?,?,?,?,?,?)";
	         String aa = "select * from User where uName=?";
	         PreparedStatement stmt =null;
	         PreparedStatement stmt1 =null;
	         ResultSet rs =null;
	         try {
	                   stmt1=con.prepareStatement(aa);
	                   stmt1.setString(2,u.getuName());
	                   rs=stmt1.executeQuery();
	                   if(rs.next()){
	                            flag=true;
	                   }else{
	                     stmt = con.prepareStatement(sql);
	                     	stmt.setString(1,u.getuID());
	                         stmt.setString(2,u.getuName());
	                         stmt.setString(3,u.getuPassword());
	                         stmt.setString(4,u.getuRealName());
	                         stmt.setString(6,u.getuSex());
	                         stmt.setString(7,u.getuPhone());
	                         stmt.setString(8,u.getuEmail());
	                         stmt.executeUpdate();
	                         flag=false;
	                   }
	      } catch (SQLException e)
	         {e.printStackTrace();
	      }finally{
	    	  try {
	              if(stmt!=null)
	              {stmt.close();}
	              if(con!=null)
	              {con.close();}
	              } 
	    	  catch (Exception e2) {
	                e2.printStackTrace();
	                }
	      }
	         return flag;
	  }
	     // 查询信息
	     public User query(String uName)
	     {
	    	 Connection con =DataAccess.getConnection();
             String sql ="select * from User where uName=? ";
             PreparedStatement pst = null;
             ResultSet rs = null ;
             User u = null ;
             
             try {
            	 pst=con.prepareStatement(sql);
            	 pst.setString(2, u.getuName());
                 rs=pst.executeQuery();
            	 while (rs.next())
      	       {
      	            if (!uName.equals(rs.getString("u_name")))
      	            {
      	            throw new SQLException("查询用户信息出错");
      	            }
      	            u.setuID(rs.getString("u_id"));
      	            u.setuName(uName);
      	            u.setuRealName(rs.getString("u_real_name"));
      	            u.setuSex(rs.getString("u_sex"));
      	            u.setuPhone(rs.getString("u_phone"));
      	            u.setuEmail(rs.getString("u_email"));
      	            u.settName(rs.getString("t_name"));
      	            u.settNo(rs.getString("t_no"));
      	       }
      	       return u;
      	     }
      	     catch(SQLException sqle)
      	     {
      	          System.out.println("查询用户信息出错!");
      	          sqle.printStackTrace();
      	          return null;
      	     }
             }
      	     
	       
	     // 修改信息
	    /* public boolean update(User user)
	     {
	     boolean flag = false;
	     String sql = "UPDATE user SET u_phone = '" + user.getuPhone() + "',u_email = '" + user.getuEmail() + "' WHERE u_name = '" + user.getuName() + "'"; 
	     flag = DBManager.update(sql);
	     return flag;
	     }
	     public static void main(String[] args)
	     {
	     UserDAO u = new UserDAO();
	    // System.out.println(u.login("sliver.two", "123456")); // 测试登陆
	     // 测试注册
	     /*User user = new User("430524198955253365","ittwo","987456321abc","王老五","男","13142311559","5461578@qq.com");
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

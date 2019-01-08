package com.ascent.dao;
import java.sql.*;
import java.util.*;
import com.ascent.bean.Usr;
import com.ascent.util.*;
public class UserManagerDAO {
	public boolean register(Usr user){
		boolean flag = false;  //标识注册用户是否成功字段
		Connection con = DataAccess.getConnection(); //连接数据库
		PreparedStatement pst = null;  //编译语句
		PreparedStatement p = null;
		String s="select * from Usr where id=? ";  //查询该账号是否已经注册
		try{
		con.setAutoCommit(false);  //禁用自动提交模式
		p = con.prepareStatement(s);
		p.setInt(1,user.getId());
		ResultSet rs=p.executeQuery();
		if(rs.next()){
		flag=false;
		System.out.println("该账号已被注册，请重新输入账号");
		}
		else{
		String sql="insert into usr(id,username,password,fullname,title,companyname,companyaddress,city,job,tel,email,country,zip,superuser) "
		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,'1')";
		pst=con.prepareStatement(sql); 	//执行sql语句
		pst.setInt(1,user.getId());
		pst.setString(2,user.getUsername());
		pst.setString(3,user.getPassword());
		pst.setString(4,user.getFullname());
		pst.setString(5,user.getTitle());
		pst.setString(6,user.getCompanyname());
		pst.setString(7,user.getCompanyaddress());
		pst.setString(8,user.getCity());
		pst.setString(9,user.getJob());
		pst.setString(10,user.getTel());
		pst.setString(11,user.getEmail());
		pst.setString(12,user.getCountry());
		pst.setString(13,user.getZip());
		pst.executeUpdate(); 
		con.commit();
		flag=true;
		pst.close();
		con.close(); } 
		}catch (SQLException e) {
		e.printStackTrace();
		try{
		con.rollback();
		}catch (SQLException e1) {
		e1.printStackTrace();
		}
			}
		return flag;
		}
	
 public List<Usr>getAllProductUser(){
  Connection con = DataAccess.getConnection();
  String sql = "select * from usr p order by p.id";
  List<Usr>list = new ArrayList<Usr>();
  Statement stmt = null;
  ResultSet rs = null;
  try{
   stmt = con.createStatement();
   rs=stmt.executeQuery(sql);
   while(rs.next()){
    Usr pu = new Usr();
    pu.setId(rs.getInt("id"));
    pu.setUsername(rs.getString("username"));
    pu.setPassword(rs.getString("password"));
    pu.setFullname(rs.getString("fullname"));
    pu.setTitle(rs.getString("title"));
    pu.setCompanyname(rs.getString("companyname"));
    pu.setCompanyaddress(rs.getString("companyaddress"));
    pu.setCity(rs.getString("city"));
    pu.setJob(rs.getString("job"));
    pu.setTel(rs.getString("tel"));
    pu.setEmail(rs.getString("email"));
    pu.setCountry(rs.getString("country"));
    pu.setZip(rs.getString("zip"));
    pu.setSuperuser(rs.getString("superuser"));
    list.add(pu);
    
   }
  }catch(Exception e){
   e.printStackTrace();
  }finally{
   try{
    if(rs!=null){
     rs.close();
    }
    if(stmt!=null){
     stmt.close();
    }
    if(con!=null){
     con.close();
    }
   }catch(Exception e2){
    e2.printStackTrace();
   }
  }
  System.out.println("listuser:"+list);
  return list;
 }
}
 
package com.csms.dao.interImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.csms.dao.inter.UserInterface;
import com.csms.dao.model.UserInfo;
import com.csms.db.DBConnection;
public class UserImpl implements UserInterface {

	public int insertUser(UserInfo user)  throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("insert into usertable (userLogin,userName,userPwd,userNote,flag)");
		strSql.append(" values('"+user.getUserLogin()+"','"+user.getUserName()+"','"+user.getUserPwd()+"','"+user.getUserNote()+"',0)");
		DBConnection db=new DBConnection();
		Connection conn=db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		int result=pst.executeUpdate();
		return result;
	}

	public int delUser(String userLogin) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("delete from usertable where userLogin='"+userLogin+"'");
		DBConnection db=new DBConnection();
		Connection conn=db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		int result=pst.executeUpdate();
		return result;
	}

	public int updateUser(UserInfo user) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("update  usertable set userName='"+user.getUserName()+"', userNote='"+user.getUserNote()+"' ");
		strSql.append(" where userLogin='"+user.getUserLogin()+"'");
		DBConnection db=new DBConnection();
		Connection conn=db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		int result=pst.executeUpdate();
		return result;
		
	}

	public ResultSet queryUser(String strWhere) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("select * from usertable ");
		if(!strWhere.equals("")){
			strSql.append(" where "+strWhere);
		}
		DBConnection db=new DBConnection();
		Connection conn=db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		ResultSet rs=pst.executeQuery();
		return rs;
	}

	public int updatePwd(String userLogin,String oldPwd, String newPwd) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("select * from usertable where ");
		strSql.append(" userLogin='"+userLogin+"' and userPwd='"+oldPwd+"'");
		DBConnection db=new DBConnection();
		Connection conn=db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			StringBuffer strUpdate=new StringBuffer();
			strUpdate.append("update usertable set userpwd='"+newPwd+"' where userlogin='"+userLogin+"'");
			PreparedStatement pst1=conn.prepareStatement(strUpdate.toString());
			return pst1.executeUpdate();
		}
		else {
			return -1;
		}

	}

	public ResultSet loginUser(String userLogin, String userPwd) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		StringBuffer strSql=new StringBuffer();
		strSql.append("select * from usertable where ");
		strSql.append("userLogin='"+userLogin+"'and userPwd='"+userPwd+"'");
		DBConnection db =new DBConnection();
		Connection conn = db.getConn();
		PreparedStatement pst=conn.prepareStatement(strSql.toString());
		ResultSet rs=pst.executeQuery();
		return rs;
	}
}

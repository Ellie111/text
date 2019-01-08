package com.hbsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.domain.Usr;
import com.hbsi.utils.DataAccess;
 
public class UserManagerDAO {
   public boolean Register(Usr u){
       Connection con = DataAccess.getConnection();
       boolean flag=false;
       String sql = "insert into usr(Username,Password,Tel,Email) values(?,?,?,?)";
       String aa = "select * from usr where username=?";
       PreparedStatement stmt =null;
       PreparedStatement stmt1 =null;
       ResultSet rs =null;
       try {
                 stmt1=con.prepareStatement(aa);
                 stmt1.setString(1,u.getUsername());
                 rs=stmt1.executeQuery();
                 if(rs.next()){
                          flag=true;
                 }else{
                   stmt = con.prepareStatement(sql);
                       stmt.setString(1,u.getUsername());
                       stmt.setString(2,u.getPassword());
                       stmt.setString(3,u.getTel());
                       stmt.setString(4,u.getEmail());
                
                       stmt.executeUpdate();
                       flag=false;
                 }
    } catch (SQLException e) {
                                e.printStackTrace();
    }finally{
              try {
                       if(stmt!=null){
                                stmt.close();
                       }
                       if(con!=null){
                                con.close();
                       }
              } catch (Exception e2) {
                       e2.printStackTrace();
              }
    }
       return flag;
}
}
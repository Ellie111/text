package com.hbsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hbsi.domain.Usr;
import com.hbsi.utils.DataAccess;
 
public class LoginDAO {
   public Usr LogIn(String username,String password){
            Connection con =DataAccess.getConnection();
            String sql ="select * from usr where username=? and password=?";
            PreparedStatement pst = null;
            ResultSet rs = null ;
            Usr u = null ;
            try {
                      pst = con.prepareStatement(sql);
                      pst.setString(1, username);
                      pst.setString(2, password);
                      rs = pst.executeQuery();
                      if (rs.next()) {
                      u = new Usr();
                      u.setId(rs.getInt("id"));
                      u.setUsername(rs.getString("username"));
                    }
            } catch (SQLException e) {
                   // TODO Auto-generated catch block
                   e.printStackTrace();
         }
            return u;
   }
}
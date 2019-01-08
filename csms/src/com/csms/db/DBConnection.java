package com.csms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    private static String url="jdbc:mysql://localhost:3306/csmsdb";
    private static String user="root";
    private static String pwd="123456";
    
    public Connection conn;
    
    public Connection getConn() throws ClassNotFoundException,SQLException
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	conn=DriverManager.getConnection(url,user,pwd);
    	return conn;
    }
    public void closeConn()throws SQLException{
    	conn.close();
    }
}

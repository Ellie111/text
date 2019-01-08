package com.ascent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DataAccess {
private static String  driver ="com.mysql.jdbc.Driver";
private static String url ="jdbc:mysql://localhost:3306/ab";
private static String username="root";
private static String password="1234";
public static Connection getConnection(){
Connection con=null;
try {
Class.forName(driver);

 con=DriverManager.getConnection(url,username,password);
} catch (ClassNotFoundException e) {
System.err.println("装载 JDBC/ODBC 驱动程序失败" );  
e.printStackTrace();
}catch (SQLException e2) {
System.err.println( "无法连接数据库" );  
e2.printStackTrace(); 
}
return con;
}}
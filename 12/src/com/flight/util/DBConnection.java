package com.flight.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 private static String driver;
	    private static String url;
	    private static String user;
	    private static String pwd;


	    public static Connection getConnection(){
	        driver = "com.mysql.jdbc.Driver";
	        url = "jdbc:mysql://localhost:3306/flight";
	        user = "root";
	        pwd = "1234";
	        Connection conn = null;
	        try {
	            Class.forName(driver);
	            conn = DriverManager.getConnection(url,user,pwd);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	    public static void main(String[] args){
	        System.out.println(getConnection());
	    }

	}
package com.hzyc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class JDBC {
	
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
		public void getConnection(){
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "root", "1234");
				
				stmt = conn.createStatement();
				
				System.out.println("成功");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			
		}
		
		
		
		public int update(String sql){
			int result = -1;//0.1.2.3.44.55.56.....
			try {
				
				getConnection();
				result = stmt.executeUpdate(sql);
				
				
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			
			return result;
				
		}
		
		
		
	
		public ArrayList<HashMap<String,String>> query(String sql){
			
			ArrayList<HashMap<String,String>> rsList = new ArrayList<HashMap<String,String>>();
			
			try {
				getConnection();
				rs = stmt.executeQuery(sql);
				
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()){
					HashMap<String,String> rsMap = new HashMap<String,String>();
					
					for(int i = 1;i <= rsmd.getColumnCount();i++){
						//System.out.println(rsmd.getColumnName(i));
						String columnName = rsmd.getColumnName(i);
						String columnValue = rs.getString(columnName);
						rsMap.put(columnName, columnValue);
						
					}
					
					rsList.add(rsMap);
					
				}
				
				return rsList;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			
			return null;
			
		}
		
		
		
		public void close(){
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(conn != null){
					conn.close();
				}
				
				System.out.println("关闭");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}

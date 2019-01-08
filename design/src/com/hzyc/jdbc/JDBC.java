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
	
	
	//连接
		public void getConnection(){
			
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//获取连接
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/warehouse", "root", "mysql");
				
				stmt = conn.createStatement();
				
				System.out.println("连接成功");
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				//System.out.println("连接失败");
			}
			
		}
		
		
		//更新数据库
		public int update(String sql){
			int result = -1;//0.1.2.3.44.55.56.....
			try {
				//连接方法
				getConnection();
				result = stmt.executeUpdate(sql);
				
				//break:终止整个循环。
				//return：返回，终止整个方法体。
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				close();
			}
			
			
			return result;
				
		}
		
		
		
		//查询数据库
		public ArrayList<HashMap<String,String>> query(String sql){
			
			ArrayList<HashMap<String,String>> rsList = new ArrayList<HashMap<String,String>>();
			
			try {
				getConnection();
				rs = stmt.executeQuery(sql);
				//得到结果集结构对象（为了得到字段名）
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()){
					HashMap<String,String> rsMap = new HashMap<String,String>();
					//每一条记录只需要一个map即可，map内有5个键值对
					for(int i = 1;i <= rsmd.getColumnCount();i++){
						//System.out.println(rsmd.getColumnName(i));
						String columnName = rsmd.getColumnName(i);
						//根据字段名取得字段值
						String columnValue = rs.getString(columnName);
						//将遍历得到的键值对存储到map中
						rsMap.put(columnName, columnValue);
						
					}
					//当五对键值对都存储到map中之后，存储到list中。
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
		
		
		//释放资源
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
				
				System.out.println("资源关闭");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}

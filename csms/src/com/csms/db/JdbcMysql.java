package com.csms.db;
import java.sql.*;

public class JdbcMysql {

		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			JdbcMysql jdbcMysql = new JdbcMysql();
			//For mssqlserver2008
			/*jdbcMysql.setDbName("flight");
			jdbcMysql.setDbType("sqlserver");
			jdbcMysql.setUser("sa");
			jdbcMysql.setPwd("111111");
			*/
			
			jdbcMysql.setDbName("csmsdb");
			jdbcMysql.setDbType("mysql");
			jdbcMysql.setUser("root");
			jdbcMysql.setPwd("123456");
			
			jdbcMysql.getConnection();
			
			/*String sql="select * from student";
			ResultSet rs = jdbcMysql.excuteQuery(sql);
			
			try {
				while (rs.next()) {
					
					rs.getString("name");
					System.out.print("SNO:"+rs.getString("sno")+"  |  ");
					System.out.println("Name:"+rs.getString("name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                  */
		}
		

		//�������ݿ����ͣ�֧��oracle,sqlserver2008,mysql
		public void setDbType(String dbtype){
			this.dbtype=dbtype;
		}
		
		//������ݿ����ͣ�֧��oracle,sqlserver2008,mysql
		public String getDbType(){
			return dbtype;
		}
		
		//�������ݿ����ӵ��û���	
		public void setUser(String user){
			this.user=user;
		}
		
		//������ݿ����ӵ��û���
		public String getUser(){
			return user;
		}
		//�������ݿ����ӵ�����
		public void setPwd(String passwd){
			this.passwd=passwd;
		}
		//������ݿ����ӵ�����
		public String getPwd(){
			return passwd;
		}
		
		public String getDbName(){
			return dbname;
		}
		public void setDbName(String dbname){
			this.dbname=dbname;
		}
		public Connection getConnection(){
			String driverName=null;		
			if ( dbtype.equalsIgnoreCase("mysql")){
				connURL="jdbc:mysql://localhost:3306/"+dbname+"?user="+user+"&password"+passwd;
				//connURL="jdbc:mysql://localhost:3306/"+dbname;
				driverName="com.mysql.jdbc.Driver";
			}else if (dbtype.equalsIgnoreCase("oracle")){
				connURL="jdbc:mysql://localhost:3306/test?user="+user+"&password"+passwd;
				driverName="com.mysql.jdbc.Driver";
			}else if ( dbtype.equalsIgnoreCase("sqlserver")){
				
				driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				connURL="jdbc:sqlserver://localhost:1433;DatabaseName="+dbname;
			}else {
				System.out.println("��֧�����ݿ�");
			}
			try {
				System.out.println("DriverName:"+driverName);
				System.out.println("URL:"+connURL);
				Class.forName(driverName).newInstance();
				conn=DriverManager.getConnection(connURL,user,passwd);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return conn;

		}
		
		public void close(){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public ResultSet excuteQuery(String sql){
			ResultSet rs=null;
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQLCODE="+e.getErrorCode());
				e.printStackTrace();
				
			}	
			return rs;
		}
		

		//�����������ݿ�ʹ��
		private Connection conn=null;
		private String dbname=null;
		private String connURL=null;
		private String user=null;
		private String passwd=null;
		private String dbtype=null;
		
		//����ִ��excuteQueryʹ��


	}




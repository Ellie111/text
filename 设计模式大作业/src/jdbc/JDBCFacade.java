package jdbc;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;  
import java.sql.ResultSetMetaData;
import java.sql.SQLException;  
import java.sql.Statement;  

public class JDBCFacade {  
        Connection conn = null;  
        Statement stmt = null;  
        ResultSet rs = null;  
        String sqlStr = ""; 
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名
        String url = "jdbc:mysql://localhost:3306/bookshop";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password ="1234";
        public void createStatement() {  
            try {  
                stmt = conn.createStatement();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }   
        
        public ResultSet jdbcSelect(String sqlStr){  
        	this.sqlStr = sqlStr;  
            getConnection();  
            createStatement();  
            try {  
                rs = stmt.executeQuery(sqlStr); 
               ResultSetMetaData rsmd = rs.getMetaData();
                int j = 0;
                j = rsmd.getColumnCount();
                while(rs.next()){  
             		 for(int i=0;i<j;i++){
             			 System.out.print(rs.getString(i+1));
             			 System.out.print("\t");
             			 }
             		 System.out.println();
              }
            } catch (SQLException e) {  
                e.printStackTrace();  
            }
			return rs;              
        }   
        
        public void jdbcUpdate(String sqlStr) {  
        	this.sqlStr = sqlStr;  
            getConnection();  
            createStatement();  
            try {
                int count = stmt.executeUpdate(sqlStr);
                System.out.println("表更新 " + count + " 条数据");
            } catch (SQLException e) {  
                System.out.println("更新数据失败");  
            }  
        }  
        
        public void jdbcInsert(String sqlStr) { 
        	this.sqlStr = sqlStr;  
            getConnection();  
            createStatement(); 
            try {
                int count = stmt.executeUpdate(sqlStr); 
                System.out.println("向表插入 " + count + " 条数据"); 
            } catch (SQLException e) {  
                System.out.println("插入数据失败" + e.getMessage());  
            }  
        }  
        
        public void jdbcDelete(String sqlStr) {
        	this.sqlStr = sqlStr;  
            getConnection();  
            createStatement();
        	try { 
        		int count = stmt.executeUpdate(sqlStr);
        		System.out.println("向表删除 " + count + " 条数据");     
            } catch (SQLException e) {  
                System.out.println("删除数据失败");  
            }                
        }  
        
        public void jdbcClose(){  
            try {  
                rs.close();  
                stmt.close();  
                conn.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }
        
        public Connection getConnection() {   
            try {  
            	   // 通过构造方法加载数据库驱动     
                Class.forName("com.mysql.jdbc.Driver"); 
                // 创建数据库连接     
                conn = DriverManager.getConnection(url, user, password);	
            } catch (Exception e) {  
                System.out.println("数据库连接失败" + e.getMessage());  
            }  
            return conn;  
        }        
} 
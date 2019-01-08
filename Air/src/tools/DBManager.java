package tools;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBManager
{
     private static String driver;
     private static String url;
     private static String user;
     private static String pass;
     private static Connection conn;
     private static Statement stat;
     private static PreparedStatement pstat;
     // 利用静态初始化块来初始化Connection、Statement对象
     static
     {
    	 InputStream in=DBManager.class.getClassLoader().getResourceAsStream("db.properties");
    	 Properties props = new Properties();
    	 try{
          /*String s = new File("mysql.ini").getAbsolutePath();
          System.out.println(s);*/
          props.load(in);
  driver = props.getProperty("driver");
  url = props.getProperty("url");
  user = props.getProperty("user");
  pass = props.getProperty("pass");
          // 加载数据库驱动
  Class.forName(driver);
  // 获取数据库连接
  conn = DriverManager.getConnection(url,user,pass);
  stat = conn.createStatement();
     }
     catch(IOException ioe)
     {
          System.out.println("读取配置文件失败...");
          ioe.printStackTrace();
     }
     catch(SQLException sqle)
     {
          System.out.println("数据库连接失败...");
          sqle.printStackTrace();
     }
     catch(Exception e)
     {
          e.printStackTrace();
     }
     }
     public void init()
     {
     
     }
     public static ResultSet select(String sql)
     {
     try
     {
          stat.executeQuery(sql);
          ResultSet rs = stat.getResultSet();
          return rs;
     } catch (SQLException e)
     {
          System.out.println("查询出错!");
          e.printStackTrace();
          return null;
     }
     }
     public static  boolean update(String sql)
     {
     try
     {
          if(stat.executeUpdate(sql) > 0)
          {
          return true;
          }
          return false;
     }
     catch (SQLException sqle)
     {
          sqle.printStackTrace();
          return false;
     }
     }
     public static boolean preSelect(String sql,Object... args)
     {
     try
     {
          int i = 1;
          pstat = conn.prepareStatement(sql);
          for (Object s : args)
          {
          pstat.setObject(i++, s);
          }
          ResultSet rs = pstat.executeQuery();
          if (rs.next())
          return true;
          return false;
     } catch (SQLException e)
     {
          e.printStackTrace();
          return false;
     }
     
     }
     public static void main(String[] args)
     {
//       DBManager dbm = null;
//	dbm.update("insert into user values('430524199705212930','sliver.two','123456','lin','男','18142611739','18142611739@189.cn','无','无')");
//         System.out.println( DBManager.preSelect("select * from user where u_name = ?",(Object[])new String[]{"sliver.two1"}));
//     
     }
}
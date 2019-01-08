package com.hbsi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.domain.Book;
import com.hbsi.utils.DataAccess;

public class BookDao {
	
	public Book find(String id) {
		Connection conn = null;
		PreparedStatement pt = null;//声明预处理对象
		ResultSet rs = null;//声明结果集对象
		Book b = new Book();//创建书籍对象
		try {
			conn = DataAccess.getConnection();//获得连接对象
			String sql = "select * from book where id=?";//SQL语句
			pt = conn.prepareStatement(sql);///获得预处理对象并赋值
			pt.setString(1, id);//设置第一个SQL占位符参数
			rs = pt.executeQuery();//执行查询
			if(rs.next()){//若找到用户
				b.setId(rs.getString("id"));//设置书籍编号
				b.setName(rs.getString("name"));//设置书籍姓名
				b.setAuthor(rs.getString("author"));//设置书籍作者
				b.setPrice(rs.getDouble("price"));//设置书籍价格
				b.setDescription(rs.getString("description"));//设置书籍主分类
				b.setCategory(rs.getString("category"));//设置书籍次分类
				b.setSales(rs.getInt("sales"));//设置书籍销量
				return b;	//返回书籍对象
			}
			return null;
		} catch (Exception e) {//捕获异常
			  e.printStackTrace();//处理异常
		  }finally{
		   try{
		    if(rs!=null){
		     rs.close();//关闭结果集对象
		    }
		    if(pt!=null){
		     pt.close();//关闭预处理对象
		    }
		    if(conn!=null){
		     conn.close();//关闭连接对象
		    }
		   }catch(Exception e2){
		    e2.printStackTrace();
		   }
		  }
		  return b;
	}
	public List<Book> getAllz2(String key) {//按关键字模糊匹配
		Connection conn = null;
		PreparedStatement pt = null;//声明预处理对象
		ResultSet rs = null;//声明结果集对象
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();
			String sql = "select * from book where author like ?";
			pt = conn.prepareStatement(sql);//获得预处理对象并赋值
			pt.setString(1, "%"+key+"%");//设置第一个SQL占位符参数
			rs = pt.executeQuery();		//执行查询
			while (rs.next()) {//迭代循坏
				Book b = new Book();//创建用户对象
				b.setId(rs.getString("id"));//设置书籍编号
				b.setName(rs.getString("name"));//设置书籍姓名
				b.setAuthor(rs.getString("author"));//设置书籍作者
				b.setPrice(rs.getDouble("price"));//设置书籍价格
				b.setDescription(rs.getString("description"));//设置书籍主分类
				b.setCategory(rs.getString("category"));//设置书籍次分类
				b.setSales(rs.getInt("sales"));//设置书籍销量
				list.add(b);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		  }finally{
		   try{
			   if(rs!=null){
				     rs.close();//关闭结果集对象
				    }
				    if(pt!=null){
				     pt.close();//关闭预处理对象
				    }
				    if(conn!=null){
				     conn.close();//关闭连接对象
				    }
		   }catch(Exception e2){
		    e2.printStackTrace();
		   }
		  }
		  System.out.println("listuser:"+list);
		  return list;
	}
	public List<Book> getAllz1(String key) {//按名字模糊匹配
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();
			String sql = "select * from book where name like ?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, "%"+key+"%");
			rs = pt.executeQuery();		
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));//设置书籍编号
				b.setName(rs.getString("name"));//设置书籍姓名
				b.setAuthor(rs.getString("author"));//设置书籍作者
				b.setPrice(rs.getDouble("price"));//设置书籍价格
				b.setDescription(rs.getString("description"));//设置书籍主分类
				b.setCategory(rs.getString("category"));//设置书籍次分类
				b.setSales(rs.getInt("sales"));//设置书籍销量
				list.add(b);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		  }finally{
		   try{
		    if(rs!=null){
		     rs.close();
		    }
		    if(pt!=null){
		     pt.close();
		    }
		    if(conn!=null){
		     conn.close();
		    }
		   }catch(Exception e2){
		    e2.printStackTrace();
		   }
		  }
		  System.out.println("listuser:"+list);
		  return list;
	}
	
	public List<Book> getAllc1() {//文学
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where category='文学'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}
	

	public List<Book> getAllc2() {//按价格从高到低排序
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where category='小说'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}
	public List<Book> getAlld4() {//按生活
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where description='生活'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}
	
	public List<Book> getAlld3() {//按教育
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where description='教育'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}

	public List<Book> getAlld2() {//按文学艺术
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where description='文学艺术'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	
	}

	public List<Book> getAlld1() {//按科学技术
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book where description='科学技术'";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}

	public List<Book> getAllp1() {//按价格从高到低排序
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book order by price asc";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
	}
	

		public List<Book> getAllp() {//价格从高到底
			Connection conn = null;
			Statement pt = null;
			ResultSet rs = null;
			List<Book> list = new ArrayList<Book>();
			try {
				conn = DataAccess.getConnection();			
				String sql = "select * from book order by price desc";
				pt = conn.createStatement();
				   rs=pt.executeQuery(sql);
				while (rs.next()) {
					Book b = new Book();
					b.setId(rs.getString("id"));
					b.setName(rs.getString("name"));
					b.setAuthor(rs.getString("author"));
					b.setPrice(rs.getDouble("price"));
					b.setDescription(rs.getString("description"));
					b.setCategory(rs.getString("category"));
					b.setSales(rs.getInt("sales"));
					list.add(b);
				}
				
			} catch (Exception e) {
					   e.printStackTrace();
					  }finally{
					   try{
					    if(rs!=null){
					     rs.close();
					    }
					    if(pt!=null){
					     pt.close();
					    }
					    if(conn!=null){
					     conn.close();
					    }
					   }catch(Exception e2){
					    e2.printStackTrace();
					   }
					  }
					  System.out.println("listuser:"+list);
					  return list;
					 }

	public List<Book> getAll() {
		Connection conn = null;
		Statement pt = null;
		ResultSet rs = null;
		List<Book> list = new ArrayList<Book>();
		try {
			conn = DataAccess.getConnection();			
			String sql = "select * from book";
			pt = conn.createStatement();
			   rs=pt.executeQuery(sql);
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				list.add(b);
			}
			
		} catch (Exception e) {
				   e.printStackTrace();
				  }finally{
				   try{
				    if(rs!=null){
				     rs.close();
				    }
				    if(pt!=null){
				     pt.close();
				    }
				    if(conn!=null){
				     conn.close();
				    }
				   }catch(Exception e2){
				    e2.printStackTrace();
				   }
				  }
				  System.out.println("listuser:"+list);
				  return list;
				 }
	}

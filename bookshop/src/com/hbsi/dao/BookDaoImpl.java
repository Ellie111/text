package com.hbsi.dao;
//封装书籍查找的函数
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hbsi.domain.Book;
import com.hbsi.utils.DBManager;

public class BookDaoImpl implements BookDao{

	@Override
	public Book find(String id) {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select * from book where id=?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, id);	
			rs = pt.executeQuery();
			//Book b = null;
			if(rs.next()){
				Book b = new Book();
				b.setId(rs.getString("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setDescription(rs.getString("description"));
				b.setCategory(rs.getString("category"));
				b.setSales(rs.getInt("sales"));
				return b;	
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	public List<Book> getAllz1(String key) {//按关键字模糊匹配
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select * from book where name like ?";
			pt = conn.prepareStatement(sql);
			pt.setString(1, "%"+key+"%");
			rs = pt.executeQuery();
			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	
	public List<Book> getAllc1() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='文学艺术'and category='文学'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	
	@Override
	public List<Book> getAllc2() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='文学艺术'and category='小说'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	public List<Book> getAlld4() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='教育'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();
			List<Book> list = new ArrayList<Book>();
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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	
	public List<Book> getAlld3() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='生活'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	@Override
	public List<Book> getAlld2() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='文学艺术'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	@Override
	public List<Book> getAlld1() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book where description='科学技术'";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}
	}
	
	@Override
	public List<Book> getAllp1() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book order by price asc";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}

	}
	
	@Override
	public List<Book> getAllp() {//按价格从高到低排序
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			String sql = "select id,name,author,price,description,category,sales from book order by price desc";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;

		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}

	}

	@Override
	public List<Book> getAll() {
		Connection conn = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			
			String sql = "select id,name,author,price,description,category,sales from book";
			pt = conn.prepareStatement(sql);
			rs = pt.executeQuery();

			List<Book> list = new ArrayList<Book>();

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
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			DBManager.closeDB(conn, pt, rs);
		}

	}

}

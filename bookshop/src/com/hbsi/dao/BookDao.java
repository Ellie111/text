package com.hbsi.dao;

import java.util.List;

import com.hbsi.domain.Book;

public interface BookDao {
	//获取所有的书
		public List<Book> getAll();
		
		//根据id获取书
		public Book find(String id);
		//根据price获取书
		public List<Book> getAllp();//价格从高到低
		public List<Book> getAllp1();//价格从低到高
		
		//根据主分类获取书
		public List<Book> getAlld1();//科学技术
		public List<Book> getAlld2();//文学艺术
		public List<Book> getAlld3();//生活
		public List<Book> getAlld4();//教育
		
		//根据次分类获取书
		public List<Book> getAllc1();//文学
		public List<Book> getAllc2();//小说
		
		//根据关键字获取书
		public List<Book> getAllz1(String key);//文学


}

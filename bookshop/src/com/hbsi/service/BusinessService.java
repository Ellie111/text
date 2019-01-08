package com.hbsi.service;
//调用函数进行相对应的操作。
import java.util.List;

import com.hbsi.domain.Book;
import com.hbsi.domain.Cart;

public interface BusinessService {
	public List<Book> getAllBook();

	public Book findBook(String id);	//获取指定id的书

	public void deleteCartItem(String sid, Cart cart);//删除购物项
	
	public void clearCart(Cart cart);//清空购物车

	public void changeQuantity(String sid, String quantity, Cart cart);
		//改变数量

	public List<Book> getAllBookp();//价格从高到低
	public List<Book> getAllBookp1();//价格从高到低
	
	public List<Book> getAllBookd1();//科学技术
	public List<Book> getAllBookd2();//文学艺术
	public List<Book> getAllBookd3();//生活
	public List<Book> getAllBookd4();//教育
	
	public List<Book> getAllBookc1();//科学技术
	public List<Book> getAllBookc2();//科学技术
	
	public List<Book> getAllBookz1(String key);//关键字

	
}

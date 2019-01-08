package com.hbsi.dao;

import java.util.List;

import com.hbsi.domain.Book;
import com.hbsi.domain.Cart;
import com.hbsi.domain.CartItem;

public class BusinessDAO {
	BookDao dao=new BookDao();
	public List<Book> getAllBook() {
		return dao.getAll();
	}
	public List<Book> getAllBookp(){
		return dao.getAllp();
	}
	
	public List<Book> getAllBookp1(){
		return dao.getAllp1();
	}
	
	
	public List<Book> getAllBookd1(){
		return dao.getAlld1();
	}
	
	public List<Book> getAllBookd2(){
		return dao.getAlld2();
	}
	public List<Book> getAllBookd3(){
		return dao.getAlld3();
	}
	public List<Book> getAllBookd4(){
		return dao.getAlld4();
	}
	
	public List<Book> getAllBookc1(){
		return dao.getAllc1();
	}
	public List<Book> getAllBookc2(){
		return dao.getAllc2();
	}
		
	public void deleteCartItem(String sid, Cart cart) {	
		cart.getMap().remove(sid);
	}


	public Book findBook(String id) {
		
		return dao.find(id);
	}

	public List<Book> getAllBookz1(String key){
		return dao.getAllz1(key);
	}
	
	public List<Book> getAllBookz2(String key){
		return dao.getAllz2(key);
	}

	public void clearCart(Cart cart) {
		cart.getMap().clear();
		
	}

	public void changeQuantity(String sid, String quantity, Cart cart) {
		CartItem item=cart.getMap().get(sid);
		item.setQuantity(Integer.parseInt(quantity));
		
	}
	
}

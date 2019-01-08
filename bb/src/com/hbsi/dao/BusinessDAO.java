package com.hbsi.dao;

import java.util.List;
import java.util.Map;

import com.hbsi.domain.Book;
import com.hbsi.domain.Cart;
import com.hbsi.domain.CartItem;

public class BusinessDAO {
	BookDao dao=new BookDao();
	private Map<String, CartItem> map;//创建map对象
	
	public void deleteCartItem(String sid, Cart cart) {	
		map=cart.getMap();//得到map
		map.remove(sid);//删除map中的sid的书籍collection接口里面的方法
	}
	
	public Book findBook(String id) {//利用id查找到书籍
		return dao.find(id);
	}
	
	public void clearCart(Cart cart) {//找到购物车，调用
		map=cart.getMap();//取数据
		map.clear(); //删除map，删除该集合中所有元素
		
	}

	public void changeQuantity(String sid, String quantity, Cart cart) {
		map=cart.getMap();//得到map
		CartItem item=map.get(sid);//获取到购物项
		item.setQuantity(Integer.parseInt(quantity));//强制类型转换数量，然后获取
		
	}
	
}

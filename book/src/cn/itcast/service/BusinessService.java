package cn.itcast.service;

import java.util.Map;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;

//业务类，统一对web层提供所有服务
public class BusinessService {

 private BookDao dao = new BookDao();

 public Map<String, Book> getAllBook() {
     return dao.getAll();
 }

 public Book findBook(String id) {
     return dao.find(id);
 }

 // 删除购物车中购物项
 public void deleteCartItem(String id, Cart cart) {
     cart.getMap().remove(id);
 }

 // 清空购物车
 public void clearCart(Cart cart) {
     cart.getMap().clear();
 }

 // 改变购物车某购物项的数量
 public void changeItemQuantity(String id, String quantity, Cart cart) {
     CartItem item = cart.getMap().get(id);
     item.setQuantity(Integer.parseInt(quantity));
 }

}

package com.hbsi.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	private Map<String,CartItem> map=new LinkedHashMap<String,CartItem>();
	//多个购物项组成的购物车数据在hashmap中,HashMap<key,value> 数据集合。可以根据key值找到对应的value对象。
//key为商品id
//value为记录此商品信息及购买数量的CartItem对象。

	private double price;//所有购物项的价格总计
	
	public void add(Book book){
		CartItem item=map.get(book.getId());//get取数据
		//购物车中的一项通过map传来的数据id来获得书籍信息
		if(item!=null){//如果购物车中有这一项
			item.setQuantity(item.getQuantity()+1);//把这一项的数量加一
		}else{//如果购物车中没有这一项
			item=new CartItem();//创建一个新的购物项
			item.setBook(book);//把这本书信息加入到这一项中
			item.setQuantity(1);//自默认为数量为1
			//把新的购物项添加到map集合中
			map.put(book.getId(),item);//put存数据
		}
	}
	public Map<String, CartItem> getMap() {
		return map;//get取
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	public double getPrice() {//获得新的价格总计
		double totalprice=0;
		for(Map.Entry<String, CartItem> me:map.entrySet()){//进行map的遍历
			//这里的me是一个TextArea，map是一个HashMap。
//		    这种遍历Map的方法可以让我们在从Map中取得关键字之后，我们不用每次重复返回到Map中取得相对的值。
//		    如下面是以前的写法：每次都要再从map中读出me所对应的值。
			CartItem item=me.getValue();//获得它的value
			totalprice+=item.getPrice();//相加得到总计
		}
		this.price=totalprice;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}

package test;

import discount.DiscountStyleOne;
import discount.DiscountStyleThree;
import discount.DiscountStyleTwo;
import discount.OrderBook;
import guke.BookShop;
import guke.customer1;
import guke.customer2;

public class Client {
	public static void main (String arg[]){
		BookShop starBookShop = BookShop.getBookShop();
		new customer1(starBookShop, "语文书");		
		starBookShop.getNewName("小红");
		starBookShop.notifyCustomer();	
		OrderBook book = new OrderBook();
		System.out.println("今日促销一律8折优惠");	
		book.setM(8);
		book.setStyle(new DiscountStyleThree());//打八折
		book.setPrice(100) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+book.getMoney(book.getPrice(),book.getM())+"，原价100");
		System.out.println("=================================");
		
		new customer2(starBookShop, "数学书");		
		starBookShop.getNewName("小明");
		starBookShop.notifyCustomer();	
		OrderBook book1 = new OrderBook();
		System.out.println("今日不打折");	
		book1.setM(0);
		book1.setStyle(new DiscountStyleOne());//不打折
		book1.setPrice(80) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+book1.getMoney(book1.getPrice(),book1.getM())+"，原价80");
		System.out.println("=================================");
		
		new customer1(starBookShop, "英语书");		
		starBookShop.getNewName("小黑");
		starBookShop.notifyCustomer();	
		OrderBook book2 = new OrderBook();
		System.out.println("今日促销满200减40");	
		book2.setM(40);
		book2.setStyle(new DiscountStyleTwo());//打八折
		book2.setPrice(200) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+book2.getMoney(book2.getPrice(),book2.getM())+"，原价200");
		System.out.println("=================================");
		
	}
}
package net.xsl.ordercake.test;
import net.xsl.ordercake.discount.DiscountStyleOne;
import net.xsl.ordercake.discount.DiscountStyleThree;
import net.xsl.ordercake.discount.DiscountStyleTwo;
import net.xsl.ordercake.discount.OrderCake;
import net.xsl.ordercake.order.CakeShop;
import net.xsl.ordercake.order.EastVilla;
import net.xsl.ordercake.order.WestVilla;

public class Client {
	public static void main (String arg[]){
		CakeShop starCakeShop = CakeShop.getCakeShop();
		new WestVilla(starCakeShop, "草莓水果");		
		starCakeShop.getNewName("小红");
		starCakeShop.notifyCustomer();	
		OrderCake cake = new OrderCake();
		System.out.println("今日促销一律8折优惠");	
		cake.setM(8);
		cake.setStyle(new DiscountStyleThree());//打八折
		cake.setPrice(80) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+cake.getMoney(cake.getPrice(),cake.getM())+"，原价80");
		System.out.println("=================================");
		
		new EastVilla(starCakeShop, "甜奶");
		starCakeShop.getNewName("小明");
		starCakeShop.notifyCustomer();	
		OrderCake cake1 = new OrderCake();
		System.out.println("今日不打折");	
		cake1.setStyle(new DiscountStyleOne());//不打折
		cake1.setPrice(100) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+cake.getMoney(cake1.getPrice(),cake.getM())+"，原价100");
		System.out.println("=================================");
		
		new WestVilla(starCakeShop, "黑巧克力");		
		starCakeShop.getNewName("小黑");
		starCakeShop.notifyCustomer();	
		OrderCake cake2 = new OrderCake();
		System.out.println("今日促销满200减40");	
		cake2.setM(40);
		cake2.setStyle(new DiscountStyleTwo());//打八折
		cake2.setPrice(200) ;
		System.out.println("本次订购成功完成，需要支付的金额为"+cake.getMoney(cake2.getPrice(),cake.getM())+"，原价200");
		System.out.println("=================================");
	}
}
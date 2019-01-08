package guke;

import jdbc.JDBCFacade;

public class customer1 implements Customer{
	Shop shop;
	private String book;
	
	public customer1(Shop shop,String book){
		this.shop = shop;
		this.book = book;
		shop.addCustomer(this);
	}
	
	public void orderBook(String name){		
		System.out.println(name+"订了本"+book);
		JDBCFacade dbFacade=new JDBCFacade(); 
		String sqlStr = "select * from orderbook"; 
		String sqlStr1 = "insert into orderbook(book, name)"+ " VALUES ('"+book+"','"+name+"')"; 
		dbFacade.jdbcInsert(sqlStr1);
		System.out.println("查询插入之后新的数据库");
        dbFacade.jdbcSelect(sqlStr);
		if(book.equals("语文书") ){
			System.out.println("生产了一本语文书");
		}
		else if(book.equals("数学书")){
			System.out.println("生产了一本数学书");
		}
		else if(book.equals("英语书")){
			System.out.println("生产了一本英语书");
		}
	}


}       
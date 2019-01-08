package guke;

import java.util.ArrayList;

public class BookShop implements Shop{	
	String name;
	boolean changed;
	ArrayList<Customer>personList;
		private int i = 0;
	private static BookShop uniqueBookShop;

		private BookShop() {
			uniqueBookShop = this;
			personList = new ArrayList<Customer>();
			name = "";
			changed = false;
		}
		
		public static synchronized BookShop getBookShop(){
			if(uniqueBookShop == null){
				uniqueBookShop = new BookShop();
			}		
			return uniqueBookShop;	
		}		

		public void addCustomer(Customer o) {
			if(!(personList.contains(o)))
				personList.add(o);
		}
		
		public void deleteCustomer(Customer o) {
			if((personList.contains(o)))
				personList.remove(o);
		}
		
		public void notifyCustomer() {		
			if(changed){			
				try{
					Customer customer = personList.get(i);
					customer.orderBook(name);			
					i++;
					changed = false;
				}
				catch(Exception e){
					System.out.println("没有新的订购信息");
				}
			}		
		}
		
		public void getNewName(String str){
			if(str.equals(name))
				changed = false;
			else{
				name = str;
				changed = true;
			}
		}
	}
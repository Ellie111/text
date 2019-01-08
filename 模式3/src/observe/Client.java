package observe;

public class Client {
	 public static void main(String[] args) {  
         
	        Account account = new Account("fly", 5.0);  
	        account.deposit(100);  
	        account.withdraw(200);  
	        account.deposit(1000);  
	        account.withdraw(2000);  
	        account.withdraw(100);  
	    }  
}
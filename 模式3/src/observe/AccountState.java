package observe;

public abstract class AccountState {

	  protected Account account;  
	    protected double balance;  
	      
	    public abstract void deposit(double amount);  
	    public abstract void withdraw(double amount);  
	    public abstract void stateCheck();  
	}  
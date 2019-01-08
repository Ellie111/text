package observe;

public class GreenState extends AccountState{  
  
    public GreenState(AccountState state) {  
        // TODO Auto-generated constructor stub  
        this.balance =state.balance;  
        this.account = state.account;  
    }  
      
    public GreenState(double balance,Account account) {  
        // TODO Auto-generated constructor stub  
        this.balance = balance;  
        this.account = account;  
    }  
      
    @Override  
    public void deposit(double amount) {  
        // TODO Auto-generated method stub  
        this.balance += amount;  
        stateCheck();  
    }  
  
    @Override  
    public void withdraw(double amount) {  
        // TODO Auto-generated method stub  
        this.balance -= amount;  
        stateCheck();  
    }  
  
    @Override  
    public void stateCheck() {  
        // TODO Auto-generated method stub  
        if(balance>=-1000&&balance<0){  
            account.setState(new YellowState(this));  
        }else if(balance<-1000){  
            account.setState(new RedState(this));  
        }  
    }  
  
}  
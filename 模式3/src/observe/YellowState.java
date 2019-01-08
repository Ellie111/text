package observe;

public class YellowState  extends AccountState{  
  
    public YellowState(AccountState state) {  
        // TODO Auto-generated constructor stub  
        this.balance = state.balance;  
        this.account = state.account;  
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
        if(balance>=0){  
            account.setState(new GreenState(this));  
        }else if(balance<-1000){  
            account.setState(new RedState(this));  
        }  
    }  
  
}  
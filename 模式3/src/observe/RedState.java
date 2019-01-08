package observe;

public class RedState extends AccountState{  
  
    public RedState(AccountState state) {  
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
        System.out.println("账户被冻结，取款失败");  
    }  
  
    @Override  
    public void stateCheck() {  
        // TODO Auto-generated method stub  
        if(balance>=0){  
            account.setState(new GreenState(this));  
        }else if(balance>=-1000){  
            account.setState(new YellowState(this));  
        }  
    }  
  
}  
package zhizelian;

public class Java extends Search{ 
    public void handleRequest(SearchKey key) { 
        String key1 = "java"; 
        if((key.getKey()).contains(key1)) 
            System.out.println("查询Java"); 
        else 
            if(this.successor != null) this.successor.handleRequest(key); 
    } 
}
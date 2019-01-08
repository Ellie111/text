package zhizelian;

public class UML extends Search{ 
	    public void handleRequest(SearchKey key) { 
	        String key1 = "UML"; 
	        if((key.getKey()).contains(key1))  {
	         System.out.println("您搜索的内容在Java中不存在");
	            System.out.println("查询UML");  
	        }
	        else  
	          if(this.successor != null) 
	              this.successor.handleRequest(key); 
	    } 
	} 
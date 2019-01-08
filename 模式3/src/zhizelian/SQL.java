package zhizelian;

public class SQL extends Search{ 
    public void handleRequest(SearchKey key) { 
        String key1 = "SQL"; 
        if((key.getKey()).contains(key1)) { 
         System.out.println("您搜索的内容在Java，UML不存在");
            System.out.println("查询SQL");  
        }
        else  
         System.out.println("您搜索的内容不存在"); 
    } 
} 
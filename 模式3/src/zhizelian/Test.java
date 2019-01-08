package zhizelian;

public class Test {
	 public static void main(String[] args) { 
         Search objJava,objSQL,objUML; 
         objJava = new Java();  
         objSQL = new SQL();  
         objUML = new UML(); 
        objJava.setSuccessor(objUML);  //设置下一级,这是体现职责链的代码
        objUML.setSuccessor(objSQL);  
        System.out.println("输入java");
        SearchKey key1 = new SearchKey("java");  
        objJava.handleRequest(key1);   
        System.out.println("输入UMLS");
        SearchKey key2 = new SearchKey("UMLS");  
        objJava.handleRequest(key2);   
        System.out.println("输入SQL");
        SearchKey key3 = new SearchKey("SQL");  
        objJava.handleRequest(key3); 
        System.out.println("输入C++");
        SearchKey key4 = new SearchKey("C++");  
        objJava.handleRequest(key4);  
     } 
 }
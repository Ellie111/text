package 工厂;

public class Client {
	public static void main(String[] args) {  
        try {  
            Log log;  
            //LogFactory factory1;  
            LogFactory factory2;  
            //factory1 = new DatabaseLogFactory();  
            factory2 = new FileLogFactory();  
            //factory = (LogFactory)XMLUtil.getBean();  
            log = factory2.createLog();  
            log.writeLog();  
        } catch(Exception e) {  
            System.out.println(e.getMessage());  
        }  
    }  
}  

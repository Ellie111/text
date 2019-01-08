package diedaiqi;

public class Client {
	public static void main(String[] args) {  
        
        String[] pNames = {"ThinkPad电脑","Tissot手表","iPhone手机","LV手提包"};  
        AbstractIterator iterator;  
        AbstractProductList list;  
        list = new ProductList(pNames);  
        iterator = list.getIterator();  
        while (!iterator.isLast()) {  
            System.out.println(iterator.getNextItem());  
            iterator.next();  
        }  
        System.out.println("----------------------------------------------------");  
        while (!iterator.isFirst()) {  
            System.out.println(iterator.getPreviousItem());  
            iterator.previous();  
        }  
    }  
}  
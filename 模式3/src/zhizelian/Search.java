package zhizelian;

public abstract class Search {
	protected Search successor;  
    public void setSuccessor(Search successor) {  
        this.successor = successor;  
    }  
    public abstract void handleRequest(SearchKey key);  
}  

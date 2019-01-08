package diedaiqi;

public interface AbstractIterator {
	public void next();  
    public boolean isLast();  
    public void previous();  
    public boolean isFirst();  
    public String getNextItem();  
    public String getPreviousItem();  
}  
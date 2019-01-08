package diedaiqi;

abstract class AbstractProductList {  
    
    private String[] productsName;  
      
    public AbstractProductList(String[] productsName) {  
        // TODO Auto-generated constructor stub  
        this.productsName = productsName;  
    }  
      
    public String[] getProductsName(){  
        return this.productsName;  
    }  
      
    public abstract AbstractIterator getIterator();  
}  
class ProductList extends AbstractProductList{  
  
    public ProductList(String[] productsName) {  
        // TODO Auto-generated constructor stub  
        super(productsName);  
    }  
  
    @Override  
    public AbstractIterator getIterator() {  
        // TODO Auto-generated method stub  
        return new MyIterator(this);  
    }  
}  
package stock;

public class ConcreteInvestor implements Investor{

	private String name;
	
	public ConcreteInvestor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	@Override
	public void response(Stock stock) {
		// TODO Auto-generated method stub
		System.out.print("提示股民："+name);
		System.out.print("----------股票："+stock.getStockName());
		System.out.print("价格波动幅度超过5%--------------");
		System.out.println("新价格是："+stock.getPrice()+"。");
	}

}
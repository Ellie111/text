package stock;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	private List<Investor> investors;
	private String stockName;
	private double price;
	
	public Stock(String stockName,double price) {
		// TODO Auto-generated constructor stub
		this.stockName = stockName;
		this.price = price;
		investors = new ArrayList<Investor>();
	}
	
	public void attach(Investor investor){
		investors.add(investor);
	}
	
	public void detach(Investor investor){
		investors.remove(investor);
	}

	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		double range = Math.abs(price - this.price)/this.price;
		this.price = price;
		if(range>=0.05){
			this.notifyInvestor();
		}
	}
	
	public void notifyInvestor(){
		for(Object obj:investors){
			((Investor)obj).response(this);
		}
	}
}
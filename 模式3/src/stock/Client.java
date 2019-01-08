package stock;

public class Client {
public static void main(String[] args) {
		Investor investor1,investor2;
		investor1 =new ConcreteInvestor("xyc");
		investor2 =new ConcreteInvestor("kk");
		
		Stock geli = new Stock("格力", 20.00);
		geli.attach(investor1);
		geli.setPrice(25.00);
		Stock haier = new Stock("海尔", 30.00);
		haier.attach(investor2);
		haier.setPrice(31.00);
	}
}
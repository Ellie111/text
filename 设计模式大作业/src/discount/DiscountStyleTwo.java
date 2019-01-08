package discount;

public class DiscountStyleTwo implements DiscountStyle{
public double disCount(double price,double m) {//减去m的价格
	price = price - m;
	return price;
}
}

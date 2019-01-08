package com.ascent.util;

import com.ascent.bean.Product;

public class CartItem {
	 
	private Product product;
	private int quantity;
	
	public CartItem(Product product){
		quantity=1;
		this.product=product;
	}

	public double getCartItemPrice(){
		return product.getPrice1()*quantity;
	}
	public void incre(){
		quantity++;
	} 
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}

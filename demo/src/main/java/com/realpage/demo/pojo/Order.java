package com.realpage.demo.pojo;

import java.io.Serializable;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String product;
	private Double total;
	
	
	public Order(int id, String product, Double total) {
		super();
		this.id = id;
		this.product = product;
		this.total = total;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	
}

package com.realpage.demo.pojo;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String joined;
	private String name;
	private String city;
	private Double orderTotal;
	private List<Order> orders;
		
	public Customer(int id, String joined, String name, String city, Double orderTotal, List<Order> orders) {
		super();
		this.id = id;
		this.joined = joined;
		this.name = name;
		this.city = city;
		this.orderTotal = orderTotal;
		this.orders = orders;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJoined() {
		return joined;
	}
	public void setJoined(String joined) {
		this.joined = joined;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
	
}

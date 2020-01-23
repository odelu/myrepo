package com.realpage.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.realpage.demo.pojo.Customer;
import com.realpage.demo.pojo.Order;

@Service
public class CustomerService {
	
	private List<Customer> customersList;
	
	public CustomerService() {
		customersList = new ArrayList<Customer>();
		Order order1 = new Order(1, "shoes", 9.9664);
		Order order2 = new Order(2, "Computers", 10.924);
		Order order3 = new Order(3, "Clothes", 2.5964);
		Order order4 = new Order(4, "Books", 10.3964);
		Order order5 = new Order(5, "Phones", 125.564);
		Order order6 = new Order(6, "Bags", 5.994);
		
		List<Order> orderList1 = new ArrayList<Order>();
		orderList1.add(order1);
		
		List<Order> orderList2 = new ArrayList<Order>();
		orderList2.add(order2);
		orderList2.add(order5);
		
		List<Order> orderList3 = new ArrayList<Order>();
		orderList3.add(order3);
		orderList3.add(order2);
		orderList3.add(order1);
		
		List<Order> orderList4 = new ArrayList<Order>();
		orderList4.add(order4);
		
		List<Order> orderList5 = new ArrayList<Order>();
		orderList5.add(order5);
		orderList5.add(order6);
		
		customersList.add(new Customer(1, "2001-12-02", "Odelu", "Karimnagar", 9.9875, orderList1));
		customersList.add(new Customer(2, "2002-10-02", "Devender", "Nalgonda", 10.9875, orderList2));
		customersList.add(new Customer(3, "2003-02-02", "Naseer", "Hyderabad", 125.9875, orderList3));
		customersList.add(new Customer(4, "2004-05-02", "Satish", "Hyderabad", 19.9875, orderList4));
		customersList.add(new Customer(5, "2005-09-02", "Suresh", "Warangal", 12.9875, orderList5));
	}

	public List<Customer> getCustomers(){		
		
		return customersList;
	}

}

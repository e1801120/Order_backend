package com.example.demo.orderdemo.service;

import java.util.List;

import com.example.demo.orderdemo.model.Order;


public interface IOrderService {
	List<Order> findAll();
	
	Order findById(Long orderId);
	Order addOrder(Order userOrder);
	Order editOrder(Order userOrder);
	
	void removeOrder(Long orderId);

}

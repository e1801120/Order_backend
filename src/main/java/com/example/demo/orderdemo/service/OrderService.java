package com.example.demo.orderdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.orderdemo.model.Order;
import com.example.demo.orderdemo.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<Order> findAll(){
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId)
				.orElse(null);
	}

	@Override
	public Order addOrder(Order userOrder) {
		// TODO Auto-generated method stub
		return orderRepository.saveAndFlush(userOrder);
	}

	@Override
	public Order editOrder(Order userOrder) {
		// TODO Auto-generated method stub
		return orderRepository.saveAndFlush(userOrder);
	}

	@Override
	public void removeOrder(Long orderId) {
		orderRepository.deleteById(orderId);
		
	}
}

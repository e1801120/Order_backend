package com.example.demo.orderdemo.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.orderdemo.model.Order;
import com.example.demo.orderdemo.model.OrderDTO;
import com.example.demo.orderdemo.service.IOrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {
	
	@Autowired
	private IOrderService ordersService;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

  
  @GetMapping(produces=MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<?> getOrders() {
	  List<Order> orders = ordersService.findAll();
	  return new ResponseEntity<>(OrderDTO.toDTO(orders), HttpStatus.OK);
  }
  
  @GetMapping(value = "{orderId}", produces=MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<?> getOrderById(@PathVariable Long orderId, Authentication authentication) {
	  Order order = ordersService.findById(orderId);
	  if(order == null) {
		  return new ResponseEntity<>("Order could not be found", HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<>(OrderDTO.toDTO(order), HttpStatus.OK);
  }
  

  @PostMapping(produces=MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<?> addOrder(@RequestBody OrderDTO order, Authentication authentication) {
	  Order userOrder = new Order();
	  userOrder.setDescription(order.description);
	  userOrder.setRowNumber(order.rowNumber);
	  
	  ordersService.addOrder(userOrder);
	  return new ResponseEntity<>(OrderDTO.toDTO(userOrder), HttpStatus.CREATED);
  }
  
  @PutMapping(value = "{orderId}", produces=MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<?> editOrder(@PathVariable Long orderId, @RequestBody OrderDTO order, Authentication authentication) {
	  Order foundOrder = ordersService.findById(orderId);
	  
	  if(foundOrder == null) {
		  return new ResponseEntity<>("Order was not found", HttpStatus.NOT_FOUND);
	  }else {
		  foundOrder.setDocumentDateTime(Timestamp.from(Instant.now()));
	  }
	  
	  foundOrder.setDescription(order.description);
	  foundOrder.setRowNumber(order.rowNumber);
	  foundOrder.setDocumentDateTime(Timestamp.from(Instant.now()));
	  
	  ordersService.editOrder(foundOrder);
	  return new ResponseEntity<>(OrderDTO.toDTO(foundOrder), HttpStatus.OK);
  }
  
  

  @DeleteMapping(value = "{orderId}", produces=MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
	  Order foundOrder = ordersService.findById(orderId);
	  
	  if(foundOrder == null) {
		  return new ResponseEntity<>("Order was not found", HttpStatus.NOT_FOUND);
	  }
	  
	  ordersService.removeOrder(orderId);
	  return new ResponseEntity<>("Order was deleted", HttpStatus.OK);
  }
}
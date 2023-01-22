package com.example.demo.orderdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.orderdemo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
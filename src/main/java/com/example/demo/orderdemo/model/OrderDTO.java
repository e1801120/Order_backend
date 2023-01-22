package com.example.demo.orderdemo.model;

import java.util.List;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class OrderDTO {

	public Long OrderId;
	public String description;
	public String rowNumber;
	public Timestamp documentDateTime = Timestamp.from(Instant.now());
	
	public static OrderDTO toDTO(Order entity) {
		OrderDTO dto = new OrderDTO();
		dto.OrderId = entity.getOrderId();
		dto.description = entity.getDescription();
		dto.rowNumber = entity.getRowNumber();
		dto.documentDateTime = entity.getDocumentDateTime();
		
		return dto;
	}
	
	public static List<OrderDTO> toDTO(List<Order> entities) {
		List<OrderDTO> dtos = new ArrayList<>();
		entities.forEach(orderEntity -> {
			OrderDTO dto = toDTO(orderEntity);
			if(dto != null) {
				dtos.add(dto);
			}
		});
		
		return dtos;
	}
		
}

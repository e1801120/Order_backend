package com.example.demo.orderdemo.model;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Orders")

@XmlRootElement(name = "Orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long orderId;
	protected String description;
	protected String rowNumber;
	
	@Column(insertable = true, updatable = false)
	protected Timestamp documentDateTime = Timestamp.from(Instant.now());

  public Order() {}

  public Order(String description, String rowNumber, Timestamp documentDateTime ) {

    this.description = description;
    this.rowNumber = rowNumber;
    this.documentDateTime = documentDateTime = Timestamp.from(Instant.now());
    
  }

public Long getOrderId() {
	return orderId;
}

public void setOrderId(Long orderId) {
	this.orderId = orderId;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Timestamp getDocumentDateTime() {
	return documentDateTime;
}

public void setDocumentDateTime(Timestamp documentDateTime) {
	this.documentDateTime = documentDateTime;
}

public String getRowNumber() {
	return rowNumber;
}

public void setRowNumber(String rowNumber) {
	this.rowNumber = rowNumber;
}

  
}
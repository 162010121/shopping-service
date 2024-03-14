package com.shoppingservice.user.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long customerId;

	private String customerName;

	private String email;

	private long mobileNumber;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	private ProductDetails productDetails;
//	
	
	private long productId;

	private String productName;

	private String productCompany;
	
	private long quntity;


	private long paymentId;

	private double amount;

	private String paymentType;

	private String paymentStatus;

	
	private LocalDate paymentDate;

	private String flatNumber;

	private String area;

	private String city;

	private long pincode;

	private String state;
}

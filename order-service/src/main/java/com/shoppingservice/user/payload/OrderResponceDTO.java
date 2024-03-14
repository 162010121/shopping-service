package com.shoppingservice.user.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class OrderResponceDTO {

	private long customerId;

	private String customerName;

	private String email;

	private long mobileNumber;
	
	private long quntity;

	private Product productDetails;
	
	private Payment paymentDetails;
	
	private AddressDetails customerAddressDetails;
	 
	
	 

//	private long productId;
//
//	private String productName;
//
//	private String productCompany;
//
//	private long paymentId;
//
//	private double amount;
//
//	private String paymentType;
//
//	private String paymentStatus;
//
//	private Date PayrmentDate;
//
//	private String flatNumber;
//
//	private String area;
//
//	private String city;
//
//	private long pincode;
//
//	private String state;

}

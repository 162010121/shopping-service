package com.shoppingservice.user.payload;

import java.util.Date;

import lombok.Data;

@Data

public class Payment {

	
	private long paymentId;

	private double amount;

	private String paymentType;

	private String paymentStatus;

	private Date PayrmentDate;
	
	
	//private AddressDetails customerAddressDetails;

}

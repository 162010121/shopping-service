package com.shoppingservice.user.payload;

import lombok.Data;

@Data
public class AddressDetails {

	private String flatNumber;

	private String area;

	private String city;

	private long pincode;

	private String state;
	
	
}

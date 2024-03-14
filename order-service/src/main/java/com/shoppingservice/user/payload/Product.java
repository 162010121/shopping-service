package com.shoppingservice.user.payload;

import lombok.Data;

@Data

public class Product {

	private long productId;
	
	private String productName;

	private String productCompany;
	
	//private long remaingQuntity;
	
//	public Product(ProductDetails  details)
//	{
//		this.setProductId(details.getProductId());
//		this.setProductCompany(details.getProductCompany());
//		this.setProductName(details.getProductName());
//		
//	}

	//private Payment paymentDetails;

}

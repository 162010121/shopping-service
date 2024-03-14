package com.shoppingservice.user.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RemainingQuntityDTO {
	
	private long remainingQuntity;
	
	private String productName;
	
	private String status;

}

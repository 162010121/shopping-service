package com.shoppingservice.user.payload;

import java.util.List;

import com.shoppingservice.user.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderListDTO {
	
	
	private int count;
	
	private List<Order>  customerOrderDetails;
	
	private String customerName;

}

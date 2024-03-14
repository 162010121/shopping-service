package com.shoppingservice.user.service;

import java.util.List;

import com.shoppingservice.user.entity.Order;
import com.shoppingservice.user.payload.OrderListDTO;
import com.shoppingservice.user.payload.OrderResponceDTO;
import com.shoppingservice.user.payload.Responce;

public interface UserService {
	
	
	public OrderResponceDTO  saveCustomer(Order   order);
	
	public List<Order> getAllProduct();
	
	public Order getById(long Id);
	
	public OrderListDTO getAllCustomerOrders();
	
	//public OrderResponceDTO getByCustomerId(long customerId);
	
	public Responce getAllOrders();
	

	
	
	
	

}

package com.shoppingservice.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.exception.UserNotFound;
import com.shoppingservice.user.entity.Order;
import com.shoppingservice.user.payload.OrderListDTO;
import com.shoppingservice.user.payload.OrderResponceDTO;
import com.shoppingservice.user.payload.RemainingQuntityDTO;
import com.shoppingservice.user.payload.Responce;
import com.shoppingservice.user.repository.UserRepository;
import com.shoppingservice.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class OrderController {

	@Autowired
	private UserService service;
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/save")
	public OrderResponceDTO saveCustomer(@RequestBody Order order) {
		
		OrderResponceDTO responceDTO = service.saveCustomer(order);
		
		
		return responceDTO;

	}
	
	@PostMapping("/orderItem")
	public RemainingQuntityDTO saveQuntityDetails(@RequestBody Order order)
	{
		RemainingQuntityDTO quntity=new RemainingQuntityDTO();
		
		try {
			
			List<Order> items= userRepository.findByProductName(order.getProductName());
			
			boolean exist= items.iterator().hasNext();
			if (!exist) {
				System.out.println("Stock not exist so reverting the order");
				throw new Exception("Stock not available");
			}
			
			items.forEach(stock -> {
				stock.setQuntity(stock.getQuntity()- order.getQuntity());
				userRepository.save(stock);
				
				quntity.setProductName(stock.getProductName());
				quntity.setRemainingQuntity(stock.getQuntity());
				quntity.setStatus("Completed");
				
				
			});
			
		} catch (Exception e) {
		}
		
		return quntity;
	}

	@GetMapping("/getAllNames")
	public List<Order> getAllPro() {
		log.info("");
		List<Order> fromDb = service.getAllProduct();
		return fromDb;
     }

	@GetMapping("/getAllCustomers")
	public Responce getAll() {
		Responce fromDb = service.getAllOrders();
		return fromDb;
	}

	@GetMapping("/getById/{Id}")
	public Order getById(@PathVariable("Id") long Id) {
		try {
			Order order = service.getById(Id);

			return order;
		} catch (Exception e) {

			throw new UserNotFound("User Not Found");
		}
	}

	@GetMapping("/getAllOrders")
	public OrderListDTO getAllOrders() {
		return service.getAllCustomerOrders();
	}

//	@GetMapping("/getById/{customerId}")
//	public OrderResponceDTO getById(@PathVariable("customerId") long customerId) {
//		try {
//
//			OrderResponceDTO orderResponceDTO = service.getByCustomerId(customerId);
//
//			return orderResponceDTO;
//		} catch (Exception e) {
//
//			throw new UserNotFound("User Not Found");
//		}
//	}
//	

}

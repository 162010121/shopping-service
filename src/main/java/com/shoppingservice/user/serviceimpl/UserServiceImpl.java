package com.shoppingservice.user.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingservice.user.entity.Quntity;
import com.shoppingservice.user.entity.Order;
import com.shoppingservice.user.payload.AddressDetails;
import com.shoppingservice.user.payload.OrderListDTO;
import com.shoppingservice.user.payload.OrderResponceDTO;
import com.shoppingservice.user.payload.Payment;
import com.shoppingservice.user.payload.Product;
import com.shoppingservice.user.payload.Responce;
import com.shoppingservice.user.repository.UserRepository;
import com.shoppingservice.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	

	public static final String customer = "customer";

	public static final String porduct = "porduct";

//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private UserRepository userRepository;

	@Override
	public OrderResponceDTO saveCustomer(Order entity) {

		OrderResponceDTO responceDTO = new OrderResponceDTO();
		Product product = new Product();
		Payment payment = new Payment();
		AddressDetails address = new AddressDetails();
		


		responceDTO.setCustomerId(entity.getCustomerId());
		responceDTO.setCustomerName(entity.getCustomerName());
		responceDTO.setEmail(entity.getEmail());
		responceDTO.setMobileNumber(entity.getMobileNumber());
		responceDTO.setQuntity(entity.getQuntity());
		

		// For Product
		product.setProductId(entity.getProductId());
		product.setProductName(entity.getProductName());
		product.setProductCompany(entity.getProductCompany());
		//product.setRemaingQuntity(entity.getQuntity());

		payment.setPaymentId(entity.getPaymentId());
		payment.setAmount(entity.getAmount());
		payment.setPaymentStatus(entity.getPaymentStatus());
		payment.setPaymentType(entity.getPaymentType());
		payment.setPayrmentDate(new Date());

		address.setFlatNumber(entity.getFlatNumber());
		address.setArea(entity.getArea());
		address.setCity(entity.getCity());
		address.setPincode(entity.getPincode());
		address.setState(entity.getState());
		
		repository.save(entity);

		responceDTO.setProductDetails(product);
		responceDTO.setPaymentDetails(payment);
		responceDTO.setCustomerAddressDetails(address);

		return responceDTO;
	}

	@Override
	public List<Order> getAllProduct() {
		return repository.findAll().stream().filter(s -> s.getCustomerName().startsWith("P")).toList();
	}

	@Override
	public Order getById(long Id) {

		Order order = repository.findById(Id).get();

		return order;
	}

	// To get the list of details counting
	public OrderListDTO getAllCustomerOrders() {
		OrderListDTO orderDTO = new OrderListDTO();

		String serch = "Praveen Pustera";

//		List<OrderResponceDTO> list=repository.getAllOrders();
//		List<OrderResponceDTO> orderList=list.stream()
//				.filter(s -> s.getUserName().equalsIgnoreCase(serch))
//				.collect(Collectors.toList());
//		
//		orderDTO.setCount(orderList.size());
//		orderDTO.setCustomerName(serch);
//		orderDTO.setCustomerOrderDetails(orderList);

		List<Order> list = repository.findAll();
		List<Order> ordersList = list.stream().filter(s -> s.getCustomerName().equalsIgnoreCase(serch))
				.collect(Collectors.toList());

		orderDTO.setCount(ordersList.size());
		orderDTO.setCustomerName(serch);
		orderDTO.setCustomerOrderDetails(ordersList);

		return orderDTO;

	}

	@Override
	public Responce getAllOrders() {

		Responce responce = new Responce();

		Product product = new Product();
		Payment payment = new Payment();
		AddressDetails address = new AddressDetails();
		OrderResponceDTO responceDTO = new OrderResponceDTO();

		List<Order> userResponce = repository.findAll().stream().filter(user -> user.getAmount() < 50000.00 * 1.10)
				.collect(Collectors.toList());
		for (Order entity : userResponce) {

			// For Customer
			responceDTO.setCustomerId(entity.getCustomerId());
			responceDTO.setCustomerName(entity.getCustomerName());
			responceDTO.setEmail(entity.getEmail());
			responceDTO.setMobileNumber(entity.getMobileNumber());

			// For Product
			product.setProductId(entity.getProductId());
			product.setProductName(entity.getProductName());
			product.setProductCompany(entity.getProductCompany());
			// product.setRemaingQuntity(entity.getQuntity());

			// For Payment
			payment.setPaymentId(entity.getPaymentId());
			payment.setAmount(entity.getAmount());
			payment.setPaymentStatus(entity.getPaymentStatus());
			payment.setPaymentType(entity.getPaymentType());
			// payment.setPayrmentDate(new LocalDate(0));

			// For Address
			address.setFlatNumber(entity.getFlatNumber());
			address.setArea(entity.getArea());
			address.setCity(entity.getCity());
			address.setPincode(entity.getPincode());
			address.setState(entity.getState());

		}

		responce.setOrderDetails(responceDTO);
		responceDTO.setProductDetails(product);
		responceDTO.setPaymentDetails(payment);
		responceDTO.setCustomerAddressDetails(address);
		return responce;

	}

}

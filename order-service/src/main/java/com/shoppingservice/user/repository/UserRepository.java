package com.shoppingservice.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingservice.user.entity.Order;

@Repository
public interface UserRepository extends JpaRepository<Order, Long> {
	

	
//	static final String QUERY_TO_GET_CUSTOMERDETAILSBYID = 
//			"select * from customer where customerId =: customerId";
//
////	@Query(value = QUERY_TO_GET_ALLCUSTOMERS, nativeQuery = true)
////	List<OrderResponceDTO> getAllOrders();
//	
//	@Query(value = QUERY_TO_GET_CUSTOMERDETAILSBYID, nativeQuery = true)
//	public OrderResponceDTO findByCustomerId(@Param("customerId")    long customerId);

	
	List<Order> findByProductName(String productName);

}

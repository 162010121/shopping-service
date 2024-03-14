package com.shoppingservice.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingservice.user.entity.Quntity;

public interface QuntityRespo extends JpaRepository<Quntity, Long>{
	
	List<Quntity> findByProductName(String item);


}

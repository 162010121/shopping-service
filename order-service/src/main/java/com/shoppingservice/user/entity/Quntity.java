package com.shoppingservice.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="quntity")
public class Quntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long quntity;
	
	private String productName;
}

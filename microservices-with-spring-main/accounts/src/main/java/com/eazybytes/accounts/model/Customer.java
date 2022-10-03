package com.eazybytes.accounts.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.ToString;

@Entity
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;
	
	private String name;
	
	private String email;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "create_dt")
	private LocalDate createDt;
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public void setCreateDt(LocalDate createDt) {
		this.createDt = createDt;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	public LocalDate getCreateDt() {
		return createDt;
	}
}

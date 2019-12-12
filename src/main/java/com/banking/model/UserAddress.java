package com.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserAddress {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="house_number")
	private Integer houseNumber;
	
	@Column(name="street")
	private String street;
	
	@Column(name="street_number")
	private String streetNumber;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postal_Code")
	private Integer postalCode;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;


	public UserAddress(Integer userAddressId) {
		// TODO Auto-generated constructor stub
	}

	

	public UserAddress() {
		super();
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Integer getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
		
	
	
	
}

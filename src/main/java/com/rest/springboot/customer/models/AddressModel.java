package com.rest.springboot.customer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_address")
@Component
public class AddressModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "ADDRESS_TYPE_ID")
	private Integer addressTypeId;
	
	@Column(name = "STREET")
	private String street;
	
	@Column(name = "ZIPCODE")
	private  String zipCode;
	
	@Column(name = "CITY")
	private String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
	        name = "CATEGORY_ARTICLE",
	        joinColumns = @JoinColumn(name = "ADDRESS_id"),
	        inverseJoinColumns = @JoinColumn(name = "CUSTOMER_ID")
	)
	private CustomerModel customerModel;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID", nullable = false)
	private AddressTypeModel addressTypeModel;
	
	public AddressModel()
	{
		
	}

	public AddressModel(Integer id, Integer addressTypeId, String street, String zipCode, String city,
			CustomerModel customerModel, AddressTypeModel addressTypeModel) {
		super();
		this.id = id;
		this.addressTypeId = addressTypeId;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.customerModel = customerModel;
		this.addressTypeModel = addressTypeModel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAddressTypeId() {
		return addressTypeId;
	}

	public void setAddressTypeId(Integer addressTypeId) {
		this.addressTypeId = addressTypeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}



	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@JsonIgnore
	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}
	
	public AddressTypeModel getAddressTypeModel() {
		return addressTypeModel;
	}

	public void setAddressTypeModel(AddressTypeModel addressTypeModel) {
		this.addressTypeModel = addressTypeModel;
	}
	

	@Override
	public String toString() {
		return "AddressModel [id=" + id + ", addressTypeId=" + addressTypeId + ", street=" + street + ", zipCode="
				+ zipCode + ", city=" + city + ", customerModel=" + customerModel + ", addressTypeModel="
				+ addressTypeModel + "]";
	}
	
	
}

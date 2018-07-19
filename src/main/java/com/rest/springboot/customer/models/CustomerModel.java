package com.rest.springboot.customer.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;



@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_customer")
@Component
public class CustomerModel implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NAME2")
	private String name2;
	
	@Column(name = "BGA")
	private Integer BGA;
	
	@Column(name = "SALESROLE")
	private String salesRole;
	
	@Column(name = "DELETED")
	private Integer deleted;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "CREATED_AT")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createdAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
	        name = "tbl_customer_address_map",
           joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
        inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
    private Set<AddressModel> addressModel = new HashSet<>();
	
	public CustomerModel()
	{

	}

	public CustomerModel(Integer id, String name, String name2, Integer bGA, String salesRole, Integer deleted, String createdBy,
			Date createdAt, Set<AddressModel> addressModel) {
		super();
		this.id = id;
		this.name = name;
		this.name2 = name2;
		BGA = bGA;
		this.salesRole = salesRole;
		this.deleted = deleted;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.addressModel = addressModel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public Integer getBGA() {
		return BGA;
	}

	public void setBGA(Integer bGA) {
		BGA = bGA;
	}

	public String getSalesRole() {
		return salesRole;
	}

	public void setSalesRole(String salesRole) {
		this.salesRole = salesRole;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Set<AddressModel> getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(Set<AddressModel> addressModel) {
		this.addressModel = addressModel;
	}

	@Override
	public String toString() {
		return "CustomerModel [id=" + id + ", name=" + name + ", name2=" + name2 + ", BGA=" + BGA + ", salesRole="
				+ salesRole + ", deleted=" + deleted + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", addressModel=" + addressModel + "]";
	}
		


}

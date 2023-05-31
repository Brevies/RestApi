package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USERS")
public class UserEntity {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id") 
	private Integer id;
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="MOBILE")
	private String mobile;
	
	@Column(name="ADD_L1")
	private String addLine1;
	
	@Column(name="ADD_L2")
	private String addLine2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="CREATED_USER")
	private String createdUser;
	
	@Column(name="CREATED_DATE")
	private String createdDate;
	
	@Column(name="LAST_UPDATED_USER")
	private String lastUpdatedUser;
	
	@Column(name="LAST_UPDATED_DATE")
	private String lastUpdatedDate;

}

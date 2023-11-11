package com.jsp.studentspringe2.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "NameShouldNotBeNull")
	@NotBlank(message = "NameShouldNotBeBlank")
	private String name;
	@NotNull(message = "AddressShouldNotBeNull")
	@NotBlank(message = "AddressShouldNotBeBlank")
	private String address;
	
	@Min(6000000000l)
	@Max(9999999999l)
	private long phone;
		
}

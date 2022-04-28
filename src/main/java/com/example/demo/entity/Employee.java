package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="empid")	
	private Integer empId;
	
	@NotNull
	@NotBlank
	@Size(min =2, message ="Name Should have atleast 2 Characters ")
	@Column(name="name")
	private String Name;
	
	@Column(name="role")	
	private String role;
	
	@Column(name="country")	
	private String country;
	
	@Column(name="enabled")	
	private Boolean enabled;

}

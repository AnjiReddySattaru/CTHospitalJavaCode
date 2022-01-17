package com.ct.ghospital.patient.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="patient")
public class Patient {
	@Id 
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Check(constraints = "title in ('Mr.','Ms.','Mrs.','Dr.')")
	@NotBlank(message="Kindly select the title.")
	@Column(name="title", nullable = false, length = 4)
	private String title;
	
	@NotBlank(message="First name cannot be empty")
	@Size(min = 2,message="Please don’t use abbreviations")
	@Column(name="firstName", nullable = false, length = 30)
	private String firstName;
	
	@NotBlank(message="Last name cannot be empty")
	@Size(min = 2,message="Please don’t use abbreviations")
	@Column(name="lastName", nullable = false, length = 30)
	private String lastName;
	
	@Column(name="emailId", nullable = false, length = 40,unique=true)
	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@NotEmpty(message = "Email cannot be empty")
	private String emailId;
	
	@Column(name="dob" ,nullable = false)
	@PastOrPresent(message="Birthday cannot be future date")
	private LocalDate dob;
	
	@Column(name="contactNumber",nullable = false)
	private long contactNumber;
	
	@Column(name="password",nullable = false, length = 100)
	private String password;
	
	@Column(name="status",insertable = false, columnDefinition = "varchar(1) default 'U'")
	private char status;
	
	@Column(name = "firstLogin", nullable = false, columnDefinition = "INTEGER DEFAULT 50")
	//@ColumnDefault(value = "50")
	private int firstLogin ;
	
	
	@Transient
	private String confirmPassword;
	
	
	
	@Column(name="invalidLoginAttempt",insertable = false )
	@ColumnDefault(value = "0")
	private int invalidLoginAttempt;
	
	@Column(name="updatedById",insertable = false,columnDefinition = "INTEGER DEFAULT 0")
	private long updatedById;
	
	@Column(name="createddate",insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createddate;
	
	
	@Column(name="updateddate",insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updateddate;
	
	


}

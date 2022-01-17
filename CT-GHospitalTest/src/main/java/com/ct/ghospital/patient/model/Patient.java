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
	
	@Column(name="password",nullable = false, length = 50)
	private String password;
	
	@Column(name="status",insertable = false, columnDefinition = "varchar(1) default 'I'")
	private char status;
	
	@Column(name = "firstLogin", nullable = false, columnDefinition = "INTEGER DEFAULT 100")
	//@ColumnDefault(value = "50")
	private int firstLogin ;
	
	
	@Transient
	private String confirmPassword;
	
	
	
	@Column(name="invalidLoginAttempt",insertable = false)
	@ColumnDefault(value = "0")
	private int invalidLoginAttempt;
	
	@Column(name="updatedById",insertable = true)
	private long updatedById;
	
	@Column(name="createddate",insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createddate;
	
	
	@Column(name="updateddate",insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updateddate;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}


	public int getFirstLogin() {
		return firstLogin;
	}


	public void setFirstLogin(int firstLogin) {
		this.firstLogin = firstLogin;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public int getInvalidLoginAttempt() {
		return invalidLoginAttempt;
	}


	public void setInvalidLoginAttempt(int invalidLoginAttempt) {
		this.invalidLoginAttempt = invalidLoginAttempt;
	}


	public long getUpdatedById() {
		return updatedById;
	}


	public void setUpdatedById(long updatedById) {
		this.updatedById = updatedById;
	}


	public Date getCreateddate() {
		return createddate;
	}


	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}


	public Date getUpdateddate() {
		return updateddate;
	}


	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	


}

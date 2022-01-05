package com.ct.ghospital.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "emergencyContact")
public class EmergencyContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emergencyContactId")
    private Integer emergencyContactId;
    @Column(nullable = false, length = 30)
    @NotBlank(message = "First name cannot be empty")
    @Size(min = 2, message = "Please don’t use abbreviations")
    private String firstName;
    @Column(nullable = false, length = 30)
    @NotBlank(message = "Last name cannot be empty")
    @Size(min = 2, message = "Please don’t use abbreviations")
    private String lastName;
    @Column(nullable = false)
    @NotNull(message = "Please select Relationship")
    private String relationship;
    @Column(nullable = false, length = 40, unique = true)
    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @Column
    @NotEmpty(message = "Please provide the telephone number")
    @Min(value = 7, message = "Please validate the phone number. Telephone number has XX number of digits")
    @Max(value = 10, message = "Please validate the phone number. Telephone number has XX number of digits")
    private String phoneNumber;
    @Column(nullable = false)
    private Boolean accessToPortal;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;
	public Integer getEmergencyContactId() {
		return emergencyContactId;
	}
	public void setEmergencyContactId(Integer emergencyContactId) {
		this.emergencyContactId = emergencyContactId;
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
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Boolean getAccessToPortal() {
		return accessToPortal;
	}
	public void setAccessToPortal(Boolean accessToPortal) {
		this.accessToPortal = accessToPortal;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
    
    
}

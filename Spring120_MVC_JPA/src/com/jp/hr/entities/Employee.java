package com.jp.hr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name="empRec")
@Table(name="EMP_DETAILS")
public class Employee {
	
	private int empId;
	
	@NotNull
	@Size(min = 3, max = 20, message="First Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "First Name has invalid characters")
	private String firstName;
	
	@NotNull
	@Size(min = 3, max = 20, message="Last Name not meeting size constraints.")
	@Pattern(regexp = "[a-z-A-Z]*", message = "Last Name has invalid characters")
	private String lastName;
	
	public Employee(int empId, String firstName, String lastName) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee() {
		super();
	}

	@Id
	@Column(name="EMPLOYEE_ID")
	public int getEmpId() { // Property name: empId
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() { // Property name: firstName
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() { // Property name: lastName
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

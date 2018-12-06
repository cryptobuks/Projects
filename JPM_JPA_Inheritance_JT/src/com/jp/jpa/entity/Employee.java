package com.jp.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_JT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {

	private static final long serialVersionUID = -3830958221519052671L;

	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(generator = "emp_gen", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "emp_gen", sequenceName = "emp_seq", allocationSize = 1)
	private Long empId;

	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_SAL")
	private Double empSal;

	public Employee() {

	}

	public Employee(String empName, Double empSal) {
		super();
		this.empName = empName;
		this.empSal = empSal;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + getEmpSal() + "]";
	}

}

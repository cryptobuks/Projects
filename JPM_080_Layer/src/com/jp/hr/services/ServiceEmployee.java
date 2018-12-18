package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface ServiceEmployee {
	
	public ArrayList<Employee> getEmpList() throws HrException;

	public Employee getEmpDetails(int empId) throws HrException;

	public boolean addNewEmployee(Employee emp) throws HrException;

}

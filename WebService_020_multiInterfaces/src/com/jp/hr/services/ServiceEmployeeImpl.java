package com.jp.hr.services;

import java.util.List;

import com.jp.hr.daos.DaoEmployee;
import com.jp.hr.daos.DaoEmployeeImpl;
import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public class ServiceEmployeeImpl implements ServiceEmployee, Role1 {

	private DaoEmployee daoEmp;

	// Resolving Dependency.
	public ServiceEmployeeImpl() throws HrException {
		daoEmp = new DaoEmployeeImpl();
	}

	@Override
	public List<Employee> getEmpList() throws HrException {
		return daoEmp.getEmpList();
	}

	@Override
	public Employee getEmpDetails(int empId) throws HrException {
		return daoEmp.getEmpDetails(empId);
	}

	@Override
	public boolean addNewEmployee(Employee emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}

	@Override
	public int getTestInteger(int x) throws HrException {
		System.out.println("Value: " + x + " received.");
		return x;
	}

}

package com.jp.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.interfaces.DaoEmployee;

@Service("service")
public class ServiceEmployeeImpl implements ServiceEmployee {
	
	private DaoEmployee daoEmp;
	
	public ServiceEmployeeImpl() throws HrException {
		//daoEmp = new DaoEmployeeImpl();
	}

	@Autowired
	public ServiceEmployeeImpl(@Qualifier("daoDS") DaoEmployee daoEmp) throws HrException {
		this.daoEmp = daoEmp;
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
	@Transactional(rollbackFor=HrException.class)
	public boolean addNewEmployee(Employee emp) throws HrException {
		return daoEmp.insertNewRecord(emp);
	}

}

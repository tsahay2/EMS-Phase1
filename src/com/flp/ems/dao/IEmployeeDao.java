package com.flp.ems.dao;

import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {
	
	public void AddEmployee(Employee emp);

	public void RemoveEmployee(int emp_id);

	public void ModifyEmployee(int id,Employee emp);

	public Employee SearchEmployee(int id);
	
	public List<Employee> getAllEmployee();

}

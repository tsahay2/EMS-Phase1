package com.flp.ems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public boolean AddEmployee(Map<Integer, String> mapValues);

	public void RemoveEmployee(int emp_id);

	public void ModifyEmployee(int emp_id,Map<Integer,String> inputValues);

	public String SearchEmployee(int id);
	
	public List<String> getAllEmployee();


}

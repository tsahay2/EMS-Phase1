package com.flp.ems.service;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService, Cloneable {

	EmployeeDaoImplForList empDao = new EmployeeDaoImplForList();
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
	Date dateOfJoining = null;
	Date dateOfBirth = null;;

	@Override
	public void AddEmployee(Map<Integer, String> mapValues) {
		// TODO Auto-generated method stub

		DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
		Date dateOfJoining = null;
		Date dateOfBirth = null;
		
		try {
			dateOfJoining = (Date) dateFormat.parse(mapValues.get(4));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dateOfBirth = (Date) dateFormat.parse(mapValues.get(5));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Employee emp = new Employee(mapValues.get(1), Double.valueOf(mapValues.get(2)), mapValues.get(3), dateOfBirth,
				dateOfJoining, Integer.valueOf(mapValues.get(6)), Integer.valueOf(mapValues.get(7)),
				Integer.valueOf(mapValues.get(8)));
		// EmployeeDaoImplForList empDaoList = new EmployeeDaoImplForList();

		empDao.AddEmployee(emp);

	}

	@Override
	public void RemoveEmployee(int emp_id) {
		// TODO Auto-generated method stub
		EmployeeDaoImplForList empDao = new EmployeeDaoImplForList();
		empDao.RemoveEmployee(emp_id);

	}

	@Override
	public void ModifyEmployee(int emp_id, Map<Integer, String> newValues) {
		// TODO Auto-generated method stub
		EmployeeDaoImplForList empDao = new EmployeeDaoImplForList();
		Employee emp = empDao.SearchEmployee(emp_id);

		emp.setName(newValues.get(1));
		emp.setPhone_number(Double.parseDouble(newValues.get(2)));
		emp.setAddress(newValues.get(3));
		emp.setDate_of_birth(dateOfBirth);
		emp.setDate_of_joining(dateOfJoining);
		emp.setDept_id(Integer.parseInt(newValues.get(6)));
		emp.setProject_id(Integer.parseInt(newValues.get(7)));
		emp.setRole_id(Integer.parseInt(newValues.get(8)));

		empDao.ModifyEmployee(emp_id, emp);

	}

	@Override
	public String SearchEmployee(int id) {
		// TODO Auto-generated method stub
		String employee;
		EmployeeDaoImplForList empDao = new EmployeeDaoImplForList();
		Employee emp = empDao.SearchEmployee(id);
		employee = "Id :" + emp.getEmp_id() + " Name :" + emp.getName() + " Phone : " + emp.getPhone_number();
		return employee;

	}

	@Override
	public List<String> getAllEmployee() {
		// TODO Auto-generated method stub

		EmployeeDaoImplForList empDao = new EmployeeDaoImplForList();
		List<Employee> listOfEmployee;
		List<String> allEmployeeString = new ArrayList<>();
		listOfEmployee = empDao.getAllEmployee();
		String singleEmpString;
		for (Employee emp : listOfEmployee) {

			singleEmpString = "ID" + emp.getEmp_id() + " Name :" + emp.getName() + " Number " + emp.getPhone_number();
			allEmployeeString.add(singleEmpString);
		}

		return allEmployeeString;

	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

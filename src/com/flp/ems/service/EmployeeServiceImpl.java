package com.flp.ems.service;

import java.util.Date;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.EmployeeDaoImplForList1;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService, Cloneable {

	EmployeeDaoImplForList1 empDao = new EmployeeDaoImplForList1();
	DateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");
	Date dateOfJoining = null;
	Date dateOfBirth = null;;

	@Override
	public boolean AddEmployee(Map<Integer, String> mapValues) {
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

		boolean status = false;
		try {
			status = empDao.AddEmployee(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

	@Override
	public boolean RemoveEmployee(int emp_id) throws IOException, SQLException {
		// TODO Auto-generated method stub
		EmployeeDaoImplForList1 empDao = new EmployeeDaoImplForList1();
		boolean checkStatus = empDao.RemoveEmployee(emp_id);
		return checkStatus;

	}

	@Override
	public boolean ModifyEmployee(int emp_id, Map<Integer, String> newValues) throws IOException, SQLException {
		// TODO Auto-generated method stub
		EmployeeDaoImplForList1 empDao = new EmployeeDaoImplForList1();
		Employee emp = empDao.SearchEmployee(emp_id);
		if (emp != null) {
			emp.setEmp_id(emp_id);
			if (newValues.get(1).equals("")) {
				emp.setName(emp.getName());
			} else {
				emp.setName(newValues.get(1));
			}

			if (newValues.get(2).equals("")) {
				emp.setPhone_number(emp.getPhone_number());
			} else {
				emp.setPhone_number(Double.parseDouble(newValues.get(2)));
			}

			if (newValues.get(3).equals("")) {

			} else {
				emp.setAddress(newValues.get(3));
			}

			if (newValues.get(4).equals("")) {
			} else {
				emp.setDate_of_birth(dateOfBirth);
			}

			if (newValues.get(5).equals("")) {

			} else {
				emp.setDate_of_joining(dateOfJoining);
			}

			if (newValues.get(6).equals("")) {
			} else {

				emp.setDept_id(Integer.parseInt(newValues.get(6)));
			}

			if (newValues.get(7).equals("")) {
			} else {
				emp.setProject_id(Integer.parseInt(newValues.get(7)));
			}

			if (newValues.get(8).equals("")) {
			} else {

				emp.setRole_id(Integer.parseInt(newValues.get(8)));
			}
			boolean checkStatus = empDao.ModifyEmployee(emp);
			return checkStatus;
		} else {

			System.out.println("Sorry employee not found!");
			return false;
		}
	}

	@Override
	public String SearchEmployee(Map<Integer, String> searchParameters) throws IOException, SQLException {
		// TODO Auto-generated method stub
		String employee;
		EmployeeDaoImplForList1 empDao = new EmployeeDaoImplForList1();
		
		Employee emp = empDao.SearchEmployee(id);
		if (emp == null) {
			System.out.println("Sorry, no employee found!");
			return null;
		} else {
			employee = "Id :" + emp.getEmp_id() + " Name :" + emp.getName() + " Phone : " + emp.getPhone_number();
			return employee;
		}

	}

	@Override
	public List<String> getAllEmployee() throws SQLException, IOException {
		// TODO Auto-generated method stub

		EmployeeDaoImplForList1 empDao = new EmployeeDaoImplForList1();
		List<Employee> listOfEmployee;
		List<String> allEmployeeString = new ArrayList<>();
		listOfEmployee = empDao.getAllEmployee();

		if (listOfEmployee.size() == 0) {

		} else {
			String singleEmpString;
			for (Employee emp : listOfEmployee) {

				singleEmpString = "ID" + emp.getEmp_id() + " Name :" + emp.getName() + " Number "
						+ emp.getPhone_number();
				allEmployeeString.add(singleEmpString);
			}

		}

		return allEmployeeString;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}

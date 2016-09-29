package com.flp.ems.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {

	EmployeeServiceImpl empService = new EmployeeServiceImpl();;
	Scanner sc = new Scanner(System.in);
	String name, dateOfBirth, dateOfJoining;
	int dept_id, role_id, project_id;
	long phoneNumber;
	Map<Integer, String> inputValues = new HashMap<>();

	public void AddEmployee() {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		;

		System.out.println("Enter Name :");
		name = sc.next();
		inputValues.put(1, name);

		System.out.println("Enter Mobile Number :");
		phoneNumber = sc.nextLong();
		inputValues.put(2, String.valueOf(phoneNumber));

		System.out.println("Enter Address:");
		dateOfBirth = sc.next();
		inputValues.put(3, dateOfBirth);

		System.out.println("Enter Date of Birth:");
		dateOfBirth = sc.next();
		inputValues.put(4, dateOfBirth);

		System.out.println("Enter Date of Joining :");
		dateOfJoining = sc.next();
		inputValues.put(5, dateOfJoining);

		System.out.println("Enter the department id : ");
		dept_id = sc.nextInt();
		inputValues.put(6, String.valueOf(dept_id));

		System.out.println("Enter the role id :");
		role_id = sc.nextInt();
		inputValues.put(7, String.valueOf(role_id));

		System.out.println("Enter the Project id :");
		project_id = sc.nextInt();
		inputValues.put(8, String.valueOf(project_id));

		empService.AddEmployee(inputValues);

	}

	public void ModifyEmployee() {

		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		System.out.println("Enter Name :");
		name = sc.next();
		inputValues.put(1, name);

		System.out.println("Enter Mobile Number :");
		phoneNumber = sc.nextLong();
		inputValues.put(2, String.valueOf(phoneNumber));

		System.out.println("Enter Date of Birth:");
		dateOfBirth = sc.next();
		inputValues.put(3, dateOfBirth);

		System.out.println("Enter Date of Joining :");
		dateOfJoining = sc.next();
		inputValues.put(4, dateOfJoining);

		System.out.println("Enter the department id : ");
		dept_id = sc.nextInt();
		inputValues.put(5, String.valueOf(dept_id));

		System.out.println("Enter the role id :");
		role_id = sc.nextInt();
		inputValues.put(6, String.valueOf(role_id));

		System.out.println("Enter the Project id :");
		project_id = sc.nextInt();
		inputValues.put(7, String.valueOf(project_id));

		empService.ModifyEmployee(id, inputValues);

	}

	public void SearchEmployee() {

		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		String searchedEmployee = empService.SearchEmployee(id);
		System.out.println(searchedEmployee);

	}

	public void getAllEmployee() {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		;
		List<String> listOfEmployee = empService.getAllEmployee();

		for (String emp : listOfEmployee) {

			System.out.println(emp);

		}

	}

	public void RemoveEmployee() {

		System.out.println("Enter the Employee Id : ");
		int emp_id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		empService.RemoveEmployee(emp_id);

	}

}

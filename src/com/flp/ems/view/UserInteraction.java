package com.flp.ems.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class UserInteraction {

	EmployeeServiceImpl empService = new EmployeeServiceImpl();;
	Scanner sc = new Scanner(System.in);
	String name, dateOfBirth, dateOfJoining, address;
	int dept_id, role_id, project_id;
	long phoneNumber;
	boolean checked = true;
	Validate validate = new Validate();
	Map<Integer, String> inputValues = new HashMap<>();

	public void AddEmployee() {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		getName(inputValues);
		getPhoneNumber(inputValues);
		getAddress(inputValues);
		getDateOfBirth(inputValues);
		getDateOfJoining(inputValues);
		getDepartmentId(inputValues);
		getProjectId(inputValues);
		getRoleId(inputValues);
		boolean status = empService.AddEmployee(inputValues);
		if (status)
			System.out.println("Employee Added SuccessFully");
		else
			System.out.println("Error. Please try again!");

	}

	public void ModifyEmployee() throws IOException, SQLException {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();

		getName(inputValues);
		getPhoneNumber(inputValues);
		getAddress(inputValues);
		getDateOfBirth(inputValues);
		getDateOfJoining(inputValues);
		getDepartmentId(inputValues);
		getProjectId(inputValues);
		getRoleId(inputValues);
		empService.AddEmployee(inputValues);

		boolean status = empService.ModifyEmployee(id, inputValues);
		if (status)
			System.out.println("Employee Details Modified");
		else
			System.out.println("Sorry! Try again!");

	}

	public void SearchEmployee() throws IOException, SQLException {

		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		String searchedEmployee = empService.SearchEmployee(id);
		System.out.println(searchedEmployee);

	}

	public void getAllEmployee() throws SQLException, IOException {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		List<String> listOfEmployee = empService.getAllEmployee();

		for (String emp : listOfEmployee) {

			System.out.println(emp);

		}

		EmployeeDaoImplForList dao = new EmployeeDaoImplForList();
		dao.printTree();

	}

	public void RemoveEmployee() throws IOException, SQLException {

		System.out.println("Enter the Employee Id : ");
		int emp_id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		boolean status = empService.RemoveEmployee(emp_id);
		if (status)
			System.out.println("Employee deleted successfully!\n");
		else
			System.out.println("\n Sorry there was an error!");

	}

	public String getName(Map<Integer, String> inputValues) {
		while (checked) {
			System.out.println("Enter Name :");
			name = sc.next();

			if (validate.validateName(name)) {
				inputValues.put(1, name);
				checked = false;

			} else {
				System.out.println("Incorrect Name. Please Re-Enter");
			}

		}
		return name;
	}

	public long getPhoneNumber(Map<Integer, String> inputValues) {

		checked = true;
		while (checked) {

			System.out.println("Enter Mobile Number :");
			phoneNumber = sc.nextLong();
			System.out.println(String.valueOf(phoneNumber));
			if (validate.validatePhone(String.valueOf(phoneNumber))) {
				inputValues.put(2, String.valueOf(phoneNumber));
				checked = false;
			} else {

				System.out.println("Incorrect Phone Number");
			}

		}

		return phoneNumber;

	}

	public String getAddress(Map<Integer, String> inputValues) {

		System.out.println("Enter Address:");
		address = sc.next();
		inputValues.put(3, address);
		return address;

	}

	public String getDateOfBirth(Map<Integer, String> inputValues) {

		checked = true;
		while (checked) {
			System.out.println("Enter Date Of Birth(DD/MM/YYYY):");
			dateOfBirth = sc.next();

			if (validate.validateDate(dateOfBirth)) {
				inputValues.put(4, dateOfBirth);
				checked = false;
			}

			else {

				System.out.println("Incorrect. Please enter in DD/MM/YYYY Format");
			}
		}
		System.out.println(dateOfBirth);
		return dateOfBirth;

	}

	public String getDateOfJoining(Map<Integer, String> inputValues) {

		checked = true;
		while (checked) {
			System.out.println("Enter date of joining:");
			dateOfJoining = sc.next();

			if (validate.validateDate(dateOfJoining)) {
				inputValues.put(5, dateOfJoining);
				checked = false;
			}

			else {

				System.out.println("Incorrect. Please enter in DD/MM/YYYY Format");
			}
		}
		System.out.println(dateOfJoining);
		return dateOfJoining;

	}

	public int getDepartmentId(Map<Integer, String> inputValues) {

		System.out.println("Enter the department id : ");
		dept_id = sc.nextInt();
		inputValues.put(6, String.valueOf(dept_id));
		return dept_id;

	}

	public int getProjectId(Map<Integer, String> inputValues) {

		System.out.println("Enter the Project id : ");
		project_id = sc.nextInt();
		inputValues.put(7, String.valueOf(project_id));
		return project_id;

	}

	public int getRoleId(Map<Integer, String> inputValues) {

		System.out.println("Enter the Role id : ");
		role_id = sc.nextInt();
		inputValues.put(8, String.valueOf(role_id));
		return role_id;

	}

}

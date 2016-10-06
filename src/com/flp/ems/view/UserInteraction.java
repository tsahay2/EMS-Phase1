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

	
	
	
	/*----------------------ADD EMPLOYEE------------------------*/

	public void AddEmployee() {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		System.out.println("Enter Name :");
		name = sc.nextLine();

		getName(inputValues, name);

		System.out.println("Enter Mobile Number :");
		phoneNumber = sc.nextLong();
		sc.nextLine();

		getPhoneNumber(inputValues);

		System.out.println("Enter Address:");
		address = sc.nextLine();

		getAddress(inputValues);

		System.out.println("Enter Date Of Birth(DD/MM/YYYY):");
		dateOfBirth = sc.nextLine();

		getDateOfBirth(inputValues);

		System.out.println("Enter date of joining:");
		dateOfJoining = sc.nextLine();

		getDateOfJoining(inputValues);

		System.out.println("Enter the department id : ");
		dept_id = sc.nextInt();

		getDepartmentId(inputValues);

		System.out.println("Enter the Project id : ");
		project_id = sc.nextInt();

		getProjectId(inputValues);

		System.out.println("Enter the Role id : ");
		role_id = sc.nextInt();

		getRoleId(inputValues);

		boolean status = empService.AddEmployee(inputValues);
		if (status)
			System.out.println("Employee Added SuccessFully");
		else
			System.out.println("Error. Please try again!");

	}

	/*-------------------------MODIFY EMPLOYEES-------------------------*/

	public void ModifyEmployee() throws IOException, SQLException {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		Map<Integer, String> inputValues = new HashMap<>();
		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Name :");
		name = sc.nextLine();
		if (name.equals("")) {
			inputValues.put(1, "");
		} else {
			getName(inputValues, name);
		}

		System.out.println("Enter Mobile Number :");
		String phoneNumber1 = sc.nextLine();
		if (phoneNumber1.equals("")) {
			inputValues.put(2, "");
		} else {
			phoneNumber = Long.parseLong(phoneNumber1);
			getPhoneNumber(inputValues);
		}

		System.out.println("Enter Address:");
		address = sc.nextLine();
		if (address.equals("")) {
			inputValues.put(3, "");
		} else {
			getAddress(inputValues);
		}

		System.out.println("Enter Date Of Birth(DD/MM/YYYY):");
		dateOfBirth = sc.nextLine();
		if (dateOfBirth.equals("")) {
			inputValues.put(4, "");
		} else {
			getDateOfBirth(inputValues);
		}

		System.out.println("Enter date of joining:");
		dateOfJoining = sc.nextLine();
		if (dateOfJoining.equals("")) {
			inputValues.put(5, "");
		} else {
			getDateOfJoining(inputValues);
		}

		System.out.println("Enter the department id : ");
		String dept_id1 = sc.nextLine();

		if (dept_id1.equals("")) {
			inputValues.put(6, "");
		} else {
			dept_id = Integer.parseInt(dept_id1);
			getDepartmentId(inputValues);
		}

		System.out.println("Enter the Project id : ");
		String project_id1 = sc.nextLine();

		if (project_id1.equals("")) {
			inputValues.put(7, "");
		} else {
			project_id = sc.nextInt();
			getProjectId(inputValues);
		}

		System.out.println("Enter the Role id : ");
		String role_id1 = sc.nextLine();

		if (role_id1.equals("")) {
			inputValues.put(8, "");
		} else {
			role_id = Integer.parseInt(role_id1);
			getRoleId(inputValues);
		}

		boolean status = empService.ModifyEmployee(id, inputValues);
		if (status)
			System.out.println("Employee Details Modified");
		else
			System.out.println("Sorry! Try again!");

	}

	/*---------------------SEARCH EMPLOYEE-------------------------*/

	public void SearchEmployee() throws IOException, SQLException {

		
		Map<Integer,String> searchParameters = new HashMap<>();
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		searchParameters.put(1, name);
		System.out.println("Enter the Employee Id : ");
		int id = sc.nextInt();
		searchParameters.put(2, String.valueOf(id));
		sc.nextLine();
		System.out.println("Enter the kin_id : ");
		String kin_id = sc.nextLine();
		searchParameters.put(3, String.valueOf(kin_id));
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		String searchedEmployee = empService.SearchEmployee(searchParameters);
		System.out.println(searchedEmployee);

	}

	/* --------------------- GET ALL EMPLOYEES ----------------------- */

	public void getAllEmployee() throws SQLException, IOException {

		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		List<String> listOfEmployee = empService.getAllEmployee();
		if (listOfEmployee.size() == 0) {

			System.out.println("There are no employees in the table!");
		} else {

			for (String emp : listOfEmployee) {

				System.out.println(emp);

			}
		}

	}

	/*---------------------  REMOVE AN EMPLOYEE ----------------------- */

	public void RemoveEmployee() throws IOException, SQLException {

		System.out.println("Enter the Employee Id : ");
		int emp_id = sc.nextInt();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		boolean status = empService.RemoveEmployee(emp_id);
		if (status)
			System.out.println("Employee deleted successfully!\n");
		else
			System.out.println("\nSorry there was an error!");

	}

	public String getName(Map<Integer, String> inputValues, String name) {

		checked = true;
		while (checked) {

			if (validate.validateName(name)) {
				inputValues.put(1, name);
				checked = false;

			} else {
				System.out.println("Incorrect Name. Please Re-Enter\n");
			}

		}
		return name;

	}

	public long getPhoneNumber(Map<Integer, String> inputValues) {

		checked = true;
		while (checked) {

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

		inputValues.put(3, address);
		return address;

	}

	public String getDateOfBirth(Map<Integer, String> inputValues) {

		checked = true;

		while (checked) {

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

		inputValues.put(6, String.valueOf(dept_id));
		return dept_id;

	}

	public int getProjectId(Map<Integer, String> inputValues) {

		inputValues.put(7, String.valueOf(project_id));
		return project_id;

	}

	public int getRoleId(Map<Integer, String> inputValues) {

		inputValues.put(8, String.valueOf(role_id));
		return role_id;

	}

}

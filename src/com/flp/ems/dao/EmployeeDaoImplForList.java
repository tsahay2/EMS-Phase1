package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao {

	static List<Employee> listOfEmployees = new ArrayList<Employee>();

	@Override
	public void AddEmployee(Employee emp) {
		// TODO Auto-generated method stub

		listOfEmployees.add(emp);
		System.out.println("Employee Added SuccessFully !");

	}

	@Override
	public void RemoveEmployee(int emp_id) {
		// TODO Auto-generated method stub
		Integer id2 = emp_id;
		for (Employee emp : listOfEmployees) {

			if (id2.equals(emp.getEmp_id())) {
				listOfEmployees.remove(--emp_id);
				System.out.println("Employee Successfully deleted!\n");
			}

		}

	}

	@Override
	public void ModifyEmployee(int id, Employee emp) {
		// TODO Auto-generated method stub
		// System.out.println(id);
		listOfEmployees.set(--id, emp);
		System.out.println("Modified successfully!");

	}

	@Override
	public Employee SearchEmployee(int id) {
		// TODO Auto-generated method stub

		Integer id1 = id;
		for (Employee emp : listOfEmployees) {

			if (id1.equals(emp.getEmp_id())) {

				try {
					return (Employee) emp.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return null;

	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub

		return listOfEmployees;

	}

}

package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.flp.ems.comparator.CompareById;
import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IEmployeeDao {

	static List<Employee> listOfEmployees = new ArrayList<Employee>();
	static Comparator comparator = new CompareById();
	static TreeSet tree = new TreeSet();

	@Override
	public boolean AddEmployee(Employee emp) {
		// TODO Auto-generated method stub

		if (listOfEmployees.add(emp))
		{	
			tree.add(emp.getEmp_id());
			return true;
		
		}
		

		return false;
	}

	@Override
	public boolean RemoveEmployee(int emp_id) {
		// TODO Auto-generated method stub
		Integer id2 = emp_id;
		for (Employee emp : listOfEmployees) {

			if (id2.equals(emp.getEmp_id())) {
				listOfEmployees.remove(--emp_id);
				System.out.println("Employee Successfully deleted!\n");
			}

		}
		return true;

	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
		// TODO Auto-generated method stub
		// System.out.println(id);
		int id = emp.getEmp_id();
		listOfEmployees.set(--id, emp);
		System.out.println("Modified successfully!");
return true;
	}

	@Override
	public Employee SearchEmployee(int id) {
		// TODO Auto-generated method stub

		Integer id1 = id;
		/*for (Employee emp : listOfEmployees) {

			if (id1.equals(emp.getEmp_id())) {

				try {
					return (Employee) emp.clone();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}*/
		
		if(tree.contains(id1)){
			Employee emp = listOfEmployees.get(--id1);
			return emp;
			
		}
		
		return null;

	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub

		return listOfEmployees;

	}
	
	public void printTree(){
		
		System.out.println(tree);
	}

}

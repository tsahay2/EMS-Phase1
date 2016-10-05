package com.flp.ems.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeDao {
	
	public boolean AddEmployee(Employee emp) throws FileNotFoundException, IOException, SQLException;

	public boolean RemoveEmployee(int emp_id) throws IOException, SQLException;

	public boolean ModifyEmployee(Employee emp) throws IOException, SQLException;

	public Employee SearchEmployee(int id) throws IOException, SQLException;
	
	public List<Employee> getAllEmployee() throws SQLException, IOException;

}

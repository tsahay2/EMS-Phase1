package com.flp.ems.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public boolean AddEmployee(Map<Integer, String> mapValues);

	public boolean RemoveEmployee(int emp_id) throws IOException, SQLException;

	public boolean ModifyEmployee(int emp_id,Map<Integer,String> inputValues) throws IOException, SQLException;

	public String SearchEmployee(int id) throws IOException, SQLException;
	
	public List<String> getAllEmployee() throws SQLException, IOException;


}

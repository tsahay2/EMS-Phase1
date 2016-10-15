package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList1 implements IEmployeeDao {

	static Properties props;
	static Connection dbConnection;

	@Override
	public boolean AddEmployee(Employee emp) throws IOException, SQLException {

		ConnectDatabase();
		String insertQuery = props.getProperty("jdbc.query.addEmployee");
		try (PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)) {

		
			insertStatement.setString(1, emp.getName());
			insertStatement.setDouble(2, emp.getPhone_number());
			insertStatement.setString(3, emp.getAddress());
			insertStatement.setString(4, emp.getKin_id());
			insertStatement.setDate(5, new java.sql.Date(emp.getDate_of_birth().getTime()));
			insertStatement.setDate(6, new java.sql.Date(emp.getDate_of_joining().getTime()));
			insertStatement.setInt(7, emp.getDept_id());
			insertStatement.setInt(8, emp.getProject_id());
			insertStatement.setInt(9, emp.getRole_id());
			int rowsAffected = insertStatement.executeUpdate();
			if (rowsAffected == 1)
				return true;
			else
				return false;

		}

	}

	@Override
	public boolean RemoveEmployee(int emp_id) throws IOException, SQLException {

		ConnectDatabase();
		String removeQuery = props.getProperty("jdbc.query.removeEmployee");
		try (PreparedStatement removeStatement = dbConnection.prepareStatement(removeQuery)) {

			removeStatement.setInt(1, emp_id);
			int rowsAffected = removeStatement.executeUpdate();
			if (rowsAffected == 1)
				return true;
			else
				return false;

		}

	}

	@Override
	public boolean ModifyEmployee(Employee emp) throws IOException, SQLException {

		ConnectDatabase();
		String modifyQuery = props.getProperty("jdbc.query.modifyEmployee");
		try (PreparedStatement modifyStatement = dbConnection.prepareStatement(modifyQuery)) {

			modifyStatement.setString(1, emp.getName());
			modifyStatement.setDouble(2, emp.getPhone_number());
			modifyStatement.setString(3, emp.getAddress());
			modifyStatement.setDate(4, new java.sql.Date(emp.getDate_of_birth().getTime()));
			modifyStatement.setDate(5, new java.sql.Date(emp.getDate_of_joining().getTime()));
			modifyStatement.setInt(6, emp.getDept_id());
			modifyStatement.setInt(7, emp.getProject_id());
			modifyStatement.setInt(8, emp.getRole_id());
			modifyStatement.setInt(9, emp.getEmp_id());
			int rowsUpdated = modifyStatement.executeUpdate();
			if (rowsUpdated == 1) {
				return true;
			} else
				return false;

		}

	}

	@Override
	public Employee SearchEmployee(int emp_id) throws IOException, SQLException {

		ConnectDatabase();

		String removeQuery = props.getProperty("jdbc.query.searchEmployee");
		try (PreparedStatement searchStatement = dbConnection.prepareStatement(removeQuery)) {

			searchStatement.setInt(1, emp_id);
			ResultSet resultSet = searchStatement.executeQuery();
			if (!resultSet.next())
				return null;
			else {

				return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6), resultSet.getDate(7),
						resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10));
			}
		}

	}

	@Override
	public List<Employee> getAllEmployee() throws SQLException, IOException {

		ConnectDatabase();
		List<Employee> empList = new ArrayList<>();
		String getAllEmployeesQuery = props.getProperty("jdbc.query.getAllEmployee");
		try (PreparedStatement getAllStatement = dbConnection.prepareStatement(getAllEmployeesQuery)) {
			ResultSet resultSet = getAllStatement.executeQuery();
			if (!resultSet.next()) {

			} else {

				resultSet.beforeFirst();
				while (resultSet.next()) {

					empList.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3),
							resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6), resultSet.getDate(7),
							resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10)));

				}

			}
			return empList;
		}

	}

	public static void ConnectDatabase() throws IOException, SQLException {

		props = new Properties();

		FileInputStream fIn = new FileInputStream("D:/dev/demo/demos/eclipse-workspace/EMS/dbDetails.properties");
		props.load(fIn);

		// TODO LOAD AND REGISTER JDBC DRIVER

		// String driver = props.getProperty("jdbc.driver");
		// Class.forName(driver);

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// TODO GET DATABASE CONENCTION USING JDBC URL

		String url = props.getProperty("jdbc.url");

		dbConnection = DriverManager.getConnection(url);
	}

}

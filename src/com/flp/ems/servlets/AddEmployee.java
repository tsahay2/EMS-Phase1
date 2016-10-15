package com.flp.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddEmployee() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Map<Integer, String> inputValues = new HashMap<>();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String dept_id = request.getParameter("dept_id");
		String project_id = request.getParameter("project_id");
		String role_id = request.getParameter("role_id");

		inputValues.put(1, name);
		inputValues.put(2, phone);
		inputValues.put(3, address);
		inputValues.put(4, dateOfBirth);
		inputValues.put(5, dateOfJoining);
		inputValues.put(6, dept_id);
		inputValues.put(7, project_id);
		inputValues.put(8, role_id);

		boolean status = empService.AddEmployee(inputValues);
		if (status) {
			System.out.println("Employee Added SuccessFully");
			out.println("Employee added successfully!");
		} else {
			out.print("Error while adding!");
			System.out.println("Error. Please try again!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

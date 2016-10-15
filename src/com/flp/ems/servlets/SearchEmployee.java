package com.flp.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<Integer, String> searchParameters = new HashMap<>();
		Map<Integer, String> searchresults = new HashMap<>();

		String id = request.getParameter("emp_id");
		String name = request.getParameter("name");
		String kin_id = request.getParameter("kin_id");
		System.out.println(id+" "+name+" "+kin_id );
		searchParameters.put(1, name);
		searchParameters.put(2, id);
		searchParameters.put(3, kin_id);
		EmployeeServiceImpl empService = new EmployeeServiceImpl();
		String searchedEmployee = null;
		try {
			searchresults = empService.SearchEmployee(searchParameters);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if (searchresults!=null) {
			out.println(searchresults.get(1)+" "+searchresults.get(2));

		} else {
			
			out.println("Sorry no employee found!");

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

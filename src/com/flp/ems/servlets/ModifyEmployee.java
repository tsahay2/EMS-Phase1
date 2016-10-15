package com.flp.ems.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;

@WebServlet("/ModifyEmployee")
public class ModifyEmployee extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Map<Integer, String> inputValues = new HashMap<>();
		Map<Integer, String> searchResults = new HashMap<>();
		EmployeeServiceImpl empService = new EmployeeServiceImpl();

		String emp_id = request.getParameter("emp_id");
		inputValues.put(2, emp_id);
		
		try {
			searchResults = empService.SearchEmployee(inputValues);
			if(searchResults != null){
				
				request.setAttribute("name", searchResults.get(2));
				request.setAttribute("phone", searchResults.get(3));
				RequestDispatcher dispatcher = request.getRequestDispatcher("modifyPage.jsp");
				dispatcher.forward(request, response);
			}
			else{
				
				out.println("Sorry no employee found!");
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

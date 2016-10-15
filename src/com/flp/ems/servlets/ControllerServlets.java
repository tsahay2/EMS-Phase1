package com.flp.ems.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlets
 */
@WebServlet("/ControllerServlets")
public class ControllerServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlets() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String choice = request.getParameter("choice");
		if (choice.equals("AddEmployee")) {

			response.sendRedirect("/AddEmployee");
		}

		else if (choice.equals("RemoveEmployee")) {

			response.sendRedirect("/RemoveEmployee");
		}

		else if (choice.equals("SearchEmployee")) {

			response.sendRedirect("/SearchEmployee");
		}

		else if (choice.equals("getAllEmployee")) {
			response.sendRedirect("/getAllEmployee");

		}

		else {

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

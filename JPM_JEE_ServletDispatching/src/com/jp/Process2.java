package com.jp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Process2
 */
@WebServlet("/process2")
public class Process2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		System.out.println("param1: " + param1);
		System.out.println("Servlet: Process2 before dispatch");
		PrintWriter out = response.getWriter();
		out.write("Process 2 before dispatch");
		RequestDispatcher dispatch = request.getRequestDispatcher("/jsps/Welcome.jsp");
		dispatch.forward(request, response);
		System.out.println("Servlet: Process2 afert dispatch");

	}

}

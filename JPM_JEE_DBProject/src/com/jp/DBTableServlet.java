package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.db.ConnectionUtil;

/**
 * Servlet implementation class DBTableServlet
 */
@WebServlet("/DBTableServlet")
public class DBTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tableName = request.getParameter("tableName");
		ArrayList<ArrayList<String>> tableData = new ArrayList<ArrayList<String>>();
		ConnectionUtil connUtil = new ConnectionUtil();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<h1>Table Data</h1>");
		out.write("<table border='1px'>");
		tableData = connUtil.getTableDetails(tableName);

		Iterator<ArrayList<String>> rowIt = tableData.iterator();
		while (rowIt.hasNext()) {
			out.write("<tr>");
			Iterator<String> colIt = rowIt.next().iterator();
			while (colIt.hasNext()) {
				String dataValue = colIt.next();
				out.write("<td>");
				if (dataValue != null) {
					out.write(dataValue);
				}
				out.write("</td>");
			}
			out.write("</tr>");
		}
		out.write("</table>");
		out.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

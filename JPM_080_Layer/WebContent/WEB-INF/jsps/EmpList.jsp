<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.jp.hr.entities.Employee, java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
<body>
	<jsp:include page="Head01.jsp"/> 
	<jsp:include page="Head02.jsp"/>
	<%-- ${ requestScope.empList } --%>
	<%-- Welcome Mr./Ms. ${ sessionScope.userFullName } --%> <!-- Commented this line since we added jsp:include statement above -->
	<!-- <a href="logout.do">Logout</a> -->
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>View Details</th>
		</tr>
		<c:forEach items="${ requestScope.empList }" var="emp">  <!-- this will bring details of the first emp -->
		<tr>
			<td>${ emp.empId }</td> <!-- getEmpId -->
			<td><a href="empDetails.do?id=${ emp.empId }">View</a></td>
		</tr>
		
		</c:forEach>
		
		<!-- we have commented the below block because we wanted to write same syntax above using JSTL and not in java -->
		
		<%-- <% for(Employee emp : (ArrayList<Employee>)request.getAttribute("empList")) {%>		
			<tr>
				<td><%= emp.getEmpId() %></td>
				<td><%= emp.getFirstName() %></td>
				<td><%= emp.getLastName() %></td>
			</tr>
			<% } %> --%>
	</table>
	<a href="mainMenu.do">Go back to Main Menu</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form id="loginfrm" name="loginfrm" method="POST"
		action="controllerServlet?action=authenticate">
		<div style="color:red">${errMsg}</div>
		User Name: <input type="text" name="username"> <br /> <br />
		Password: <input type="password" name="password"> <br /> <br />
		<input type="submit" name="submit" value="Ok"> <input
			type="reset" name="reset" value="Cancel">
	</form>
</body>
</html>
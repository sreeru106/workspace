<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Login Success!!!</h2>
	Now you can add Employeess...
	<form:form method="get" action="authUser/registration.html">
		<input type="submit" value="Employee Registarion" />

	</form:form>
</body>
</html>
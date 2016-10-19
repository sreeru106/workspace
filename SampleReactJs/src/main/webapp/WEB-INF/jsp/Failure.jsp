<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Login Failed!!!</h2>
	Login Again....
	<form:form method="get" action="Login.html">
		<input type="submit" id="submitForm" value="Login" />
	</form:form>
</body>
</html>
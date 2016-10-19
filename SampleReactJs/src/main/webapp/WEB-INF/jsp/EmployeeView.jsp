<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Employee Details</h2>
	<form:form method="post" action="delete.html" modelAttribute="empDet">
		<table>
			<tr>
				<th></th>
				<th></th>
				<th>Id.</th>
				<th>Name</th>
				<th>Department</th>
			</tr>
			<c:forEach items="${empDet.employees}" var="emp" varStatus="status">
				<tr>
					<td><form:checkbox
							path="employees[${status.index}].checkControl" /></td>
					<td><input name="pageItemList[${status.index}].id"
						value="${pageItem.id}" type="checkbox" class="case" /></td>


					<td align="center">${status.count}</td>
					<td><input name="emp[${status.index}].id" value="${emp.id}" /></td>
					<td><input name="emp[${status.index}].name"
						value="${emp.name}" /></td>
					<td><input name="emp[${status.index}].dept"
						value="${emp.dept}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<input type="submit" value="Delete" />

	</form:form>
</body>
</html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
<script src="https://unpkg.com/react@15.3.2/dist/react.min.js"></script>
<script src="https://unpkg.com/react-dom@15.3.2/dist/react-dom.min.js"></script>
<script src="https://unpkg.com/babel-core@5.8.38/browser.min.js"></script>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>

<body>
  <Script type="text/javascript">
		$(document).on(
				'click',
				'.loginForm',
				function(event) {
					//$("#employeeForm").submit(function(event) {
					event.preventDefault();
					var $form = $("#loginForm");

					$.ajax({
						type : $form.attr('method'),
						url : $form.attr('action'),
						data : $form.serialize(),
						success : function(jsonResponse) {
							var $table = $("<table border='2' class='table'>")
									.appendTo($("#result"));
						},
						error : function() {
							$('#result').html("Exception!!");
						}
					});
				});
	</Script>
	
<script type="text/babel">

var Login = React.createClass({
					render : function(){

return (
            <div>
              <table border="0">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="id" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /></td>
			</tr>
		</table>
            </div>
        );

}

});

ReactDOM.render(<Login/>,document.getElementById("container"));
</script>
<form:form method="post" action="authentication.html"
		modelAttribute="login">
<div id="container"></div>
</form:form>
		
</body>

</html>
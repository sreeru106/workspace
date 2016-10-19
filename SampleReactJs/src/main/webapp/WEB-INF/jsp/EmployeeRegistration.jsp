<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
    <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>
<body>

<h2>User Information</h2>
<Script type="text/javascript">
$(document).on('click', '.submitform', function(event){
 //$("#employeeForm").submit(function(event) {
      event.preventDefault();
      var $form = $( "#employeeForm" );
      
      $.ajax({
    	     type: $form.attr('method'),
    	     url: $form.attr('action'),
    	     data:$form.serialize(),
    	     success: function (jsonResponse) {var $table = $("<table border='2' class='table'>").appendTo($("#result")); 
			$("<tr>").appendTo($table)
			         .append($("<td>").text("ID"))
			         .append($("<td>").text("Name"))
					 .append($("<td>").text("Department"))
					 .append($("<td>").text("ACTIONS"));
			$("</tr>").appendTo($table);
			
			var employees = JSON.parse(jsonResponse); 

			$.each(employees, function(index, empDet) {   
	            $("<tr>").appendTo($table)
	            		.append($("<td>").text(empDet.id))
	                	.append($("<td>").text(empDet.name))
	            		.append($("<td>").text(empDet.dept))
	            		.append($("<td>").html('<button id="editemployee" name='+empDet.id+' class="action" >Edit</button>'));
	            $("</tr>").appendTo($table);
	        });
		},
		error: function(){
			$('#result').html("Exception!!");
		}
});
});
</Script>

<form:form method="POST" action="addUser" id="employeeForm">
   <table>
    <tr>
        <td><form:label path="name">Employee Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="id">Employee id</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td><form:label path="dept">Department</form:label></td>
        <td><form:input path="dept" /></td>
    <tr>
        <td colspan="2">
            <input type="button" value="Submit" class ="submitform"/>
        </td>
    </tr>
</table>  
</form:form>
<div id= "result"></div>
</body>
</html>
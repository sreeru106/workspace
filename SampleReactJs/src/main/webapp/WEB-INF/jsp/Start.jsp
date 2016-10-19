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
	
<script type="text/babel">
var StartPage = React.createClass({

 getInitialState: function() {
    return {data: [],editMode : true};
  },
addEmp:function(){
$.ajax({
      url: this.props.url,
      dataType: 'json',
      success: function(data) {
        this.setState({data: data,editMode : false});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
},
render : function(){

if (this.state.editMode){
return(
		<div>
			<table>
    			<tr>
        			<td>Employee Name</td>
        			<td><input type ="text" name="name" /></td>
    			</tr>
    			<tr>
       				 <td>Employee id</td>
       				 <td><input type ="text" name="id" /></td>
   				 </tr>
   				 <tr>
        				<td>Department</td>
        				<td><input type ="text" name="dept" /></td>
				</tr>
   				 <tr>
      					  <td colspan="2">
          				  <input type="button" value="Submit" id="save onClick={addEmp}" />
      					  </td>
   				 </tr>
			</table>  
		</div>
		
);
}else{
return(
		<div>
			<table>
    			<tr>
        			<td>Employee Name</td>
        			<td><input type ="text" name="name" /></td>
    			</tr>
    			<tr>
       				 <td>Employee id</td>
       				 <td><input type ="text" name="id" /></td>
   				 </tr>
   				 <tr>
        				<td>Department</td>
        				<td><input type ="text" name="dept" /></td>
				</tr>
   				 <tr>
      					  <td colspan="2">
          				  <input type="button" value="Submit" id="save onClick={addEmp}" />
      					  </td>
   				 </tr>
			</table>  
<table>
<tr>
<td>ID</td>
</tr>
<tr>
<td>NAME</td>
</tr>
<tr>
<td>DEPARTMENT</td>
</tr>
</table>
		</div>
		
);

}

}
});

ReactDOM.render(<StartPage url="authUser/addUser"></StartPage>,document.getElementById("container"));
</script>
<form:form method="POST" action="authUser/addUser" id="employeeForm">
<div id="container"></div>
</form:form>
	<div id= "result"></div>	

</body>

</html>
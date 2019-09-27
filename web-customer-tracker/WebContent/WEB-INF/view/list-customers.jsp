<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<title>
List Customers
</title>

<!--  Reference our style sheet -->
<link  type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
                                               
<body>

<div id="wrapper">
	<div id="header">
		<h2>CRM- Customer Relation</h2>
	</div>
</div>
<div id="container">
	<div id="content"> 
	
	<!-- Add the button for Add Customer -->
	<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"	
	/>
	
	
		<!--  add the html table here -->
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
		</tr>
		<!--  loop over and print the customers -->
		<c:forEach var="tempCustomer" items="${customers}">
			<tr>
				<td>${tempCustomer.firstname}</td>
				<td>${tempCustomer.lastname}</td>
				<td>${tempCustomer.email}</td>
			</tr>
		
		</c:forEach>
		
		</table>
	
	</div>

</div>


</body>

</html>
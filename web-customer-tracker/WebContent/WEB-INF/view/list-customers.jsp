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
				<th>Action</th>
		</tr>
		<!--  loop over and print the customers -->
		<c:forEach var="tempCustomer" items="${customers}">
		<!-- Create a update link with customer id -->
		<c:url  var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomer.id}"></c:param>
		</c:url>
			<tr> 
				<td>${tempCustomer.firstname}</td>
				<td>${tempCustomer.lastname}</td>
				<td>${tempCustomer.email}</td>
				<!-- display update link -->
				<td>
					<a href="${updateLink}">Update</a>
				</td>
			</tr>
		
		</c:forEach>
		
		</table>
	
	</div>

</div>


</body>

</html>
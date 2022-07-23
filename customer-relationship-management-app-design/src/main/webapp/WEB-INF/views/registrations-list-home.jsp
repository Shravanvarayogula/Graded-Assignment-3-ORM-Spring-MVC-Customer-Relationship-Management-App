<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta name="viewport">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Student Registrations Application - Home</title>
</head>
<body>
	<div>
		<div class="container">
			<div class="jumbotron jumbotron-fluid" align="center">
				<h2 class="display-6">Customer Relationship Management
					Application - Spring MVC - Lab 6</h2>
			</div>
			<hr>
			<div class="container-fluid">
				<h5>Create New Customer Registration</h5>

				<input type="button" value="Create New Registration"
					onclick="window.location.href='registration'; return false;"	
					class="btn btn-primary btn-sm">
				<hr>
			</div>
			<div class="container-fluid">
				<h5>View All Customer Registrations</h5>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Customer Id</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email Address</th>
							<th scope="col">Country</th>
							<th scope="col">Manage Registration</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempCust" items="${customers}">
							<c:url var="updateLink" value="/customers/loadform">
								<c:param name="customerId" value="${tempCust.customerId}" />
							</c:url>

							<c:url var="deleteLink" value="/customers/deletecustomer">
								<c:param name="customerId" value="${tempCust.customerId}" />
							</c:url>
							<tr>
								<td>${tempCust.customerId}</td>
								<td>${tempCust.firstName}</td>
								<td>${tempCust.lastName}</td>
								<td>${tempCust.email}</td>
								<td>${tempCust.country}</td>
								<td><a href="${updateLink}" class="btn btn-sm btn-success">
										Update </a> | <a href="${deleteLink}"
									class="btn btn-sm btn-danger"
									onclick="if (! (confirm ('Are you Sure?')))return false">
										Delete Customer </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
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
<title>Customer Relationship Manager - Delete Customer</title>
</head>
<body>
	<div class="container">
			<div class="jumbotron jumbotron-fluid" align="center">
			<h2 class="display-6">Delete Confirmation Page</h2>
		</div>
		<hr>
		<div class="container-fluid">
			<h5>Delete Customer - Confirmation</h5>
			<div class="card">
				<div class="card-body" modelAttribute="customer">
					<ul class="list-group">
						<li class="list-group-item" style="readonly:readonly">Customer ID: <c:out
								value="${customer.customerId}"/>
						</li>
						<li class="list-group-item">First Name: <c:out
								value="${customer.firstName}" />
						</li>
						<li class="list-group-item">Last Name: <c:out
								value="${customer.lastName}" />
						<li class="list-group-item">Email<c:out
								value="${customer.email}" />
						</li>
						<li class="list-group-item">Student Country: <c:out
								value="${customer.country}" />
						</li>
					</ul>
					<br>
					<div class="alert alert-danger" role="alert"> Deleted
						Customer ${customer.firstName}, ${customer.lastName} Successfully!</div>
					<a href="${contextPath}/customers/home"
						class="btn btn-small btn-info"> Back to List </a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
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
<title>Customer Registration Update Confirmation</title>
</head>
<body>
	<div class="container">
			<div class="jumbotron jumbotron-fluid" align="center">
			<h2 class="display-6">Registration Update Confirmation Page</h2>
		</div>
		<hr>
		<div class="container-fluid">
			<div class="container-fluid">
				<h2>Customer Registration Update - Acknowledgement</h2>
			</div>
			<div class="card">
				<div class="card-body" modelAttribute="customer">
					<ul class="list-group">
					<li class="list-group-item" style="display:none">Customer Id: <c:out
								value="${customer.customerId}"/>
						</li>
						<li class="list-group-item">Customers First name: <c:out
								value="${customer.firstName}" />
						</li>
						<li class="list-group-item">Customer's Last name: <c:out
								value="${customer.lastName}" />
						<li class="list-group-item">Customer's Email: <c:out
								value="${customer.email}" />
						</li>
						<li class="list-group-item">Student Country: <c:out
								value="${customer.country}" />
						</li>
					</ul>
					<br>
					<div class="alert alert-success" role="alert"> Updated 
						Customer ${customer.firstName}, ${customer.lastName} Registration Successfully!</div>

					<a href="${contextPath}/customers/home"
						class="btn btn-small btn-info"> Back to List </a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
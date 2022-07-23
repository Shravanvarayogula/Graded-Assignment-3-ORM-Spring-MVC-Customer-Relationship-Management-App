<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta name="viewport">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Update Customer Registration</title>
</head>
<body>
	<div>
		<div class="container">
			<div class="jumbotron jumbotron-fluid" align="center">
				<h2>Update Customer Registration</h2>
			</div>
			<div class="card">
				<div class="card-body">
					<div class="form-group">
						<form:form action="${contextPath}/customers/updatecustomer/?customerId=${customer.customerId}"
							modelAttribute="customer" method="POST">
							<br>

								<div class="form-group row">
									<label for="first_Name" class="col-sm-2 col-form-label">First
										Name</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" name="firstName"
											value="${customer.firstName}" placeholder="Enter first name" required>
									</div>
								</div>
								<div class="form-group row">
									<label for="last_Name" class="col-sm-2 col-form-label">Last
										Name</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" name="lastName"
											value="${customer.lastName}" placeholder="Enter last name" required>
									</div>
								</div>
								<div class=" form-group row">
									<label for="course_name" class="col-sm-2 col-form-label">Email
									</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" name="email"
											value="${customer.email}" placeholder="Enter Email Address" required>
									</div>
								</div>
								<div class=" form-group row">
									<label for="country" class="col-sm-2 col-form-label">Country
									</label>
									<div class="col-sm-7">
										<input type="text" class="form-control" name="country"
											value="${customer.country}"
											placeholder="Enter residence country" required>
									</div>
								</div>

								<br>
								<button type="submit" class="btn btn-primary">Save
									Changes</button>

								<a href="${contextPath}/customers/home"
									class="btn btn-small btn-info"> Back to List </a>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
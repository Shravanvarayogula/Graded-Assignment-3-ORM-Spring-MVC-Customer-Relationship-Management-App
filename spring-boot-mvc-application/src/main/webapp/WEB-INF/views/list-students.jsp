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
			<div class="jumbotron">
				<h2 class="display-6">Student Management Application - Spring Boot MVC Security - Lab 6</h2>
			</div>
			<hr>
			<div class="container-fluid">
				<h5>Create New Student Registration</h5>

				<input type="button" value="Add Student"
					onclick="window.location.href='registration'; return false;"
					class="btn btn-primary btn-sm">
				<hr>
			</div>
			<div class="container-fluid">
				<h5>View All Student Registrations</h5>

				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Student Id</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Course</th>
							<th scope="col">Country</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="tempStudent" items="${students}">
							<c:url var="updateLink" value="/student/loadform">
								<c:param name="id" value="${tempStudent.id}" />
							</c:url>

							<c:url var="deleteLink" value="/student/deletestudent">
								<c:param name="id" value="${tempStudent.id}" />
							</c:url>
							<tr>
								<td>${tempStudent.id}</td>
								<td>${tempStudent.firstname}</td>
								<td>${tempStudent.lastname}</td>
								<td>${tempStudent.coursename}</td>
								<td>${tempStudent.country}</td>
								<td><a href="${updateLink}" class="btn btn-sm btn-success">
										Update </a> | <a href="${deleteLink}"
									class="btn btn-sm btn-danger"
									onclick="if (! (confirm ('Are you Sure?')))return false">
										Delete Student </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>
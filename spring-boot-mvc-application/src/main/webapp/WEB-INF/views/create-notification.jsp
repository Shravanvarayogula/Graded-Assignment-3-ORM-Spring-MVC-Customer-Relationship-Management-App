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
<title>Student Registration Confirmation</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h2 class="display-6">Registration Confirmation Page</h2>
		</div>
		<hr>
		<div class="container-fluid">
			<div class="container-fluid">
				<h5>Registration Confirmation</h5>
			</div>
			<div class="card">
				<div class="card-body" modelAttribute="student">
					<ul class="list-group">
						<li class="list-group-item">Student First name: <c:out
								value="${student.firstname}" />
						</li>
						<li class="list-group-item">Student Last name: <c:out
								value="${student.lastname}" />
						<li class="list-group-item">Student Course name: <c:out
								value="${student.coursename}" />
						</li>
						<li class="list-group-item">Student Country: <c:out
								value="${student.country}" />
						</li>
					</ul>
					<div class="alert alert-success" role="alert">Created New
						User ${student.firstname}, ${student.lastname} Successfully!</div>

					<a href="${contextPath}/student/studentsinfo"
						class="btn btn-small btn-info"> Back to List </a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
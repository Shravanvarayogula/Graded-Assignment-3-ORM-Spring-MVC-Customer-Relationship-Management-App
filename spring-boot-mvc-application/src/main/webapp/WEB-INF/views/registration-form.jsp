<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>New User Registration</title>

</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<h2>Student Registration Form</h2>
		</div>
		<div class="card">
			<div class="card-body">

				<div class="form-group">
					<form:form action="${contextPath}/student/savestudent"
						modelAttribute="student" method="POST">
						<br>
						<div class="form-group row">
							<label for="first_Name" class="col-sm-2 col-form-label">First
								Name</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="firstname" value="${student.firstname}"
									placeholder="Enter first name" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="last_Name" class="col-sm-2 col-form-label">Last
								Name</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="lastname"  value="${student.lastname}"
									placeholder="Enter last name" required>
							</div>
						</div>
						<div class=" form-group row">
							<label for="course_name" class="col-sm-2 col-form-label">Course
								Name</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="coursename" value="${student.coursename}"
									placeholder="Enter course name" required>
							</div>
						</div>
						<div class=" form-group row">
							<label for="course" class="col-sm-2 col-form-label">Country
							</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="country" value="${student.country}"
									placeholder="Enter residence country" required>
							</div>
						</div>

						<br>
						<button type="submit" class="btn btn-primary">Submit</button>

						<a href="${contextPath}/student/studentsinfo"
							class="btn btn-small btn-info"> Back to List </a>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
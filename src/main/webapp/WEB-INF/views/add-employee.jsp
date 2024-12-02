<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
</head>
<body>
	<h1>Add Employee</h1>
	<%-- Display validation error message if present --%>
	<c:if test="${not empty errorMessage}">
		<script>
        alert("${errorMessage}");
    </script>
	</c:if>
	<form action="/addEmployee" method="post">
		Name: <input type="text" name="name"><br> Department: <input
			type="text" name="department"><br> Email: <input
			type="text" name="email"><br> Salary: <input
			type="number" step="0.01" name="salary"><br>
		<button type="submit">Add</button>
	</form>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <h1>Update Employee</h1>
    <form action="/updateEmployee/${employee.id}" method="post">
        Name: <input type="text" name="name" value="${employee.name}"><br>
        Department: <input type="text" name="department" value="${employee.department}"><br>
        Email: <input type="text" name="email" value="${employee.email}"><br>
        Salary: <input type="number" step="0.01" name="salary" value="${employee.salary}"><br>
        <button type="submit">Update</button>
    </form>
</body>
</html>

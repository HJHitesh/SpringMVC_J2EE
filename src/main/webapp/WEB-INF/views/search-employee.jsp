<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Employees</title>
</head>
<body>
    <h2>Search Employees</h2>
    <form action="/searchEmployee" method="GET">
        <label for="search">Search by Name or Department:</label>
        <input type="text" id="search" name="search" value="${param.search}"/>
        <button type="submit">Search</button>
    </form>

    <h3>Employee List</h3>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Email</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.email}</td>
                    <td>${employee.salary}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users table</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		<h3><a href="new">New user</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Username</th>
				<th>Password</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${listUser}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td>${user.phone}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>
					<a href="edit?id=${user.id}"><input type="button" value="Edit"></a>
					&nbsp; &nbsp;
					<a href="delete?id=${user.id}"><input type="button" value="Delete"></a> 
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
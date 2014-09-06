<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>User List page</title>
</head>
<body>
	<h1>User management</h1>
	<br />
	<i>${message}</i>
	<br />
	<a href="${pageContext.request.contextPath}/user/create">Create
		a new user</a>
	<br />
	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>
				<th width="25px">ID</th>
				<th width="150px">User name</th>
				<th width="150px">Password</th>
				<th width="150px">Full name</th>
				<th width="50px">Gender</th>
				<th width="100px">Birthday</th>
				<th width="150px">Email</th>
				<th width="50px">Active</th>
				<th width="50px">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userID}</td>
					<td>${user.userName}</td>
					<td>${user.pwd}</td>
					<td>${user.fullName}</td>
					<td>${user.gender}</td>
					<td>${user.birthOfDay}</td>
					<td>${user.email}</td>
					<td>${user.active}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/edit/${user.userID}">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/user/delete/${user.userID}">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
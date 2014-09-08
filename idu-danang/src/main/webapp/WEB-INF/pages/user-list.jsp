<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User List page</title>
</head>
<body>
	<h1>User management</h1>
	<br />
	<i>${message}</i>
	<br />
	<a href="${pageContext.request.contextPath}/user/create">Create a
		new user</a>
	<br />
	<table style="text-align: center;" border="1px" cellpadding="0"
		cellspacing="0">
		<thead>
			<tr>
				<th width="25px">ID</th>
				<th width="130px">User name</th>
				<th width="130px">Password</th>
				<th width="150px">Full name</th>
				<th width="100px">Birthday</th>
				<th width="70px">Gender</th>
				<th width="120px">ID Card</th>
				<th width="150px">Address</th>
				<th width="150px">Email</th>
				<th width="100px">Phone number</th>
				<th width="100px">Avatar</th>
				<th width="80px">Role</th>
				<th width="50px">Active</th>
				<th width="50px">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.pwd}</td>
					<td>${user.fullName}</td>
					<td><fmt:formatDate value="${user.birthOfDay}"
							pattern="dd/MM/yyyy" /></td>
					<td>${user.gender == 1 ? 'Male' : 'Female'}</td>
					<td>${user.idCard}</td>
					<td>${user.address}</td>
					<td>${user.email}</td>
					<td>${user.phoneNumber}</td>
					<td>${user.avatarPath}</td>
					<td>${user.role.roleName}</td>
					<td>${user.active == 1 ? 'True' : 'False'}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/edit/${user.userId}">Edit</a><br />
						<a
						href="${pageContext.request.contextPath}/user/delete/${user.userId}">Delete</a><br />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
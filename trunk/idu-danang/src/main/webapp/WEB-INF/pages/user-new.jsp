<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>New User page</title>
</head>
<body>
	<h1>New User page</h1>
	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/user/create">
		<table>
			<tbody>
				<tr>
					<td>User name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Full name:</td>
					<td><form:input path="fullName" /></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><form:input path="birthOfDay" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:select path="gender" items="${gender}" /></td>
				</tr>
				<tr>
					<td>ID Card:</td>
					<td><form:input path="idCard" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Phone number:</td>
					<td><form:input path="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Role:</td>
					<td><form:input path="role" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Create" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/user/list">User
		management</a>
</body>
</html>
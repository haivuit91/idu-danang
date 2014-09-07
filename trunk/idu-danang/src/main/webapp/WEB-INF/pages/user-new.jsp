<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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
					<td><form:errors path="userName" cssStyle="color: red;" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td colspan="2"><form:password path="pwd" /></td>
				</tr>
				<tr>
					<td>Full name:</td>
					<td colspan="2"><form:input path="fullName" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td colspan="2"><form:select path="gender" items="${gender}" /></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td colspan="2"><form:input path="birthOfDay" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td colspan="2"><form:input path="email" /></td>
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
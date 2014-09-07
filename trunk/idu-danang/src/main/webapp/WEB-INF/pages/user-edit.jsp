<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit user page</title>
</head>
<body>
	<h1>Edit user page</h1>
	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/user/edit/${user.userID}">
		<table>
			<tbody>
				<tr>
					<td>User name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="pwd" /></td>
				</tr>
				<tr>
					<td>Full name:</td>
					<td><form:input path="fullName" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:select path="gender" items="${gender}" /></td>
				</tr>
				<tr>
					<td>Birthday:</td>
					<td><form:input path="birthOfDay" ></form:input>
							<%-- <fmt:formatDate value="${user.birthOfDay}"
							pattern="dd/MM/yyyy" /> --%>
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/user/list">User
		management</a>
</body>
</html>
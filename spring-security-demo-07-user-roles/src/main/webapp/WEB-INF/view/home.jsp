<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
	<head>
		<title>Coding Company</title>
	</head>
	<body>
		<h2>Coding Company Home Page - Yahoo - Silly Goose!!!</h2>
		<hr>
		<p>Welcome to Luv 2 Code Company Home Page</p>
		<hr>
		<!--  Display User Names and Roles -->
		<p>
			User: <security:authentication property="principal.username" />
			<br><br>
			Role(s): <security:authentication property="principal.authorities" />
		</p>
		<hr>
		<!--  Add a link to point to /leaders.
		      This is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for manager people)
		</p>
		<hr>
		<!--  Add a link to point to /systems.
		      This is for the admin -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for admin people)
		</p>
		<hr>
		<!--  Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" /> 
		</form:form>
	</body>
</html>
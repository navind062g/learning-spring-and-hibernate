<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Coding Company</title>
	</head>
	<body>
		<h2>Coding Company Home Page - Yahoo - Silly Goose!!!</h2>
		<hr>
		<p>Welcome to Luv 2 Code Company Home Page</p>
		<hr>
		<!--  Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" /> 
		</form:form>
	</body>
</html>
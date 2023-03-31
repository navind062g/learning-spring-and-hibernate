<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
	.failed {
		color: red;
		font-weight: bolder;
	}
</style>
<title>Custom Login Page</title>
</head>
<body>
	<h3>My Custom Login Page</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<!-- check for the error -->
		<core:if test="${param.error != null}">
			<i class="failed">Invalid Credentials! Please enter a valid username and password!</i>
		</core:if>
		
		<p>
			User Name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>
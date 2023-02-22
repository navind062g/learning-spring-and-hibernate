<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		<h1>The Student is confirmed: ${student.firstName} ${student.lastName}</h1>
		<br><br>
		<h2>Student belongs to Country: ${student.country}</h2>
		<div>Student uses the following Operating Systems:
			<br>
			<ul>
				<core:forEach var="temp" items="${student.operatingSystems}">
					<li>${temp}</li>
				</core:forEach>
			</ul>
		</div>
	</body>
</html>
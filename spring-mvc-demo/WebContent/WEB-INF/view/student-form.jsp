<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Student Form</title>
	</head>
	<body>
		<form:form action="processForm" modelAttribute="student">
			First Name: <form:input path="firstName" />
			<br><br>
			Last Name: <form:input path="lastName" />
			<br><br>
			<div>
				Favorite Language:
				<br>
				<form:radiobutton path="favoriteLanguage" value="Java" />Java
				<br>
				<form:radiobutton path="favoriteLanguage" value="CSharp" />C#
				<br>
				<form:radiobutton path="favoriteLanguage" value="JavaScript" />JavaScript
				<br>
				<form:radiobutton path="favoriteLanguage" value="Python" />Python
				<br>
			</div>
			<br><br>
			Country: 
			<form:select path="country">
				<form:options items="${student.countryOptions.values()}"/>
			</form:select>
			<br><br>
			Select Operating System that you use:
			<br>
			Linux <form:checkbox path="operatingSystems" value="Linux" />
			Microsoft Windows<form:checkbox path="operatingSystems" value="Windows" />
			Mac OS <form:checkbox path="operatingSystems" value="Apple" />
			Google Chrome <form:checkbox path="operatingSystems" value="Chrome" />
			<br><br>
			<input type="submit" value="Submit" />			
		</form:form>
	</body>
</html>
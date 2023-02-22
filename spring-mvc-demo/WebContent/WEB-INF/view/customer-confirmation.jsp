<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer Confirmation</title>
	</head>
	<body>
		<h1>The Customer is confirmed: ${customer.firstName} ${customer.lastName}</h1>
		<br>
		<h2>Customer has ${customer.freePasses} Free Pass(or Passes)</h2>
		<br>
		<p>Postal Code: ${customer.postalCode}</p>
		<br>
		<p>Course Code: ${customer.courseCode}</p>
	</body>
</html>
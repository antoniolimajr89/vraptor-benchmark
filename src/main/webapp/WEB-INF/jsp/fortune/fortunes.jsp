<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Fortunes</title>
</head>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>message</th>
		</tr>
		<c:forEach var="f" items="${fortunes}">
			<tr>
				<td>${f.id}</td>
				<td>${f.message}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
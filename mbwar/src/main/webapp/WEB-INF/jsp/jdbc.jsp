<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>Property</th>
				<c:forEach var="dbName" items="${dbNames}">
					<th>${dbName}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="propName" items="${propNames}">
				<tr>
					<td>${propName}</td>
					<c:forEach var="dbName" items="${dbNames}">
						<td>${allDbProps.get(dbName}.get(propName)</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.T {
	background: #44ab44;
	color: white;
	text-align: center;
}

.F {
	background: #e11;
	color: white;
	text-align: center;
}
</style>
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
			<c:forEach var="propName" items="${booleanPropNames}">
				<tr>
					<td>${propName}</td>
					<c:forEach var="dbName" items="${dbNames}">
						<td class="${allBooleanDbProps.get(dbName).get(propName)}">${allBooleanDbProps.get(dbName).get(propName)}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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
			<c:forEach var="propName" items="${intPropNames}">
				<tr>
					<td>${propName}</td>
					<c:forEach var="dbName" items="${dbNames}">
						<td>${allIntDbProps.get(dbName).get(propName)}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
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
			<c:forEach var="propName" items="${stringPropNames}">
				<tr>
					<td>${propName}</td>
					<c:forEach var="dbName" items="${dbNames}">
						<td>${allStringDbProps.get(dbName).get(propName)}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul>
		<c:forEach var="otherMethod" items="${otherMethods}">
			<li>${otherMethod}</li>
		</c:forEach>

	</ul>
</body>
</html>
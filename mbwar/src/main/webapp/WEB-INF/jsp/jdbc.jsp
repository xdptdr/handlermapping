<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: #fff;
	color: #222;
	font-family: sans-serif;
}

h1 {
	font-size: 150%;
}

h2 {
	font-size: 125%;
}

.center {
	text-align: center;
}

table {
	border-collapse: collapse;
	border: 0;
	box-shadow: 1px 2px 3px #ccc;
}

td, th {
	border: 1px solid #666;
	font-size: 75%;
	vertical-align: baseline;
	padding: 4px 5px;
}

.center table {
	margin: 1em auto;
	text-align: left;
}

.center th {
	text-align: center !important;
}

.e {
	background-color: #ccf;
	width: 300px;
	font-weight: bold;
}

.h {
	background-color: #99c;
	font-weight: bold;
}

.v {
	background-color: #ddd;
	max-width: 300px;
	max-height: 300px;
	overflow-y: auto;
}

.T.v {
	background: #44ab44;
	color: white;
	text-align: center;
}

.F.v {
	background: #e11;
	color: white;
	text-align: center;
}

ul {
	text-align: left;
}
</style>
</head>
<body class="center">
	<h1>Simple getters</h1>
	<h2>Booleans</h2>
	<table>
		<thead>
			<tr>
				<th></th>
				<c:forEach var="columnName" items="${columnNames}">
					<th class="h">${columnName}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rowName" items="${rowNames}">
				<c:if test="${rowName.type == 'boolean'}">
					<tr>
						<td class="e">${rowName.content}</td>
						<c:forEach var="columnName" items="${columnNames}">
							<td
								class="v ${table.get(columnName).get(rowName.content).className}">${table.get(columnName).get(rowName.content).content}</td>
						</c:forEach>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<h2>Integers</h2>
	<table>
		<thead>
			<tr>
				<th></th>
				<c:forEach var="columnName" items="${columnNames}">
					<th class="h">${columnName}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rowName" items="${rowNames}">
				<c:if test="${rowName.type == 'integer'}">
					<tr>
						<td class="e">${rowName.content}</td>
						<c:forEach var="columnName" items="${columnNames}">
							<td
								class="v ${table.get(columnName).get(rowName.content).className}">${table.get(columnName).get(rowName.content).content}</td>
						</c:forEach>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<h2>Strings</h2>


	<table>

		<tbody>
			<c:forEach var="rowName" items="${rowNames}">
				<c:if test="${rowName.type == 'string'}">
					<tr>
						<td class="e" rowspan="${columnNames.size()+1}">${rowName.content}</td>
						<td class="v">${columnNames.get(0)}</td>
						<td class="v">${table.get(columnNames.get(0)).get(rowName.content).content}</td>
					</tr>
					<c:forEach var="columnName" items="${columnNames}">
						<tr>
							<c:if test="${columnName != columnNames.get(0)}">
								<td class="v">${columnName}</td>
								<td class="v" style="max-width: 600px">${table.get(columnName).get(rowName.content).content}</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:if>
			</c:forEach>
		</tbody>
	</table>

	<h1>Functions and keywords</h1>

	<c:forEach var="commaSeparatedListGettersTitle"
		items="${commaSeparatedListGettersTitles}">
		<h2>${commaSeparatedListGettersTitle.value}</h2>


		<table>
			<thead>
				<tr>
					<th></th>
					<c:forEach var="columnName" items="${columnNames}">
						<th class="h">${columnName}</th>
					</c:forEach>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="numericFunction"
					items="${allCommaSeparatedLists.get(commaSeparatedListGettersTitle.key)}">
					<tr>
						<td class="e">${numericFunction}</td>
						<c:forEach var="columnName" items="${columnNames}">
							<td
								class="v ${commaSeparatedListValuesPerDb.get(commaSeparatedListGettersTitle.key).get(columnName).contains(numericFunction)?'T':'F'}">${commaSeparatedListValuesPerDb.get(commaSeparatedListGettersTitle.key).get(columnName).contains(numericFunction)?'T':'F'}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:forEach>
	<ul>
		<c:forEach var="otherMethod" items="${otherMethods}">
			<li>${otherMethod}</li>
		</c:forEach>
	</ul>
</body>
</html>
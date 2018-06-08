<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
	<title>Administrator CRUD Operations</title>
</head>
<body>
<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Category (FT/PT)</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<td><a href="/courses/${course.courseid}">${course.name}</a></td>
						<td>${course.category}</td>
						<td> <a href="enrollment?id=${course.courseid}">Enrollment</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
</body>
</html>
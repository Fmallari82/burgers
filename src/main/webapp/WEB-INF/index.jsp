<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container m3">
		<h1 class="text-center">Burger Tracker</h1>

		<form action="/burgers/search">
			<input type="text" name="search" /> <input type="submit"
				value="Search" />
		</form>
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">Burger Name</th>
					<th scope="col">Restaurant Name</th>
					<th scope="col">Rating (out of 5)</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allBurgers}" var="burger">
					<tr>
						<td><a href="/burgers/${burger.id}"><c:out value="${burger.burgerName}"/></a></td>
						<td><a href="/burgers/${burger.id}"><c:out value="${burger.restaurantName}" /></a></td>
						<td><a href="/burgers/${burger.id}"><c:out value="${burger.rating}" /></a></td>
						<td>
							<div class="d-flex">
								<form action="/burgers/edit/${burger.id}" method="get">
									    <input type="hidden" name="_method" value="edit">
									    <input type="submit" value="Edit">
								</form>
								<form action="/burgers/${burger.id}" method="post">
									    <input type="hidden" name="_method" value="delete">
									    <input type="submit" value="Delete">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h2>Add a Burger</h2>
		<form:form action="/burgers/all" method="post" modelAttribute="burger">
			<div class="form-group">
				<form:label path="burgerName">Burger Name</form:label>
				<form:errors path="burgerName" />
				<form:input path="burgerName" />
			</div>

			<div class="form-group">
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:errors path="restaurantName" />
				<form:input path="restaurantName" />
			</div>
			<div class="form-group">
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" />
				<form:input type="number" path="rating" />
			</div>
			<div class="form-group">
				<form:label path="notes">Notes</form:label>
				<form:errors path="notes" />
				<form:textarea path="notes" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>
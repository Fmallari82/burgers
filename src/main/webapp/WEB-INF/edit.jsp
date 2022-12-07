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
		<h1>Edit Burger</h1>
		<form:form action="/burgers/edit/process/${burger.id}" method="post"
			modelAttribute="burger">
			<input type="hidden" name="_method" value="put">
					    <div class="form-group">
				<form:label path="burgerName">Burger Name</form:label>
				<form:errors path="burgerName" />
				<form:input path="burgerName" />
			</div>
			
			<div class="form-group">
				<form:label path="restaurantName">Restaurant Name</form:label>
				<form:errors path="restaurantName" />
				<form:textarea path="restaurantName" />
			</div>
			<div class="form-group">
				<form:label path="rating">Rating</form:label>
				<form:errors path="rating" />
				<form:input type="number" path="rating" />
			</div>
			<div class="form-group">
				<form:label path="notes">Notes</form:label>
				<form:errors path="notes" />
				<form:input path="notes" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
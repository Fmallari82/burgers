<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>
		<c:out value="${oneBurger.burgerName}" />
	</h1>
	<h3>
		Restaurant Name:
		<c:out value="${oneBurger.restaurantName}" />
	</h3>
	<h3>
		Rating:
		<c:out value="${oneBurger.rating}" />
	</h3>
	<h3>
		Notes:
		<c:out value="${oneBurger.notes}" />
	</h3>

	<form action="/burgers/all" method="get">
		<input type="hidden" name="_method" value="home">     
		<input type="submit" value="Home">
	</form>



	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
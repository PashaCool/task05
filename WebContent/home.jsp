<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ include file="login.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Start page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<h5> Кнопки edit and delete ничего не делают</h5>
	<header class="container">
	<div class="row">
		<h1 class="col-sm-8">Турфирма</h1>
		<nav class="col-sm-12">
		<p>
		<form action="ClientList" method="get">
			<input type="submit" name="clients" value="Clients" />
		</form>
		</p>
		<p>
		<form action="SaleList" method="get">
			<input type="submit" name="sales" value="Sales" />
		</form>
		</p>
		<p>
		<form action="Contacts" method="get">
			<input type="submit" name="contacts" value="Contscts" />
		</form>
		</p>
		</nav>
	</div>
	<table border="1">
		<caption>Список туров</caption>
		<tr>
			<th>Город</th>
			<th>Тип поездки</th>
			<th>Цена</th>
			<th>Дни</th>
			<th>Еда</th>
			<th>Отель</th>
			<th>Виза</th>
			<th>Транспорт</th>
		</tr>
		<c:forEach var="tour" items="${t}">
			<tr>
				<td>${tour.city}</td>
				<td>${tour.type}</td>
				<td>${tour.price}</td>
				<td>${tour.days}</td>
				<td>${tour.eat}</td>
				<td>${tour.hotel}</td>
				<td>${tour.visa}</td>
				<td>${tour.transBus}</td>
				<td><input type="submit" name="enter" value="Edit" /></td>
				<td><input type="submit" name="enter" value="Delete" /></td>
			</tr>
		</c:forEach>
	</table>
	<form action="CreateTour" method="get">
		<input type="submit" name="createTour" value="Create new tour" />
	</form>
	<%@ include file="footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<%@ include file="login.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Start page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,700'
	rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" >
<link rel="stylesheet" href="css/tablestl.css">
</head>
<body>
	<header>
	<div class="container">
		<h1>Турфирма</h1>
		<nav>
			<form action="ClientList" method="get">
				<input type="submit" name="clients" value="Clients" />
			</form>
			<form action="SaleList" method="get">
				<input type="submit" name="sales" value="Sales" />
			</form>
			<form action="Contacts" method="get">
				<input type="submit" name="contacts" value="Contscts" />
			</form>
		</nav>
	</div>
	</header>
	<h2>Список туров</h2>
	<table class="inventory" border="1">
		<caption></caption>
		<colgroup>
			<col id="city">
			<col id="type">
			<col id="price">
			<col id="days">
			<col id="food">
			<col id="hotel">
			<col id="visa">
			<col id="transport">
		</colgroup> 
		<tr>
			<th scope="col">Город</th>
			<th scope="col">Тип поездки</th>
			<th scope="col">Цена</th>
			<th scope="col">Дни</th>
			<th scope="col">Еда</th>
			<th scope="col">Отель</th>
			<th scope="col">Виза</th>
			<th scope="col">Транспорт</th>
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
				<td><img src="image/edit.png" width="16" height="16" alt="edit"></td>
				<td><img src="image/del.png" width="16" height="16" alt="del"></td>
			</tr>
		</c:forEach>
	</table>
	<form action="CreateTour" method="get">
		<input type="submit" name="createTour" value="Create new tour" />
	</form>
	<%@ include file="footer.jsp"%>
</body>
</html>
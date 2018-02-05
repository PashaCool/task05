<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	    <%@ page errorPage="error.jsp" %>
    <%@ include file="login.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
		<table border="1">	
		<caption>Список клиентов</caption>	
		<tr>
			<td>ID</td>
			<td>Имя</td>
			<td>Фамилия</td>
			<td>Телефон</td>
			<td>Sale %</td>
			<td>Путешествий</td>
		</tr>
		<c:forEach var="client" items="${clients}">
			<tr>
				<td>${client.id}</td>
				<td>${client.name}</td>
				<td>${client.surname}</td>
				<td>${client.phone}</td>
				<td>${client.sale}</td>
				<td>${client.trips}</td>			
				<td><input type="submit" name="enter" value="Edit"/></td>
				<td><input type="submit" name="enter" value="Delete"/></td>
				</tr>
		</c:forEach>		
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>Список вариантов скидок</br>
		<table border="1">		
			<td>ID</td>
			<td>Название</td>
			<td>Количество в %</td>
		<c:forEach var="sale" items="${sales}">
			<tr>
				<td>${sale.id}</td>
				<td>${sale.name}</td>
				<td>${sale.size}</td>
				<td><input type="submit" name="enter" value="Edit"/></td>
				<td><input type="submit" name="enter" value="Delete"/></td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>
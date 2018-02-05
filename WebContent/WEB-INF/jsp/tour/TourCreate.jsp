<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="DataTour" method="post">
		<table>
			<tr>
				<td><b>City</b></td>
				<td><input type="text" name="city" size=25 /></td>
			</tr>
			<tr>
				<td><b>Type tour</b></td>
				<td><select name="type" size="1" multiple form="nubexForm">
						<option>tour</option>
						<option>shopping</option>
						<option>sanative</option>
				</select></td>
			</tr>
			<tr>
				<td><b>Days</b></td>
				<td><input type="text" name="days" size=2 /></td>
			</tr>
			<tr>
				<td><b>Price</b></td>
				<td><input type="text" name="price" size=25 /></td>
			</tr>
			<tr>
				<td><b>Eat</b></td>
				<td><input type="checkbox" name="eat" /></td>
			</tr>
			<tr>
				<td><b>Hotel</b></td>
				<td><input type="checkbox" name="hotel" /></td>
			</tr>
			<tr>
				<td><b>Visa</b></td>
				<td><input type="checkbox" name="visa" /></td>
			</tr>
			<tr>
				<td><b>Transport</b></td>
				<td><select name="transport" size="1" multiple form="nubexForm">
						<option>bus</option>
						<option>avia</option>
						<option>train</option>
				</select></td>
			</tr>
			<tr>

				<td><b><input type="submit" name="create" value="Create" /></b></td>

			</tr>
		</table>
	</form>
</body>
</html>
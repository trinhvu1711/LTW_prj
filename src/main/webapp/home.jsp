<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	day la trang home <br>
	hello ${sessionScope.account.name} <br>
	${sessionScope.account.username}
	so nguoi truy cap: ${sessionScope.count} <br>
</body>
</html>
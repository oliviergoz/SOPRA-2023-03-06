<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>les parametres recu:${prenom} ${age}</h1>
	<c:if test="${age<18 }">
		<div>mineur</div>
	</c:if>
	<c:if test="${age>=18 }">
		<div>majeur</div>
		<div>nos site pour adulte ...</div>
	</c:if>

</body>
</html>
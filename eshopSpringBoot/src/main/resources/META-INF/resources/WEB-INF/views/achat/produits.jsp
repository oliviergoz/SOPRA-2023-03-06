<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eshop</title>
<base href="${pageContext.request.contextPath}/">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>nos produits</h1>
	<table class="table">
		<c:forEach items="${produits}" var="p">
			<tr>
				<td>${p.libelle }</td>
				<td>${p.prix }</td>
				<td><a href="achat/addPanier?id=${p.id}" class="btn btn-link">
						ajouter au panier</a></td>
				<td>${panier.get(p) }</td>
				<td><c:if test="${panier.get(p)!=null }">
						<a href="achat/remove?id=${p.id}" class="btn btn-link">
							retirer un element du panier</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<a href="achat/save" class="btn btn-link">valider panier</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eshop</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<base href="${pageContext.request.contextPath}/">
</head>
<body>
	<div class="container">
		<h1>la page des produits</h1>
		<jsp:include page="../menu.jsp"></jsp:include>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>libelle</th>
					<th>description</th>
					<th>prix</th>
					<th>fournisseur</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${produits}">
					<tr>
						<td>${p.id }</td>
						<td>${p.libelle }</td>
						<td>${p.description }</td>
						<td>${p.prix }</td>
						<td>${p.fournisseur.nom}</td>
						<td><a href="produit/edit?id=${p.id}"
							class="btn btn-outline-primary">edition</a></td>
						<td><a href="produit/delete?id=${p.id}"
							class="btn btn-outline-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="produit/add" class="btn btn-link">nouveau produit</a>
	</div>
</body>
</html>
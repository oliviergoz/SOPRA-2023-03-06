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
</head>
<body>
	<div class="container">
		<h1>la page des fournisseurs</h1>
		<jsp:include page="../menu.jsp"></jsp:include>
		<table class="table">
			<thead>
				<tr>
					<th>id</th>
					<th>nom</th>
					<th>contact</th>
					<th>adresse</th>
					<th></th>
					<th></th>
			</thead>
			<tbody>
				<c:forEach var="f" items="${fournisseurs}">
					<tr>
						<td>${f.id}</td>
						<td>${f.nom}</td>
						<td>${f.contact}</td>
						<td>${f.adresse.numero}${f.adresse.rue }<br>
							${f.adresse.codePostal} ${f.adresse.ville}
						</td>
						<td><a href="fournisseur/edit?id=${f.id}" class="btn btn-outline-primary">edition</a></td>
						<td><a href="fournisseur/delete?id=${f.id}"
							class="btn btn-outline-danger">suppression</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="fournisseur/create" class="btn btn-link">nouveau
			fournisseur</a>
	</div>
</body>
</html>
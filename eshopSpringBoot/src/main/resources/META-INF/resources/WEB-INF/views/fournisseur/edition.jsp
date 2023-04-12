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
	<div class="container">
		<h1>edition fournisseur</h1>
		<c:if test="${error}">
			<div class="alert alert-danger">données incorrectes</div>
		</c:if>
		<div>
			<form action="fournisseur" method="post">
			<div class="form-group">
					<label for="id">id:</label> <input name="id" id="id"
						class="form-control" value="${fournisseur.id}" readonly="readonly"
						placeholder="génération automatique">
				</div>
				<div class="form-group">
					<label for="nom">nom:</label> <input name="nom" id="nom"
						class="form-control" value="${fournisseur.nom}">
				</div>
				<div class="form-group">
					<label for="contact">contact:</label> <input name="contact"
						id="contact" class="form-control" value="${fournisseur.contact}">
				</div>

				<div class="row">
					<div class="col-6">
						<label for="adresse.numero">numero:</label><input
							id="adresse.numero" name="adresse.numero" class="form-control"
							value="${fournisseur.adresse.numero}">
					</div>
					<div class="col-6">
						<label for="adresse.rue">rue:</label><input id="adresse.rue"
							name="adresse.rue" class="form-control"
							value="${fournisseur.adresse.rue}">
					</div>
					<div class="col-6">
						<label for="adresse.codePostal">code postal:</label><input
							id="adresse.codePostal" name="adresse.codePostal"
							class="form-control" value="${fournisseur.adresse.codePostal}">
					</div>
					<div class="col-6">
						<label for="adresse.ville">ville:</label> <input
							id="adresse.ville" name="adresse.ville" class="form-control"
							value="${fournisseur.adresse.ville}">
					</div>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">envoyer</button>
					<a href="fournisseur" class="btn btn-outline-warning">annuler</a>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
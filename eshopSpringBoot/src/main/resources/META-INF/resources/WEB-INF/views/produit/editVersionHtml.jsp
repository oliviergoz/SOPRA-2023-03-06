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
		<h1>edition produit</h1>
		<c:if test="${error}">
			<div class="alert alert-danger">données incorrectes</div>
		</c:if>
		<div>
			<form action="produit" method="post">
				<div class="form-group">
					<label for="id">id:</label> <input name="id" id="id"
						class="form-control" value="${produit.id}" readonly="readonly"
						placeholder="génération automatique">
				</div>
				<div class="form-group">
					<label for="libelle">libelle:</label> <input name="libelle"
						id="libelle" class="form-control" value="${produit.libelle}">
				</div>
				<div class="form-group">
					<label for="description">description:</label>
					<textarea id="description" name="description" rows="10"
						class="form-control">${produit.description }</textarea>
				</div>
				<div class="form-group">
					<label for="prix">prix:</label> <input type="number" name="prix"
						id="prix" step="0.1" class="form-control" value="${produit.prix}">
				</div>
				<div class="form-group">
					<label for="fournisseur.id">fournisseur:</label> <select
						name="fournisseur.id" class="form-control">
						<option value="">pas de fournisseur</option>
						<c:forEach var="fournisseur" items="${fournisseurs}">
							<c:choose>
								<c:when test="${produit.fournisseur.id==fournisseur.id}">
									<option value="${fournisseur.id }" selected="selected">${fournisseur.id}
										${fournisseur.nom}</option>
								</c:when>
								<c:otherwise>
									<option value="${fournisseur.id }">${fournisseur.id}
										${fournisseur.nom}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">envoyer</button>
					<a href="produit" class="btn btn-outline-warning">annuler</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
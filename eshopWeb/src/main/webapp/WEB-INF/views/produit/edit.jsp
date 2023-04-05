<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>edition produit spring</h1>
		<c:if test="${error}">
			<div class="alert alert-danger">données incorrectes</div>
		</c:if>
		<div>
			<form:form action="produit" method="post" modelAttribute="produit">
				<div class="form-group">
					<form:label path="id">id:</form:label>
					<form:input path="id" class="form-control" readonly="readonly"
						placeholder="génération automatique" />
				</div>
				<div class="form-group">
					<form:label path="libelle">libelle:</form:label>
					<form:input path="libelle" class="form-control" />
					<form:errors path="libelle"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="description">description:</form:label>
					<form:textarea path="description" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="prix">prix:</form:label>
					<form:input type="number" path="prix" step="0.1"
						class="form-control" />
					<form:errors path="prix"></form:errors>
				</div>
				<div class="form-group">
					<form:label path="fournisseur.id">fournisseur:</form:label>
					<form:select path="fournisseur.id" class="form-control">
						<form:option value="">pas de fournisseur</form:option>
						<form:options items="${fournisseurs}" itemValue="id"
							itemLabel="nom" />
					</form:select>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">envoyer</button>
					<a href="produit" class="btn btn-outline-warning">annuler</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
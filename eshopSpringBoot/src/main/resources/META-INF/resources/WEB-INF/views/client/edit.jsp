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
		<h1>edition client</h1>
		<div>
			<form:form action="client/save" method="post" modelAttribute="client">
				<input type="hidden" name="create" value="${create}">
				<div class="form-group">
					<form:label path="id">id:</form:label>
					<form:input path="id" readonly="true" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="civilite">titre:</form:label>
					<form:select path="civilite" items="${civilites}" itemLabel="texte"
						class="form-control"></form:select>
				</div>

				<div class="form-group">
					<form:label path="prenom">prenom:</form:label>
					<form:input path="prenom" class="form-control" />
					<form:errors path="prenom">
						<div class="alert alert-danger">il faut un prenom</div>
					</form:errors>
				</div>

				<div class="form-group">
					<form:label path="nom">nom:</form:label>
					<form:input path="nom" class="form-control" />
					<form:errors path="nom" class="alert alert-danger" element="div"></form:errors>
				</div>
				<c:if test="${create}">
					<div class="form-group">
						<form:label path="compte.login">login:</form:label>
						<form:input path="compte.login" class="form-control" />
						<form:errors path="compte.login" class="alert alert-danger"
							element="div"></form:errors>
					</div>
					<div class="form-group">
						<form:label path="compte.password">password:</form:label>
						<form:input type="password" path="compte.password"
							class="form-control" />
						<form:errors path="compte.password" class="alert alert-danger"
							element="div"></form:errors>
					</div>
				</c:if>
				<div class="form-group">
					<form:label path="adresse.numero">numero:</form:label>
					<form:input path="adresse.numero" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.rue">rue:</form:label>
					<form:input path="adresse.rue" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.codePostal">code postal:</form:label>
					<form:input path="adresse.codePostal" class="form-control" />
				</div>
				<div class="form-group">
					<form:label path="adresse.ville">ville:</form:label>
					<form:input path="adresse.ville" class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-outline-primary">envoyer</button>
					<a href="client" class="btn btn-outline-warning">annuler</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
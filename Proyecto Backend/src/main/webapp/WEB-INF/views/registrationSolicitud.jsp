<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Solicitud Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">Solicitud Registration Form</div>
	 	<form:form method="POST" modelAttribute="solicitud" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>

			<form:input type="hidden" path="institucionId" id="institucionidId"/>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="institucionNombre">Nombre de Institucion </label>
					<div class="col-md-7">
						<form:input type="text" path="institucionNombre" id="institucionNombre" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="institucionNombre" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>

			<c:choose>
				<c:when test="${edit}">
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="institucionId">ID de Institucion </label>
							<div class="col-md-7">
								<form:input type="number" path="institucionId" id="institucionId" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="institucionId" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			
			
			
			
			
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="estadoDes">Estado de Solicitud </label>
					<div class="col-md-7">
						<form:input type="text" path="estadoDes" id="estadoDes" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="estadoDes" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
	
			<c:choose>
				<c:when test="${edit}">
				</c:when>
				<c:otherwise>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="estadoId">ID de Estado </label>
							<div class="col-md-7">
								<form:input type="number" path="estadoId" id="estadoId" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="estadoId" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
			
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
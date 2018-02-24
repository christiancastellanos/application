<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring5 MVC  Demo</title>
		<style type="text/css">
			.error {
				color: red;
			}
			table {
				width: 50%;
				border-collapse: collapse;
				border-spacing: 0px;
			}
			table td {
				border: 1px solid #565454;
				padding: 20px;
			}
		</style>
	</head>
	<body>
		<h2>Lista de Personas</h2>
		<a href="vistaPersona"> Agregar</a>
		<table>
			<tr>
				<td><strong>Id</strong></td>
				<td><strong>Nombres</strong></td>
				<td><strong>Apellidos</strong></td>
				<td><strong>Telefono</strong></td>
				<td><strong>DNI</strong></td>
				<td><strong>Direccion</strong></td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${personas}" var="persona">
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombres}</td>
					<td>${persona.apellidos}</td>
					<td>${persona.telefono}</td>
					<td>${persona.dni}</td>
					<td>${persona.direccion}</td>
					<td><a href="vistaPersona?id=${persona.id}"> Editar</a></td>
					<td><a href="eliminarPersona/${persona.id}"> Eliminar</a></td>
					<td><a href="vistaSolicitudes/${persona.id}"> VistaSolicitudes</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
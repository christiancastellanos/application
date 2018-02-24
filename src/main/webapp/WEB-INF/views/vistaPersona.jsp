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
		<h1>Input Form</h1>
		<form:form action="${empty persona.id?'agregarPersona':'modificarPersona'}" method="post" modelAttribute="persona">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>Nombres</td>
					<td>
						<form:input path="nombres" /> <br />
						<form:errors path="nombres" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Apellidos</td>
					<td>
						<form:input path="apellidos" /> <br />
						<form:errors path="apellidos" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Telefono</td>
					<td>
						<form:input path="telefono" /> <br />
						<form:errors path="telefono" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>DNI</td>
					<td>
						<form:input path="dni" /> <br />
						<form:errors path="dni" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Direccion</td>
					<td>
						<form:input path="direccion" /> <br />
						<form:errors path="direccion" cssClass="error" />
					</td>
				</tr>
						
				<tr>
					<td colspan="2"><button type="submit">Submit</button></td>
				</tr>
			</table>
		</form:form>
		
	</body>
</html>
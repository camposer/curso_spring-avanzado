<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Personas</title>
	<style>
		.errores {
			background-color: red;
		}
	</style>
	<script>
		var eliminar = function(id) {
			var conf = confirm("Seguro quiere eliminar la persona con id = " + id);
			
			if (conf)
				window.location.href="eliminar.do?id=" + id;
		};
	</script>
</head>
<body>
	<h1>Personas</h1>
	<form:form action="agregar.do" method="post" commandName="personaForm">
		<form:errors cssClass="errores" path="*" />
	
		<table>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido" 
					id="apellido" value="${personaForm.apellido}"/></td>
			</tr>
			<tr>
				<td>Fecha de Nacimiento:</td>
				<td><form:input path="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Agregar"/> 
					<input type="button" value="Modificar"/> 
				</td>
			</tr>
		</table>
	</form:form>
	<hr/>
	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Fecha de nacimiento</th>
			<th>Mostrar</th>
			<th>Eliminar</th>
		</tr>
		<c:forEach var="p" items="${personas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.apellido}</td>
				<td>${p.fechanacimiento}</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#" onclick="eliminar(${p.id})">eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
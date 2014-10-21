<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Personas</title>
</head>
<body>
	<h1>Personas</h1>
	<form>
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre"/>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="apellido"/>
			</tr>
			<tr>
				<td>Fecha de Nacimiento:</td>
				<td><input type="text" name="fechaNacimiento"/>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Agregar"/> 
					<input type="button" value="Modificar"/> 
				</td>
			</tr>
		</table>
	</form>
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
				<td><a href="#">eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
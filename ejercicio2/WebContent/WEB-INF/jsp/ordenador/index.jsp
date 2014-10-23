<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><t:message code="persona.index.titulo"/></title>
	<style>
		.errores {
			background-color: red;
		}
	</style>
	<script>
		var eliminar = function(id) {
			var conf = confirm('<t:message code="persona.index.js.eliminar"/> = ' + id);
			
			if (conf)
				window.location.href="eliminar.do?id=" + id;
		};
		
		var guardar = function() {
			var personaId = document.getElementById('personaId');
			
			if (!personaId.options[personaId.selectedIndex].value) {
				window.alert("Debe seleccionar un dueño");				
				return false;
			}
			
			return true;
		}
	</script>
</head>
<body>
	<h1>Ordenadores</h1>
	<form:form action="guardar.do" method="post" commandName="ordenadorForm">
		<form:errors cssClass="errores" path="*" />
		<form:hidden path="id"/>
		<table>
			<tr>
				<td>Nombre:</td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td>Serial:</td>
				<td><form:input path="serial"/></td>
			</tr>
			<tr>
				<td>Dueño</td>
				<td>
					<form:select path="personaId">
						<form:option value="">Seleccione un dueño</form:option>
						<form:options itemValue="id" 
							itemLabel="nombreCompleto"
							items="${personas}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="btnAgregar" value="Agregar" onclick="return guardar()"/> 
					<input type="submit" name="btnModificar" value="Modificar" onclick="return guardar()"/> 
				</td>
			</tr>
		</table>
	</form:form>
	<hr/>
	<table>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Serial</th>
			<th>Dueño</th>
			<th>Mostrar</th>
			<th>Eliminar</th>
		</tr>
		<c:forEach var="o" items="${ordenadores}">
			<tr>
				<td>${o.id}</td>
				<td>${o.nombre}</td>
				<td>${o.serial}</td>
				<td>${o.persona.nombreCompleto}</td>
				<td><a href="mostrar.do?id=${o.id}">mostrar</a></td>
				<td><a href="#" onclick="eliminar(${o.id})">eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
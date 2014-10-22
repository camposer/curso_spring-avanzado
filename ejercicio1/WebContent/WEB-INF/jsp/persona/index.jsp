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
		const AGREGAR = 0;
		const MODIFICAR = 1;
		
		var eliminar = function(id) {
			var conf = confirm("Seguro quiere eliminar la persona con id = " + id);
			
			if (conf)
				window.location.href="eliminar.do?id=" + id;
		};
		
		var guardar = function(op) {
			var form = document.getElementById('formPersona');
			
			if (op == AGREGAR)
				form.action = "agregar.do";
			else if (op == MODIFICAR)
				form.action = "modificar.do";
				
			form.submit();
		}
	</script>
</head>
<body>
	<h1><t:message code="persona.index.titulo"/></h1>
	<form:form id="formPersona" method="post" commandName="personaForm">
		<form:errors cssClass="errores" path="*" />
		<form:hidden path="id"/>
		<table>
			<tr>
				<td><t:message code="persona.index.form.nombre"/></td>
				<td><form:input path="nombre"/></td>
			</tr>
			<tr>
				<td><t:message code="persona.index.form.apellido"/></td>
				<td><input type="text" name="apellido" 
					id="apellido" value="${personaForm.apellido}"/></td>
			</tr>
			<tr>
				<td><t:message code="persona.index.form.fecha"/></td>
				<td><form:input path="fechaNacimiento"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="<t:message code="persona.index.form.btnAgregar"/>" onclick="guardar(AGREGAR)"/> 
					<input type="button" value="<t:message code="persona.index.form.btnModificar"/>" onclick="guardar(MODIFICAR)"/> 
				</td>
			</tr>
		</table>
	</form:form>
	<hr/>
	<table>
		<tr>
			<th><t:message code="persona.index.tabla.id"/></th>
			<th><t:message code="persona.index.tabla.nombre"/></th>
			<th><t:message code="persona.index.tabla.apellido"/></th>
			<th><t:message code="persona.index.tabla.fecha"/></th>
			<th><t:message code="persona.index.tabla.mostrar"/></th>
			<th><t:message code="persona.index.tabla.eliminar"/></th>
		</tr>
		<c:forEach var="p" items="${personas}">
			<tr>
				<td>${p.id}</td>
				<td>${p.nombre}</td>
				<td>${p.apellido}</td>
				<td>${p.fechanacimiento}</td>
				<td><a href="mostrar.do?id=${p.id}"><t:message code="persona.index.tabla.mostrar"/></a></td>
				<td><a href="#" onclick="eliminar(${p.id})"><t:message code="persona.index.tabla.eliminar"/></a></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>
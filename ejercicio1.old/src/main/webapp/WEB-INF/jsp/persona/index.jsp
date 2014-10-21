<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<tr>
			<td>1</td>
			<td>Juan</td>
			<td>Pérez</td>
			<td>2012-01-01</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>
		<tr>
			<td>2</td>
			<td>María</td>
			<td>García</td>
			<td>2013-02-02</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>
		<tr>
			<td>3</td>
			<td>Pedro</td>
			<td>Pérez</td>
			<td>2014-03-03</td>
			<td><a href="#">mostrar</a></td>
			<td><a href="#">eliminar</a></td>
		</tr>
	</table>
	
	
</body>
</html>
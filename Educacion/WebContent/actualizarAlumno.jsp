<%@page import="beans.AlumnoDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>Actualizar Alumno</title>
</head>
<body>
	<%
		AlumnoDTO obj = (AlumnoDTO) request.getAttribute("Alumno");
	%>
	<form action="ServletAlumno?tipo=actualizar" id="frmactualizar"
		method="post">
		<input type="hidden" name="txtCod"
			value="${requestScope.Alumno.idAlumno }">

		<div class="container">
			<h2>Actualizar Alumno</h2>
			<fieldset class="mb-3">
				<label for="txt_nombre">Nombres : </label> <input name="txt_nom"
					type="text" class="form-control"
					value="${requestScope.Alumno.nombres }">
			</fieldset>
			<div class="mb-3">
				<label for="txt_nombre">Apellidos : </label> <input name="txt_ape"
					type="text" class="form-control"
					value="${requestScope.Alumno.apellidos }">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">DNI : </label> <input name="txt_dni"
					type="text" class="form-control"
					value="${requestScope.Alumno.DNI }">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Fecha nacimiento : </label> <input
					name="txt_fecnac" type="text" class="form-control"
					value="${requestScope.Alumno.fechaNacimiento }">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Sexo : </label> <input name="txt_sexo"
					type="text" class="form-control"
					value="${requestScope.Alumno.sexo }">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Ciudad : </label> <input name="txt_ciud"
					type="text" class="form-control"
					value="${requestScope.Alumno.ciudad }">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Direccion : </label> <input name="txt_direc"
					type="text" class="form-control"
					value="${requestScope.Alumno.direccion }">
			</div>
			<button class="btn btn-primary" type="submit">Actualizar</button>
		</div>

	</form>




</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
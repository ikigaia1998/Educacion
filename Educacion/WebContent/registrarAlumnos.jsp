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
<title>Registrar Alumno</title>
</head>
<body>
	<form action="ServletAlumno?tipo=registrar" id="frmagregar"
		method="post">

		<div class="container">
			<h2>Registrar Alumno</h2>
			<div class="mb-3">
				<label for="txt_nombre">Nombres : </label> <input name="txt_nom"
					type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Apellidos : </label> <input name="txt_ape"
					type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">DNI </label> <input name="txt_dni"
					type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Fecha de nacimiento </label> <input
					name="txt_fecnac" type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Sexo </label> <input name="txt_sexo"
					type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Ciudad </label> <input name="txt_ciud"
					type="text" class="form-control">
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Dirección </label> <input name="txt_direc"
					type="text" class="form-control">
			</div>
			<div>
				<button class="btn btn-primary" type="submit">Registrar</button>
			</div>
		</div>
	</form>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
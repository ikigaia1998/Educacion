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
<title>Registrar Matricula</title>
</head>
<body>
	<form action="ServletMatricula?tipo=registrar" id="frmagregar"
		method="post">

		<div class="container">
			<h2>Registrar Matricula</h2>
			<div class="mb-3">
			<tr>
				<td>Marca:</td>
				<td><select name="cbo_apoderado" onChange="combo(this, demo)">
						<option value="1">Jorge</option>
						<option value="2">Juan</option>
				</select></td>
			</tr>
			</div>
			<div class="mb-3">
			<tr>
				<td>Marca:</td>
				<td><select name="cbo_alumno" onChange="combo(this, demo)">
						<option value="1">Bruno</option>
						<option value="2">Pepe</option>
				</select></td>
			</tr>
			</div>
			<div class="mb-3">
			<tr>
				<td>Marca:</td>
				<td><select name="cbo_curso" onChange="combo(this, demo)">
						<option value="1">Matemática</option>
						<option value="2">Comunicación</option>
				</select></td>
			</tr>
			</div>
			<div class="mb-3">
				<label for="txt_nombre">Pago </label> <input name="txt_pago"
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
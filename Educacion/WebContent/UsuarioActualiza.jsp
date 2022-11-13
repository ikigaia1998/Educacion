<%@ page import="beans.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>Document</title>
</head>
<body>
	<%
		UsuarioDTO obj = (UsuarioDTO) request.getAttribute("Usuario");
	%>
	<h2>Actualizar Usuario</h2>
	<div class="container">
		<form action="ServletUsuario?tipo=actualizar" method="post"
			id="frmactualizar">
			
				<label for="txt_cod">Codigo : </label> <input name="txt_cod"
					type="hidden" class="form-control" 
					value="${requestScope.Usuario.idUsuario }">
			
			<div class="mb-3">
				<label for="txt_nombre">Nombres : </label> <input name="txt_nombre"
					type="text" class="form-control"
					value="${requestScope.Usuario.nombres }">
			</div>
			<div class="mb-3">
				<label for="txt_apellido">Apellidos : </label> <input
					name="txt_apellido" type="text" class="form-control"
					value="${requestScope.Usuario.apellidos }">
			</div>
			<div class="mb-3">
				<label for="txt_Login">Usuario : </label> <input name="txt_Login"
					type="text" class="form-control"
					value="${requestScope.Usuario.loginUsuario }">
			</div>
			<div class="mb-3">
				<label for="txt_clave">Contraseña : </label> <input name="txt_clave"
					type="text" class="form-control"
					value="${requestScope.Usuario.clave }">
			</div>
			<div class="mb-3">
				<label for="fecha">Registro : </label> <input name="fecha"
					type="date" class="form-control"
					value="${requestScope.Usuario.fechaRegistro }">
			</div>
			<button class="btn btn-primary">Actualizar</button>
	</div>
	</form>
	</div>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">   
<title>Matricular Alumno</title>
</head>
<body>
<form action="ServletApoderado?tipo=registrar" id="frmagregar" method="post">
	<div class="container">
	<br>
    <h2>Registrar Alumno</h2>
    <br>
            <div class="mb-3">
                <label for="txt_nombres">Nombres:</label>
                <input name="txt_nom" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_apellidos">Apellidos:</label>
                <input name="txt_ape" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_telefono">Telefono:</label>
                <input name="txt_tel" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_dni">Dni:</label>
                <input name="txt_dni" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_idalumno">Id Alumno:</label>
                <input name="txt_idal" type="text" class="form-control">
            </div>
            <div><button  class="btn btn-primary" type="submit">Registrar</button></div>
    </div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
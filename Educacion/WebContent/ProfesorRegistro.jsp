<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <title>Registrar Profesor</title>
</head>
<body>
<form action="ServletProfesor?tipo=registrar" id="frmagregar" method="post">

    <div class="container">
    <h2>Registrar Profesor</h2>
            <div class="mb-3">
                <label for="txt_nombre">Nombres : </label>
                <input name="txtNom" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_nombre">Apellidos : </label>
                <input name="txtApe" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_nombre">Sexo </label>
                <input name="txtSexo" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_nombre">Telefono </label>
                <input name="txtTel" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_nombre">Direccion </label>
                <input name="txtDir" type="text" class="form-control">
            </div>
            <div class="mb-3">
                <label for="txt_nombre">DNI </label>
                <input name="txtDni" type="text" class="form-control">
            </div>
            <div><button  class="btn btn-primary" type="submit">Registrar</button></div>
    </div>
</form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
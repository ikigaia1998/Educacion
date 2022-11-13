<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Inicio de Sesion</title>
</head>
<body class="fondo-login">
	<%
		String x = (String)request.getAttribute("msj");
		String a = "";
		if(x!=null) a =x;
	%> 
    <main class=" fondo">
    <section>
        <div class="box-img">
            <img src="img/academico.png" alt="">
            <h1 class="title">Ingresa con tu cuenta</h1>
        </div>
        <form action="ServletUsuario?tipo=iniciarSesion" name="frmsesion" method="post">
            <div class="mb-3">
                <label class="form-label" for="user">Usuario</label>
                <input class="form-control" type="text" placeholder="ingresa tu usuario" name="txtlogin">
            </div>
            <div class="mb-3">
                <label class="form-label" for="pass">Contraseña</label>
                <input class="form-control" type="text" name="txtpass" id="pass" placeholder="ingresa tu contraseña">
            </div>
            <div class="mb-3 btn-login">
                <button class="btn btn-primary" type="submit">Ingresar</button>
            </div>
            <%=a %>
        </form>
    </section>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="beans.UsuarioDTO" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <title>Inicio Usuario</title>
</head>
<body>
		<%
		String x = (String) request.getAttribute("msj");
	String a = "";
	if (x != null) {
		a = x;
	}
	List<UsuarioDTO> lista = (List<UsuarioDTO>) request.getAttribute("data");
	%>

    <main class="container">
        <div>
            <h2>Usuarios</h2>
            <a href="UsuarioRegistro.jsp" class="btn btn-primary m-2">Registrar</a>
        </div>
    <div>
        <table class="table text-center">
            <thead>
                <th>Id Usuario</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Usuario</th>
                <th>Contraseña</th>
                <th>Fecha Registro</th>
                <th>Acciones</th>
            </thead>
            <tbody>
            <%
							if (lista != null) {
							for (UsuarioDTO u : lista) {
						%>
				<tr>		
                <td><%=u.getIdUsuario() %></td>
                <td><%=u.getNombres() %></td>
                <td><%=u.getApellidos() %></td>
                <td><%=u.getLoginUsuario() %></td>
                <td><%=u.getClave() %></td>
                <td><%=u.getFechaRegistro() %></td>
                <td><a href="ServletUsuario?tipo=buscar&cod=<%=u.getIdUsuario() %>" class="btn btn-success" style="margin-right:10px ;"><i class="bi bi-pencil-square"></i></a><a href="ServletUsuario?tipo=eliminar&cod=<%=u.getIdUsuario() %>" class="btn btn-danger"><i class="bi bi-trash3"></i></a></td>
            	</tr>
            <%
							}
						}
						%>
            </tbody>
        </table>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
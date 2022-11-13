<%@page import="beans.ApoderadoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>Listar Apoderados</title>
</head>
<body>
<main class="container">
        <br>
        <div>
            <h2>Apoderados</h2>
            <br>
            <a href="registrarApoderado.jsp" class="btn btn-primary m-2">Registrar</a> 
        </div>
        <br>
        <div>
        <table class="table text-center">
<tr>
<th>CODIGO</th>
<th>NOMBRES</th>
<th>APELLIDOS</th>
<th>DNI</th>
<th>TELEFONO</th>
<th>ID ALUMNO</th>
<th colspan="2">ACCIONES</th>
</tr>
<%
	ArrayList<ApoderadoDTO> lista = (ArrayList<ApoderadoDTO>) request.getAttribute("data");

	if(lista != null)
	{
		for(ApoderadoDTO xApo : lista)
		{
			out.println("<tr>");
			out.println("<td>" + xApo.getIdApoderado() + "</td>");
			out.println("<td>" + xApo.getNombres() + "</td>");
			out.println("<td>" + xApo.getApellidos() + "</td>");
			out.println("<td>" + xApo.getDni() + "</td>");
			out.println("<td>" + xApo.getTelefono() + "</td>");
			out.println("<td>" + xApo.getIdAlumno() + "</td>");
			out.println("<td><a href='ServletAlumno?tipo=buscar&cod="+xApo.getIdApoderado()+"' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletAlumno?tipo=eliminar&cod="+xApo.getIdApoderado()+"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
		}		
	}	
%>

</table>
</div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
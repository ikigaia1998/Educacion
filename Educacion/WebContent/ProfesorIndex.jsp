<%@page import="interfaces.ProfesorDAO"%>
<%@page import="beans.ProfesorDTO"%>
<%@page import="java.util.ArrayList" %>
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
    <title>Inicio Profesor</title>
</head>
<body>
	<main class="container">
        <div>
            <h2>Profesores</h2>
            <a href="ProfesorRegistro.jsp" class="btn btn-primary m-2">Registrar</a>
        </div>
    	<div>
        <table class="table text-center">
	<tr>
	<th>Id</th>
	<th>Nombres</th>
	<th>Apellidos</th>
	<th>Sexo</th>
	<th>Telefono</th>
	<th>Direccion</th>
	<th>DNI</th>


	<th colspan="2">ACCIONES</th>
	</tr>
	<%
		ArrayList<ProfesorDTO> lista = (ArrayList<ProfesorDTO>) request.getAttribute("data");
		if(lista !=null){
			for(ProfesorDTO prof : lista ){
				out.println("<tr>");
				out.println("<td>"+prof.getIdprofesor()+"</td>");
				out.println("<td>"+prof.getNom()+"</td>");
				out.println("<td>"+prof.getApe()+"</td>");
				out.println("<td>"+prof.getSexo()+"</td>");
				out.println("<td>"+prof.getTel()+"</td>");
				out.println("<td>"+prof.getDir()+"</td>");
				out.println("<td>"+prof.getDni()+"</td>");
				//out.println("<td><a href='' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletDocente?tipo=buscar&cod="+ doc.getIdDocente() +"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
				out.println("<td><a href='ServletProfesor?tipo=buscar&cod="+prof.getIdprofesor()+"' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletProfesor?tipo=eliminar&cod="+prof.getIdprofesor()+"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
			}
		}
	
	
	
	%>
	
	 </table>
    </div>
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
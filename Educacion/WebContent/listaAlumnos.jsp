<%@page import="interfaces.AlumnoDAO"%>
<%@page import="beans.AlumnoDTO"%>
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
    <title>Inicio Alumnos</title>
</head>
<body>
	<main class="container">
        <div>
            <h2>Alumnos</h2>
            <a href="registrarAlumnos.jsp" class="btn btn-primary m-2">Registrar</a>
        </div>
	 <form action="ServletAlumno?tipo=buscarcod" id="frmbuscarcod"
		method="post" class="row g-4">
		<div class="col-auto">
			<input type="text" name="cod1" class="form-control"
				placeholder="Ingrese codigo"> <input type="submit" value="Consultar" class="btn btn-warning">
		</div>
	</form>	
    	<div>
        <table class="table text-center">
	<tr>
	<th>Id</th>
	<th>Nombres</th>
	<th>Apellidos</th>
	<th>DNI</th>
	<th>Fecha nacimiento</th>
	<th>Sexo</th>
	<th>Ciudad</th>
	<th>Direccion</th>
	<th>Fecha registro</th>


	<th colspan="2">ACCIONES</th>
	</tr>
	<%
		ArrayList<AlumnoDTO> lista = (ArrayList<AlumnoDTO>) request.getAttribute("data");
		if(lista !=null){
			for(AlumnoDTO prof : lista ){
				out.println("<tr>");
				out.println("<td>"+prof.getIdAlumno()+"</td>");
				out.println("<td>"+prof.getNombres()+"</td>");
				out.println("<td>"+prof.getApellidos()+"</td>");
				out.println("<td>"+prof.getDNI()+"</td>");
				out.println("<td>"+prof.getFechaNacimiento()+"</td>");
				out.println("<td>"+prof.getSexo()+"</td>");
				out.println("<td>"+prof.getCiudad()+"</td>");
				out.println("<td>"+prof.getDireccion()+"</td>");
				out.println("<td>"+prof.getFechaRegistro()+"</td>");
				//out.println("<td><a href='' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletDocente?tipo=buscar&cod="+ doc.getIdDocente() +"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
				out.println("<td><a href='ServletAlumno?tipo=buscar&cod="+prof.getIdAlumno()+"' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletAlumno?tipo=eliminar&cod="+prof.getIdAlumno()+"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
			}
		}
	
	
	
	%>
	
	 </table>
    </div>
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

<%@page import="interfaces.MatriculaDAO"%>
<%@page import="beans.MatriculaDTO"%>
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
    <title>Inicio Matriculas</title>
</head>
<body>
	<main class="container">
        <div>
            <h2>Matriculas</h2>
            <a href="registrarMatricula.jsp" class="btn btn-primary m-2">Registrar</a>
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
	<th>IdMatricula</th>
	<th>Apoderado</th>
	<th>Alumno</th>
	<th>Curso</th>
	<th>Pago</th>


	<th colspan="2">ACCIONES</th>
	</tr>
	<%
		ArrayList<MatriculaDTO> lista = (ArrayList<MatriculaDTO>) request.getAttribute("data");
		if(lista !=null){
			for(MatriculaDTO prof : lista ){
				out.println("<tr>");
				out.println("<td>"+prof.getIdMatricula()+"</td>");
				out.println("<td>"+prof.getNombreApo()+"</td>");
				out.println("<td>"+prof.getNombreAlu()+"</td>");
				out.println("<td>"+prof.getDescripCurso()+"</td>");
				out.println("<td>"+prof.getPago()+"</td>");
				//out.println("<td><a href='' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletDocente?tipo=buscar&cod="+ doc.getIdDocente() +"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
				out.println("<td><a href='ServletMatricula?tipo=buscar&cod="+prof.getIdMatricula()+"' class='btn btn-success' style='margin-right:10px ;'><i class='bi bi-pencil-square'></i></a><a href='ServletMatricula?tipo=eliminar&cod="+prof.getIdMatricula()+"' class='btn btn-danger'><i class='bi bi-trash3'></i></a></td>");
			}
		}
	
	
	
	%>
	
	 </table>
    </div>
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

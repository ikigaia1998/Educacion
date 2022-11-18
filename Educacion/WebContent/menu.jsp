<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html"; charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
    <title>Sistema de Gestion Escolar</title>
</head>
<body >
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Abraham Valdelomar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Configuraciones
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="UsuarioRegistro.jsp">Crear Usuario</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="ServletUsuario?tipo=listar">Listar Usuario</a></li>
                </ul>
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Alumnos
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="ServletAlumno?tipo=listar">Crear Alumnos</a></li>
                  <li><a class="dropdown-item" href="#">Consulta y Reporte</a></li>
                </ul>
              </li>
                
                <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Apoderado
                </a>
                <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="registrarApoderado.jsp">Crear Apoderado</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="ServletApoderado?tipo=listar">Listar Apoderados</a></li>
                </ul>
              </li>
            
            
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Profesor
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="ProfesorRegistro.jsp">Crear Profesores</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="ServletProfesor?tipo=listar">Listar Profesores</a></li>
                  
                </ul>
              </li>
<!-- 
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Cursos
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Crear Cursos</a></li>
                  <li>
                </ul>
              </li> -->
              
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Matricula
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="ServletMatricula?tipo=listar">Crear Matricula</a></li>
                  <li><a class="dropdown-item" href="#">Consulta y Reporte</a></li>
                </ul>
              </li>
            </ul>

        </ul>
          </div>
        </div>
        <form class="container-fluid justify-content-end" action="">
            <button class="btn btn-danger me-2 bi bi-arrow-right-square-fill" type="button"> Cerrar Sesion </button>
            
        </form>
      </nav>
    <main class="fondo-menu">

    </main>
    <footer>
        <p>Derechos Reservados Cibertec2022</p>
    </footer>
</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>



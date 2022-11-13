package MisServlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioDTO;
import service.UsuarioService;
import util.Conversiones;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	UsuarioService uservice = new UsuarioService();
	private static final long serialVersionUID = 1L;

    public ServletUsuario() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xtipo= request.getParameter("tipo"); 
		if(xtipo.equals("iniciarSesion")) iniciarSesion(request,response);
		else if (xtipo.equals("registrar")) registrar(request,response);
		else if (xtipo.equals("listar")) listar(request,response);
		else if (xtipo.equals("actualizar")) actualizar(request,response);
		else if (xtipo.equals("eliminar")) eliminar(request,response);
		else if (xtipo.equals("buscar")) buscar(request,response);
		
	}

	protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String log,pass;
		log= request.getParameter("txtlogin");
		pass=request.getParameter("txtpass");
		UsuarioDTO e = uservice.iniciarSesion(log, pass);
		if(e==null) {
			request.setAttribute("msj","<div class ='alert alert-warning' role ='alert'>" + 
					"            <h4>Error usuario y/o clave</h4></div>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else response.sendRedirect("menu.jsp");
	}
	protected void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombres,apellidos,Login,Clave;
		nombres =request.getParameter("txt_nombre");
		apellidos = request.getParameter("txt_apellido");
		Login = request.getParameter("txt_Login");
		Clave = request.getParameter("txt_clave");
		int codigo = Integer.parseInt(request.getParameter("txt_cod"));
		Date fecha = Conversiones.toFecha(request.getParameter("fecha"))  ;
		UsuarioDTO obj  =  new UsuarioDTO ();
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setLoginUsuario(Login);
		obj.setClave(Clave);
		obj.setFechaRegistro(fecha);
		obj.setIdUsuario(codigo);
		uservice.actualizarUsuario(obj);
		listar(request,response);
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data",uservice.listarUsuario());
		request.getRequestDispatcher("UsuarioIndex.jsp").forward(request, response);		
	}
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		uservice.eliminarUsuario(cod);
		listar(request,response);
		
	}
	protected void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Usuario",uservice.buscarUsuario(cod));
		request.getRequestDispatcher("UsuarioActualiza.jsp").forward(request, response);
		
		
		
	}
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("UsuarioRegistro.jsp").forward(request, response);
		String nombres,apellidos,Login,Clave;
		nombres =request.getParameter("txt_nombre");
		apellidos = request.getParameter("txt_apellido");
		Login = request.getParameter("txt_Login");
		Clave = request.getParameter("txt_clave");
		UsuarioDTO obj  =  new UsuarioDTO ();
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setLoginUsuario(Login);
		obj.setClave(Clave);
		
		uservice.registrarUsuario(obj);
		listar(request,response);
	}

}

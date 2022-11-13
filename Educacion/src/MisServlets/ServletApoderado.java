package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApoderadoDTO;
import service.ApoderadoService;

/**
 * Servlet implementation class ServletApoderado
 */
@WebServlet("/ServletApoderado")
public class ServletApoderado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApoderadoService serviApoderado = new ApoderadoService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletApoderado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("listar"))
		{
			listar(request,response);
		}
		else if(xtipo.equals("buscar"))
		{
			buscar(request,response);
		}
		else if(xtipo.equals("registrar"))
		{
			registrar(request,response);
		}
		else if(xtipo.equals("actualizar"))
		{
			actualizar(request,response);
		}
		else if(xtipo.equals("eliminar"))
		{
			eliminar(request,response);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviApoderado.eliminaApoderado(cod);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idalumno, dni, telefono,idapoderado;
		String nombres,apellidos;

		idapoderado = Integer.parseInt(request.getParameter("txt_idap"));
		nombres = request.getParameter("txt_nom");
		apellidos = request.getParameter("txt_ape");
		telefono = Integer.parseInt(request.getParameter("txt_tel"));
		dni = Integer.parseInt(request.getParameter("txt_dni"));
		idalumno = Integer.parseInt(request.getParameter("txt_idal"));
		
		ApoderadoDTO obj = new ApoderadoDTO();
		
		obj.setIdApoderado(idapoderado);
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setTelefono(telefono);
		obj.setDni(dni);
		obj.setIdAlumno(idalumno);
		
		serviApoderado.actualizaApoderado(obj);
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idalumno, dni, telefono;
		String nombres,apellidos;

		nombres = request.getParameter("txt_nom");
		apellidos = request.getParameter("txt_ape");
		telefono = Integer.parseInt(request.getParameter("txt_tel"));
		dni = Integer.parseInt(request.getParameter("txt_dni"));
		idalumno = Integer.parseInt(request.getParameter("txt_idal"));
		
		ApoderadoDTO obj = new ApoderadoDTO();
		
		obj.setNombres(nombres);
		obj.setApellidos(apellidos);
		obj.setTelefono(telefono);
		obj.setDni(dni);
		obj.setIdAlumno(idalumno);
		
		serviApoderado.registraApoderado(obj);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Apoderado", serviApoderado.buscaApoderado(cod));
		request.getRequestDispatcher("actualizarApoderado.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviApoderado.listaApoderado());
		request.getRequestDispatcher("listarApoderado.jsp").forward(request, response);
	}

}

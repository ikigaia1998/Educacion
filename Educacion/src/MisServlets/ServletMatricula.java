package MisServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MatriculaDTO;
import service.MatriculaService;

/**
 * Servlet implementation class ServletMatricula
 */
@WebServlet("/ServletMatricula")
public class ServletMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MatriculaService serviMatricula = new MatriculaService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMatricula() {
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
		if (xtipo.equals("listar")) {
			listar(request, response);
		}else if (xtipo.equals("registrar"))
			registrar(request, response);
		else if (xtipo.equals("buscar"))
			buscar(request, response);
		else if (xtipo.equals("actualizar"))
			actualizar(request, response);
		else if (xtipo.equals("eliminar"))
			eliminar(request, response);
		else if (xtipo.equals("buscarcod"))
			buscarcod(request, response);
	}
	
	private void buscarcod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod1"));
		request.setAttribute("data", serviMatricula.buscaMatriculaxcod(cod));
		request.getRequestDispatcher("listaMatriculas.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviMatricula.eliminaMatricula(cod);
		listar(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod;
		cod = Integer.parseInt(request.getParameter("txtCod"));
		int idapo = Integer.parseInt(request.getParameter("cbo_apoderado"));
		int idalum = Integer.parseInt(request.getParameter("cbo_alumno"));
		int curso = Integer.parseInt(request.getParameter("cbo_curso"));
		Double pago = Double.parseDouble(request.getParameter("txt_pago"));
		MatriculaDTO obj = new MatriculaDTO();
		obj.setIdMatricula(cod);
		obj.setIdApoderado(idapo);
		obj.setIdAlumno(idalum);
		obj.setIdCurso(curso);
		obj.setPago(pago);
		serviMatricula.actualizaMatricula(obj);
		listar(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Matricula", serviMatricula.buscaMatricula(cod));
		request.getRequestDispatcher("actualizarMatricula.jsp").forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idapo = Integer.parseInt(request.getParameter("cbo_apoderado"));
		int idalum = Integer.parseInt(request.getParameter("cbo_alumno"));
		int curso = Integer.parseInt(request.getParameter("cbo_curso"));
		Double pago = Double.parseDouble(request.getParameter("txt_pago"));
		MatriculaDTO obj = new MatriculaDTO();
		obj.setIdApoderado(idapo);
		obj.setIdAlumno(idalum);
		obj.setIdCurso(curso);
		obj.setPago(pago);
		serviMatricula.registraMatricula(obj);
		listar(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("data", serviMatricula.listaMatricula());
		request.getRequestDispatcher("listaMatriculas.jsp").forward(request, response);
	}

}

package MisServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProfesorDTO;
import service.ProfesorService;

/**
 * Servlet implementation class ServletProfesor
 */
@WebServlet("/ServletProfesor")
public class ServletProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProfesorService serviProf = new ProfesorService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo = request.getParameter("tipo");
		if(xtipo.equals("listar")) {
			listar(request,response);
		}else if(xtipo.equals("registrar")) {
			registrar(request,response);
		}else if(xtipo.equals("actualizar")) {
			actualizar(request,response);
		}else if(xtipo.equals("buscar")) {
			buscar(request,response);
		}else if(xtipo.equals("eliminar")) {
			eliminar(request,response);
		}
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int cod = Integer.parseInt(request.getParameter("cod"));
		serviProf.eliminarProfesor(cod);
		listar(request,response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int cod = Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Profesor", serviProf.buscarProfesor(cod));
		request.getRequestDispatcher("ProfesorActualiza.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nom,ape,sexo,dir;
		int tel,dni,cod;
		cod=Integer.parseInt(request.getParameter("txtCod"));
		nom=request.getParameter("txtNom");
		ape=request.getParameter("txtApe");
		sexo=request.getParameter("txtSexo");
		dir=request.getParameter("txtDir");
		tel=Integer.parseInt(request.getParameter("txtTel"));
		dni=Integer.parseInt(request.getParameter("txtDni"));
		
		ProfesorDTO obj = new ProfesorDTO();
		obj.setIdprofesor(cod);
		obj.setNom(nom);
		obj.setApe(ape);
		obj.setSexo(sexo);
		obj.setTel(tel);
		obj.setDir(dir);
		obj.setDni(dni);
		serviProf.actualizarProfesor(obj);
		listar(request,response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*create table profesor(
				idprofesor int primary key AUTO_INCREMENT,
				nombres varchar(255),
				apellidos varchar(255),
				sexo varchar(25),
				telefono int,
				direccion varchar(255),
				dni int);
				--*/
		String nom,ape,sexo,dir;
		int tel,dni;
		nom=request.getParameter("txtNom");
		ape=request.getParameter("txtApe");
		sexo=request.getParameter("txtSexo");
		dir=request.getParameter("txtDir");
		tel=Integer.parseInt(request.getParameter("txtTel"));
		dni=Integer.parseInt(request.getParameter("txtDni"));
		
		ProfesorDTO obj = new ProfesorDTO();
		obj.setNom(nom);
		obj.setApe(ape);
		obj.setSexo(sexo);
		obj.setTel(tel);
		obj.setDir(dir);
		obj.setDni(dni);
		serviProf.registrarProfesor(obj);
		listar(request,response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setAttribute("data", serviProf.listaProfesor());
		request.getRequestDispatcher("ProfesorIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

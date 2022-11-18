package Factory;

import dao.MySqlAlumnoDAO;
import dao.MySqlApoderadoDAO;
import dao.MySqlMatriculaDAO;
import dao.MySqlProfesorDAO;
import dao.MySqlUsuarioDAO;
import interfaces.AlumnoDAO;

import interfaces.ProfesorDAO;
import interfaces.UsuarioDao;
import interfaces.ApoderadoDAO;
import interfaces.MatriculaDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public AlumnoDAO getAlumno() {
		// TODO Auto-generated method stub
		return new MySqlAlumnoDAO();
	}

	@Override
	public UsuarioDao getUsuario() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public ProfesorDAO getProfesor() {
		// TODO Auto-generated method stub
		return new MySqlProfesorDAO();
	}


	@Override
	public ApoderadoDAO getApoderado() {
		// TODO Auto-generated method stub
		return new MySqlApoderadoDAO();
	}

	@Override
	public MatriculaDAO getMatricula() {
		// TODO Auto-generated method stub
		return new MySqlMatriculaDAO();
	}
}

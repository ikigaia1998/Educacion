package Factory;

import interfaces.AlumnoDAO;

import interfaces.UsuarioDao;
import interfaces.ApoderadoDAO;
import interfaces.MatriculaDAO;
import interfaces.ProfesorDAO;

public abstract class DAOFactory {

	//posibles origenes de datos
	public static final int MYSQL=1;
	public static final int ORACLE=2;
	public static final int DB2=3;
	public static final int SQLSERVER=4;
	public static final int XML=5;
	
	//Se ponen tantas interfaces como tengas
	public abstract AlumnoDAO getAlumno();
	public abstract UsuarioDao getUsuario();
	public abstract ProfesorDAO getProfesor();
	public abstract ApoderadoDAO getApoderado();
	public abstract MatriculaDAO getMatricula();
	
	//con que fabrica vas a salir
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
		case MYSQL:	return new MySqlDAOFactory();	
		case ORACLE: //return new OracleDAOFactory();
		case SQLSERVER :// return new SQLServerDAOFactory();
		}
		return null;
	}
}


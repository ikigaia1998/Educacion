package service;

import java.util.List;

import Factory.DAOFactory;
import beans.AlumnoDTO;
import interfaces.AlumnoDAO;
import util.Constantes;

public class AlumnoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	AlumnoDAO objPro = fabrica.getAlumno();

	public List<AlumnoDTO> listaAlumno() {
		return objPro.listarAlumno();
	}

	public AlumnoDTO buscaAlumno(int cod) {
		return objPro.buscarAlumno(cod);
	}

	public int registraAlumno(AlumnoDTO obj) {
		return objPro.registrarAlumno(obj);
	}

	public int actualizaAlumno(AlumnoDTO obj) {
		return objPro.actualizarAlumno(obj);
	}

	public int eliminaAlumno(int cod) {
		return objPro.eliminarAlumno(cod);
	}
	
}

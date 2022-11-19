package service;

import java.util.List;

import Factory.DAOFactory;
import beans.MatriculaDTO;
import interfaces.MatriculaDAO;
import util.Constantes;

public class MatriculaService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	MatriculaDAO objPro = fabrica.getMatricula();

	public List<MatriculaDTO> listaMatricula() {
		return objPro.listarMatricula();
	}

	public MatriculaDTO buscaMatricula(int cod) {
		return objPro.buscarMatricula(cod);
	}

	public int registraMatricula(MatriculaDTO obj) {
		return objPro.registrarMatricula(obj);
	}

	public int actualizaMatricula(MatriculaDTO obj) {
		return objPro.actualizarMatricula(obj);
	}

	public int eliminaMatricula(int cod) {
		return objPro.eliminarMatricula(cod);
	}
	
	public List<MatriculaDTO> buscaMatriculaxcod(int cod) {
		return objPro.buscarMatriculaxcod(cod);
	}

}

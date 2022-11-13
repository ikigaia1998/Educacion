package service;

import java.util.List;

import Factory.DAOFactory;
import beans.ApoderadoDTO;
import interfaces.ApoderadoDAO;
import util.Constantes;

public class ApoderadoService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ApoderadoDAO objApo = fabrica.getApoderado();
	
	public List<ApoderadoDTO> listaApoderado() {
		return objApo.listarApoderado();
	}

	public ApoderadoDTO buscaApoderado(int cod) {
		return objApo.buscarApoderado(cod);
	}

	public int registraApoderado(ApoderadoDTO obj) {
		return objApo.registrarApoderado(obj);
	}

	public int actualizaApoderado(ApoderadoDTO obj) {
		return objApo.actualizarApoderado(obj);
	}

	public int eliminaApoderado(int cod) {
		return objApo.eliminarApoderado(cod);
	}
}

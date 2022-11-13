package service;

import java.util.List;

import Factory.DAOFactory;

import beans.ProfesorDTO;
import interfaces.ProfesorDAO;
import util.Constantes;

public class ProfesorService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProfesorDAO objDoc = fabrica.getProfesor();
	
	public List<ProfesorDTO> listaProfesor(){
		return objDoc.listarProfesor();
	}
	public ProfesorDTO buscarProfesor(int cod) {
		return objDoc.buscarProfesor(cod);
	}
	public int registrarProfesor(ProfesorDTO obj) {
		return objDoc.registrarProfesor(obj);
	}
	public int actualizarProfesor(ProfesorDTO obj) {
		return objDoc.actualizarProfesor(obj);
	}
	public int eliminarProfesor(int cod) {
		return objDoc.eliminarProfesor(cod);
	}
}

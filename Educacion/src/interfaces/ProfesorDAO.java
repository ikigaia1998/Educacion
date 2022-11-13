package interfaces;

import java.util.List;

import beans.ProfesorDTO;

public interface ProfesorDAO {
	public List<ProfesorDTO>listarProfesor();
	public int registrarProfesor(ProfesorDTO obj);
	public int actualizarProfesor(ProfesorDTO obj);
	public int eliminarProfesor(int cod);
	public ProfesorDTO buscarProfesor(int cod);
}

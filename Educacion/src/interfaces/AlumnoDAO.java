package interfaces;

import java.util.List;

import beans.AlumnoDTO;

public interface AlumnoDAO {
	public List<AlumnoDTO>listarAlumno();
	public int registrarAlumno(AlumnoDTO obj);
	public int actualizarAlumno(AlumnoDTO obj);
	public int eliminarAlumno(int cod);
	public AlumnoDTO buscarAlumno(int cod);
	
}


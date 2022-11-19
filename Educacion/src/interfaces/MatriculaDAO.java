package interfaces;

import java.util.List;

import beans.MatriculaDTO;

public interface MatriculaDAO {
	public List<MatriculaDTO>listarMatricula();
	public int registrarMatricula(MatriculaDTO obj);
	public int actualizarMatricula(MatriculaDTO obj);
	public int eliminarMatricula(int cod);
	public MatriculaDTO buscarMatricula(int cod);
	public List<MatriculaDTO> buscarMatriculaxcod(int cod);

}

package interfaces;

import java.util.List;

import beans.ApoderadoDTO;

public interface ApoderadoDAO {
	
	public List<ApoderadoDTO> listarApoderado();
	public int registrarApoderado(ApoderadoDTO obj);
	public int actualizarApoderado(ApoderadoDTO obj);
	public int eliminarApoderado(int cod);
	public ApoderadoDTO buscarApoderado(int cod);

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.MatriculaDTO;
import interfaces.MatriculaDAO;
import util.MySqlDBConexion;

public class MySqlMatriculaDAO implements MatriculaDAO {

	@Override
	public List<MatriculaDTO> listarMatricula() {
		List<MatriculaDTO> data = new ArrayList<MatriculaDTO>();

		MatriculaDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select m.idmatricula, a.nombres, n.nombres, c.descripcion, m.pagomatricula\r\n" + 
					"from matricula m join apoderado a on m.idapoderado = a.idapoderado\r\n" + 
					"				 join alumno n on n.idalumno = m.idalumno\r\n" + 
					"                 join curso c on c.idcurso = m.idcurso";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new MatriculaDTO();
				obj.setIdMatricula(rs.getInt(1));
				obj.setNombreApo(rs.getString(2));
				obj.setNombreAlu(rs.getString(3));
				obj.setDescripCurso(rs.getString(4));
				obj.setPago(rs.getDouble(5));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarMatricula(MatriculaDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into matricula values(null,?,?,?,?);";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdApoderado());
			pstm.setInt(2, obj.getIdAlumno());
			pstm.setInt(3, obj.getIdCurso());
			pstm.setDouble(4, obj.getPago());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarMatricula(MatriculaDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update matricula set idapoderado=?,idalumno=?,idcurso=?,pagomatricula=? where idmatricula=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdApoderado());
			pstm.setInt(2, obj.getIdAlumno());
			pstm.setInt(3, obj.getIdCurso());
			pstm.setDouble(4, obj.getPago());
			pstm.setInt(5, obj.getIdMatricula());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarMatricula(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from matricula where idmatricula=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public MatriculaDTO buscarMatricula(int cod) {
		MatriculaDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select m.idmatricula, a.nombres, n.nombres, c.descripcion, m.pagomatricula\r\n" + 
					"from matricula m join apoderado a on m.idapoderado = a.idapoderado\r\n" + 
					"				 join alumno n on n.idalumno = m.idalumno\r\n" + 
					"                 join curso c on c.idcurso = m.idcurso where m.idmatricula=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new MatriculaDTO();
				obj.setIdMatricula(rs.getInt(1));
				obj.setNombreApo(rs.getString(2));
				obj.setNombreAlu(rs.getString(3));
				obj.setDescripCurso(rs.getString(4));
				obj.setPago(rs.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public List<MatriculaDTO> buscarMatriculaxcod(int cod) {
		MatriculaDTO obj = null;
		List<MatriculaDTO> data = new ArrayList<MatriculaDTO>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from matricula where idmatricula=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new MatriculaDTO();
				obj.setIdMatricula(rs.getInt(1));
				obj.setNombreApo(rs.getString(2));
				obj.setNombreAlu(rs.getString(3));
				obj.setDescripCurso(rs.getString(4));
				obj.setPago(rs.getDouble(5));
				data.add(obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			}
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

}

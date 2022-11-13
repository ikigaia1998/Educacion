package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ApoderadoDTO;
import interfaces.ApoderadoDAO;
import util.MySqlDBConexion;

public class MySqlApoderadoDAO implements ApoderadoDAO {

	@Override
	public List<ApoderadoDTO> listarApoderado() {
		List<ApoderadoDTO> data = new ArrayList<ApoderadoDTO>();
		ApoderadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select a.idapoderado, a.nombres, a.apellidos, a.dni, a.telefono, al.idalumno from apoderado a inner join alumno al on a.idalumno = al.idalumno";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next())
			{
				obj = new ApoderadoDTO();
				obj.setIdApoderado(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setTelefono(rs.getInt(5));
				obj.setIdAlumno(rs.getInt(6));
				data.add(obj);
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarApoderado(ApoderadoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into apoderado values(null,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setInt(3, obj.getDni());
			pstm.setInt(4, obj.getTelefono());
			pstm.setInt(5, obj.getIdAlumno());
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarApoderado(ApoderadoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update apoderado set nombres=?, apellidos=?, dni=?, telefono=?, idalumno=? where idapoderado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setInt(3, obj.getDni());
			pstm.setInt(4, obj.getTelefono());
			pstm.setInt(5, obj.getIdAlumno());
			pstm.setInt(6, obj.getIdApoderado());
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarApoderado(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from apoderado where idapoderado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public ApoderadoDTO buscarApoderado(int cod) {
		ApoderadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from apoderado where idapoderado=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next())
			{
				obj = new ApoderadoDTO();
				obj.setIdApoderado(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDni(rs.getInt(4));
				obj.setTelefono(rs.getInt(5));
				obj.setIdAlumno(rs.getInt(6));
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}

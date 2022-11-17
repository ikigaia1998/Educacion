package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.AlumnoDTO;
import interfaces.AlumnoDAO;
import util.MySqlDBConexion;

public class MySqlAlumnoDAO implements AlumnoDAO {

	@Override
	public List<AlumnoDTO> listarAlumno() {
		List<AlumnoDTO> data = new ArrayList<AlumnoDTO>();

		AlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from ALUMNO";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new AlumnoDTO();
				obj.setIdAlumno(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDNI(rs.getString(4));
				obj.setFechaNacimiento(rs.getDate(5));
				obj.setSexo(rs.getString(6));
				obj.setCiudad(rs.getString(7));
				obj.setDireccion(rs.getString(8));
				obj.setFechaRegistro(rs.getDate(9));
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	//----------------------------------------------------------------------------------------------------------

	@Override
	public int registrarAlumno(AlumnoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "insert into ALUMNO values(null,?,?,?,?,?,?,?,curtime());";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getDNI());
			pstm.setDate(4, obj.getFechaNacimiento());
			pstm.setString(5, obj.getSexo());
			pstm.setString(6, obj.getCiudad());
			pstm.setString(7, obj.getDireccion());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
	
	//----------------------------------------------------------------------------------------------------------

	@Override
	public int actualizarAlumno(AlumnoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "update alumno set nombres=?,apellidos=?,dni=?,fechanacimiento=?,sexo=?,ciudad=?,direccion=? where idalumno=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getDNI());
			pstm.setDate(4, obj.getFechaNacimiento());
			pstm.setString(5, obj.getSexo());
			pstm.setString(6, obj.getCiudad());
			pstm.setString(7, obj.getDireccion());
			pstm.setInt(8, obj.getIdAlumno());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
	
	//----------------------------------------------------------------------------------------------------------

	@Override
	public int eliminarAlumno(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from alumno where idalumno=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}
	
	//----------------------------------------------------------------------------------------------------------

	@Override
	public AlumnoDTO buscarAlumno(int cod) {
		AlumnoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from alumno where idalumno=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new AlumnoDTO();
				obj.setIdAlumno(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setDNI(rs.getString(4));
				obj.setFechaNacimiento(rs.getDate(5));
				obj.setSexo(rs.getString(6));
				obj.setCiudad(rs.getString(7));
				obj.setDireccion(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	@Override
	public List<AlumnoDTO> buscarAlumnoxcod(int cod) {
		AlumnoDTO alu = null;
		List<AlumnoDTO> data = new ArrayList<AlumnoDTO>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from alumno where idalumno=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				alu = new AlumnoDTO();
				alu.setIdAlumno(rs.getInt(1));
				alu.setNombres(rs.getString(2));
				alu.setApellidos(rs.getString(3));
				alu.setDNI(rs.getString(4));
				alu.setFechaNacimiento(rs.getDate(5));
				alu.setSexo(rs.getString(6));
				alu.setCiudad(rs.getString(7));
				alu.setDireccion(rs.getString(8));
				alu.setFechaRegistro(rs.getDate(9));
				data.add(alu);
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


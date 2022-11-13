package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.ProfesorDTO;
import interfaces.ProfesorDAO;
import util.MySqlDBConexion;

public class MySqlProfesorDAO implements ProfesorDAO{

	@Override
	public List<ProfesorDTO> listarProfesor() {
		List<ProfesorDTO> data = new ArrayList<ProfesorDTO>();
		ProfesorDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "select * from profesor";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				obj = new ProfesorDTO();
				obj.setIdprofesor(rs.getInt(1));;
				obj.setNom(rs.getString(2));
				obj.setApe(rs.getString(3));
				obj.setSexo(rs.getString(4));
				obj.setTel(rs.getInt(5));
				obj.setDir(rs.getString(6));
				obj.setDni(rs.getInt(7));
				data.add(obj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public int registrarProfesor(ProfesorDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;

		try {
			cn=MySqlDBConexion.getConexion();
			String sql = "insert into profesor values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom());
			pstm.setString(2, obj.getApe());
			pstm.setString(3, obj.getSexo());
			pstm.setInt(4, obj.getTel());
			pstm.setString(5, obj.getDir());
			pstm.setInt(6, obj.getDni());

			estado = pstm.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int actualizarProfesor(ProfesorDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql = "update profesor set nombres=?,apellidos=?,sexo=?,telefono=?,direccion=?,dni=? where idprofesor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom());
			pstm.setString(2, obj.getApe());
			pstm.setString(3, obj.getSexo());
			pstm.setInt(4, obj.getTel());
			pstm.setString(5, obj.getDir());
			pstm.setInt(6, obj.getDni());
			pstm.setInt(7, obj.getIdprofesor());
			estado = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public int eliminarProfesor(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm =null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql = "delete from profesor where idprofesor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public ProfesorDTO buscarProfesor(int cod) {
		ProfesorDTO obj=null;
		Connection cn = null;
		PreparedStatement pstm =null;
		ResultSet rs = null;
		try {
			cn=MySqlDBConexion.getConexion();
			String sql = "Select * from profesor where idprofesor=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			while(rs.next()) {
				obj = new ProfesorDTO();
				obj.setIdprofesor(rs.getInt(1));
				obj.setNom(rs.getString(2));
				obj.setApe(rs.getString(3));
				obj.setSexo(rs.getString(4));
				obj.setTel(rs.getInt(5));
				obj.setDir(rs.getString(6));
				obj.setDni(rs.getInt(7));

				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.UsuarioDTO;
import interfaces.UsuarioDao;




import util.MySqlDBConexion;


public class MySqlUsuarioDAO implements UsuarioDao {

	@Override
	public List<UsuarioDTO> listarUsuario() {
		List<UsuarioDTO> data = new ArrayList<UsuarioDTO>();
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm =null;
		ResultSet rs = null;
		try {
		String sql = "select*from usuario";
		cn = MySqlDBConexion.getConexion();
		pstm = cn.prepareStatement(sql);
		rs= pstm.executeQuery();
		while(rs.next()) {
			obj= new UsuarioDTO();
			obj.setIdUsuario(rs.getInt(1));
			obj.setNombres(rs.getString(2));
			obj.setApellidos(rs.getString(3));
			obj.setLoginUsuario(rs.getString(4));
			obj.setClave(rs.getString(5));
			obj.setFechaRegistro(rs.getDate(6));
			data.add(obj);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return data;
	}

	@Override
	public int registrarUsuario(UsuarioDTO obj) {
		int estado = -1;
		Connection cn  = null;
		PreparedStatement pstm  = null;
		try {
			String sql = "insert into usuario values(null,?,?,?,?,curtime());";
			cn = MySqlDBConexion.getConexion();
			pstm =cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getLoginUsuario());
			pstm.setString(4, obj.getClave());
			estado = pstm.executeUpdate();
		} catch (Exception e) {	e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO obj) {
		int estado  = -1;
		Connection cn  = null;
		PreparedStatement pstm = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql= "update usuario set nombres=?,apellidos=?,loginUsuario=?, loginClave=?,fecharegistro=? where idUsuario=?";
			pstm =cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getLoginUsuario());
			pstm.setString(4, obj.getClave());
			pstm.setDate(5,obj.getFechaRegistro());
			pstm.setInt(6, obj.getIdUsuario());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return estado;
	}

	@Override
	public int eliminarUsuario(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			String sql= "delete from usuario where idusuario = ? ";
			cn= MySqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1,cod);
			estado=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public UsuarioDTO buscarUsuario(int cod) {
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select * from usuario where idusuario = ? ";
			cn = MySqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs= pstm.executeQuery();
			if(rs.next()) {
				obj = new UsuarioDTO();
				obj.setIdUsuario(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setLoginUsuario(rs.getString(4));
				obj.setClave(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return obj;
	}

	public UsuarioDTO iniciarSesion(String log, String pass) {
		UsuarioDTO obj= null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs= null;
		try {
			String sql = "Select*from usuario where LoginUsuario=? and LoginClave=?";
			cn = MySqlDBConexion.getConexion();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1,log);
			pstm.setString(2,pass);
			rs = pstm.executeQuery();
			if(rs.next()) {
				obj = new UsuarioDTO();
				obj.setIdUsuario(rs.getInt(1));
				obj.setNombres(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setLoginUsuario(rs.getString(4));
				obj.setClave(rs.getString(5));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null)cn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}
}

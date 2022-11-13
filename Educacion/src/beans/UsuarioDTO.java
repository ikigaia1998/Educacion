package beans;

import java.sql.Date;


public class UsuarioDTO {
	 int IdUsuario;
	String Nombres;
	String Apellidos;
	String LoginUsuario;
	String Clave;	
	Date FechaRegistro;
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getLoginUsuario() {
		return LoginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		LoginUsuario = loginUsuario;
	}
	public String getClave() {
		return Clave;
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}	

	
}

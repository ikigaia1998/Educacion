package service;

import java.util.List;

import Factory.DAOFactory;
import beans.UsuarioDTO;
import interfaces.UsuarioDao;


public class UsuarioService {
		DAOFactory fabrica = DAOFactory.getDAOFactory(util.Constantes.ORIGEN_DE_DATOS_MYSQL);
		UsuarioDao objUsu=fabrica.getUsuario();

		public UsuarioDTO iniciarSesion(String log,String pass) {
			return objUsu.iniciarSesion(log, pass);
		}
		
		public int eliminarUsuario(int cod) {
			return objUsu.eliminarUsuario(cod);
		}
		
		public List<UsuarioDTO> listarUsuario (){
			return objUsu.listarUsuario();
		}
		
		public  UsuarioDTO buscarUsuario(int cod) {
			return objUsu.buscarUsuario(cod);
		}
		
		public int actualizarUsuario(UsuarioDTO obj) {
			return objUsu.actualizarUsuario(obj);
		}
		
		public int registrarUsuario(UsuarioDTO obj) {
			return objUsu.registrarUsuario(obj);
		}
		
}

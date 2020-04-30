/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.edu.ec.sispa.constantes.Constantes;
import com.uisrael.edu.ec.sispa.persistencia.dao.interfaces.IUsuarioDAO;
import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;
import com.uisrael.edu.ec.sispa.servicio.interfaces.IUsuarioServicio;

/**
 * @author Jorge
 *
 */
@Service
public class UsuarioServicio implements IUsuarioServicio{
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsuarioDTO identificarUsuario(UsuarioDTO usuarioDTO) {
		usuarioDTO.setContrasenia(this.encriptar(usuarioDTO.getContrasenia()));
		return this.usuarioDAO.findByEstadoAndCedulaAndContrasenia(
				Constantes.ESTADO_ACTIVO, usuarioDTO.getCedula(), usuarioDTO.getContrasenia());
	}

	@Override
	public void registrar(UsuarioDTO usuario) {
		 usuario.setContrasenia(this.encriptar(usuario.getContrasenia()));
		 usuarioDAO.save(usuario);
	}
	
	@Override
	public UsuarioDTO actualizar(UsuarioDTO usuario) {
		usuario.setContrasenia(this.encriptar(usuario.getContrasenia()));
		return usuarioDAO.save(usuario);
	}
	@Override
	public List<UsuarioDTO> listarTodos() {
		return this.usuarioDAO.findAll();
	}
	
	@Override
	public void eliminar(UsuarioDTO usuario) {
		this.usuarioDAO.delete(usuario);
	}
	
	@Override
	public UsuarioDTO buscarPorId(Integer id) {
		return this.usuarioDAO.findById(id);
	}

	private String encriptar(String password) {
		MessageDigest md;
		String passwordEncriptada = null;
		
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			passwordEncriptada = DatatypeConverter
		      .printHexBinary(md.digest()).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return passwordEncriptada;
	}
	
	
	
}

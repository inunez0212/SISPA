/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.implentacion;

import java.util.List;

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
		
		return this.usuarioDAO.findByEstadoAndCedulaAndContrasenia(
				Constantes.ESTADO_ACTIVO, usuarioDTO.getCedula(), usuarioDTO.getContrasenia());
	}

	@Override
	public void registrar(UsuarioDTO usuario) {
		 usuarioDAO.save(usuario);
	}
	
	@Override
	public UsuarioDTO actualizar(UsuarioDTO usuario) {
		return usuarioDAO.save(usuario);
	}
	@Override
	public List<UsuarioDTO> listarTodos() {
		return this.usuarioDAO.findByEstado(Constantes.ESTADO_ACTIVO);
	}
	
	@Override
	public void eliminar(UsuarioDTO usuario) {
		this.usuarioDAO.delete(usuario);
	}
	
	@Override
	public UsuarioDTO buscarPorId(Integer id) {
		return this.usuarioDAO.findById(id);
	}

	
	
	
}

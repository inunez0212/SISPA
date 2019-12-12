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
 * @author Ivan
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
	public List<UsuarioDTO> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrar(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		
	}
	
}

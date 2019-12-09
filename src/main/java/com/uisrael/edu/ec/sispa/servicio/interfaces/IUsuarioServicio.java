/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.interfaces;

import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;

/**
 * @author Ivan
 *
 */
public interface IUsuarioServicio {

	
	/**
	 * Retorna un usuario activo por cedula y contrasenia
	 * @param usuarioDTO
	 * @return
	 */
	UsuarioDTO identificarUsuario(UsuarioDTO usuarioDTO);

	

}

/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.interfaces;

import java.util.List;

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

	List<UsuarioDTO> listarTodos();

	void registrar(UsuarioDTO usuarioDTO);

	UsuarioDTO actualizar(UsuarioDTO usuario);

	void eliminar(UsuarioDTO usuario);

	UsuarioDTO buscarPorId(Integer id);

	

	

}

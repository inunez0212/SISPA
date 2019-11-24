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
	 * Registra un usuario nuevo
	 * @param usuario
	 * @return
	 */
	public UsuarioDTO registrar(UsuarioDTO usuario);

	/**
	 * Actualiza un usuario
	 * @param usuario
	 * @return
	 */
	public UsuarioDTO actualizar(UsuarioDTO usuario);

	/**
	 * Lista los usuarios activos
	 * @return
	 */
	public List<UsuarioDTO> listarTodos();

	/**
	 * Elimina un usuario
	 * @param usuario
	 */
	public void eliminar(UsuarioDTO usuario);

}

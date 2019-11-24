/**
 * 
 */
package com.uisrael.edu.ec.sispa.servicio.interfaces;

import java.util.List;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;

/**
 * @author Ivan
 *
 */
public interface ICatalogoServicio {

	/**
	 * Registra un catalogo nuevo
	 * @param usuario
	 * @return
	 */
	public CatalogoDTO registrar(CatalogoDTO catalogo);

	/**
	 * Actualiza un catalogo
	 * @param usuario
	 * @return
	 */
	public CatalogoDTO actualizar(CatalogoDTO catalogo);

	/**
	 * Lista los catalogos activos
	 * @return
	 */
	public List<CatalogoDTO> listarTodos();

	/**
	 * Elimina un catalogo
	 * @param catalogo
	 */
	public void eliminar(CatalogoDTO catalogo);

}

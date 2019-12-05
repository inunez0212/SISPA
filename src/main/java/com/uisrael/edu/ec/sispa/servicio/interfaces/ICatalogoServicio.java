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
	CatalogoDTO registrar(CatalogoDTO catalogo);

	/**
	 * Actualiza un catalogo
	 * @param usuario
	 * @return
	 */
	CatalogoDTO actualizar(CatalogoDTO catalogo);

	/**
	 * Lista los catalogos activos
	 * @return
	 */
	List<CatalogoDTO> listarTodos();

	/**
	 * Elimina un catalogo
	 * @param catalogo
	 */
	void eliminar(CatalogoDTO catalogo);
	
	
	/**
	 * @param id
	 * @return
	 */
	CatalogoDTO buscarPorId(String id);

	/**
	 * @param idRelacionado
	 * @return
	 */
	List<CatalogoDTO> buscarPorRelacionado(String idRelacionado);

}

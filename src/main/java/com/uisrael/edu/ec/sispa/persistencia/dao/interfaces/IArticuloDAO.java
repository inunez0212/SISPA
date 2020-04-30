/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.ArticuloDTO;

/**
 * @author Jorge
 *
 */
public interface IArticuloDAO extends JpaRepository<ArticuloDTO, Long> {	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<ArticuloDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(ArticuloDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	ArticuloDTO getOne(Long id);
	
	/**
	 * Contar por estado
	 * @param estado
	 * @return
	 */
	long countByEstado(String estado);
	
	/**
	 * Guardar entidad
	 * @param entity
	 * @return
	 */
	@Transactional
	ArticuloDTO save(ArticuloDTO entity);

}

/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;

/**
 * @author Ivan
 *
 */
@Repository
public interface ICatalogoDAO  extends JpaRepository<CatalogoDTO, Long>{
	
	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<CatalogoDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(CatalogoDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	CatalogoDTO getOne(Long id);
	
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
	CatalogoDTO save(CatalogoDTO entity);

}
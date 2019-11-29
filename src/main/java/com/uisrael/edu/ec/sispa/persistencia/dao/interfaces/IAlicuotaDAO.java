/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.AlicuotaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;

/**
 * @author Ivan
 *
 */
public interface IAlicuotaDAO  extends JpaRepository<AlicuotaDTO, Long>{

	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<AlicuotaDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(AlicuotaDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	AlicuotaDTO getOne(Long id);
	
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
	AlicuotaDTO save(AlicuotaDTO entity);}

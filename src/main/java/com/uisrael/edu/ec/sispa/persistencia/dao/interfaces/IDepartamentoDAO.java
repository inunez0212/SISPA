/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.DepartamentoDTO;

/**
 * @author Ivan
 *
 */
public interface IDepartamentoDAO extends JpaRepository<DepartamentoDTO, Long> {	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<DepartamentoDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(DepartamentoDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	DepartamentoDTO findById(Integer id);
	
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
	DepartamentoDTO save(DepartamentoDTO entity);

	/**
	 * Obtiene un departamento por numero y bloque
	 * @param bloque
	 * @param numero
	 * @return
	 */
	DepartamentoDTO findByBloqueAndNumero(String bloque, String numero);
	
}

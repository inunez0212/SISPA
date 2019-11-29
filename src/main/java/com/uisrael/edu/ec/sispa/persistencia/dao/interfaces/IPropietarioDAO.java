/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.FacturaDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.PropietarioDTO;

/**
 * @author Ivan
 *
 */
public interface IPropietarioDAO extends JpaRepository<PropietarioDTO, Long>{/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<PropietarioDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(PropietarioDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	PropietarioDTO getOne(Long id);
	
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
	PropietarioDTO save(PropietarioDTO entity);


}

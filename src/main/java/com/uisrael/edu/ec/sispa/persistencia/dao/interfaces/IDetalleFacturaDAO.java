/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.DetalleFacturaDTO;

/**
 * @author Ivan
 *
 */
public interface IDetalleFacturaDAO extends JpaRepository<DetalleFacturaDTO, Long> {	
	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<DetalleFacturaDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(DetalleFacturaDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	DetalleFacturaDTO getOne(Long id);
	
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
	DetalleFacturaDTO save(DetalleFacturaDTO entity);

}

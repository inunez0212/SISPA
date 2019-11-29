package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.CatalogoDTO;
import com.uisrael.edu.ec.sispa.persistencia.dto.ClienteDTO;

public interface IClienteDAO extends JpaRepository<ClienteDTO, Long> {	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<ClienteDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(ClienteDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	ClienteDTO getOne(Long id);
	
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
	ClienteDTO save(ClienteDTO entity);

}

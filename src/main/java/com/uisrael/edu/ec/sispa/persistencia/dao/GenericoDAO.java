/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ivan
 * Maneja los metodos CRUD
 */
@Repository
public interface GenericoDAO<T extends Serializable, ID extends Serializable>  extends JpaRepository<T, ID>{
	
	/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<T> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(T entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	T getOne(Long id);
	
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
	T save(T entity);
	
}

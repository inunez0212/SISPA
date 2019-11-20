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
 *
 */
@Repository
public interface GenericoDAO<T extends Serializable, ID extends Serializable>  extends JpaRepository<T, ID>{
	
	public List<T> findByEstado(String estado);
	
	@Transactional
	void delete(T entity);
	
	T getOne(Long id);
	
	long count();
	
	@Transactional
	T save(T entity);
	
}

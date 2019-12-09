/**
 * 
 */
package com.uisrael.edu.ec.sispa.persistencia.dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.edu.ec.sispa.persistencia.dto.UsuarioDTO;

/**
 * @author Ivan
 *
 */
public interface IUsuarioDAO extends JpaRepository<UsuarioDTO, Long>
{/**
	 * Buscar entidad por estado
	 * @param estado
	 * @return
	 */
	public List<UsuarioDTO> findByEstado(String estado);
	
	/**
	 * Eliminar entidad
	 */
	@Transactional
	void delete(UsuarioDTO entity);
	
	/**
	 * Obtiene entidad por ID
	 * @param id
	 * @return
	 */
	UsuarioDTO getOne(Long id);
	
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
	UsuarioDTO save(UsuarioDTO entity);

	/**
	 * Buscar usuario
	 * @param estado
	 * @param cedula
	 * @param contrasenia
	 * @return
	 */
	public UsuarioDTO findByEstadoAndCedulaAndContrasenia(
			String estado, String cedula, String contrasenia);
}
